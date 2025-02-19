package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Payment {

    @Id
    private int paymentId;  // Mã thanh toán

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;  // Đơn hàng liên quan đến thanh toán

    private String paymentMethod;  // Phương thức thanh toán (Ví dụ: "Thẻ tín dụng", "Tiền mặt")
    private String paymentStatus;  // Trạng thái thanh toán (Ví dụ: "Đã thanh toán", "Chưa thanh toán")
    private LocalDate paymentDate;  // Ngày thanh toán

    // Constructor không tham số
    public Payment() {}

    public Payment(Order order, String paymentMethod, String paymentStatus, LocalDate paymentDate) {
        this.order = order;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.paymentDate = paymentDate;
    }

    // Getter và Setter
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "Payment [paymentId=" + paymentId + ", order=" + order + ", paymentMethod=" + paymentMethod + ", paymentStatus=" + paymentStatus + ", paymentDate=" + paymentDate + "]";
    }
}
