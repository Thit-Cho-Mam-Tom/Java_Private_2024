package Model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "CustomerOrder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(nullable = false)
    private LocalDateTime orderDate;

    @Column(nullable = false, precision = 10, scale = 2)
    //precision = 10: Tổng cộng 10 chữ số.
    //scale = 2: 2 chữ số sau dấu thập phân.
    private BigDecimal totalPrice;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    public Order() {
    }

    public Order(int id, Customer customer, LocalDateTime orderDate, BigDecimal totalPrice, List<OrderDetail> orderDetails) {
        this.id = id;
        this.customer = customer;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.orderDetails = orderDetails;
    }

    // Getter và Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

  /*  // Phương thức lấy tên khách hàng
    public String getCustomerName() {
        return customer != null ? customer.getName() : null;
    }

    public void setCustomerName(String name) {
        if (customer != null) {
            customer.setName(name);
        }
    }

    // Phương thức lấy thông tin sản phẩm và số lượng từ OrderDetail
    public String getProductName() {
        return orderDetails != null && !orderDetails.isEmpty() ? orderDetails.get(0).getProduct().getName() : null;
    }

    public int getQuantity() {
        return orderDetails != null && !orderDetails.isEmpty() ? orderDetails.get(0).getQuantity() : 0;
    }*/
}
