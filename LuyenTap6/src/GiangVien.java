public abstract class GiangVien {
    protected String hoTen;
    protected String ngaySinh;
    protected String diaChi;

    public GiangVien() {
    }

    public GiangVien(String hoTen, String ngaySinh, String diaChi) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "GiangVien{" +
                "hoTen='" + hoTen + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }
    public void inThongTin(){
        System.out.println(toString());
    }
    public abstract void nhapThongTin();
    public abstract double tinhLuong();
}
