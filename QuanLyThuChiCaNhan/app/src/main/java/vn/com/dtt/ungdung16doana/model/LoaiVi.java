package vn.com.dtt.ungdung16doana.model;



public class LoaiVi {
    private int maLoaiVi;
    private String tenLoaiVi;

    //tạo contructor không có ID
//region contructor ko ID

    public LoaiVi(String tenLoaiVi) {
        this.tenLoaiVi = tenLoaiVi;
    }

    public LoaiVi(int maLoaiVi, String tenLoaiVi) {
        this.maLoaiVi = maLoaiVi;
        this.tenLoaiVi = tenLoaiVi;
    }

    public LoaiVi() {
    }

    public int getMaLoaiVi() {
        return maLoaiVi;
    }

    public void setMaLoaiVi(int maLoaiVi) {
        this.maLoaiVi = maLoaiVi;
    }

    public String getTenLoaiVi() {
        return tenLoaiVi;
    }

    public void setTenLoaiVi(String tenLoaiVi) {
        this.tenLoaiVi = tenLoaiVi;
    }
    //endregion
}
