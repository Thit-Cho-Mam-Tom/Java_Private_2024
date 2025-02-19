package view;

import controller.OrderController;
import controller.ProductController;
import controller.UserController;

import javax.swing.*;
import java.awt.*;

public class AdminView extends JFrame {
    private UserController userController;
    private ProductController productController;
    private OrderController orderController;

    public AdminView(UserController userController, ProductController productController, OrderController orderController) {
        this.userController = userController;
        this.productController = productController;
        this.orderController = orderController;

        // Cài đặt JFrame
        setTitle("Admin - Sales Management");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Nút điều hướng
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10));  // Dùng GridLayout cho các nút
        JButton btnManageUsers = new JButton("Manage Users");
        JButton btnManageProducts = new JButton("Manage Products");
        JButton btnManageOrders = new JButton("Manage Orders");
        JButton btnViewReports = new JButton("View Reports");

        buttonPanel.add(btnManageUsers);
        buttonPanel.add(btnManageProducts);
        buttonPanel.add(btnManageOrders);
        buttonPanel.add(btnViewReports);

        add(buttonPanel, BorderLayout.CENTER);  // Thêm các nút vào giữa cửa sổ chính

        // Sự kiện điều hướng
        btnManageUsers.addActionListener(e -> new UserView(userController));
        btnManageProducts.addActionListener(e -> new ProductView(productController));
        btnManageOrders.addActionListener(e -> new OrderView(orderController));
        btnViewReports.addActionListener(e -> showReports());

        setLocationRelativeTo(null);
        revalidate();
        repaint();
        setVisible(true);
    }

    private void showReports() {
        JOptionPane.showMessageDialog(this, "Reports and statistics not implemented yet.");
    }

}
