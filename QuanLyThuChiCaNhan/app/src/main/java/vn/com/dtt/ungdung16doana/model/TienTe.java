package vn.com.dtt.ungdung16doana.model;



public class TienTe {
    private int MaTienTe;
    private String TenTienTe;

    public TienTe(int maTienTe, String tenTienTe) {
        MaTienTe = maTienTe;
        TenTienTe = tenTienTe;
    }

    public TienTe() {
    }

    public TienTe(String tenTienTe) {
        TenTienTe = tenTienTe;
    }

    public int getMaTienTe() {
        return MaTienTe;
    }

    public void setMaTienTe(int maTienTe) {
        MaTienTe = maTienTe;
    }

    public String getTenTienTe() {
        return TenTienTe;
    }

    public void setTenTienTe(String tenTienTe) {
        TenTienTe = tenTienTe;
    }
}
