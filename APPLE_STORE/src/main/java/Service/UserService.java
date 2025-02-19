package Service;

import DAO.UserDAO;
import Model.User;
import java.util.List;

public class UserService {

    private UserDAO userDAO = new UserDAO();

    // Lưu người dùng
    public void saveUser(User user) {
        userDAO.save(user);
    }

    // Lấy người dùng theo tên đăng nhập
    public User getUserByUsername(String username) {
        return userDAO.getByUsername(username);
    }

    // Cập nhật người dùng
    public void updateUser(User user) {
        userDAO.update(user);
    }

    // Xóa người dùng theo tên đăng nhập
    public void deleteUser(String username) {
        userDAO.delete(username);
    }

    // Kiểm tra thông tin đăng nhập
    public boolean authenticate(String username, String password) {
        User user = getUserByUsername(username);
        return user != null && user.getPassword().equals(password);
    }

    // Lấy tất cả người dùng
    public List<User> getAllUsers() {
        return userDAO.getAll();
    }
}
