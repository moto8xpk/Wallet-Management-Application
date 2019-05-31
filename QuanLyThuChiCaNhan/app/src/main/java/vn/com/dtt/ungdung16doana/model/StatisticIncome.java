package vn.com.dtt.ungdung16doana.model;

/**
 * Created by PC on 09/12/2017.
 */

public class StatisticIncome {

    private String TenLoaiThu;
    private double SoTienThu;

    public StatisticIncome(String tenLoaiThu, double soTienThu) {
        TenLoaiThu = tenLoaiThu;
        SoTienThu = soTienThu;
    }
    public StatisticIncome() {
    }

    public String getTenLoaiThu() {
        return TenLoaiThu;
    }

    public void setTenLoaiThu(String tenLoaiThu) {
        TenLoaiThu = tenLoaiThu;
    }

    public double getSoTienThu() {
        return SoTienThu;
    }

    public void setSoTienThu(double soTienThu) {
        SoTienThu = soTienThu;
    }
}
