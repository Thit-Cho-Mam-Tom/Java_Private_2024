package View;

import Controller.AdminController;
import Model.Admin;

import javax.swing.*;
import java.awt.*;

public class LoginView extends javax.swing.JFrame {

    private AdminController adminController;

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPasswordField jPasswordField1;

    public LoginView() {
        adminController = new AdminController();
        initComponents();
    }

    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();

        jTextField1.setColumns(20);  // Tăng số cột của JTextField
        jPasswordField1.setColumns(20);  // Tăng số cột của JPasswordField
        jTextField1.setPreferredSize(new Dimension(250, 30)); // Chiều rộng 250px, chiều cao 30px
        jPasswordField1.setPreferredSize(new Dimension(250, 30));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập");
        setBackground(new java.awt.Color(0, 153, 255));

        jLabel2.setText("Tên đăng nhập:");
        jLabel3.setText("Mật khẩu:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 48));
        jLabel4.setText("Apple Store");
        jLabel4.setForeground(new Color(34, 34, 34)); // Màu vàng #FFD100

// Đặt màu nền là vàng (#FFD100) và chữ màu đen (#000000)
        Color buttonColor = new Color(255, 209, 0); // Màu vàng
        Color textColor = Color.BLACK; // Màu đen

        jButton1.setBackground(buttonColor);
        jButton1.setForeground(textColor);

        jButton2.setBackground(buttonColor);
        jButton2.setForeground(textColor);

        jButton3.setBackground(buttonColor);
        jButton3.setForeground(textColor);

        Font buttonFont = new Font("Arial", Font.BOLD, 18);
        jButton3.setFont(buttonFont);



        jButton3.setText("Đăng nhập");
        jButton3.addActionListener(evt -> loginButtonActionPerformed(evt));

        jButton1.setText("Đổi mật khẩu");
        jButton1.addActionListener(evt -> forgotPasswordActionPerformed(evt));

        jButton2.setText("Đăng ký");
        jButton2.addActionListener(evt -> registerButtonActionPerformed(evt));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addGap(53, 53, 53)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jButton2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton1)
                                                .addGap(66, 66, 66))))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton2)
                                        .addComponent(jButton1))
                                .addGap(47, 47, 47))
        );

        pack();
    }

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String username = jTextField1.getText();
        char[] password = jPasswordField1.getPassword();

        Admin admin = adminController.login(username, new String(password));
        if (admin != null) {
            JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
            new ToggleMenu();  // Chuyển sang màn hình menu tiếp theo
            setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Tên đăng nhập hoặc mật khẩu không chính xác", "Đăng nhập thất bại", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void forgotPasswordActionPerformed(java.awt.event.ActionEvent evt) {
        // Mở cửa sổ thay đổi mật khẩu mà không đóng cửa sổ đăng nhập
        new ChangePasswordView(adminController,this);  // 'this' là cửa sổ SettingsView hoặc cửa sổ gọi phương thức này
        setVisible(false);  // Ẩn cửa sổ hiện tại
    }


    // Phương thức đăng ký tài khoản Admin
    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        SignUpView signUpView = new SignUpView(adminController);
        signUpView.setVisible(true);  // Hiển thị cửa sổ đăng ký

    }


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            LoginView loginView = new LoginView();
            loginView.setVisible(true);
            loginView.setLocationRelativeTo(null);
        });
    }
}
