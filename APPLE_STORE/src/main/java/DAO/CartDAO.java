package DAO;

import Model.Cart;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CartDAO {

    // Save Cart
    public void save(Cart cart) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(cart);
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

    // Get Cart by ID
    public Cart getById(int cartId) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        Cart cart = null;
        try {
            cart = entityManager.find(Cart.class, cartId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return cart;
    }

    // Update Cart
    public void update(Cart cart) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(cart);
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

    // Delete Cart by ID
    public void delete(int cartId) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Cart cart = entityManager.find(Cart.class, cartId);
            if (cart != null) {
                entityManager.remove(cart);
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
