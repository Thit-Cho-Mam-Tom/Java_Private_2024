import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập bán kính: ");
        double n = sc.nextDouble();
        if(n <= 0) {
            System.out.println("vui lòng nhập bán kính lớn hơn 0");
            return;
        }
        ResizableCircle r = new ResizableCircle(n);
        System.out.println("chu vi hình tròn ban đầu là:" + r.getPerimeter());
        System.out.println("nhập phần trăm thay dổi:");
        int x = sc.nextInt();
        r.resize(x);
        System.out.println("chu vi hình tròn sau đó là:"+r.getPerimeter());
    }
}
