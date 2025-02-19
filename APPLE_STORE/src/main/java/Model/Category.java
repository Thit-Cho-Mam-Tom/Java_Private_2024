package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Category {

    @Id
    private int id;  // Mã danh mục
    private String name;  // Tên danh mục

    @OneToMany(mappedBy = "category")
    private List<Product> products;  // Danh sách sản phẩm trong danh mục

    // Constructor
    public Category() {}

    public Category(String name) {
        this.name = name;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + "]";
    }
}
