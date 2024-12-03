import java.util.Scanner;

public class GVThinhGiangimpl extends GiangVien implements GVThinhGiang {


    private int soTietDay;
    private double donGia;

    public GVThinhGiangimpl() {

    }

    public GVThinhGiangimpl(int soTietDay, double donGia) {
        this.soTietDay = soTietDay;
        this.donGia = donGia;
    }

    public GVThinhGiangimpl(String hoTen, String ngaySinh, String diaChi, int soTietDay, double donGia) {
        super(hoTen, ngaySinh, diaChi);
        this.soTietDay = soTietDay;
        this.donGia = donGia;
    }

    public int getSoTietDay() {
        return soTietDay;
    }

    public void setSoTietDay(int soTietDay) {
        this.soTietDay = soTietDay;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return "GVThinhGiangimpl{" +
                "soTietDay=" + soTietDay +
                ", donGia=" + donGia +
                ", hoTen='" + hoTen + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }
    @Override
    public void setsoTietDay(int soTietDay) {
    this.soTietDay=soTietDay;
    }

    @Override
    public void setdonGia(double donGia) {
this.donGia=donGia;
    }

    @Override
    public void nhapThongTin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập số tiết dạy");
        try{
            soTietDay=sc.nextInt();
            sc.nextLine();
        }catch(Exception e){
            System.out.println("đang xảy ra lỗi"+e.getMessage());
        }
        System.out.println("nhập đơn giá");
        try{
            donGia=sc.nextDouble();
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("đang xảy ra lỗi"+e.getMessage());
        }
    }

    @Override
    public double tinhLuong() {
        double thuNhap =soTietDay*donGia;
        double thueThuNhap=0.15*thuNhap;
        return thuNhap-thueThuNhap;
    }
}
