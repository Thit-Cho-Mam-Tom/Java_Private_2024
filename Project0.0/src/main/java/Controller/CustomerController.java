package Controller;

import Model.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class CustomerController {
    private EntityManagerFactory emf;

    public CustomerController() {
        emf = Persistence.createEntityManagerFactory("SalesManagement");
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void createCustomer(Customer customer) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(customer);  // Lưu khách hàng vào cơ sở dữ liệu
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("lỗi tạo khách hàng: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void updateCustomer(Customer customer) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(customer);  // Cập nhật thông tin khách hàng vào cơ sở dữ liệu
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("lỗi cập nhập khách hàng " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void deleteCustomer(int customerId) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Customer customer = em.find(Customer.class, customerId);
            if (customer != null) {
                em.remove(customer);  // Xóa khách hàng khỏi cơ sở dữ liệu
            } else {
                System.out.println("Không tìm thấy khách hàng có ID: " + customerId);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("lỗi xóa khách hàng: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    // tìm theo tên
    public List<Customer> findCustomersByName(String name) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT c FROM Customer c WHERE c.name LIKE :name", Customer.class)
                    .setParameter("name", "%" + name + "%")
                    .getResultList();
        } finally {
            em.close();
        }
    }


    // Phương thức tìm khách hàng theo ID
    public Customer findCustomerById(int customerId) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Customer.class, customerId);  // Tìm khách hàng theo ID
        } finally {
            em.close();
        }
    }


    // Phương thức lấy danh sách tất cả khách hàng
    public List<Customer> getAllCustomers() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();  // Truy vấn tất cả khách hàng
        } finally {
            em.close();
        }
    }
}
