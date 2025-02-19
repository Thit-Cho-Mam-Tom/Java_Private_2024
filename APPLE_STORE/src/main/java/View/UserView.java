package View;

import controller.UserController;

import javax.swing.*;

public class UserView extends JFrame {
    private UserController userController;

    public UserView(UserController userController) {
        this.userController = userController;

        setTitle("User Panel");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblWelcome = new JLabel("Welcome to the User Panel!");
        lblWelcome.setBounds(100, 50, 200, 30);
        add(lblWelcome);

        JButton btnLogout = new JButton("Logout");
        btnLogout.setBounds(150, 150, 100, 30);
        btnLogout.addActionListener(e -> {
            new LoginView(userController); // Quay lại giao diện đăng nhập
            dispose(); // Đóng cửa sổ hiện tại
        });
        add(btnLogout);

        setVisible(true);
    }
}
