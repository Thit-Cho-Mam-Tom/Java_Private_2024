public class Test {
    public static void main(String[] args) {
        System.out.println("Test câu a: ");
        MayTinhCasio580 mt= new MayTinhCasio580();
        MayTinhVinacal500 mt2 = new MayTinhVinacal500();
        System.out.println("5+3="+mt.cong(5,3));
        System.out.println("5/0="+mt2.chia(5,0));
        System.out.println("test câu b:");
        double[] arr= new double[]{4,2,6,1,6,2};
        double[] arr2= new double[]{5,9,5,2,6,8,3};
        SapXepChen sxc = new SapXepChen();
        SapXepChon sxcn = new SapXepChon();
        sxcn.sapXepGiam(arr2);
        for(int i = 0; i < arr2.length;i++){
            System.out.print(arr2[i]+" ");
        }
    }
}
