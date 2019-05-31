package vn.com.dtt.ungdung16doana.model;


public class Vi {
    private int maVi;
    private String tenVi;
    private String loaiVi;
    private double soDu;
    private String loaiTienTe;

    public Vi(int maVi, String tenVi, String loaiVi, double soDu, String loaiTienTe) {
        this.maVi = maVi;
        this.tenVi = tenVi;
        this.loaiVi = loaiVi;
        this.soDu = soDu;
        this.loaiTienTe = loaiTienTe;
    }

    public Vi(String tenVi, String loaiVi, double soDu, String loaiTienTe) {
        this.tenVi = tenVi;
        this.loaiVi = loaiVi;
        this.soDu = soDu;
        this.loaiTienTe = loaiTienTe;
    }

    public Vi() {
    }

    public int getMaVi() {
        return maVi;
    }

    public void setMaVi(int maVi) {
        this.maVi = maVi;
    }

    public String getTenVi() {
        return tenVi;
    }

    public void setTenVi(String tenVi) {
        this.tenVi = tenVi;
    }

    public String getLoaiVi() {
        return loaiVi;
    }

    public void setLoaiVi(String loaiVi) {
        this.loaiVi = loaiVi;
    }

    public double getSoDu() {
        return soDu;
    }

    public void setSoDu(double soDu) {
        this.soDu = soDu;
    }

    public String getLoaiTienTe() {
        return loaiTienTe;
    }

    public void setLoaiTienTe(String loaiTienTe) {
        this.loaiTienTe = loaiTienTe;
    }
}
