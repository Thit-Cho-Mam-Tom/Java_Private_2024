import java.util.Scanner;

public class bt2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; i++)
        {
            a[i]= sc.nextInt();
        }
        int []b = new int[n];
        b[0]=a[0];
        for(int i = 1; i < n; i++)
        {
            b[i]=b[i-1]+a[i];
        }
        int q=sc.nextInt();
        while(q!=0){
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(b[y]-b[x-1]);
            q--;
        }
    }
}
