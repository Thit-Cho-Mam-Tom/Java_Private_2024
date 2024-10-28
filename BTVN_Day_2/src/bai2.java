import java.util.Arrays;
import java.util.Scanner;

class bai2{
    public static long solve(int[]a, int n, int k){
        long sum = 0;
        for(int i = 0; i < k; i++)
        {
            sum+=a[i];
        }
        long maxsum = sum;
        long x = 0;
        for(int i = k; i < n; i++)
        {
            sum+= a[i]-a[i-k];
            x+=a[i-k];
            x=Math.max(x,0);
            maxsum = Math.max(maxsum,sum+x);
        }
        return maxsum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int []a = new int [n];
        for(int i = 0; i < n; i++)
        {
            a[i]=sc.nextInt();
        }
        System.out.println(solve(a,n,k));
    }
}