package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Customer {

    @Id
    private String email;  // Email (làm khóa chính)

    private String name;  // Tên khách hàng
    private String password;  // Mật khẩu

    @OneToMany(mappedBy = "customer")
    private List<Cart> carts;  // Danh sách giỏ hàng của khách hàng

    public Customer() {
        // Constructor không tham số
    }

    public Customer(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    // Getter và Setter
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    @Override
    public String toString() {
        return "Customer [email=" + email + ", name=" + name + "]";
    }
}
