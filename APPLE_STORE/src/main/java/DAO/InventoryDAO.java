package DAO;

import Model.Inventory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class InventoryDAO {

    // Save Inventory
    public void save(Inventory inventory) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(inventory);
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

    // Get Inventory by ID
    public Inventory getById(int id) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        Inventory inventory = null;
        try {
            inventory = entityManager.find(Inventory.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return inventory;
    }

    // Update Inventory
    public void update(Inventory inventory) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(inventory);
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

    // Delete Inventory by ID
    public void delete(int id) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Inventory inventory = entityManager.find(Inventory.class, id);
            if (inventory != null) {
                entityManager.remove(inventory);
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
