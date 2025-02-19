package controller;

import Model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class UserController {
    private String storedUsername = "admin";  // Tên đăng nhập mặc định
    private String storedPassword = "admin123";  // Mật khẩu mặc định

    // Phương thức kiểm tra đăng nhập
    public boolean authenticate(String username, String password) {
        return storedUsername.equals(username) && storedPassword.equals(password);
    }

    // Phương thức thay đổi mật khẩu
    public boolean changePassword(String oldPassword, String newPassword) {
        if (storedPassword.equals(oldPassword)) {
            storedPassword = newPassword;
            return true;  // Đổi mật khẩu thành công
        }
        return false;  // Mật khẩu cũ không đúng
    }

    // Phương thức cho quên mật khẩu (ví dụ đơn giản, trong thực tế có thể dùng email hoặc câu hỏi bảo mật)
    public boolean resetPassword(String username, String newPassword) {
        if (storedUsername.equals(username)) {
            storedPassword = newPassword;
            return true;  // Đặt lại mật khẩu thành công
        }
        return false;  // Tên đăng nhập không tồn tại
    }
    private EntityManagerFactory emf;

    // Constructor khởi tạo EntityManagerFactory
    public UserController() {
        emf = Persistence.createEntityManagerFactory("SalesManagement");
    }







}
