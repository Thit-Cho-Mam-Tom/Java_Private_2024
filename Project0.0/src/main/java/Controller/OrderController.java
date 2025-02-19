package Controller;

import Model.Customer;
import Model.Order;
import Model.OrderDetail;
import Model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderController {
    private EntityManagerFactory emf;

    public OrderController() {

        emf = Persistence.createEntityManagerFactory("SalesManagement");
    }

    public Order createOrder(int customerId, int productId, int quantity, LocalDateTime orderDate) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Customer customer = em.find(Customer.class, customerId);
            Product product = em.find(Product.class, productId);
            if (customer == null || product == null) {
                em.getTransaction().rollback();
                return null;
            }
            if (product.getQuantity() < quantity) {
                em.getTransaction().rollback();
                System.out.println("Không đủ sản phẩm trong kho!");
                return null;
            }

            // Tạo đơn hàng mới
            Order newOrder = new Order();
            newOrder.setCustomer(customer);
            newOrder.setOrderDate(orderDate);
            newOrder.setTotalPrice(product.getPrice().multiply(BigDecimal.valueOf(quantity)));

            em.persist(newOrder);

            // Tạo chi tiết đơn hàng
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setProduct(product);
            orderDetail.setQuantity(quantity);
            orderDetail.setOrder(newOrder);
            orderDetail.setPrice(product.getPrice());

            em.persist(orderDetail);

            // Giảm số lượng sản phẩm trong kho
            product.setQuantity(product.getQuantity() - quantity);
            em.merge(product);

            em.getTransaction().commit();
            return newOrder;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    // Phương thức lấy danh sách tất cả các đơn hàng hoặc tìm kiếm theo văn bản
//    public List<Order> getAllOrders(String searchText) {
//        EntityManager em = emf.createEntityManager();
//        try {
//            if (searchText != null && !searchText.isEmpty()) {
//                return em.createQuery(
//                                "SELECT o FROM Order o WHERE LOWER(o.customer.name) LIKE :searchText", Order.class)
//                        .setParameter("searchText", "%" + searchText.toLowerCase() + "%")
//                        .getResultList();
//            } else {
//                return em.createQuery("SELECT o FROM Order o", Order.class).getResultList();
//            }
//        } finally {
//            em.close();
//        }
//    }


    public List<Order> getOrdersByCustomerName(String customerName) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery(
                            "SELECT o FROM Order o WHERE LOWER(o.customer.name) LIKE :name", Order.class)
                    .setParameter("name", "%" + customerName.toLowerCase() + "%")
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public void deleteOrder(int orderId) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            // Tìm đơn hàng cần xóa
            Order order = em.find(Order.class, orderId);
            if (order != null) {
                for (OrderDetail orderDetail : order.getOrderDetails()) {
                    Product product = orderDetail.getProduct();
                    int quantity = orderDetail.getQuantity();
                    product.setQuantity(product.getQuantity() + quantity);
                    em.merge(product);
                }
                em.remove(order);
            }

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }


    // Phương thức tính tổng số lượng sản phẩm trong đơn hàng
    public int getTotalQuantityForOrder(int orderId) {
        EntityManager em = emf.createEntityManager();
        try {
            Order order = em.find(Order.class, orderId);
            if (order != null && order.getOrderDetails() != null) {
                return order.getOrderDetails().stream()
                        .mapToInt(OrderDetail::getQuantity)// Lấy số lượng quantity của từng OrderDetail.
                        .sum();  // Tính tổng số lượng
            }
            return 0;
        } finally {
            em.close();
        }
    }

}
