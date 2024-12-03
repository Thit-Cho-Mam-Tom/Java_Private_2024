public class MayBay extends PhuongTienDiChuyen{
    private String loaiNhienLieu;

    public MayBay() {
    }


    public MayBay(String loaiPhuongTien, HangSanXuat hangSanXuat, String loaiNhienLieu) {
        super(loaiPhuongTien, hangSanXuat);
        this.loaiNhienLieu = loaiNhienLieu;
    }

    public String getLoaiNhienLieu() {
        return loaiNhienLieu;
    }

    public void setLoaiNhienLieu(String loaiNhienLieu) {
        this.loaiNhienLieu = loaiNhienLieu;
    }
    public double layVanToc(){
        return 100;
    }
}
