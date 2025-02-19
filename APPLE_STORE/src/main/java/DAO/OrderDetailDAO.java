package DAO;

import Model.OrderDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class OrderDetailDAO {

    // Save OrderDetail
    public void save(OrderDetail orderDetail) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(orderDetail);
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

    // Get OrderDetail by ID
    public OrderDetail getById(int id) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        OrderDetail orderDetail = null;
        try {
            orderDetail = entityManager.find(OrderDetail.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return orderDetail;
    }

    // Update OrderDetail
    public void update(OrderDetail orderDetail) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(orderDetail);
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

    // Delete OrderDetail by ID
    public void delete(int id) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            OrderDetail orderDetail = entityManager.find(OrderDetail.class, id);
            if (orderDetail != null) {
                entityManager.remove(orderDetail);
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
