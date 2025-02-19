package View;

import Controller.AdminController;
import Model.Admin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpView extends JFrame {
    private AdminController adminController;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<Admin.Role> roleComboBox;
    private JButton signUpButton;
    private JButton cancelButton;

    public SignUpView(AdminController adminController) {
        this.adminController = adminController;

        // Cài đặt cửa sổ đăng ký
        setTitle("Đăng ký Tài khoản Admin");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Đặt vị trí cửa sổ ở giữa màn hình

        // Tạo các thành phần giao diện
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel roleLabel = new JLabel("Role:");

        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);

        roleComboBox = new JComboBox<>(Admin.Role.values()); // ComboBox cho Role (Admin, User...)

        signUpButton = new JButton("Đăng ký");
        cancelButton = new JButton("Hủy");
        signUpButton.setBackground(new Color(255, 209, 0));
        signUpButton.setForeground(Color.BLACK);
        cancelButton.setBackground(new Color(255, 209, 0));
        cancelButton.setForeground(Color.BLACK);


        // Đặt layout
        setLayout(null);
        usernameLabel.setBounds(30, 30, 80, 30);
        usernameField.setBounds(120, 30, 200, 30);
        passwordLabel.setBounds(30, 70, 80, 30);
        passwordField.setBounds(120, 70, 200, 30);
        roleLabel.setBounds(30, 110, 80, 30);
        roleComboBox.setBounds(120, 110, 200, 30);
        signUpButton.setBounds(50, 160, 90, 30);
        cancelButton.setBounds(233, 160, 90, 30);

        // Thêm các thành phần vào cửa sổ
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(roleLabel);
        add(roleComboBox);
        add(signUpButton);
        add(cancelButton);

        // Xử lý sự kiện nút Đăng ký
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText().trim();
                String password = new String(passwordField.getPassword()).trim();
                Admin.Role role = (Admin.Role) roleComboBox.getSelectedItem();

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(SignUpView.this, "Vui lòng điền đầy đủ thông tin.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (adminController.isUsernameTaken(username)) {
                    JOptionPane.showMessageDialog(SignUpView.this, "Username đã tồn tại, vui lòng chọn tên khác.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                boolean success = adminController.createAdmin(username, password, role);
                if (success) {
                    JOptionPane.showMessageDialog(SignUpView.this, "Đăng ký thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(SignUpView.this, "Đăng ký thất bại. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        // Xử lý sự kiện nút Hủy
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Đóng cửa sổ nếu bấm Hủy
            }
        });

    }

    // Hàm khởi tạo cửa sổ và hiển thị

}
