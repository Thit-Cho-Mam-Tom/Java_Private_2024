import java.util.Scanner;

public abstract class Nguoi {
    protected String hoTen;
    protected int ngaySinh;
    protected String diaChi;

    public Nguoi() {
    }

    public Nguoi(String hoTen, int ngaySinh, String diaChi) {
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

    public int getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(int ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "Nguoi{" +
                "hoTen='" + hoTen + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }

    public void nhapThongtin() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập họ tên:");
        try {
            hoTen = sc.nextLine();
        } catch (Exception e) {
            System.out.println("Lỗi nhập họ tên: " + e.getMessage());
        }

        System.out.println("Nhập ngày sinh:");
        try {
            ngaySinh = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Ngày sinh phải là số nguyên.");
        } catch (Exception e) {
            System.out.println("Lỗi nhập ngày sinh: " + e.getMessage());
        }

        System.out.println("Nhập địa chỉ:");
        try {
            diaChi = sc.nextLine();
        } catch (Exception e) {
            System.out.println("Lỗi nhập địa chỉ: " + e.getMessage());
        }
    }

    public void inThongTin() {
        System.out.println(toString());
    }

    public abstract void tinhDiem();
    public abstract double getDiemTrungBinh();

}
