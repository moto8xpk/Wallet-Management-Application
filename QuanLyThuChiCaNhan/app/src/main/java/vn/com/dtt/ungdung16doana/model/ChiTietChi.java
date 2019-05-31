package vn.com.dtt.ungdung16doana.model;


public class ChiTietChi {
    private int MaGiaoDichChi;
    private String TenLoaiChi;
    private String TenViChi;
    private double SoTienChi;
    private String NgayChi;
    private String DienGiaiChi;

    public ChiTietChi(int maGiaoDichChi, String tenLoaiChi, String tenViChi, double soTienChi, String ngayChi, String dienGiaiChi) {
        MaGiaoDichChi = maGiaoDichChi;
        TenLoaiChi = tenLoaiChi;
        TenViChi = tenViChi;
        SoTienChi = soTienChi;
        NgayChi = ngayChi;
        DienGiaiChi = dienGiaiChi;
    }
    public ChiTietChi( String tenLoaiChi, String tenViChi, double soTienChi, String ngayChi, String dienGiaiChi) {
        TenLoaiChi = tenLoaiChi;
        TenViChi = tenViChi;
        SoTienChi = soTienChi;
        NgayChi = ngayChi;
        DienGiaiChi = dienGiaiChi;
    }
    public ChiTietChi() {
    }

    public int getMaGiaoDichChi() {
        return MaGiaoDichChi;
    }

    public void setMaGiaoDichChi(int maGiaoDichChi) {
        MaGiaoDichChi = maGiaoDichChi;
    }

    public String getTenLoaiChi() {
        return TenLoaiChi;
    }

    public void setTenLoaiChi(String tenLoaiChi) {
        TenLoaiChi = tenLoaiChi;
    }

    public String getTenViChi() {
        return TenViChi;
    }

    public void setTenViChi(String tenViChi) {
        TenViChi = tenViChi;
    }

    public double getSoTienChi() {
        return SoTienChi;
    }

    public void setSoTienChi(double soTienChi) {
        SoTienChi = soTienChi;
    }

    public String getNgayChi() {
        return NgayChi;
    }

    public void setNgayChi(String ngayChi) {
        NgayChi = ngayChi;
    }

    public String getDienGiaiChi() {
        return DienGiaiChi;
    }

    public void setDienGiaiChi(String dienGiaiChi) {
        DienGiaiChi = dienGiaiChi;
    }
}
