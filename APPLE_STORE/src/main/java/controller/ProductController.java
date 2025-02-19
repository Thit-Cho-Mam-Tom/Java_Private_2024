package controller;

import Service.ProductService;
import Model.Product;
import java.util.List;

public class ProductController {

    private ProductService productService = new ProductService();

    // Lưu sản phẩm
    public void saveProduct(Product product) {
        productService.saveProduct(product);
    }

    // Lấy sản phẩm theo ID
    public Product getProductById(int id) {
        return productService.getProductById(id);
    }

    // Lấy tất cả sản phẩm
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Cập nhật sản phẩm
    public void updateProduct(Product product) {
        productService.updateProduct(product);
    }

    // Xóa sản phẩm
    public void deleteProduct(int id) {
        productService.deleteProduct(id);
    }
}
