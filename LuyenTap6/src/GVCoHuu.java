import java.util.Scanner;

public class GVCoHuu extends GiangVien{
    private double luongCoBan;
    private double heSoLuong;
    private int thamNien;

    public GVCoHuu(){

    }
    public GVCoHuu(double luongCoBan, double heSoLuong, int thamNien) {
        this.luongCoBan = luongCoBan;
        this.heSoLuong = heSoLuong;
        this.thamNien = thamNien;
    }

    public GVCoHuu(String hoTen, String ngaySinh, String diaChi, double luongCoBan, double heSoLuong, int thamNien) {
        super(hoTen, ngaySinh, diaChi);
        this.luongCoBan = luongCoBan;
        this.heSoLuong = heSoLuong;
        this.thamNien = thamNien;
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public int getThamNien() {
        return thamNien;
    }

    public void setThamNien(int thamNien) {
        this.thamNien = thamNien;
    }

    @Override
    public void nhapThongTin() {
        Scanner sc =new Scanner(System.in);
        System.out.println("nhập lương cơ bản");
        try{
            luongCoBan = sc.nextDouble();
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("đang xảy ra lỗi"+e.getMessage());
        }
        System.out.println("nhập hệ số lương");
        try {
            heSoLuong=sc.nextDouble();
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("đang xảy ra lỗi"+e.getMessage());
        }
        System.out.println("nhập thâm niên");
        try{
            thamNien=sc.nextInt();
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("đang xảy ra lỗi"+e.getMessage());
        }
    }

    @Override
    public double tinhLuong() {
        double phuCap;
        if(thamNien < 5){
            phuCap=0;
        }
        else phuCap=(5+(thamNien-5))*luongCoBan/100;
        return luongCoBan*heSoLuong*phuCap;
    }
}
