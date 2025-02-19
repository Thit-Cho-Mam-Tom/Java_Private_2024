package Service;

import DAO.ProductDAO;
import Model.Product;
import java.util.List;

public class ProductService {

    private ProductDAO productDAO = new ProductDAO();

    // Save product
    public void saveProduct(Product product) {
        productDAO.save(product);
    }

    // Get product by ID
    public Product getProductById(int id) {
        return productDAO.getById(id);
    }

    // Get all products
    public List<Product> getAllProducts() {
        return productDAO.getAll();
    }

    // Update product
    public void updateProduct(Product product) {
        productDAO.update(product);
    }

    // Delete product by ID
    public void deleteProduct(int id) {
        productDAO.delete(id);
    }
}
