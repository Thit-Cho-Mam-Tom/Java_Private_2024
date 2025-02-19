package View;

import Controller.AdminController;

import javax.swing.*;
import java.awt.*;

public class SettingsView extends JFrame {
    private JComboBox<String> themeComboBox;
    private JCheckBox notificationsCheckBox;
    private JSpinner fontSizeSpinner;
    private JButton saveButton;
    private JButton cancelButton;
    private JButton changePasswordButton;
    private JButton logoutButton;
    private AdminController adminController;  // Declare AdminController instance

    public SettingsView(AdminController adminController) {  // Pass AdminController instance to constructor
        this.adminController = adminController;  // Assign to local variable

        setTitle("Cài Đặt Hệ Thống");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Tạo các thành phần giao diện
        JLabel themeLabel = new JLabel("Chọn chủ đề:");
        String[] themes = {"Light", "Dark"};
        themeComboBox = new JComboBox<>(themes);

        JLabel fontSizeLabel = new JLabel("Kích thước văn bản:");
        fontSizeSpinner = new JSpinner(new SpinnerNumberModel(12, 8, 36, 1));

        notificationsCheckBox = new JCheckBox("Bật thông báo");

        saveButton = new JButton("Lưu");
        cancelButton = new JButton("Hủy");
        changePasswordButton = new JButton("Đổi Mật Khẩu");
        logoutButton = new JButton("Đăng Xuất");

        saveButton.setBackground(new Color(255, 209, 0));
        saveButton.setForeground(Color.BLACK);
        cancelButton.setBackground(new Color(255, 209, 0));
        cancelButton.setForeground(Color.BLACK);
        changePasswordButton.setBackground(new Color(255, 209, 0));
        changePasswordButton.setForeground(Color.BLACK);
        logoutButton.setBackground(new Color(255, 209, 0));
        logoutButton.setForeground(Color.BLACK);

        // Đặt layout
        setLayout(new GridLayout(8, 2, 10, 10));

        // Thêm các thành phần vào cửa sổ
        add(themeLabel);
        add(themeComboBox);
        add(fontSizeLabel);
        add(fontSizeSpinner);
        add(notificationsCheckBox);
        add(new JLabel()); // Dòng trống
        add(saveButton);
        add(cancelButton);
        add(changePasswordButton);  // Thêm nút Đổi Mật Khẩu
        add(logoutButton);          // Thêm nút Đăng Xuất

        // Xử lý sự kiện
        saveButton.addActionListener(e -> saveSettings());
        cancelButton.addActionListener(e -> dispose());
        changePasswordButton.addActionListener(e -> openChangePasswordView());
        logoutButton.addActionListener(e -> logout());
    }

    private void saveSettings() {
        String theme = (String) themeComboBox.getSelectedItem();
        int fontSize = (Integer) fontSizeSpinner.getValue();
        boolean notificationsEnabled = notificationsCheckBox.isSelected();

        // Cập nhật các cài đặt
        JOptionPane.showMessageDialog(this, "Cài đặt đã được lưu!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }

    private void openChangePasswordView() {
        // Mở cửa sổ đổi mật khẩu và truyền AdminController vào
        new ChangePasswordView(adminController,this);  // Pass AdminController instance here
        this.dispose();  // Đóng cửa sổ cài đặt
    }

    private void logout() {
        int option = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn đăng xuất?", "Đăng Xuất", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "Đăng xuất thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

            // Đóng tất cả cửa sổ đang mở
            for (Window window : Window.getWindows()) {
                window.dispose();
            }

            // Mở lại màn hình đăng nhập
            LoginView loginView = new LoginView();
            loginView.setLocationRelativeTo(null); // Hiển thị giữa màn hình
            loginView.setVisible(true);
        }
    }

}
