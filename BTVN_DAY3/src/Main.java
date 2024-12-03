import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Nhập thông tin sinh viên");
            System.out.println("2. Hiển thị thông tin sinh viên");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Đọc bỏ dòng mới sau số

            switch (choice) {
                case 1:
                    // Nhập thông tin sinh viên
                    System.out.print("Nhập mã sinh viên: ");
                    String studentCode = scanner.nextLine();
                    System.out.print("Nhập họ tên: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Nhập tuổi: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();  // Đọc bỏ dòng mới
                    System.out.print("Nhập số điện thoại: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Nhập email: ");
                    String email = scanner.nextLine();

                    // Tạo đối tượng Student và thêm vào danh sách
                    Student student = new Student(studentCode, fullName, age, phoneNumber, email);
                    students.add(student);
                    System.out.println("Đã thêm sinh viên thành công!");
                    break;

                case 2:
                    // Hiển thị thông tin sinh viên
                    if (students.isEmpty()) {
                        System.out.println("Không có sinh viên nào để hiển thị.");
                    } else {
                        System.out.printf("| %-12s | %-20s | %-3s | %-12s | %-25s |\n",
                                "Mã SV", "Họ tên", "Tuổi", "SĐT", "Email");
                        for (Student s : students) {
                            s.display();
                        }
                    }
                    break;

                case 0:
                    // Thoát chương trình
                    System.out.println("Đã thoát chương trình.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
}
