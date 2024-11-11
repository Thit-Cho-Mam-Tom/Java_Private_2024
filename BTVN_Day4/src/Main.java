
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book(3243432, "aaa", "bbb", 2004, "hhh", 50));
        books.add(new Book(24432, "dsfds", "hsss", 2222, "lll", 100));
        books.add(new Book(654654, "kkk", "sss", 1000, "nnn", 10));
        books.add(new Book(876875, "ooo", "jjj", 2444, "ppp", 20));
        books.add(new Book(21121, "avf", "rrrr", 463634, "mmm", 90));
        while (true) {
            System.out.println("------MENU-----");
            System.out.println("1.thêm sách mới");
            System.out.println("2.chỉnh sửa thông tin sách");
            System.out.println("3.In ra danh sách các cuốn sách có trong mảng");
            System.out.println("4.In ra cuốn sách lâu đời cổ kính nhất");
            System.out.println("5.In ra thông tin các loại sách phù hợp với giá tiền");
            System.out.println("6.sắp xếp các cuốn sách");
            System.out.println("0.thoát chương trình");
            System.out.println("chọn chức năng: ");
            int chon = sc.nextInt();
            sc.nextLine();
            switch (chon) {
                case 1:
                    addNewBook(books, sc);
                    break;
                case 2:
                    SuaThongTinSach(books, sc);
                    break;
                case 3:
                    HienThi(books, sc);
                    break;
                case 4:
                    HienThiLauDoi(books, sc);
                    break;
                case 5:
                    SachPhuHop(books, sc);
                    break;
                case 6:
                    SapXep(books, sc);
                    break;
                case 0:
                    System.out.println("Đã thoát chương trình.");
                    sc.close();
                    return;
                default:
                    System.out.println("lựa chọn không hợp lệ");
                    break;
            }
        }
    }
       private static void addNewBook(ArrayList<Book> books, Scanner sc){
            System.out.println("nhập mã sách");
            int maSach = sc.nextInt();
            sc.nextLine();
            System.out.println("nhập tên sách");
            String tenSach =sc.nextLine();
            System.out.println("tên tác giả");
            String tenTacGia= sc.nextLine();
            System.out.println("nhập năm sản xuất");
            int namSanXuat =sc.nextInt();
            sc.nextLine();
            System.out.println("nhâp tóm tắt nội dung");
            String tomTatNoiDung = sc.nextLine();
            System.out.println("nhập giá tiền");
           double giaTien = sc.nextDouble();
           sc.nextLine();
            Book newBook = new Book(maSach,tenSach,tenTacGia,namSanXuat,tomTatNoiDung,giaTien);
            books.add(newBook);
            System.out.println("đã thêm thành công");
        }
        private static void SuaThongTinSach(ArrayList<Book> books, Scanner sc){
            System.out.println("nhập mã sách cần sửa");
            int maSach = sc.nextInt();
            sc.nextLine();
            for(Book b : books){
                if(b.getMaSach() == maSach){
                    System.out.println("nhập tên sách mới");
                    b.setTenSach(sc.nextLine());
                    System.out.println("nhập tên tác giả mới");
                    b.setTenTacGia(sc.nextLine());
                    System.out.println("nhập năm sản xuất mới");
                    b.setNamSanXuat(sc.nextInt());
                    sc.nextLine();
                    System.out.println("nhập tóm tắt nội dung mới");
                    b.setTomTatNoiDung(sc.nextLine());
                    System.out.println("nhập giá tiền mới");
                    b.setGiaTien(sc.nextDouble());
                    sc.nextLine();
                    System.out.println("đã sửa thông tin sách");
                    return;
                }
            }
        }
        public static void HienThi(ArrayList<Book> books, Scanner sc){
            System.out.println("danh sách thông tin các cuốn: ");
            for(Book b : books){
                b.Display();
            }
        }
        public static void HienThiLauDoi(ArrayList<Book> books,Scanner sc){
            int Min = 99999999;
            for(Book b : books){
               if( b.getNamSanXuat() < Min){
                   Min = b.getNamSanXuat();
               }
            }
            System.out.println("thông tin cuốn sách lâu đời nhất là");
            for(Book b : books)
            {
                if(b.getNamSanXuat()==Min){
                    b.Display();
                    return;
                }
            }
        }
        public static void SachPhuHop(ArrayList<Book> books, Scanner sc){
            System.out.println("nhập giá tiền người mua yêu cầu");
            int giatien = sc.nextInt();
            sc.nextLine();
            for(Book b : books){
                if(b.getGiaTien() <= giatien){
                    b.Display();
                    return;
                }
            }
        }
        public static void SapXep(ArrayList<Book> books, Scanner sc){
            System.out.println("chọn cách sắp xếp");
            System.out.println("1.sắp xếp theo giá tiền");
            System.out.println("2.sắp xếp theo tên sách");
            System.out.println("chọn cách sắp xếp:");
            int chonn = sc.nextInt();
            sc.nextLine();
            switch (chonn){
                case 1:
                    books.sort((o1, o2) -> Double.compare(o1.getGiaTien(),o2.getGiaTien()));
                    System.out.println("đã sắp xếp theo giá tiền");
                    break;
                case 2:
                    books.sort((o1, o2) -> o1.getTenSach().compareTo(o2.getTenSach()));
                    System.out.println("đã sắp xếp theo tên sách");
                    break;
                default:
                    System.out.println("lựa chọn không hợp lệ");
                    return;
            }
        }

    }
