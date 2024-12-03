import java.util.Scanner;

public class SVCDN extends Nguoi{
    private double TDKT;
    private int SMKT;

    public SVCDN() {
        super();
    }

    public SVCDN(String hoTen, String ngaySinh, String diaChi, double TDKT, int SMKT) {
        super(hoTen, ngaySinh, diaChi);
        this.TDKT = TDKT;
        this.SMKT = SMKT;
    }

    public double getTDKT() {
        return TDKT;
    }

    public void setTDKT(double TDKT) {
        this.TDKT = TDKT;
    }

    public int getSMKT() {
        return SMKT;
    }

    public void setSMKT(int SMKT) {
        this.SMKT = SMKT;
    }

    @Override
    public void nhapthongtin() {
        super.nhapthongtin();
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập tổng điểm kiểm tra: ");
        this.TDKT=sc.nextDouble();
        sc.nextLine();
        System.out.println("nhập số môn kiểm tra: ");
        this.SMKT=sc.nextInt();
        sc.nextLine();
    }
    @Override
    public double tinhDiem(){
        return TDKT/SMKT;
    }
}
