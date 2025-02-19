package DAO;

import Model.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class CategoryDAO {

    // Save Category
    public void save(Category category) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(category);
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

    // Get Category by ID
    public Category getById(int id) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        Category category = null;
        try {
            category = entityManager.find(Category.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return category;
    }

    // Get all Categories
    public List<Category> getAll() {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        List<Category> categories = null;
        try {
            categories = entityManager.createQuery("from Category", Category.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return categories;
    }

    // Update Category
    public void update(Category category) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(category);
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

    // Delete Category by ID
    public void delete(int id) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Category category = entityManager.find(Category.class, id);
            if (category != null) {
                entityManager.remove(category);
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
