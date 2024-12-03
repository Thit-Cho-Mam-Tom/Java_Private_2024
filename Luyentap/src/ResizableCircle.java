public class ResizableCircle extends Cricle implements Resizable{
    public ResizableCircle() {
    }

    public ResizableCircle(double raduis) {
        super(raduis);
    }
    @Override
    public void resize(int precent) {
      this.raduis *= (1+precent/100.0);
    }

}
