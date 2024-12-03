public class Test {
    public static void main(String[] args) {
      HangSanXuat h = new HangSanXuat("Vinfast","Vietnam");
      PhuongTienDiChuyen mb = new MayBay("maybay",h,"xang");
      PhuongTienDiChuyen oto = new XeOto("oto",h,"xang");
      PhuongTienDiChuyen xedep = new XeDap("xedap",h);
        System.out.println("lấy hàng sản xuất");
        System.out.println("mb"+ mb.layTenHangSanXuat());
        System.out.println("vận tốc"+ xedep.layVanToc());
    }
}
