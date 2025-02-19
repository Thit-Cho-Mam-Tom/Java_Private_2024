package view;

import controller.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePasswordView extends JFrame {
    private UserController userController;

    public ChangePasswordView(UserController userController) {
        this.userController = userController;

        // Cài đặt JFrame
        setTitle("Change Password");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        // Các component nhập liệu
        JLabel lblOldPassword = new JLabel("Old Password:");
        JPasswordField txtOldPassword = new JPasswordField();
        JLabel lblNewPassword = new JLabel("New Password:");
        JPasswordField txtNewPassword = new JPasswordField();
        JButton btnChangePassword = new JButton("Change Password");

        add(lblOldPassword);
        add(txtOldPassword);
        add(lblNewPassword);
        add(txtNewPassword);
        add(new JLabel());  // Chỗ trống
        add(btnChangePassword);

        // Sự kiện thay đổi mật khẩu
        btnChangePassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oldPassword = new String(txtOldPassword.getPassword());
                String newPassword = new String(txtNewPassword.getPassword());

                if (userController.changePassword(oldPassword, newPassword)) {
                    JOptionPane.showMessageDialog(null, "Password changed successfully!");
                    dispose();  // Đóng cửa sổ thay đổi mật khẩu
                } else {
                    JOptionPane.showMessageDialog(null, "Old password is incorrect!");
                }
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ChangePasswordView(new UserController());
    }
}
