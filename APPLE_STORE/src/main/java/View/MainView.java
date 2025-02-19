package View;

import controller.UserController;

import javax.swing.*;

public class MainView extends JFrame {
    public MainView(UserController userController) {
        setTitle("Admin Panel");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblWelcome = new JLabel("Welcome to the Admin Panel!");
        lblWelcome.setBounds(100, 50, 200, 30);
        add(lblWelcome);

        JButton btnLogout = new JButton("Logout");
        btnLogout.setBounds(150, 150, 100, 30);
        btnLogout.addActionListener(e -> {
            new LoginView(userController); // Quay lại giao diện đăng nhập
            dispose();
        });
        add(btnLogout);

        setVisible(true);
    }
}
