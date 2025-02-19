package DAO;

import Model.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class OrderDAO {

    // Save Order
    public void save(Order order) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(order);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    // Get Order by ID
    public Order getById(int orderId) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        Order order = null;
        try {
            order = entityManager.find(Order.class, orderId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return order;
    }

    // Get all Orders
    public List<Order> getAll() {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        List<Order> orders = null;
        try {
            orders = entityManager.createQuery("from Order", Order.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return orders;
    }

    // Update Order
    public void update(Order order) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(order);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    // Delete Order by ID
    public void delete(int orderId) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Order order = entityManager.find(Order.class, orderId);
            if (order != null) {
                entityManager.remove(order);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
}
