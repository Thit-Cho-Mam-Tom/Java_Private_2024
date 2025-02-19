package Controller;

import Model.OrderDetail;
import Model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.List;

public class ProductController {
    private EntityManagerFactory emf;

    // Constructor: Khởi tạo EntityManagerFactory một lần
    public ProductController() {
        emf = Persistence.createEntityManagerFactory("SalesManagement");
    }

    // Lấy tất cả sản phẩm
    public List<Product> getAllProducts() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
        } finally {
            em.close(); // Đảm bảo đóng EntityManager
        }
    }

    // Thêm hoặc cập nhật sản phẩm
    public void addProduct(Product product) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            // Kiểm tra xem sản phẩm cùng tên đã tồn tại hay chưa
            TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.name = :name", Product.class);
            query.setParameter("name", product.getName());
            List<Product> existingProducts = query.getResultList();

            if (existingProducts.isEmpty()) {
                // Sản phẩm chưa tồn tại, thêm sản phẩm mới
                em.persist(product);
                System.out.println("New product added.");
            } else {
                // Sản phẩm đã tồn tại, chỉ cập nhật các thuộc tính khác
                Product existingProduct = existingProducts.get(0);
                existingProduct.setPrice(product.getPrice());
                existingProduct.setQuantity(existingProduct.getQuantity() + product.getQuantity());
                em.merge(existingProduct); // Cập nhật sản phẩm cũ
                System.out.println("Existing product updated.");
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback(); // Rollback nếu có lỗi
            System.out.println("Error while adding product: " + e.getMessage()); // In lỗi chi tiết
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // Cập nhật sản phẩm
    @Transactional
    public void updateProduct(Product updatedProduct) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            // Tìm sản phẩm cần cập nhật theo ID
            Product existingProduct = em.find(Product.class, updatedProduct.getId());
            if (existingProduct != null) {
                // Cập nhật thông tin sản phẩm
                existingProduct.setName(updatedProduct.getName());
                existingProduct.setPrice(updatedProduct.getPrice());
                existingProduct.setQuantity(updatedProduct.getQuantity());

                // Cập nhật các OrderDetail nếu cần
                for (OrderDetail orderDetail : existingProduct.getOrderDetails()) {
                    orderDetail.setPrice(updatedProduct.getPrice()); // Cập nhật giá của OrderDetail
                }

                em.merge(existingProduct); // Lưu các thay đổi
                em.getTransaction().commit();
                System.out.println("Product updated successfully.");
            } else {
                System.out.println("Product not found.");
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error while updating product: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // Xóa sản phẩm
    public void deleteProduct(int productId) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Product product = em.find(Product.class, productId);
            if (product != null) {
                em.remove(product);
                System.out.println("Product deleted.");
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error while deleting product: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // Lấy sản phẩm theo ID
    public Product getProductById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Product.class, id);
        } finally {
            em.close();
        }
    }

    // Tìm sản phẩm theo tên
    public Product findProductByName(String productName) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.name = :name", Product.class);
            query.setParameter("name", productName);
            List<Product> products = query.getResultList();
            return products.isEmpty() ? null : products.get(0); // Return the first product found, or null if not found
        } finally {
            em.close();
        }
    }

    // Đóng EntityManagerFactory khi ứng dụng kết thúc
    public void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
