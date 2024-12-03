import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Nhập số lượng sinh viên (2-4): ");
            int n = sc.nextInt();
            if (n < 2 || n > 4) {
                System.out.println("Số lượng sinh viên phải từ 2 đến 4.");
                return;
            }

            Nguoi[] sinhVienArray = new Nguoi[n];

            // Nhập thông tin sinh viên
            for (int i = 0; i < n; i++) {
                System.out.println("Nhập thông tin sinh viên thứ " + (i + 1));
                sc.nextLine();  // Clear buffer
                System.out.print("Nhập loại sinh viên (1: SVCĐCQ, 2: SVCĐN): ");
                int loai = sc.nextInt();
                sc.nextLine();  // Clear buffer

                if (loai == 1) {
                    sinhVienArray[i] = new sinhVienCDCQ();
                } else {
                    sinhVienArray[i] = new sinhVienCDN();
                }

                sinhVienArray[i].nhapThongtin();
            }

            // Sắp xếp mảng sinh viên theo điểm trung bình giảm dần (Bubble Sort)
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (sinhVienArray[i].getDiemTrungBinh() < sinhVienArray[j].getDiemTrungBinh()) {
                        // Hoán đổi vị trí
                        Nguoi temp = sinhVienArray[i];
                        sinhVienArray[i] = sinhVienArray[j];
                        sinhVienArray[j] = temp;
                    }
                }
            }

            // Hiển thị thông tin các sinh viên sau khi sắp xếp
            System.out.println("\nThông tin sinh viên (sắp xếp theo điểm trung bình giảm dần):");
            for (Nguoi sv : sinhVienArray) {
                sv.inThongTin();
                sv.tinhDiem();
            }

            // Tìm kiếm sinh viên theo mã
            System.out.print("Nhập mã sinh viên cần tìm: ");
            String maSV = sc.nextLine();
            boolean found = false;

            for (Nguoi sv : sinhVienArray) {
                // Giả sử mã sinh viên là họ tên
                if (sv.getHoTen().equalsIgnoreCase(maSV)) {
                    sv.inThongTin();
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Không tồn tại sinh viên với mã " + maSV);
            }

        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
