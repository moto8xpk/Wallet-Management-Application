package vn.com.dtt.ungdung16doana.model;

public class StatisticOutcome {
    private String TenLoaiChi;
    private double SoTienChi;

    public StatisticOutcome(String tenLoaiChi, double soTienChi) {
        TenLoaiChi = tenLoaiChi;
        SoTienChi = soTienChi;
    }

    public StatisticOutcome() {
    }

    public String getTenLoaiChi() {
        return TenLoaiChi;
    }

    public void setTenLoaiChi(String tenLoaiChi) {
        TenLoaiChi = tenLoaiChi;
    }

    public double getSoTienChi() {
        return SoTienChi;
    }

    public void setSoTienChi(double soTienChi) {
        SoTienChi = soTienChi;
    }
}
