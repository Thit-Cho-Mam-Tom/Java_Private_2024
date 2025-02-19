    package Model;

    import jakarta.persistence.*;
    import java.math.BigDecimal;
    import java.util.List;

    @Entity
    @Table(name = "Product")
    public class Product {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(nullable = false, length = 255)
        private String name;

        @Column(nullable = false, precision = 10, scale = 2)
        private BigDecimal price;

        @Column(nullable = false)
        private int quantity;

        @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<OrderDetail> orderDetails;


        // Constructors
        public Product() {
        }

        public Product( String name, BigDecimal price, int quantity) {

            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        // Getters and Setters
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
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("Tên sản phẩm không được để trống");
            }
            this.name = name;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("Giá sản phẩm phải lớn hơn 0");
            }
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            if (quantity < 0) {
                throw new IllegalArgumentException("Số lượng không thể âm");
            }
            this.quantity = quantity;
        }
        // Inside Product class
        public List<OrderDetail> getOrderDetails() {
            return orderDetails;
        }


    }
