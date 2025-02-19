package view;

import controller.ProductController;
import controller.OrderController;
import controller.ProductController;
import controller.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private UserController userController;

    public LoginView(UserController userController) {
        this.userController = userController;

        // Cài đặt JFrame
        setTitle("Login");
        setSize(440, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        // Các component nhập liệu
        JLabel lblUsername = new JLabel("Username:");
        txtUsername = new JTextField();
        JLabel lblPassword = new JLabel("Password:");
        txtPassword = new JPasswordField();
        JButton btnLogin = new JButton("Login");

        // Các nút liên kết
        JButton btnForgotPassword = new JButton("Forgot Password?");
        JButton btnChangePassword = new JButton("Change Password");

        add(lblUsername);
        add(txtUsername);
        add(lblPassword);
        add(txtPassword);
        add(new JLabel());  // Chỗ trống
        add(btnLogin);
        add(btnForgotPassword);
        add(btnChangePassword);

        // Sự kiện đăng nhập
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                char[] password = txtPassword.getPassword();

                if (userController.authenticate(username, new String(password))) {
                    JOptionPane.showMessageDialog(null, "Login successful!");

                    // Mở cửa sổ AdminView sau khi đăng nhập thành công
                    new AdminView(userController, new controller.ProductController(), new OrderController());
                      // Hiển thị cửa sổ AdminView

                    // Đóng cửa sổ LoginView
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password!");
                }
            }
        });


        // Sự kiện "Quên mật khẩu"
        btnForgotPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ForgotPasswordView(userController);
            }
        });

        // Sự kiện "Đổi mật khẩu"
        btnChangePassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ChangePasswordView(userController);
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginView(new UserController());
    }
}
