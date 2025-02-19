package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Inventory {

    @Id
    private int productId;  // Mã sản phẩm (khóa chính)

    private int quantity;  // Số lượng tồn kho

    @ManyToOne
    @JoinColumn(name = "productId", insertable = false, updatable = false)
    private Product product;  // Liên kết với sản phẩm

    // Constructor
    public Inventory() {}

    public Inventory(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    // Getter và Setter
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Inventory [productId=" + productId + ", quantity=" + quantity + "]";
    }
}
