package Controller;

import Model.Admin;
import org.mindrot.jbcrypt.BCrypt;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;

public class AdminController {
    private EntityManagerFactory emf;
    private static  Admin currentAdmin;


    public AdminController() {
        emf = Persistence.createEntityManagerFactory("SalesManagement");
    }


    // Phương thức đăng ký tài khoản Admin mới
    public boolean createAdmin(String username, String password, Admin.Role role) {
        EntityManager em = emf.createEntityManager();
        try {
            // Kiểm tra xem username đã tồn tại hay chưa
            Long count = em.createQuery("SELECT COUNT(a) FROM Admin a WHERE a.username = :username", Long.class)
                    .setParameter("username", username)
                    .getSingleResult();
            if (count != null && count > 0) {
                return false; // Username đã tồn tại
            }

            String hashedPassword = hashPassword(password);  // Mã hóa mật khẩu
            Admin admin = new Admin(username, hashedPassword, role);

            em.getTransaction().begin();
            em.persist(admin);
            em.getTransaction().commit();
            return true; // Đăng ký thành công
        } finally {
            em.close();
        }
    }


    public Admin login(String username, String password) {
        EntityManager em = emf.createEntityManager();
        try {
            Admin admin = em.createQuery("SELECT a FROM Admin a WHERE a.username = :username", Admin.class)
                    .setParameter("username", username)
                    .getSingleResult();

            if (admin != null && checkPassword(password, admin.getPassword())) {
                currentAdmin = admin;  // Lưu admin đang đăng nhập
                return admin;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }
    public boolean isUsernameTaken(String username) {
        EntityManager em = emf.createEntityManager();
        try {
            Long count = em.createQuery("SELECT COUNT(a) FROM Admin a WHERE a.username = :username", Long.class)
                    .setParameter("username", username)
                    .getSingleResult();
            return count != null && count > 0;
        } finally {
            em.close();
        }
    }


    // Trả về tên Admin hiện tại
    public String getAdminName() {
        return (currentAdmin != null) ? currentAdmin.getUsername() : "Chưa đăng nhập";
    }

    // Phương thức thay đổi mật khẩu Admin
    public boolean changePassword(String username, String oldPassword, String newPassword) {
        EntityManager em = emf.createEntityManager();
        try {
            Admin admin = em.createQuery("SELECT a FROM Admin a WHERE a.username = :username", Admin.class)
                    .setParameter("username", username)
                    .getSingleResult();

            if (admin != null && checkPassword(oldPassword, admin.getPassword())) {
                // Mật khẩu cũ đúng, cập nhật mật khẩu mới
                String hashedNewPassword = hashPassword(newPassword);
                em.getTransaction().begin();
                admin.setPassword(hashedNewPassword);
                em.getTransaction().commit();
                return true;  // Thay đổi mật khẩu thành công
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return false;  // Thay đổi mật khẩu thất bại (mật khẩu cũ không đúng hoặc không tìm thấy admin)
    }

    // Mã hóa mật khẩu
    private String hashPassword(String password) {

        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    // Kiểm tra mật khẩu
    private boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
    public BigDecimal getMonthlyRevenue() {
        EntityManager em = emf.createEntityManager();
        try {
            BigDecimal revenue = em.createQuery(
                    "SELECT COALESCE(SUM(o.totalPrice), 0) FROM Order o WHERE MONTH(o.orderDate) = MONTH(CURRENT_DATE) AND YEAR(o.orderDate) = YEAR(CURRENT_DATE)",
                    BigDecimal.class
            ).getSingleResult();
            return revenue;
        } catch (Exception e) {
            e.printStackTrace();
            return BigDecimal.ZERO;
        } finally {
            em.close();
        }
    }

    public long getOrderCount() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT COUNT(o) FROM Order o WHERE MONTH(o.orderDate) = MONTH(CURRENT_DATE)", Long.class)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            em.close();
        }
    }

}
