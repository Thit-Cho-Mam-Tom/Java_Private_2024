package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;

import java.util.List;

@Entity
public class Cart {

    @Id
    private int cartId;  // Mã giỏ hàng

    @ManyToOne
    @JoinColumn(name = "customer_email")
    private Customer customer;  // Khách hàng sở hữu giỏ hàng

    @ManyToMany
    @JoinTable(
            name = "cart_products",  // Tên bảng trung gian
            joinColumns = @JoinColumn(name = "cart_id"),  // Liên kết với Cart
            inverseJoinColumns = @JoinColumn(name = "product_id")  // Liên kết với Product
    )
    private List<Product> products;  // Danh sách sản phẩm trong giỏ hàng

    // Constructor
    public Cart() {}

    public Cart(Customer customer, List<Product> products) {
        this.customer = customer;
        this.products = products;
    }

    // Getter và Setter
    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Cart [cartId=" + cartId + ", customer=" + customer + ", products=" + products + "]";
    }
}
