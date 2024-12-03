import java.util.Scanner;

public class SVCDCQ extends Nguoi implements tinhDiem{
    private double TDSMKT;
    private int SMKT;
    private double DTKTHP;

    public SVCDCQ() {
        super();
    }


    public SVCDCQ(String hoTen, String ngaySinh, String diaChi, double TDSMKT, int SMKT, double DTKTHP) {
        super(hoTen, ngaySinh, diaChi);
        this.TDSMKT = TDSMKT;
        this.SMKT = SMKT;
        this.DTKTHP = DTKTHP;
    }

    public double getTDSMKT() {
        return TDSMKT;
    }

    public void setTDSMKT(double TDSMKT) {
        this.TDSMKT = TDSMKT;
    }

    public int getSMKT() {
        return SMKT;
    }

    public void setSMKT(int SMKT) {
        this.SMKT = SMKT;
    }

    public double getDTKTHP() {
        return DTKTHP;
    }

    public void setDTKTHP(double DTKTHP) {
        this.DTKTHP = DTKTHP;
    }
    public void nhapthongtin(){
        super.nhapthongtin();
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập tổng điểm số môn kiểm tra: ");
        this.TDSMKT= sc.nextDouble();
        sc.nextLine();
        System.out.println("nhập tổng số môn kiểm tra: ");
        this.SMKT= sc.nextInt();
        sc.nextLine();
        System.out.println("nhập điểm kết thúc học phần: ");
        this.DTKTHP=sc.nextDouble();
        sc.nextLine();
    }
    @Override
    public double tinhDiem() {
        return (TDSMKT/SMKT +DTKTHP)/3;
    }
}
