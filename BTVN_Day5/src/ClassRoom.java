import java.util.ArrayList;
import java.util.Scanner;

public class ClassRoom {
    static ArrayList<Student> students = new ArrayList<>(); // Danh sách sinh viên

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n------MENU------");
            System.out.println("1. Nhập thông tin sinh viên");
            System.out.println("2. In ra thông tin sinh viên");
            System.out.println("3. Sắp xếp danh sách sinh viên");
            System.out.println("4. Xóa sinh viên theo ID");
            System.out.println("0. Thoát chương trình");
            System.out.print("Lựa chọn của bạn: ");
            int chon = sc.nextInt();
            sc.nextLine(); // Xóa bộ đệm

            switch (chon) {
                case 1:
                    inputList(sc);
                    break;
                case 2:
                    outputList();
                    break;
                case 3:
                    sortByGpa();
                    break;
                case 4:
                    removeById(sc);
                    break;
                case 0:
                    System.out.println("Thoát chương trình!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
            }
        }
    }

    // Nhập thông tin danh sách sinh viên
    public static void inputList(Scanner sc) {
        while (true) {
            Student student = new Student();
            student.input();
            students.add(student);
            System.out.println("Nhập Thành Công Sinh Viên!");
            if (students.getLast().getId() == 555) return;
        }
    }

    // In danh sách sinh viên dưới dạng bảng
    public static void outputList() {
        if (students.isEmpty()) {
            System.out.println("\nDanh sách sinh viên trống.");
            return;
        }

        System.out.printf("\n%-10s %-20s %-10s %-10s %-20s %-20s %-20s %-20s\n",
                "ID", "Name", "Age", "GPA", "Class", "Commune", "District", "City");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");

        for (Student s : students) {
            System.out.printf("%-10d %-20s %-10d %-10.2f %-20s %-20s %-20s %-20s\n",
                    s.getId(), s.getName(), s.getAge(), s.getGpa(), s.getNameClass(),
                    s.getAddress().getCommune(), s.getAddress().getDistrict(), s.getAddress().getCity());
        }
    }

    // Sắp xếp danh sách sinh viên theo GPA
    public static void sortByGpa() {
        if (students.isEmpty()) {
            System.out.println("\nDanh sách sinh viên trống.");
            return;
        }

        students.sort((s1, s2) -> Float.compare(s2.getGpa(), s1.getGpa())); // Sắp xếp giảm dần theo GPA
        System.out.println("\nDanh sách sinh viên sau khi sắp xếp theo GPA:");
        outputList();
    }

    // Xóa sinh viên theo ID
    public static void removeById(Scanner sc) {
        if (students.isEmpty()) {
            System.out.println("\nDanh sách sinh viên trống.");
            return;
        }

        System.out.print("\nNhập ID sinh viên cần xóa: ");
        int idToRemove = sc.nextInt();

        boolean removed = students.removeIf(student -> student.getId() == idToRemove); // Xóa nếu ID trùng khớp
        if (removed) {
            System.out.println("Xóa sinh viên thành công!");
        } else {
            System.out.println("Không tìm thấy sinh viên với ID: " + idToRemove);
        }
    }
}
