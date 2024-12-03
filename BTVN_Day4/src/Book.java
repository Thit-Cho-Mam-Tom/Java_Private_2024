public class Book {
    protected int maSach;
    protected String tenSach;
    protected TacGia tenTacGia;
    protected int namSanXuat;
    protected String tomTatNoiDung;
    protected double giaTien;

    public Book(){

    }

    public Book(int maSach, String tenSach, TacGia tenTacGia, int namSanXuat, String tomTatNoiDung, double giaTien) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tenTacGia = tenTacGia;
        this.namSanXuat = namSanXuat;
        this.tomTatNoiDung = tomTatNoiDung;
        this.giaTien = giaTien;
    }


    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public TacGia getTenTacGia() {
        return tenTacGia;
    }


    public int getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(int namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public String getTomTatNoiDung() {
        return tomTatNoiDung;
    }

    public void setTomTatNoiDung(String tomTatNoiDung) {
        this.tomTatNoiDung = tomTatNoiDung;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    @Override
    public String toString() {
        return "Book{" +
                "maSach=" + maSach +
                ", tenSach='" + tenSach + '\'' +
                ", tenTacGia='" + tenTacGia + '\'' +
                ", namSanXuat=" + namSanXuat +
                ", tomTatNoiDung='" + tomTatNoiDung + '\'' +
                ", giaTien=" + giaTien +
                '}';
    }
    public void Display(){
        System.out.println(toString());
    }

    public void setTacGia(TacGia tacGia) {
        this.tenTacGia = tacGia;
    }
}
