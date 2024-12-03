import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            // Nhập số nhân viên cần nhập
            System.out.println("Nhập số nhân viên cần nhập (2-5): ");
            int n = sc.nextInt();
            if (n < 2 || n > 5) {
                System.out.println("Số nhân viên không hợp lệ. Vui lòng nhập lại.");
                return;
            }

            // Mảng nhân viên
            NhanVienFullTime[] nhanViens = new NhanVienFullTime[n];
            sc.nextLine();  // Dùng để xóa ký tự newline còn sót lại

            // Nhập thông tin nhân viên
            for (int i = 0; i < n; i++) {
                System.out.println("Nhập thông tin cho nhân viên thứ " + (i + 1) + ": ");
                System.out.print("Nhập họ tên: ");
                String hoTen = sc.nextLine();
                System.out.print("Nhập mã nhân viên: ");
                String maNV = sc.nextLine();
                System.out.print("Nhập lương cơ bản: ");
                double luongCoBan = sc.nextDouble();
                sc.nextLine(); // Dùng để xóa ký tự newline còn sót lại

                nhanViens[i] = new NhanVienFullTime(hoTen, maNV, luongCoBan);
            }

            // Hiển thị thông tin nhân viên
            System.out.println("\nDanh sách thông tin nhân viên vừa nhập: ");
            for (NhanVienFullTime nv : nhanViens) {
                nv.inThongTin();
            }

            // Thực hiện chamCong và tinhLuong cho từng nhân viên
            for (NhanVienFullTime nv : nhanViens) {
                System.out.print("\nNhập số ngày công cho nhân viên " + nv.getHoTen() + ": ");
                int soNgayCong = sc.nextInt();
                nv.chamCong(soNgayCong);  // Cập nhật hệ số lương
                nv.inThongTin();  // In thông tin nhân viên
            }

        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}