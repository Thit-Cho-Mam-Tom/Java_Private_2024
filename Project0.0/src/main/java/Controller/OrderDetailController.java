package Controller;

import Model.OrderDetail;
import Model.Order;
import Model.Customer; // Thêm import Customer nếu cần
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class OrderDetailController {
    private EntityManagerFactory emf;

    public OrderDetailController() {
        emf = Persistence.createEntityManagerFactory("SalesManagement");
    }

//    public void createOrderDetail(OrderDetail orderDetail) {
//        EntityManager em = emf.createEntityManager();
//        try {
//            em.getTransaction().begin();
//            em.persist(orderDetail);
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            em.getTransaction().rollback();
//            e.printStackTrace();
//        } finally {
//            em.close();
//        }
//    }

//    public void updateOrderDetail(OrderDetail orderDetail) {
//        EntityManager em = emf.createEntityManager();
//        try {
//            em.getTransaction().begin();
//            em.merge(orderDetail);
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            em.getTransaction().rollback();
//            e.printStackTrace();
//        } finally {
//            em.close();
//        }
//    }

//    public OrderDetail findOrderDetailById(int id) {
//        EntityManager em = emf.createEntityManager();
//        try {
//            return em.find(OrderDetail.class, id);
//        } finally {
//            em.close();
//        }
//    }

    public void deleteOrderDetail(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            OrderDetail orderDetail = em.find(OrderDetail.class, id);
            if (orderDetail != null) {
                em.remove(orderDetail);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<OrderDetail> getAllOrderDetails() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT od FROM OrderDetail od", OrderDetail.class).getResultList();
        } finally {
            em.close();
        }
    }
    public List<OrderDetail> searchOrderDetails(String productName, String customerName) {
        EntityManager em = emf.createEntityManager();
        try {
            String queryStr = "SELECT od FROM OrderDetail od JOIN od.product p JOIN od.order o JOIN o.customer c WHERE 1=1";
            if (!productName.isEmpty()) {
                queryStr += " AND p.name LIKE :productName";
            }
            if (!customerName.isEmpty()) {
                queryStr += " AND c.name LIKE :customerName";
            }
            var query = em.createQuery(queryStr, OrderDetail.class);
            if (!productName.isEmpty()) {
                query.setParameter("productName", "%" + productName + "%");
            }
            if (!customerName.isEmpty()) {
                query.setParameter("customerName", "%" + customerName + "%");
            }
            return query.getResultList();
        } finally {
            em.close();
        }
    }

}
