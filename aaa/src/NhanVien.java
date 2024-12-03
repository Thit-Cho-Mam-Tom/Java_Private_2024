import java.util.Scanner;

// Lớp trừu tượng NhanVien
public abstract class NhanVien {
    protected String hoTen;
    protected String maNV;
    protected double luongCoBan;

    public NhanVien(String hoTen, String maNV, double luongCoBan) {
        this.hoTen = hoTen;
        this.maNV = maNV;
        this.luongCoBan = luongCoBan;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getMaNV() {
        return maNV;
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public abstract double tinhLuong();

    public void inThongTin() {
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Mã nhân viên: " + maNV);
        System.out.println("Lương: " + tinhLuong());
    }
}
