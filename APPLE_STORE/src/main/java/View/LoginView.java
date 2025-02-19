package View;

import Model.User;
import controller.UserController;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {
    private UserController userController;

    public LoginView(UserController userController) {
        this.userController = userController;

        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(50, 50, 100, 30);
        add(lblUsername);

        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(150, 50, 150, 30);
        add(txtUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(50, 100, 100, 30);
        add(lblPassword);

        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(150, 100, 150, 30);
        add(txtPassword);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(50, 150, 100, 30);
        btnLogin.addActionListener(e -> {
            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());

            User user = userController.authenticate(username, password);
            if (user != null) {
                if (user.getRole() == User.Role.ADMIN) {
                    JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
                    new MainView(userController); // Chuyển đến MainView
                } else {
                    JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
                    new UserView(userController); // Chuyển đến UserView
                }
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password!");
            }
        });
        add(btnLogin);

        JButton btnRegister = new JButton("Register");
        btnRegister.setBounds(200, 150, 100, 30);
        btnRegister.addActionListener(e -> {
            new RegisterView(userController); // Chuyển đến giao diện đăng ký
            dispose();
        });
        add(btnRegister);

        setVisible(true);
    }
    public static void main(String[] args) {
        UserController userController = new UserController();
        new LoginView(userController);
    }
}
