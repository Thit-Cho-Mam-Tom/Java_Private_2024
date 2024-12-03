import java.util.Scanner;

public abstract class GiangVien {
    protected String hoTen;
    protected String ngaySinh;
    protected String diaChi;

    public GiangVien() {
    }

    public GiangVien(String hoTen, String ngaySinh, String diaChi) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập họ tên: ");
        this.hoTen= sc.nextLine();
        System.out.println("nhập ngày sinh: ");
        this.ngaySinh=sc.nextLine();
        System.out.println("nhập địa chỉ: ");
        this.diaChi= sc.nextLine();
    }
    public void output(){
        System.out.println("họ tên: "+this.hoTen);
        System.out.println("ngày sinh: "+this.ngaySinh);
        System.out.println("dịa chỉ: "+ this.diaChi);
    }
    public abstract double tinhLuong();
}