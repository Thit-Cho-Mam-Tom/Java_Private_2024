package View;

import Controller.OrderController;
import Model.Order;
import Model.OrderDetail;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;

public class ManageOrdersView extends JFrame {
    private OrderController orderController;
    private JTextField searchTextField;
    private JTable orderTable;
    private DefaultTableModel orderTableModel;
    private ToggleMenu previousMenu;

    public ManageOrdersView(ToggleMenu previousMenu) {
        this.previousMenu = previousMenu;
        orderController = new OrderController();

        setTitle("Quản Lý Đơn Hàng");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout());
        JLabel searchLabel = new JLabel("Tìm kiếm:");
        searchTextField = new JTextField(20);
        JButton searchButton = new JButton("Tìm kiếm");
        topPanel.add(searchLabel);
        topPanel.add(searchTextField);
        topPanel.add(searchButton);

        orderTableModel = new DefaultTableModel();
        orderTableModel.setColumnIdentifiers(new String[]{"ID Đơn Hàng", "Khách Hàng", "Ngày Tạo", "Số Lượng", "Tổng Tiền"});
        orderTable = new JTable(orderTableModel);
        JScrollPane tableScrollPane = new JScrollPane(orderTable);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton createOrderButton = new JButton("Tạo Đơn Hàng");
        JButton deleteOrderButton = new JButton("Xóa Đơn Hàng");
        JButton viewDetailsButton = new JButton("Xem Chi Tiết");
        JButton backToMainMenuButton = new JButton("Quay lại");
        JButton refreshButton = new JButton("Làm Mới");
        Color buttonColor = new Color(255, 209, 0);
        Color textColor = Color.BLACK;

        createOrderButton.setBackground(buttonColor);
        createOrderButton.setForeground(textColor);

        deleteOrderButton.setBackground(buttonColor);
        deleteOrderButton.setForeground(textColor);

        viewDetailsButton.setBackground(buttonColor);
        viewDetailsButton.setForeground(textColor);

        backToMainMenuButton.setBackground(buttonColor);
        backToMainMenuButton.setForeground(textColor);

        refreshButton.setBackground(buttonColor);
        refreshButton.setForeground(textColor);

        searchButton.setBackground(buttonColor);
        searchButton.setForeground(textColor);

        buttonPanel.add(createOrderButton);
        buttonPanel.add(deleteOrderButton);
        buttonPanel.add(viewDetailsButton);
        buttonPanel.add(backToMainMenuButton);
        buttonPanel.add(refreshButton);

        add(topPanel, BorderLayout.NORTH);
        add(tableScrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        loadAllOrders("");  // Tải tất cả đơn hàng khi bắt đầu

        searchButton.addActionListener(e -> loadAllOrders(searchTextField.getText()));

        createOrderButton.addActionListener(e -> {
            String customerIdStr = JOptionPane.showInputDialog("Nhập ID khách hàng:");
            String productIdStr = JOptionPane.showInputDialog("Nhập ID sản phẩm:");
            String quantityStr = JOptionPane.showInputDialog("Nhập số lượng:");

            try {
                int customerId = Integer.parseInt(customerIdStr);
                int productId = Integer.parseInt(productIdStr);
                int quantity = Integer.parseInt(quantityStr);
                LocalDateTime orderDate = LocalDateTime.now();

                Order newOrder = orderController.createOrder(customerId, productId, quantity, orderDate);
                if (newOrder != null) {
                    JOptionPane.showMessageDialog(null, "Đơn hàng đã được tạo thành công!");
                    loadAllOrders("");
                } else {
                    JOptionPane.showMessageDialog(null, "Lỗi khi tạo đơn hàng! Có thể sản phẩm không đủ trong kho.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng!");
            }
        });


        deleteOrderButton.addActionListener(e -> {
            int rowIndex = orderTable.getSelectedRow();
            if (rowIndex >= 0) {
                int orderId = Integer.parseInt(orderTable.getValueAt(rowIndex, 0).toString());
                int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa đơn hàng này?", "Xóa Đơn Hàng", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    orderController.deleteOrder(orderId);
                    JOptionPane.showMessageDialog(null, "Đơn hàng đã được xóa!");
                    loadAllOrders("");  // Load lại danh sách đơn hàng sau khi xóa
                }
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn đơn hàng để xóa!");
            }
        });

        viewDetailsButton.addActionListener(e -> ManageOrderDetailsView());


        backToMainMenuButton.addActionListener(e -> {
            previousMenu.setVisible(true);
            dispose();
        });

        // Thêm hành động cho nút làm mới
        refreshButton.addActionListener(e -> loadAllOrders(""));  // Tải lại tất cả đơn hàng khi bấm nút làm mới

        setVisible(true);
    }
    private void ManageOrderDetailsView() {
        new ManageOrderDetailView();
    }


    private void loadAllOrders(String searchText) {
        List<Order> orders = orderController.getOrdersByCustomerName(searchText);  // Thay đổi để tìm theo tên khách hàng
        orderTableModel.setRowCount(0);
        for (Order order : orders) {
            int totalQuantity = orderController.getTotalQuantityForOrder(order.getId());
            orderTableModel.addRow(new Object[]{
                    order.getId(),
                    order.getCustomer().getName(),
                    order.getOrderDate(),
                    totalQuantity,
                    order.getTotalPrice()
            });
        }
    }
}
