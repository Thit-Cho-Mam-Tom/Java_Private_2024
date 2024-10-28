import java.util.Arrays;
import java.util.Scanner;

class bai1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; i++)
        {
            a[i]= sc.nextInt();
        }
        int index = Arrays.binarySearch(a,k);
        if(index >= 0){
            System.out.println(index);
        }
        else System.out.println(-1);
    }
}