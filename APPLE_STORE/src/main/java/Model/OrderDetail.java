
package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class OrderDetail {

    @Id
    private int orderDetailId;  // Mã chi tiết đơn hàng

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;  // Đơn hàng

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;  // Sản phẩm

    private int quantity;  // Số lượng sản phẩm

    private double price;  // Giá của sản phẩm tại thời điểm đặt hàng

    // Constructor
    public OrderDetail() {}

    public OrderDetail(Order order, Product product, int quantity, double price) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    // Getter và Setter
    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderDetail [orderDetailId=" + orderDetailId + ", product=" + product + ", quantity=" + quantity + ", price=" + price + "]";
    }
}

