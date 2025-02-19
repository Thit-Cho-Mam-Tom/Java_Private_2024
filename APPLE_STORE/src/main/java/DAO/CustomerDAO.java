package DAO;

import Model.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CustomerDAO {

    // Save Customer
    public void save(Customer customer) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(customer);
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

    // Get Customer by ID
    public Customer getById(int id) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        Customer customer = null;
        try {
            customer = entityManager.find(Customer.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return customer;
    }

    // Update Customer
    public void update(Customer customer) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(customer);
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

    // Delete Customer by ID
    public void delete(int id) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Customer customer = entityManager.find(Customer.class, id);
            if (customer != null) {
                entityManager.remove(customer);
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
