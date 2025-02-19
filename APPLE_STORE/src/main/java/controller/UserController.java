package controller;

import Model.User;
import java.util.ArrayList;
import java.util.List;

public class UserController {
    private List<User> users = new ArrayList<>();
    private final User adminAccount;

    // Khởi tạo tài khoản ADMIN cố định
    public UserController() {
        adminAccount = new User("admin", "admin123", "Administrator", User.Role.ADMIN);
    }

    // Đăng ký người dùng mới (chỉ dành cho USER)
    public void saveUser(User user) {
        if (user.getRole() == User.Role.USER) {
            users.add(user);
        }
    }

    // Xác thực đăng nhập
    public User authenticate(String username, String password) {
        // Kiểm tra tài khoản ADMIN
        if (adminAccount.getUsername().equals(username) && adminAccount.getPassword().equals(password)) {
            return adminAccount;
        }
        // Kiểm tra tài khoản USER
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null; // Không tìm thấy người dùng
    }

    // Kiểm tra vai trò ADMIN
    public boolean isAdmin(User user) {
        return user.getRole() == User.Role.ADMIN;
    }
}
