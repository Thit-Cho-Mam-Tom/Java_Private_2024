package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Order {

    @Id
    private int orderId;  // Mã đơn hàng

    @ManyToOne
    @JoinColumn(name = "customer_email")
    private Customer customer;  // Khách hàng đặt đơn

    private String orderDate;  // Ngày đặt hàng
    private String status;  // Trạng thái đơn hàng (ví dụ: "Đang xử lý", "Đã giao")

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;  // Danh sách các sản phẩm trong đơn hàng

    public Order() {}

    public Order(int orderId, Customer customer, String orderDate, String status) {
        this.orderId = orderId;
        this.customer = customer;
        this.orderDate = orderDate;
        this.status = status;
    }

    // Getter và Setter
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", customer=" + customer + ", orderDate=" + orderDate + ", status=" + status + "]";
    }
    public String getCustomerName() {
        return customer.getName(); // Nếu bạn có phương thức `getName()` trong lớp `Customer`
    }

    public String getProductName() {
        // Bạn cần một cơ chế để lấy tên sản phẩm trong đơn hàng này.
        // Ví dụ, có thể thêm thuộc tính sản phẩm vào Order và sử dụng getter này.
        return "Product Name"; // Placeholder: Cập nhật logic này theo nhu cầu của bạn.
    }

    public double getTotalPrice() {
        // Tính toán tổng giá trị đơn hàng
        return 100.0; // Placeholder: Cập nhật logic này theo nhu cầu của bạn.
    }
}
