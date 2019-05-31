package vn.com.dtt.ungdung16doana.model;



public class ChiTietThu {
    private int MaGiaoDichThu;
    private String TenLoaiThu;
    private String TenViThu;
    private double SoTienThu;
    private String NgayThu;
    private String DienGiaiThu;

    public ChiTietThu(int maGiaoDichThu, String tenLoaiThu, String tenViThu, double soTienThu, String ngayThu, String dienGiaiThu) {
        MaGiaoDichThu = maGiaoDichThu;
        TenLoaiThu = tenLoaiThu;
        TenViThu = tenViThu;
        SoTienThu = soTienThu;
        NgayThu = ngayThu;
        DienGiaiThu = dienGiaiThu;
    }
    public ChiTietThu( String tenLoaiThu, String tenViThu, double soTienThu, String ngayThu, String dienGiaiThu) {
        TenLoaiThu = tenLoaiThu;
        TenViThu = tenViThu;
        SoTienThu = soTienThu;
        NgayThu = ngayThu;
        DienGiaiThu = dienGiaiThu;
    }
    public ChiTietThu() {

    }

    public int getMaGiaoDichThu() {
        return MaGiaoDichThu;
    }

    public void setMaGiaoDichThu(int maGiaoDichThu) {
        MaGiaoDichThu = maGiaoDichThu;
    }

    public String getTenLoaiThu() {
        return TenLoaiThu;
    }

    public void setTenLoaiThu(String tenLoaiThu) {
        TenLoaiThu = tenLoaiThu;
    }

    public String getTenViThu() {
        return TenViThu;
    }

    public void setTenViThu(String tenViThu) {
        TenViThu = tenViThu;
    }

    public double getSoTienThu() {
        return SoTienThu;
    }

    public void setSoTienThu(double soTienThu) {
        SoTienThu = soTienThu;
    }

    public String getNgayThu() {
        return NgayThu;
    }

    public void setNgayThu(String ngayThu) {
        NgayThu = ngayThu;
    }

    public String getDienGiaiThu() {
        return DienGiaiThu;
    }

    public void setDienGiaiThu(String dienGiaiThu) {
        DienGiaiThu = dienGiaiThu;
    }
}
