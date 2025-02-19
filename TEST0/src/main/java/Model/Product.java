package Model;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public Product() {
    }

    public Product(Order order, int quantity, double price, String name, int id) {
        this.order = order;
        this.quantity = quantity;
        this.price = price;
        this.name = name;
        this.id = id;
    }
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Constructor with (int, String, double, int)
    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Các getter và setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
