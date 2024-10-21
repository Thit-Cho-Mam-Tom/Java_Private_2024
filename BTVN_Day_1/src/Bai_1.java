import java.util.Scanner;

public class Bai_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        String s = "";
        String digits = "0123456789ABCDEF";
        while (a > 0) {
            int remainder = a % b;
            s = digits.charAt(remainder) + s;
            a /= b;
        }
        System.out.println(s);
    }
}
