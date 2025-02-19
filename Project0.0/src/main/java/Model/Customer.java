package Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String address;

    // Mối quan hệ OneToMany với Order
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
  //mappedBy = "customer": Trường customer trong lớp Order sẽ đóng vai trò là khóa ngoại.
    //cascade = CascadeType.ALL: Khi xóa hoặc cập nhật Customer, tất cả Order liên quan cũng sẽ thay đổi theo.
    //orphanRemoval = true: Nếu một đơn hàng bị xóa khỏi danh sách orders, nó cũng sẽ bị xóa khỏi database.
    private List<Order> orders;

    // Constructor mặc định (có thể bỏ nếu không dùng)
    public Customer() {
    }

    // Constructor với tham số
    public Customer(String name, String phone,String email, String address) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    // Getter và Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
