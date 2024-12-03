import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        try{
            System.out.println("nhập số giảng viên hữu cơ (2-4): ");
            int n=sc.nextInt();
            sc.nextLine();
            if(n < 2 && n >4){
                System.out.println("vui lòng nhập lại");
                return;
            }
            GVCoHuu[] dsGvCoHuus = new GVCoHuu[n];
            for(int i = 0; i < n; i++){
                System.out.println("nhập thông tin giảng viên cơ hữu thứ" + (i+1)+": ");
                System.out.println("nhập họ tên: ");
                String hoTen=sc.nextLine();
                System.out.println("nhập ngày sinh: ");
                String ngaySinh=sc.nextLine(); 
                System.out.println("nhâp dịa chỉ: ");
                String diaChi =sc.nextLine();
                System.out.println("nhập lương cơ bản: ");
                double luongCoBan=sc.nextDouble();
                sc.nextLine();
                System.out.println("nhập hệ số lương: ");
                double heSoLuong =sc.nextDouble();
                sc.nextLine();
                System.out.println("nhập thâm niên: ");
                int thamNien =sc.nextInt();
                sc.nextLine();
                dsGvCoHuus[i]=new GVCoHuu(hoTen,ngaySinh,diaChi,luongCoBan,heSoLuong,thamNien);
            }

            for(GVCoHuu gv : dsGvCoHuus){
                gv.inThongTin();
                System.out.println("lương:"+gv.tinhLuong());
            }
            System.out.println("nhập mã giảng viên cần tìm");
            String maGV = sc.nextLine();
            boolean check = false;
            for(GVCoHuu gv:dsGvCoHuus){
                if(gv.getHoTen().equalsIgnoreCase(maGV)){
                    gv.inThongTin();
                    check = true;
                    break;
                }
            }
            if(!check){
                System.out.println("khôgn tìm thấy");
            }
            for(int i = 0; i < n-1;i++){
                for(int j =i+1; j < n; j++)
                {
                    if(dsGvCoHuus[i].tinhLuong() <dsGvCoHuus[j].tinhLuong())
                    {
                        GVCoHuu tem = dsGvCoHuus[i];
                        dsGvCoHuus[i]=dsGvCoHuus[j];
                        dsGvCoHuus[j]=tem;
                    }
                }
            }
            for(GVCoHuu gv : dsGvCoHuus){
                gv.inThongTin();
                System.out.println("lương:"+gv.tinhLuong());
            }

        } catch (Exception e) {
            System.out.println("đang xảy ra lỗi"+e.getMessage());
        }

    }
}
