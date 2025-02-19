package DAO;

import Model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class ProductDAO {

    // Save Product
    public void save(Product product) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(product);
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

    // Get Product by ID
    public Product getById(int id) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        Product product = null;
        try {
            product = entityManager.find(Product.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return product;
    }

    // Get all Products
    public List<Product> getAll() {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        List<Product> products = null;
        try {
            products = entityManager.createQuery("from Product", Product.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return products;
    }

    // Update Product
    public void update(Product product) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(product);
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

    // Delete Product by ID
    public void delete(int id) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Product product = entityManager.find(Product.class, id);
            if (product != null) {
                entityManager.remove(product);
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
