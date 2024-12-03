package Model;

public class PhysicalProduct extends Product{

    @Override
    public double totalPrice() {
        return quantity*price;
    }
}
