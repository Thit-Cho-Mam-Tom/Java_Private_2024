public class Cricle implements GeometriObject{
    protected double raduis;

    public Cricle() {
    }

    public Cricle(double raduis) {
        this.raduis = raduis;
    }

    public double getRaduis() {
        return raduis;
    }

    public void setRaduis(double raduis) {
        this.raduis = raduis;
    }

    @Override
    public double getPerimeter() {
        return this.raduis*Math.PI*2;
    }

    @Override
    public double arena() {
        return this.raduis*this.raduis*Math.PI;
    }

}
