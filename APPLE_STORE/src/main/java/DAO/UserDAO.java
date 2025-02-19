package DAO;

import Model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import java.util.List;

public class UserDAO {

    // Save User
    public void save(User user) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(user);
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

    // Get User by username
    public User getByUsername(String username) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        User user = null;
        try {
            user = entityManager.find(User.class, username);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return user;
    }

    // Update User
    public void update(User user) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(user);
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

    // Delete User by username
    public void delete(String username) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            User user = entityManager.find(User.class, username);
            if (user != null) {
                entityManager.remove(user);
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

    // Get all Users
    public List<User> getAll() {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        List<User> users = null;
        try {
            Query query = entityManager.createQuery("SELECT u FROM User u", User.class);
            users = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return users;
    }
}
