import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Student> students = new ArrayList<>(); // Danh sách sinh viên

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("===== MENU =====");
            System.out.println("1. Nhập thông tin sinh viên");
            System.out.println("2. Hiển thị thông tin sinh viên");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    displayStudents();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Nhập mã sinh viên: ");
        String studentCode = scanner.nextLine();

        System.out.print("Nhập họ và tên: ");
        String fullName = scanner.nextLine();

        System.out.print("Nhập tuổi: ");
        Byte age = scanner.nextByte();
        scanner.nextLine();

        System.out.print("Nhập giới tính: ");
        String gender = scanner.nextLine();

        System.out.print("Nhập số điện thoại: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Nhập email: ");
        String email = scanner.nextLine();

        Student student = new Student(studentCode, fullName, age, gender, phoneNumber, email);
        students.add(student);
        System.out.println("Đã thêm sinh viên thành công.");
    }

    private static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("Chưa có sinh viên nào trong danh sách.");
            return;
        }

        System.out.printf("%-15s %-30s %-5s %-10s %-15s %-30s%n",
                "Mã sinh viên", "Họ và tên", "Tuổi", "Giới tính", "Số điện thoại", "Email");
        for (Student student : students) {
            student.display();
        }
    }
}
