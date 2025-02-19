package View;

import Controller.AdminController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePasswordView extends JFrame {
    private AdminController userController;
    private JFrame previousView;

    public ChangePasswordView(AdminController userController, JFrame previousView) {
        this.userController = userController;
        this.previousView = previousView;

        setTitle("Thay đổi mật khẩu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel lblUsername = new JLabel("Tên tài khoản:");
        JTextField txtUsername = new JTextField(20);
        JLabel lblOldPassword = new JLabel("Mật khẩu cũ:");
        JPasswordField txtOldPassword = new JPasswordField(20);
        JLabel lblNewPassword = new JLabel("Mật khẩu mới:");
        JPasswordField txtNewPassword = new JPasswordField(20);
        JButton btnChangePassword = new JButton("Đổi mật khẩu");
        JButton btnBack = new JButton("Trở lại");

        btnChangePassword.setBackground(new Color(255, 209, 0));
        btnChangePassword.setForeground(Color.BLACK);
        btnBack.setBackground(new Color(255, 209, 0));
        btnBack.setForeground(Color.BLACK);

        gbc.gridx = 0; gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(lblUsername, gbc);

        gbc.gridx = 1; gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(txtUsername, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(lblOldPassword, gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(txtOldPassword, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        add(lblNewPassword, gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        add(txtNewPassword, gbc);

        gbc.gridx = 1; gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        buttonPanel.add(btnChangePassword);
        buttonPanel.add(btnBack);
        add(buttonPanel, gbc);

        btnChangePassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredUsername = txtUsername.getText().trim();
                String oldPassword = new String(txtOldPassword.getPassword());
                String newPassword = new String(txtNewPassword.getPassword());

                if (userController.changePassword(enteredUsername, oldPassword, newPassword)) {
                    JOptionPane.showMessageDialog(null, "Thay đổi mật khẩu thành công!");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Mật khẩu cũ không chính xác hoặc không tìm thấy tài khoản!");
                }
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (previousView != null) {
                    previousView.setVisible(true);
                }
                dispose();
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
