public class Rectangular extends Shape {
    protected double width;
    protected double length;

    public Rectangular(){

    }
    public Rectangular(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangular(String color, boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    public double getArean(){
        return this.length*this.width;
    }

    @Override
    public double getPerimeter() {
        return (this.length+this.width)*2;
    }

    @Override
    public String toString() {
        return "Rectangular{" +
                "width=" + width +
                ", length=" + length +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
