import java.util.Scanner;

public class Bai_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int []a = new int[5];
        for(int i = 0; i < 5; i++)
        {
            a[i]=sc.nextInt();
        }
        int maxx1 = Integer.MIN_VALUE;; int maxx2 = Integer.MIN_VALUE;;
        for(int i = 0; i < 5; i++)
        {
            if(a[i]>maxx1)
            {
                maxx2 = maxx1;
                 maxx1 = a[i];
            }
            else if(a[i] > maxx2)
            {
                maxx2 =a[i];
            }
        }
        System.out.println(maxx1 +" "+maxx2);
    }
}
