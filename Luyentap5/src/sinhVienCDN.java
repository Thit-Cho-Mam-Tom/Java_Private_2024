import java.util.Scanner;

public class sinhVienCDN extends Nguoi {
    private double tdkt;
    private int smkt;

    @Override
    public void nhapThongtin() {
        super.nhapThongtin();
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập tổng điểm các môn kiểm tra:");
        try {
            tdkt = Double.parseDouble(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Tổng điểm các môn kiểm tra phải là số thực.");
        } catch (Exception e) {
            System.out.println("Lỗi nhập tổng điểm kiểm tra: " + e.getMessage());
        }

        System.out.println("Nhập số môn kiểm tra:");
        try {
            smkt = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Số môn kiểm tra phải là số nguyên.");
        } catch (Exception e) {
            System.out.println("Lỗi nhập số môn kiểm tra: " + e.getMessage());
        }
    }
    public void tinhDiem() {
        if (smkt == 0) {
            System.out.println("Lỗi: Số môn kiểm tra phải lớn hơn 0 để tính điểm trung bình.");
            return;
        }
        double dtb = tdkt / smkt;
        System.out.println("Điểm trung bình là: " + dtb);
    }
    @Override
    public double getDiemTrungBinh() {
        return tdkt / smkt;
    }

}
