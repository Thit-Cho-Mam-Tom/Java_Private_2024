public class Car extends Product{
    private String color;
    private String brand;
    private String material;

    public Car() {
        super();

    }


    public Car(String product_id, String product_name, String product_price, double product_total) {
        super(product_id, product_name, product_price, product_total);

    }


    public Car(String color, String brand, String material) {
        super();
        this.color = color;
        this.brand = brand;
        this.material = material;
    }


    public String getColor() {
        return color;
    }


    public void setColor(String color) {
        this.color = color;
    }


    public String getBrand() {
        return brand;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }


    public String getMaterial() {
        return material;
    }


    public void setMaterial(String material) {
        this.material = material;
    }



    @Override
    public String toString() {
        return "\nsố id: "+product_id+
                "\ntên sản phẩm: "+product_name+
                "\ngiá sản phẩm: "+product_price+
                "\nsố lượng sản phẩm là: "+product_total+
                "\nmàu: "+color+
                "\nthương hiệu: "+brand+
                "\nchất liệu: "+material;
    }
}
