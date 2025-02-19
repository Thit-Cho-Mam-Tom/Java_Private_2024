package view;

import controller.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ForgotPasswordView extends JFrame {
    private UserController userController;

    public ForgotPasswordView(UserController userController) {
        this.userController = userController;

        // Cài đặt JFrame
        setTitle("Forgot Password");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 10, 10));

        // Các component nhập liệu
        JLabel lblUsername = new JLabel("Username:");
        JTextField txtUsername = new JTextField();
        JLabel lblNewPassword = new JLabel("New Password:");
        JPasswordField txtNewPassword = new JPasswordField();
        JButton btnResetPassword = new JButton("Reset Password");

        add(lblUsername);
        add(txtUsername);
        add(lblNewPassword);
        add(txtNewPassword);
        add(new JLabel());  // Chỗ trống
        add(btnResetPassword);

        // Sự kiện reset mật khẩu
        btnResetPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String newPassword = new String(txtNewPassword.getPassword());

                if (userController.resetPassword(username, newPassword)) {
                    JOptionPane.showMessageDialog(null, "Password reset successful!");
                    dispose();  // Đóng cửa sổ đặt lại mật khẩu
                } else {
                    JOptionPane.showMessageDialog(null, "Username not found!");
                }
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ForgotPasswordView(new UserController());
    }
}
