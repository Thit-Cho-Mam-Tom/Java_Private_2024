package DAO;

import Model.Payment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PaymentDAO {

    // Save Payment
    public void save(Payment payment) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(payment);
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

    // Get Payment by ID
    public Payment getById(int paymentId) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        Payment payment = null;
        try {
            payment = entityManager.find(Payment.class, paymentId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return payment;
    }

    // Update Payment
    public void update(Payment payment) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(payment);
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

    // Delete Payment by ID
    public void delete(int paymentId) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Payment payment = entityManager.find(Payment.class, paymentId);
            if (payment != null) {
                entityManager.remove(payment);
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
