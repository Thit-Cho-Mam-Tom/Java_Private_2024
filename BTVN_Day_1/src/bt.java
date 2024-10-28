import java.util.Scanner;

public class bt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []a = new int[n];
        for (int i = 0; i < n; i++){
            a[i]=sc.nextInt();
        }
        int []b = new int [n];
        int ans =0;
        for(int i = 0; i < n; i++)
        {
            b[a[i]]++;
        }
        int x = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++)
        {
            if(b[i] > x){
                x=b[i];
                ans=a[i];
            }
        }
        System.out.println(x +" "+ans);
    }
}
