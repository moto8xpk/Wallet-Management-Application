package vn.com.dtt.ungdung16doana.model;


public class LoaiChi {
    private int MaChi;
    private String TenLoaiChi;

    public LoaiChi(int maChi, String tenLoaiChi) {
        MaChi = maChi;
        TenLoaiChi = tenLoaiChi;
    }

    public LoaiChi(String tenLoaiChi) {
        TenLoaiChi = tenLoaiChi;
    }

    public LoaiChi() {
    }

    public int getMaChi() {
        return MaChi;
    }

    public void setMaChi(int maChi) {
        MaChi = maChi;
    }

    public String getTenLoaiChi() {
        return TenLoaiChi;
    }

    public void setTenLoaiChi(String tenLoaiChi) {
        TenLoaiChi = tenLoaiChi;
    }
}
