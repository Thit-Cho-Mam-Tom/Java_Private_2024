package controller;

import Model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class ProductController {
    private EntityManagerFactory emf;

    public ProductController() {
        emf = Persistence.createEntityManagerFactory("SalesManagement");
    }

    public List<Product> getAllProducts() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

    public void addProduct(Product product) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
        em.close();
    }

    public void updateProduct(Product product) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(product);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteProduct(int productId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Product product = em.find(Product.class, productId);
        if (product != null) {
            em.remove(product);
        }
        em.getTransaction().commit();
        em.close();
    }
}
