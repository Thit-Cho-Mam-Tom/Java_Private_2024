package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Tự động tạo giá trị id
    private int id;  // Mã sản phẩm
    private String name;  // Tên sản phẩm
    private double price;  // Giá sản phẩm

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;  // Danh mục của sản phẩm

    // Constructor
    public Product() {}

    public Product(String name, double price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;  // Kiểm tra giá không âm
        } else {
            throw new IllegalArgumentException("Giá sản phẩm không thể âm.");
        }
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category.getName() + "]";
    }
}
