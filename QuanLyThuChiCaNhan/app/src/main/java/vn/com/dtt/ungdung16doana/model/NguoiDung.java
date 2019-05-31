package vn.com.dtt.ungdung16doana.model;

public class NguoiDung {
    private int manguoidung;
    private String hoten;
    private String tentaikhoan;
    private String matkhau;
    private String email;
    private Boolean quyen;

    //region contructor ko ID
    public NguoiDung(String hoten, String tentaikhoan, String matkhau, String email, Boolean quyen) {
        this.hoten = hoten;
        this.tentaikhoan = tentaikhoan;
        this.matkhau = matkhau;
        this.email = email;
        this.quyen = quyen;
    }
    public NguoiDung(String tentaikhoan, String matkhau) {
        this.tentaikhoan = tentaikhoan;
        this.matkhau = matkhau;
    }
    public NguoiDung(int manguoidung,String tentaikhoan, String matkhau) {
        this.manguoidung=manguoidung;
        this.tentaikhoan = tentaikhoan;
        this.matkhau = matkhau;
    }
    public NguoiDung() {}
    //endregion
    //region contructor co ID
    public NguoiDung(int manguoidung, String hoten, String tentaikhoan, String matkhau, String email, Boolean quyen) {
        this.manguoidung = manguoidung;
        this.hoten = hoten;
        this.tentaikhoan = tentaikhoan;
        this.matkhau = matkhau;
        this.email = email;
        this.quyen = quyen;
    }

    //endregion
    //region Get and set
    public int getManguoidung() {
        return manguoidung;
    }

    public void setManguoidung(int manguoidung) {
        this.manguoidung = manguoidung;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getTentaikhoan() {
        return tentaikhoan;
    }

    public void setTentaikhoan(String tentaikhoan) {
        this.tentaikhoan = tentaikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getQuyen() {
        return quyen;
    }

    public void setQuyen(Boolean quyen) {
        this.quyen = quyen;
    }
//endregion


}