package vn.com.dtt.ungdung16doana.model;


public class LoaiThu {
    private int MaThu;
    private String TenLoaiThu;

    public LoaiThu(int maThu, String tenLoaiThu) {
        MaThu = maThu;
        TenLoaiThu = tenLoaiThu;
    }

    public LoaiThu(String tenLoaiThu) {
        TenLoaiThu = tenLoaiThu;
    }

    public LoaiThu() {
    }

    public int getMaThu() {
        return MaThu;
    }

    public void setMaThu(int maThu) {
        MaThu = maThu;
    }

    public String getTenLoaiThu() {
        return TenLoaiThu;
    }

    public void setTenLoaiThu(String tenLoaiThu) {
        TenLoaiThu = tenLoaiThu;
    }
}
