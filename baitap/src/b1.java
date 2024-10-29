import java.util.Scanner;
import java.util.Scanner;

    class bt4 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n= sc.nextInt();
            int []a = new int[n+1];
            a[0]=0;
            for(int i = 1;i <= n; i++)
            {
                a[i]=sc.nextInt();
            }
            for(int i = 1;i <= n; i++)
            {
                a[i]=a[i]+a[i-1];
            }
            int q = sc.nextInt();
            while(q>0){
                int l = sc.nextInt();
                int r = sc.nextInt();
                long x = a[r]- a[l-1];
                System.out.println(x);
            }
        }
    }

