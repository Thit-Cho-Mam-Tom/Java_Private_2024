package View;

import Controller.OrderController;
import Controller.OrderDetailController;
import Controller.ProductController;
import Controller.CustomerController; // Thêm controller cho Customer
import Model.Order;
import Model.OrderDetail;
import Model.Product;
import Model.Customer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;

public class ManageOrderDetailView extends JFrame {
    private OrderDetailController orderDetailController;
    private ProductController productController;
    private OrderController orderController;
    private CustomerController customerController;  // Thêm controller cho Customer
    private JTable orderDetailTable;
    private DefaultTableModel tableModel;
    private JTextField orderIdField, productNameField, customerNameField;

    public ManageOrderDetailView() {
        orderDetailController = new OrderDetailController();
        productController = new ProductController();
        orderController = new OrderController();
        customerController = new CustomerController();

        setTitle("Quản Lý Chi Tiết Đơn Hàng");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        setLocationRelativeTo(null);

        // Cập nhật bảng để hiển thị các cột mới
        tableModel = new DefaultTableModel(new String[]{
                "ID", "Order ID", "Ngày tạo", "Tên khách hàng", "Địa chỉ", "Email", "Tên sản phẩm", "Giá", "Số lượng", "Tổng tiền"
        }, 0);


        orderDetailTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(orderDetailTable);
        add(scrollPane, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        orderIdField = new JTextField(15);
        productNameField = new JTextField(15);
        customerNameField = new JTextField(15);
        JButton searchButton = new JButton("Tìm kiếm");
        JButton deleteButton = new JButton("Xóa chi tiết");
        JButton refreshButton = new JButton("Làm mới");
        JButton backButton = new JButton("Quay lại");
        searchButton.setBackground(new Color(255, 209, 0));
        searchButton.setForeground(Color.BLACK);

        deleteButton.setBackground(new Color(255, 209, 0));
        deleteButton.setForeground(Color.BLACK);

        refreshButton.setBackground(new Color(255, 209, 0));
        refreshButton.setForeground(Color.BLACK);

        backButton.setBackground(new Color(255, 209, 0));
        backButton.setForeground(Color.BLACK);

        // Căn chỉnh các thành phần trong controlPanel
        gbc.gridx = 0; gbc.gridy = 0; controlPanel.add(new JLabel("Order ID:"), gbc);
        gbc.gridx = 1; controlPanel.add(orderIdField, gbc);

        gbc.gridx = 0; gbc.gridy = 1; controlPanel.add(new JLabel("Tên sản phẩm:"), gbc);
        gbc.gridx = 1; controlPanel.add(productNameField, gbc);

        gbc.gridx = 0; gbc.gridy = 2; controlPanel.add(new JLabel("Tên khách hàng:"), gbc);
        gbc.gridx = 1; controlPanel.add(customerNameField, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(searchButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(refreshButton);
        buttonPanel.add(backButton);

        add(controlPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        loadOrderDetails();

        // Sự kiện tìm kiếm
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchOrderDetails();
            }
        });



        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int selectedRow = orderDetailTable.getSelectedRow();
                    if (selectedRow == -1) {
                        JOptionPane.showMessageDialog(null, "Chọn chi tiết đơn hàng để xóa!", "Lỗi", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    int orderDetailId = (int) tableModel.getValueAt(selectedRow, 0);
                    orderDetailController.deleteOrderDetail(orderDetailId);
                    JOptionPane.showMessageDialog(null, "Xóa chi tiết đơn hàng thành công!");
                    loadOrderDetails();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Lỗi khi xóa chi tiết đơn hàng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadOrderDetails();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    private void searchOrderDetails() {
        String productName = productNameField.getText().trim();
        String customerName = customerNameField.getText().trim();

        List<OrderDetail> orderDetails = orderDetailController.searchOrderDetails(productName, customerName);
        updateTable(orderDetails);
    }

    private void loadOrderDetails() {
        List<OrderDetail> orderDetails = orderDetailController.getAllOrderDetails();
        updateTable(orderDetails);
    }
    private void updateTable(List<OrderDetail> orderDetails) {
        tableModel.setRowCount(0);
        for (OrderDetail orderDetail : orderDetails) {
            Order order = orderDetail.getOrder();
            Customer customer = order.getCustomer();
            BigDecimal totalPrice = orderDetail.getPrice().multiply(BigDecimal.valueOf(orderDetail.getQuantity()));

            // Thêm dữ liệu vào bảng theo đúng thứ tự cột yêu cầu
            tableModel.addRow(new Object[]{
                    orderDetail.getId(),
                    order.getId(),
                    order.getOrderDate(), // Ngày tạo
                    customer != null ? customer.getName() : "Không có",
                    customer != null ? customer.getAddress() : "Không có",
                    customer != null ? customer.getEmail() : "Không có",
                    orderDetail.getProduct().getName(),
                    orderDetail.getPrice(),
                    orderDetail.getQuantity(),
                    totalPrice
            });
        }
    }


}
