public class SapXepChon implements XapXep{
    @Override
    public void sapXeptang(double[] arr) {
    int n = arr.length;
    int i,j,min_index;
    for(i = 0;i < n-1;i++){
        min_index=i;
        for(j=i+1;j < n; j++)
            if(arr[j] < arr[min_index])
                min_index=j;


        double temp = arr[min_index];
        arr[min_index]=arr[j];
        arr[i]=temp;
    }
    }

    @Override
    public void sapXepGiam(double[] arr) {
        int n = arr.length;
        int i,j,min_index;
        for(i = 0;i < n-1;i++){
            min_index=i;
            for(j=i+1;j < n; j++)
                if(arr[j] > arr[min_index])
                    min_index=j;
            double temp = arr[min_index];
            arr[min_index]=arr[j];
            arr[i]=temp;
        }
    }
}
