class NhanVienFullTime extends NhanVien implements ChamCong {
    private double heSoLuong;

    public NhanVienFullTime(String hoTen, String maNV, double luongCoBan) {
        super(hoTen, maNV, luongCoBan);
        this.heSoLuong = 1.0; // Hệ số lương mặc định là 1.0
    }

    @Override
    public double tinhLuong() {
        return luongCoBan * heSoLuong;
    }

    @Override
    public void chamCong(int soNgayCong) {
        try {
            if (soNgayCong < 0 || soNgayCong > 31) {
                throw new IllegalArgumentException("Số ngày công không hợp lệ. Vui lòng nhập lại.");
            }
            // Giả sử hệ số lương là 1.5 cho mỗi ngày công.
            this.heSoLuong = 1.5 * soNgayCong;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
