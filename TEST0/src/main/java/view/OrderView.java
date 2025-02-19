package view;

import controller.OrderController;
import Model.Order;
import Model.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class OrderView extends JFrame {
    private OrderController orderController;
    private JTable orderTable;
    private DefaultTableModel tableModel;

    public OrderView(OrderController orderController) {
        this.orderController = orderController;
        setTitle("Order Management");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Bảng hiển thị danh sách đơn hàng
        String[] columnNames = {"Order ID", "Total Value"};
        tableModel = new DefaultTableModel(columnNames, 0);
        orderTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(orderTable);

        // Các nút chức năng
        JButton btnViewDetails = new JButton("View Order Details");
        JButton btnRefresh = new JButton("Refresh");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnViewDetails);
        buttonPanel.add(btnRefresh);

        // Sự kiện cho nút "View Order Details"
        btnViewDetails.addActionListener(e -> {
            int selectedRow = orderTable.getSelectedRow();
            if (selectedRow >= 0) {
                int orderId = Integer.parseInt(tableModel.getValueAt(selectedRow, 0).toString());
                Order order = orderController.findOrderById(orderId);
                if (order != null) {
                    StringBuilder details = new StringBuilder("Order Details:\n");
                    for (Product product : order.getProducts()) {
                        details.append("- ").append(product.getName())
                                .append(" (x").append(product.getQuantity())
                                .append("): ").append(product.getPrice()).append("\n");
                    }
                    JOptionPane.showMessageDialog(this, details.toString(), "Order Details", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select an order to view details.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Sự kiện cho nút "Refresh"
        btnRefresh.addActionListener(e -> loadOrders());

        // Layout
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Load đơn hàng vào bảng
        loadOrders();

        setVisible(true);
    }

    private void loadOrders() {
        tableModel.setRowCount(0); // Clear bảng
        List<Order> orders = orderController.getAllOrders();
        for (Order order : orders) {
            tableModel.addRow(new Object[]{
                    order.getId(),
                    orderController.calculateTotalOrderValue(order.getId())
            });
        }
    }
}
