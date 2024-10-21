import java.util.Scanner;

public class Bai_2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long ans = 1;
        while(a > 0)
        {
            ans *= a%10;
            a/=10;
        }
        System.out.println(ans);
    }
}
