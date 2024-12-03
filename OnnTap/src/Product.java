import java.util.Objects;
import java.util.Scanner;

public class Product {
    protected String product_id;
    protected String product_name;
    protected String product_price;
    protected double product_total;
    public Product() {

    }
    public Product(String product_id, String product_name, String product_price, double product_total) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_total = product_total;
    }
    public String getProduct_id() {
        return product_id;
    }
    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }
    public String getProduct_name() {
        return product_name;
    }
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
    public String getProduct_price() {
        return product_price;
    }
    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }
    public double getProduct_total() {
        return product_total;
    }
    public void setProduct_total(double product_total) {
        this.product_total = product_total;
    }



    public void nhap() {
        Scanner sc= new Scanner(System.in);
        System.out.print("nhập id:");
        product_id= sc.nextLine();
        System.out.print("tên sản phẩm: ");
        product_name=sc.nextLine();
        System.out.print("giá sản phẩm: ");
        product_price=sc.nextLine();
        System.out.print("số lượng sản phẩm: ");
        product_total=sc.nextDouble();
        sc.close();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(product_id, product.product_id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(product_id);
    }

    @Override
    public String toString() {
        return "Car [product_id=" + product_id + ", product_name=" + product_name + ", product_price=" + product_price
                + ", product_total=" + product_total + "]";
    }
}
