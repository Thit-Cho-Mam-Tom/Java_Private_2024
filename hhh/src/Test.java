import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("nhâp số sinh viên cần nhập(2-4): ");
            int n = sc.nextInt();
            sc.nextLine();
            if(n < 2 || n > 4){
                System.out.println("vui lòng nhập lại: ");
                return;
            }
            SVCDCQ[] sv = new SVCDCQ[n];
            for(int i = 0; i < n; i++){
                System.out.println("nhập thông tin cho sinh viên thứ "+i+": ");
                sv[i]=new SVCDCQ();
                sv[i].nhapthongtin();
            }
            System.out.println("hiển thị danh sách thông tin các sinh viên: ");
            for(SVCDCQ x:sv){
               x.inthongtin();
            }
            System.out.println("nhập mã sinh viên cần tìm: ");
            String MaSV= sc.nextLine();
            boolean check = true;
            for(SVCDCQ x :sv){
                if(x.getHoTen().equalsIgnoreCase(MaSV)){
                    x.inthongtin();
                    check = false;
                }
            }
            if(check)System.out.println("không tìm thấy");
            for(int i = 0; i < n-1; i++){
                for(int j = i+1; j < n; j++){
                    if(sv[i].tinhDiem() < sv[j].tinhDiem()){
                        SVCDCQ tmp = sv[i];
                        sv[i]=sv[j];
                        sv[j]=tmp;
                    }
                }
            }
            for(SVCDCQ x:sv){
                x.inthongtin();
            }
        }catch (Exception e){
            System.out.println("đang có lỗi "+ e.getMessage());
        }
    }
}
