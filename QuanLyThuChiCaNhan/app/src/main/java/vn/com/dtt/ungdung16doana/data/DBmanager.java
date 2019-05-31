package vn.com.dtt.ungdung16doana.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import vn.com.dtt.ungdung16doana.model.ChiTietChi;
import vn.com.dtt.ungdung16doana.model.ChiTietThu;
import vn.com.dtt.ungdung16doana.model.LoaiChi;
import vn.com.dtt.ungdung16doana.model.LoaiThu;
import vn.com.dtt.ungdung16doana.model.LoaiVi;
import vn.com.dtt.ungdung16doana.model.NguoiDung;
import vn.com.dtt.ungdung16doana.model.StatisticIncome;
import vn.com.dtt.ungdung16doana.model.StatisticOutcome;
import vn.com.dtt.ungdung16doana.model.TienTe;
import vn.com.dtt.ungdung16doana.model.Vi;


public class DBmanager extends SQLiteOpenHelper {

    private final String TAG = "DBManager";
    private static final String DATABASE_NAME = "quanly_thuchi_canhan";
    private static final String TABLE_NAME = "NguoiDung";

    private static final String TABLE_NAME_TYPE_WALLET = "LoaiVi";

    private static final String TABLE_NAME_WALLET = "Vi";

    private static final String TABLE_NAME_MONEY = "TienTe";

    private static final String TABLE_NAME_TYPE_INCOME = "LoaiThu";

    private static final String TABLE_NAME_INFORMATION_INCOME = "ChiTietThu";

    private static final String TABLE_NAME_TYPE_OUTCOME = "LoaiChi";

    private static final String TABLE_NAME_INFORMATION_OUTCOME = "ChiTietChi";

    //region LoaiVi
    private static final String maLoaiVi = "MaLoaiVi";
    private static final String tenLoaiVi = "TenLoaiVi";

    private static final String maVi = "MaVi";
    private static final String tenVi = "TenMaVi";
    private static final String loaiVi = "LoaiVi";
    private static final String soDu = "SoDu";
    private static final String loaiTienTe = "LoaiTienTe";
//endregion
    //region NguoiDung
    private static final String manguoidung = "MaNguoiDung";
    private static final String hoten = "HoTen";
    private static final String tentaikhoan = "TenTaiKhoan";
    private static final String matkhau = "MatKhau";
    private static final String email = "email";
    private static final String quyen = "Quyen";
    //endregion
    //region TienTe
        private static final String maTienTe = "MaTienTe";
        private static final String tenTienTe = "TenTienTe";
        //endregion
    //region LoaiThu
        private static final String maThu = "MaThu";
        private static final String tenLoaiThu = "TenLoaiThu";
    //endregion
    //region ChiTietThu
    private static final String maGiaoDichThu = "MaGiaoDichThu";
    private static final String tenGiaoDichThu = "TenGiaoDichThu";
    private static final String tenLoaiThu1 = "TenLoaiThu";
    private static final String tenViThu = "MaVi";
    private static final String soTienThu= "SoTienThu";
    private static final String ngayThu = "NgayThu";
    private static final String dienGiaiThu = "DienGiaiThu";
    //endregion
    //region LoaiChi
    private static final String maChi = "MaChi";
    private static final String tenLoaiChi = "TenLoaiChi";
    //endregion
    //region ChiTietChi
    private static final String maGiaoDichChi = "MaGiaoDichChi";
    private static final String tenGiaoDichChi = "TenGiaoDichChi";
    private static final String tenLoaiChi1 = "TenLoaiChi";
    private static final String tenViChi = "MaVi";
    private static final String soTienChi= "SoTienChi";
    private static final String ngayChi = "NgayChi";
    private static final String dienGiaiChi = "DienGiaiChi";
    //endregion
// region thongke

    private static final String[] thang=new String[]{"01","02","03","04","05","06","07","08","09","10","11","12"};

    //endregion
    private static int VERSION = 11;


    private Context context;

    private String SQLQuery="CREATE TABLE " + TABLE_NAME + "(" +
            manguoidung + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            hoten + " TEXT, " +
            tentaikhoan + " TEXT,"+
            matkhau+" TEXT,"+
            email+" TEXT,"+
            quyen+" BOOL NOT NULL  DEFAULT (0) )";

    private String SQLQuery1="CREATE TABLE " + TABLE_NAME_TYPE_WALLET + "(" +
            maLoaiVi + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            tenLoaiVi + " TEXT)";

    private String SQLQuery2="CREATE TABLE " + TABLE_NAME_WALLET + "(" +
            maVi + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            tenVi + " TEXT, "+
            loaiVi + " TEXT, "+
            soDu + " DOUBLE, "+
            loaiTienTe+" TEXT)";

    private String SQLQuery3="CREATE TABLE " + TABLE_NAME_MONEY + "(" +
            maTienTe + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            tenTienTe + " TEXT)";
    private String SQLQuery4="CREATE TABLE " + TABLE_NAME_TYPE_INCOME + "(" +
            maThu + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            tenLoaiThu + " TEXT)";

    private String SQLQuery6="CREATE TABLE " + TABLE_NAME_INFORMATION_INCOME + "(" +
            maGiaoDichThu + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            tenLoaiThu1 + " TEXT, "+
            tenViThu + " TEXT, "+
            soTienThu + " DOUBLE,"+
            ngayThu + " DATETIME, "+
            dienGiaiThu + " TEXT)";

    private String SQLQuery5="CREATE TABLE " + TABLE_NAME_TYPE_OUTCOME + "(" +
            maChi + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            tenLoaiChi + " TEXT)";

    private String SQLQuery7="CREATE TABLE " + TABLE_NAME_INFORMATION_OUTCOME + "(" +
            maGiaoDichChi + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            tenLoaiChi1 + " TEXT, "+
            tenViChi + " TEXT, "+
            soTienChi + " DOUBLE,"+
            ngayChi + " DATETIME, "+
            dienGiaiChi + " TEXT)";
    private String SQLQuery8="DROP TABLE "+TABLE_NAME_INFORMATION_OUTCOME;
    private String SQLQuery9="DROP TABLE "+TABLE_NAME_INFORMATION_INCOME;
    public DBmanager(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//            db.execSQL(SQLQuery8);
//            db.execSQL(SQLQuery9);
        db.execSQL(SQLQuery);
        db.execSQL(SQLQuery1);
        db.execSQL(SQLQuery2);
        db.execSQL(SQLQuery3);
        db.execSQL(SQLQuery4);
        db.execSQL(SQLQuery5);
        db.execSQL(SQLQuery6);
        db.execSQL(SQLQuery7);

        Log.d(TAG, "onCreate: ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
        Log.d(TAG, "onUpgrade: ");
    }

    public  void Hello(){
        Toast.makeText(context,"Hello",Toast.LENGTH_SHORT).show();
    }

    public void addNguoiDung(NguoiDung nguoiDung){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(hoten,nguoiDung.getHoten());
        values.put(tentaikhoan,nguoiDung.getTentaikhoan());
        values.put(matkhau,nguoiDung.getMatkhau());
        values.put(email,nguoiDung.getEmail());
        db.insert(TABLE_NAME,null,values);
        db.close();
        Toast.makeText(context,"Create Account Successfully",Toast.LENGTH_SHORT).show();
        Log.d(TAG, "addNguoiDung Successfuly");
    }

    public void addVi(Vi vi){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(tenVi,vi.getTenVi());
        values.put(loaiVi,vi.getLoaiVi());
        values.put(soDu,vi.getSoDu());
        values.put(loaiTienTe,vi.getLoaiTienTe());
        db.insert(TABLE_NAME_WALLET,null,values);
        db.close();
        Toast.makeText(context,"Create Wallet Successfully",Toast.LENGTH_SHORT).show();
        Log.d(TAG, "add Wallet Successfuly");
    }

    public void addLoaiVi(LoaiVi loaiVi){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(tenLoaiVi,loaiVi.getTenLoaiVi());
        db.insert(TABLE_NAME_TYPE_WALLET,null,values);
        db.close();
        Toast.makeText(context,"Create Wallet Type Successfully",Toast.LENGTH_SHORT).show();
        Log.d(TAG, "add Wallet Type Successfuly");
    }

    public void addLoaiTienTe(TienTe tienTe){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(tenTienTe,tienTe.getTenTienTe());
        db.insert(TABLE_NAME_MONEY,null,values);
        db.close();
        Toast.makeText(context,"Create Current Money Type Successfully",Toast.LENGTH_SHORT).show();
        Log.d(TAG, "add Current Money Type Successfuly");
    }

    public void addLoaiThu(LoaiThu loaiThu){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(tenLoaiThu,loaiThu.getTenLoaiThu());
        db.insert(TABLE_NAME_TYPE_INCOME,null,values);
        db.close();
        Toast.makeText(context,"Create Income Type Successfully",Toast.LENGTH_SHORT).show();
        Log.d(TAG, "add Income Type Successfuly");
    }

    public void addLoaiChi(LoaiChi loaiChi){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(tenLoaiChi,loaiChi.getTenLoaiChi());
        db.insert(TABLE_NAME_TYPE_OUTCOME,null,values);
        db.close();
        Toast.makeText(context,"Create Outcome Type Successfully",Toast.LENGTH_SHORT).show();
        Log.d(TAG, "add Outcome Type Successfuly");
    }

    public void addChiTietThu(ChiTietThu chiTietThu){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(tenLoaiThu1,chiTietThu.getTenLoaiThu());
        values.put(tenViThu,chiTietThu.getTenViThu());
        values.put(soTienThu,chiTietThu.getSoTienThu());
        values.put(ngayThu,chiTietThu.getNgayThu());
        values.put(dienGiaiThu,chiTietThu.getDienGiaiThu());

        db.insert(TABLE_NAME_INFORMATION_INCOME,null,values);
        db.close();
        Toast.makeText(context,"Create a transaction Successfully",Toast.LENGTH_SHORT).show();
        Log.d(TAG, "add Information Income Successfuly");
    }

    public void addChiTietChi(ChiTietChi chiTietChi){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(tenLoaiChi1,chiTietChi.getTenLoaiChi());
        values.put(tenViChi,chiTietChi.getTenViChi());
        values.put(soTienChi,chiTietChi.getSoTienChi());
        values.put(ngayChi,chiTietChi.getNgayChi());
        values.put(dienGiaiChi,chiTietChi.getDienGiaiChi());

        db.insert(TABLE_NAME_INFORMATION_OUTCOME,null,values);
        db.close();
        Toast.makeText(context,"Create a transaction Successfully",Toast.LENGTH_SHORT).show();
        Log.d(TAG, "add Information Outcome Successfuly");
    }

    public List<NguoiDung> GetAllNguoiDung() {
        List<NguoiDung> listnguoidung=new ArrayList<>();

        String selectQuery="SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst())
        {
            do {
                NguoiDung nguoidung=new NguoiDung();
                nguoidung.setManguoidung(cursor.getInt(0));
                nguoidung.setHoten(cursor.getString(1));
                nguoidung.setTentaikhoan(cursor.getString(2));
                nguoidung.setMatkhau(cursor.getString(3));
                nguoidung.setEmail(cursor.getString(4));

                listnguoidung.add(nguoidung);

            }while (cursor.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return listnguoidung;
    }

    public List<LoaiVi> GetAllLoaiVi() {
        List<LoaiVi> listloaivi=new ArrayList<>();

        String selectQuery="SELECT * FROM "+TABLE_NAME_TYPE_WALLET;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst())
        {
            do {
                LoaiVi loaiVi=new LoaiVi();
                loaiVi.setMaLoaiVi(cursor.getInt(0));
                loaiVi.setTenLoaiVi(cursor.getString(1));

                listloaivi.add(loaiVi);

            }while (cursor.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return listloaivi;
    }

    public List<Vi> GetAllVi() {
        List<Vi> listvi=new ArrayList<>();

        String selectQuery="SELECT * FROM "+TABLE_NAME_WALLET;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst())
        {
            do {
                Vi vi=new Vi();
                vi.setMaVi(cursor.getInt(0));
                vi.setTenVi(cursor.getString(1));
                vi.setLoaiVi(cursor.getString(2));
                vi.setSoDu(cursor.getDouble(3));
                vi.setLoaiTienTe(cursor.getString(4));

                listvi.add(vi);

            }while (cursor.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return listvi;
    }

    public List<TienTe> GetAllTienTe() {
        List<TienTe> listtiente=new ArrayList<>();

        String selectQuery="SELECT * FROM "+TABLE_NAME_MONEY;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst())
        {
            do {
                TienTe tienTe=new TienTe();
                tienTe.setMaTienTe(cursor.getInt(0));
                tienTe.setTenTienTe(cursor.getString(1));

                listtiente.add(tienTe);

            }while (cursor.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return listtiente;
    }

    public List<LoaiThu> GetAllLoaiThu() {
        List<LoaiThu> listloaithu=new ArrayList<>();

        String selectQuery="SELECT * FROM "+TABLE_NAME_TYPE_INCOME;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst())
        {
            do {
                LoaiThu loaiThu=new LoaiThu();
                loaiThu.setMaThu(cursor.getInt(0));
                loaiThu.setTenLoaiThu(cursor.getString(1));

                listloaithu.add(loaiThu);

            }while (cursor.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return listloaithu;
    }

    public List<ChiTietThu> GetAllChiTietThu() {
        List<ChiTietThu> listchitietthu=new ArrayList<>();

        String selectQuery="SELECT * FROM "+TABLE_NAME_INFORMATION_INCOME;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst())
        {
            do {
                ChiTietThu chiTietThu=new ChiTietThu();
                chiTietThu.setMaGiaoDichThu(cursor.getInt(0));
                chiTietThu.setTenLoaiThu(cursor.getString(1));
                chiTietThu.setTenViThu(cursor.getString(2));
                chiTietThu.setSoTienThu(cursor.getDouble(3));
                chiTietThu.setNgayThu(cursor.getString(4));
                chiTietThu.setDienGiaiThu(cursor.getString(5));

                listchitietthu.add(chiTietThu);

            }while (cursor.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return listchitietthu;
    }

    public List<ChiTietChi> GetAllChiTietChi() {
        List<ChiTietChi> listchitietchi=new ArrayList<>();

        String selectQuery="SELECT * FROM "+TABLE_NAME_INFORMATION_OUTCOME;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst())
        {
            do {
                ChiTietChi chiTietChi=new ChiTietChi();
                chiTietChi.setMaGiaoDichChi(cursor.getInt(0));
                chiTietChi.setTenLoaiChi(cursor.getString(1));
                chiTietChi.setTenViChi(cursor.getString(2));
                chiTietChi.setSoTienChi(cursor.getDouble(3));
                chiTietChi.setNgayChi(cursor.getString(4));
                chiTietChi.setDienGiaiChi(cursor.getString(5));

                listchitietchi.add(chiTietChi);

            }while (cursor.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return listchitietchi;
    }

    public List<LoaiChi> GetAllLoaiChi() {
        List<LoaiChi> listloaichi=new ArrayList<>();

        String selectQuery="SELECT * FROM "+TABLE_NAME_TYPE_OUTCOME;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst())
        {
            do {
                LoaiChi loaiChi=new LoaiChi();
                loaiChi.setMaChi(cursor.getInt(0));
                loaiChi.setTenLoaiChi(cursor.getString(1));

                listloaichi.add(loaiChi);

            }while (cursor.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return listloaichi;
    }

    public List<StatisticIncome> GetAllDMThongKeThu() {
        List<StatisticIncome> liststaIn=new ArrayList<>();

        String selectQuery="SELECT "+tenLoaiThu1+", SUM("+soTienThu+") FROM "+TABLE_NAME_INFORMATION_INCOME+" GROUP BY "+tenLoaiThu1;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst())
        {
            do {
                StatisticIncome statisticIncome=new StatisticIncome();

                statisticIncome.setTenLoaiThu(cursor.getString(0));
                statisticIncome.setSoTienThu(cursor.getDouble(1));

                liststaIn.add(statisticIncome);

            }while (cursor.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return liststaIn;
    }

    public List<StatisticOutcome> GetAllDMThongKeChi() {
        List<StatisticOutcome> liststaOut=new ArrayList<>();

        String selectQuery="SELECT "+tenLoaiChi1+", SUM("+soTienChi+") FROM "+TABLE_NAME_INFORMATION_OUTCOME+" GROUP BY "+tenLoaiChi1;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst())
        {
            do {
                StatisticOutcome statisticOutcome=new StatisticOutcome();

                statisticOutcome.setTenLoaiChi(cursor.getString(0));
                statisticOutcome.setSoTienChi(cursor.getDouble(1));

                liststaOut.add(statisticOutcome);

            }while (cursor.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return liststaOut;
    }

    //region tool
//    public double GetTotalMoney() {
//        double Tongsotien=0;
//        double temp=0;
//        String selectQuery="SELECT "+ maVi
//                +", "+ soDu
//                +" FROM "+TABLE_NAME_WALLET;
//
//        SQLiteDatabase db=this.getWritableDatabase();
//        Cursor cursor=db.rawQuery(selectQuery,null);
//        if(cursor.moveToFirst())
//        {
//            do {
//                temp=cursor.getDouble(1);
//                Tongsotien=Tongsotien+temp;
//
//            }while (cursor.moveToNext());
//        }
//        db.close();
//        Log.d(TAG, "load data Successfuly");
//        return Tongsotien;
//    }
    public double GetUpdateSoDu() {
        double temp=0;
        double temp1=0;
        double temp2=0;
        double temp3=0;
        String selectQuery1="SELECT SUM("
                + soDu
                +") "
                +" FROM "
                +TABLE_NAME_WALLET;
        String selectQuery2="SELECT SUM("
                + soTienThu
                +") "
                +" FROM "
                +TABLE_NAME_INFORMATION_INCOME;
        String selectQuery3="SELECT SUM("
                + soTienChi
                +") "
                +" FROM "
                +TABLE_NAME_INFORMATION_OUTCOME;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor1=db.rawQuery(selectQuery1,null);
        if(cursor1.moveToFirst())
        {
            do {
                temp1=cursor1.getDouble(0);
            }while (cursor1.moveToNext());
        }
        Cursor cursor2=db.rawQuery(selectQuery2,null);
        if(cursor2.moveToFirst())
        {
            do {
                temp2=cursor2.getDouble(0);
            }while (cursor2.moveToNext());
        }
        Cursor cursor3=db.rawQuery(selectQuery3,null);
        if(cursor3.moveToFirst())
        {
            do {
                temp3=cursor3.getDouble(0);
            }while (cursor1.moveToNext());
        }
        db.close();
        temp=temp1+temp2-temp3;
        Log.d(TAG, "load data Successfuly");
        return temp;
    }
    public String Gettypemoney() {
        String loaitien=" ";
        String selectQuery="SELECT "+ maVi
                +", "+ loaiTienTe
                +" FROM "+TABLE_NAME_WALLET;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst())
        {
            do {
                loaitien=cursor.getString(1);
            }while (cursor.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return loaitien;
    }
    //endregion
//tim nguoi dung
    public String[] timdata(String a, String b) {
        String[] c = new String[2];
        String selectQuery="SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst())
        {
            do {
                if(cursor.getString(2).equals(a)&&cursor.getString(3).equals(b)) {
                    c[0]=cursor.getString(2);
                    c[1]=cursor.getString(3);
                    break;
                }
            }while (cursor.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return c;
    }
//region spinner
    public List<String> GetAllLoaiVi2() {
        List<String> listloaivi=new ArrayList<String>();

        String selectQuery="SELECT * FROM "+TABLE_NAME_TYPE_WALLET;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst())
        {
            do {
                listloaivi.add(cursor.getString(1));
            }while (cursor.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return listloaivi;
    }
    public List<String> GetAllTienTe2() {
        List<String> listtiente=new ArrayList<String>();

        String selectQuery="SELECT * FROM "+TABLE_NAME_MONEY;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst())
        {
            do {
                listtiente.add(cursor.getString(1));
            }while (cursor.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return listtiente;
    }
    public List<String> GetAllInComeType2() {
        List<String> listincometype=new ArrayList<String>();

        String selectQuery="SELECT * FROM "+TABLE_NAME_TYPE_INCOME;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst())
        {
            do {
                listincometype.add(cursor.getString(1));
            }while (cursor.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return listincometype;
    }
    public List<String> GetAllOutComeType2() {
        List<String> listoutcometype=new ArrayList<String>();

        String selectQuery="SELECT * FROM "+TABLE_NAME_TYPE_OUTCOME;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst())
        {
            do {
                listoutcometype.add(cursor.getString(1));
            }while (cursor.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return listoutcometype;
    }
    public List<String> GetAllVi2() {
        List<String> listvi=new ArrayList<String>();

        String selectQuery="SELECT * FROM "+TABLE_NAME_WALLET;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst())
        {
            do {
                listvi.add(cursor.getString(1));
            }while (cursor.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return listvi;
    }
    //endregion
    //region phepcong

    //region

    public int updateLoaiVi(LoaiVi loaiVi){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(tenLoaiVi,loaiVi.getTenLoaiVi());
        return db.update(TABLE_NAME_TYPE_WALLET,contentValues,maLoaiVi+"=?",new String[]{String.valueOf(loaiVi.getMaLoaiVi())});
    }

    public int deleteLoaiVi(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME_TYPE_WALLET,maLoaiVi+"=?",new String[] {String.valueOf(id)});
    }
    public int deleteLoaiTienTe(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME_MONEY,maTienTe+"=?",new String[] {String.valueOf(id)});
    }
    public int deleteLoaiThu(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME_TYPE_INCOME,maThu+"=?",new String[] {String.valueOf(id)});
    }
    public int deleteLoaiChi(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME_TYPE_OUTCOME,maChi+"=?",new String[] {String.valueOf(id)});
    }
    public int deleteVi(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME_WALLET,maVi+"=?",new String[] {String.valueOf(id)});
    }
    public int deleteChiTietChi(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME_INFORMATION_OUTCOME,maGiaoDichChi+"=?",new String[] {String.valueOf(id)});
    }
    public int deleteChiTietThu(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME_INFORMATION_INCOME,maGiaoDichThu+"=?",new String[] {String.valueOf(id)});
    }

    //region solieuthongke
    //region chitheothang

    public double thongkechi1() {
        double a=0;
        String selectQuery = "SELECT SUM(SoTienChi) FROM " + TABLE_NAME_INFORMATION_OUTCOME + " WHERE strftime('%m',NgayChi)= '01' ";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor1=db.rawQuery(selectQuery,null);
        if(cursor1.moveToFirst())
        {
            do {
                a=cursor1.getDouble(0);


            }while (cursor1.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return a;
    }
    public double thongkechi2() {
        double a=0;
        String selectQuery = "SELECT SUM(SoTienChi) FROM " + TABLE_NAME_INFORMATION_OUTCOME + " WHERE strftime('%m',NgayChi)= '02' ";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor1=db.rawQuery(selectQuery,null);
        if(cursor1.moveToFirst())
        {
            do {
                a=cursor1.getDouble(0);


            }while (cursor1.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return a;
    }
    public double thongkechi3() {
        double a=0;
        String selectQuery = "SELECT SUM(SoTienChi) FROM " + TABLE_NAME_INFORMATION_OUTCOME + " WHERE strftime('%m',NgayChi)= '03' ";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor1=db.rawQuery(selectQuery,null);
        if(cursor1.moveToFirst())
        {
            do {
                a=cursor1.getDouble(0);


            }while (cursor1.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return a;
    }
    public double thongkechi4() {
        double a=0;
        String selectQuery = "SELECT SUM(SoTienChi) FROM " + TABLE_NAME_INFORMATION_OUTCOME + " WHERE strftime('%m',NgayChi)= '04' ";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor1=db.rawQuery(selectQuery,null);
        if(cursor1.moveToFirst())
        {
            do {
                a=cursor1.getDouble(0);


            }while (cursor1.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return a;
    }
    public double thongkechi5() {
        double a=0;
        String selectQuery = "SELECT SUM(SoTienChi) FROM " + TABLE_NAME_INFORMATION_OUTCOME + " WHERE strftime('%m',NgayChi)= '05' ";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor1=db.rawQuery(selectQuery,null);
        if(cursor1.moveToFirst())
        {
            do {
                a=cursor1.getDouble(0);


            }while (cursor1.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return a;
    }
    public double thongkechi6() {
        double a=0;
        String selectQuery = "SELECT SUM(SoTienChi) FROM " + TABLE_NAME_INFORMATION_OUTCOME + " WHERE strftime('%m',NgayChi)= '06' ";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor1=db.rawQuery(selectQuery,null);
        if(cursor1.moveToFirst())
        {
            do {
                a=cursor1.getDouble(0);


            }while (cursor1.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return a;
    }
    public double thongkechi7() {
        double a=0;
        String selectQuery = "SELECT SUM(SoTienChi) FROM " + TABLE_NAME_INFORMATION_OUTCOME + " WHERE strftime('%m',NgayChi)= '07' ";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor1=db.rawQuery(selectQuery,null);
        if(cursor1.moveToFirst())
        {
            do {
                a=cursor1.getDouble(0);


            }while (cursor1.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return a;
    }
    public double thongkechi8() {
        double a=0;
        String selectQuery = "SELECT SUM(SoTienChi) FROM " + TABLE_NAME_INFORMATION_OUTCOME + " WHERE strftime('%m',NgayChi)= '08' ";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor1=db.rawQuery(selectQuery,null);
        if(cursor1.moveToFirst())
        {
            do {
                a=cursor1.getDouble(0);


            }while (cursor1.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return a;
    }
    public double thongkechi9() {
        double a=0;
        String selectQuery = "SELECT SUM(SoTienChi) FROM " + TABLE_NAME_INFORMATION_OUTCOME + " WHERE strftime('%m',NgayChi)= '09' ";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor1=db.rawQuery(selectQuery,null);
        if(cursor1.moveToFirst())
        {
            do {
                a=cursor1.getDouble(0);


            }while (cursor1.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return a;
    }
    public double thongkechi10() {
        double a=0;
        String selectQuery = "SELECT SUM(SoTienChi) FROM " + TABLE_NAME_INFORMATION_OUTCOME + " WHERE strftime('%m',NgayChi)= '10' ";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor1=db.rawQuery(selectQuery,null);
        if(cursor1.moveToFirst())
        {
            do {
                a=cursor1.getDouble(0);


            }while (cursor1.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return a;
    }
    public double thongkechi11() {
        double a=0;
        String selectQuery = "SELECT SUM(SoTienChi) FROM " + TABLE_NAME_INFORMATION_OUTCOME + " WHERE strftime('%m',NgayChi)= '11' ";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor1=db.rawQuery(selectQuery,null);
        if(cursor1.moveToFirst())
        {
            do {
                a=cursor1.getDouble(0);


            }while (cursor1.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return a;
    }
    public double thongkechi12() {
        double a=0;
        String selectQuery = "SELECT SUM(SoTienChi) FROM " + TABLE_NAME_INFORMATION_OUTCOME + " WHERE strftime('%m',NgayChi)= '12' ";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor1=db.rawQuery(selectQuery,null);
        if(cursor1.moveToFirst())
        {
            do {
                a=cursor1.getDouble(0);


            }while (cursor1.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return a;
    }

//endregion
    //region thutheothang

    public double thongkethu1() {
        double a=0;
        String selectQuery = "SELECT SUM(SoTienThu) FROM " + TABLE_NAME_INFORMATION_INCOME + " WHERE strftime('%m',NgayThu)= '01' ";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor1=db.rawQuery(selectQuery,null);
        if(cursor1.moveToFirst())
        {
            do {
                a=cursor1.getDouble(0);


            }while (cursor1.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return a;
    }
    public double thongkethu2() {
        double a=0;
        String selectQuery = "SELECT SUM(SoTienThu) FROM " + TABLE_NAME_INFORMATION_INCOME + " WHERE strftime('%m',NgayThu)= '02' ";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor1=db.rawQuery(selectQuery,null);
        if(cursor1.moveToFirst())
        {
            do {
                a=cursor1.getDouble(0);


            }while (cursor1.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return a;
    }
    public double thongkethu3() {
        double a=0;
        String selectQuery = "SELECT SUM(SoTienThu) FROM " + TABLE_NAME_INFORMATION_INCOME + " WHERE strftime('%m',NgayThu)= '03' ";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor1=db.rawQuery(selectQuery,null);
        if(cursor1.moveToFirst())
        {
            do {
                a=cursor1.getDouble(0);


            }while (cursor1.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return a;
    }
    public double thongkethu4() {
        double a=0;
        String selectQuery = "SELECT SUM(SoTienThu) FROM " + TABLE_NAME_INFORMATION_INCOME + " WHERE strftime('%m',NgayThu)= '04' ";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor1=db.rawQuery(selectQuery,null);
        if(cursor1.moveToFirst())
        {
            do {
                a=cursor1.getDouble(0);


            }while (cursor1.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return a;
    }
    public double thongkethu5() {
        double a=0;
        String selectQuery = "SELECT SUM(SoTienThu) FROM " + TABLE_NAME_INFORMATION_INCOME + " WHERE strftime('%m',NgayThu)= '05' ";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor1=db.rawQuery(selectQuery,null);
        if(cursor1.moveToFirst())
        {
            do {
                a=cursor1.getDouble(0);


            }while (cursor1.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return a;
    }
    public double thongkethu6() {
        double a=0;
        String selectQuery = "SELECT SUM(SoTienThu) FROM " + TABLE_NAME_INFORMATION_INCOME + " WHERE strftime('%m',NgayThu)= '06' ";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor1=db.rawQuery(selectQuery,null);
        if(cursor1.moveToFirst())
        {
            do {
                a=cursor1.getDouble(0);


            }while (cursor1.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return a;
    }
    public double thongkethu7() {
        double a=0;
        String selectQuery = "SELECT SUM(SoTienThu) FROM " + TABLE_NAME_INFORMATION_INCOME + " WHERE strftime('%m',NgayThu)= '07' ";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor1=db.rawQuery(selectQuery,null);
        if(cursor1.moveToFirst())
        {
            do {
                a=cursor1.getDouble(0);


            }while (cursor1.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return a;
    }
    public double thongkethu8() {
        double a=0;
        String selectQuery = "SELECT SUM(SoTienThu) FROM " + TABLE_NAME_INFORMATION_INCOME + " WHERE strftime('%m',NgayThu)= '08' ";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor1=db.rawQuery(selectQuery,null);
        if(cursor1.moveToFirst())
        {
            do {
                a=cursor1.getDouble(0);


            }while (cursor1.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return a;
    }
    public double thongkethu9() {
        double a=0;
        String selectQuery = "SELECT SUM(SoTienThu) FROM " + TABLE_NAME_INFORMATION_INCOME + " WHERE strftime('%m',NgayThu)= '09' ";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor1=db.rawQuery(selectQuery,null);
        if(cursor1.moveToFirst())
        {
            do {
                a=cursor1.getDouble(0);


            }while (cursor1.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return a;
    }
    public double thongkethu10() {
        double a=0;
        String selectQuery = "SELECT SUM(SoTienThu) FROM " + TABLE_NAME_INFORMATION_INCOME + " WHERE strftime('%m',NgayThu)= '10' ";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor1=db.rawQuery(selectQuery,null);
        if(cursor1.moveToFirst())
        {
            do {
                a=cursor1.getDouble(0);


            }while (cursor1.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return a;
    }
    public double thongkethu11() {
        double a=0;
        String selectQuery = "SELECT SUM(SoTienThu) FROM " + TABLE_NAME_INFORMATION_INCOME + " WHERE strftime('%m',NgayThu)= '11' ";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor1=db.rawQuery(selectQuery,null);
        if(cursor1.moveToFirst())
        {
            do {
                a=cursor1.getDouble(0);


            }while (cursor1.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return a;
    }
    public double thongkethu12() {
        double a=0;
        String selectQuery = "SELECT SUM(SoTienThu) FROM " + TABLE_NAME_INFORMATION_INCOME + " WHERE strftime('%m',NgayThu)= '12' ";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor1=db.rawQuery(selectQuery,null);
        if(cursor1.moveToFirst())
        {
            do {
                a=cursor1.getDouble(0);


            }while (cursor1.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return a;
    }

    //endregion
    public double thongkechiy() {
        double a=0;
        String selectQuery = "SELECT SUM(SoTienChi) FROM " + TABLE_NAME_INFORMATION_OUTCOME + " WHERE strftime('%Y',NgayChi) ";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor1=db.rawQuery(selectQuery,null);
        if(cursor1.moveToFirst())
        {
            do {
                a=cursor1.getDouble(0);


            }while (cursor1.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return a;
    }
    public double thongkethuy1() {
        double a=0;
        String selectQuery = "SELECT SUM(SoTienThu) FROM " + TABLE_NAME_INFORMATION_INCOME + " WHERE strftime('%Y',NgayThu)";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor1=db.rawQuery(selectQuery,null);
        if(cursor1.moveToFirst())
        {
            do {
                a=cursor1.getDouble(0);


            }while (cursor1.moveToNext());
        }
        db.close();
        Log.d(TAG, "load data Successfuly");
        return a;
    }

//    //region chitheonam
//    public double thongkechiy1() {
//        double a=0;
//        String selectQuery = "SELECT SUM(SoTienChi) FROM " + TABLE_NAME_INFORMATION_OUTCOME + " WHERE strftime('%Y',NgayChi)= '01' ";
//        SQLiteDatabase db=this.getWritableDatabase();
//        Cursor cursor1=db.rawQuery(selectQuery,null);
//        if(cursor1.moveToFirst())
//        {
//            do {
//                a=cursor1.getDouble(0);
//
//
//            }while (cursor1.moveToNext());
//        }
//        db.close();
//        Log.d(TAG, "load data Successfuly");
//        return a;
//    }
//    public double thongkechiy2() {
//        double a=0;
//        String selectQuery = "SELECT SUM(SoTienChi) FROM " + TABLE_NAME_INFORMATION_OUTCOME + " WHERE strftime('%m',NgayChi)= '02' ";
//        SQLiteDatabase db=this.getWritableDatabase();
//        Cursor cursor1=db.rawQuery(selectQuery,null);
//        if(cursor1.moveToFirst())
//        {
//            do {
//                a=cursor1.getDouble(0);
//
//
//            }while (cursor1.moveToNext());
//        }
//        db.close();
//        Log.d(TAG, "load data Successfuly");
//        return a;
//    }
//    public double thongkechiy3() {
//        double a=0;
//        String selectQuery = "SELECT SUM(SoTienChi) FROM " + TABLE_NAME_INFORMATION_OUTCOME + " WHERE strftime('%m',NgayChi)= '03' ";
//        SQLiteDatabase db=this.getWritableDatabase();
//        Cursor cursor1=db.rawQuery(selectQuery,null);
//        if(cursor1.moveToFirst())
//        {
//            do {
//                a=cursor1.getDouble(0);
//
//
//            }while (cursor1.moveToNext());
//        }
//        db.close();
//        Log.d(TAG, "load data Successfuly");
//        return a;
//    }
//    public double thongkechiy4() {
//        double a=0;
//        String selectQuery = "SELECT SUM(SoTienChi) FROM " + TABLE_NAME_INFORMATION_OUTCOME + " WHERE strftime('%m',NgayChi)= '04' ";
//        SQLiteDatabase db=this.getWritableDatabase();
//        Cursor cursor1=db.rawQuery(selectQuery,null);
//        if(cursor1.moveToFirst())
//        {
//            do {
//                a=cursor1.getDouble(0);
//
//
//            }while (cursor1.moveToNext());
//        }
//        db.close();
//        Log.d(TAG, "load data Successfuly");
//        return a;
//    }
//    public double thongkechiy5() {
//        double a=0;
//        String selectQuery = "SELECT SUM(SoTienChi) FROM " + TABLE_NAME_INFORMATION_OUTCOME + " WHERE strftime('%m',NgayChi)= '05' ";
//        SQLiteDatabase db=this.getWritableDatabase();
//        Cursor cursor1=db.rawQuery(selectQuery,null);
//        if(cursor1.moveToFirst())
//        {
//            do {
//                a=cursor1.getDouble(0);
//
//
//            }while (cursor1.moveToNext());
//        }
//        db.close();
//        Log.d(TAG, "load data Successfuly");
//        return a;
//    }
//    public double thongkechiy6() {
//        double a=0;
//        String selectQuery = "SELECT SUM(SoTienChi) FROM " + TABLE_NAME_INFORMATION_OUTCOME + " WHERE strftime('%m',NgayChi)= '06' ";
//        SQLiteDatabase db=this.getWritableDatabase();
//        Cursor cursor1=db.rawQuery(selectQuery,null);
//        if(cursor1.moveToFirst())
//        {
//            do {
//                a=cursor1.getDouble(0);
//
//
//            }while (cursor1.moveToNext());
//        }
//        db.close();
//        Log.d(TAG, "load data Successfuly");
//        return a;
//    }
//    public double thongkechiy7() {
//        double a=0;
//        String selectQuery = "SELECT SUM(SoTienChi) FROM " + TABLE_NAME_INFORMATION_OUTCOME + " WHERE strftime('%m',NgayChi)= '07' ";
//        SQLiteDatabase db=this.getWritableDatabase();
//        Cursor cursor1=db.rawQuery(selectQuery,null);
//        if(cursor1.moveToFirst())
//        {
//            do {
//                a=cursor1.getDouble(0);
//
//
//            }while (cursor1.moveToNext());
//        }
//        db.close();
//        Log.d(TAG, "load data Successfuly");
//        return a;
//    }
//    public double thongkechiy8() {
//        double a=0;
//        String selectQuery = "SELECT SUM(SoTienChi) FROM " + TABLE_NAME_INFORMATION_OUTCOME + " WHERE strftime('%m',NgayChi)= '08' ";
//        SQLiteDatabase db=this.getWritableDatabase();
//        Cursor cursor1=db.rawQuery(selectQuery,null);
//        if(cursor1.moveToFirst())
//        {
//            do {
//                a=cursor1.getDouble(0);
//
//
//            }while (cursor1.moveToNext());
//        }
//        db.close();
//        Log.d(TAG, "load data Successfuly");
//        return a;
//    }
//    public double thongkechiy9() {
//        double a=0;
//        String selectQuery = "SELECT SUM(SoTienChi) FROM " + TABLE_NAME_INFORMATION_OUTCOME + " WHERE strftime('%m',NgayChi)= '09' ";
//        SQLiteDatabase db=this.getWritableDatabase();
//        Cursor cursor1=db.rawQuery(selectQuery,null);
//        if(cursor1.moveToFirst())
//        {
//            do {
//                a=cursor1.getDouble(0);
//
//
//            }while (cursor1.moveToNext());
//        }
//        db.close();
//        Log.d(TAG, "load data Successfuly");
//        return a;
//    }
//    public double thongkechiy10() {
//        double a=0;
//        String selectQuery = "SELECT SUM(SoTienChi) FROM " + TABLE_NAME_INFORMATION_OUTCOME + " WHERE strftime('%m',NgayChi)= '10' ";
//        SQLiteDatabase db=this.getWritableDatabase();
//        Cursor cursor1=db.rawQuery(selectQuery,null);
//        if(cursor1.moveToFirst())
//        {
//            do {
//                a=cursor1.getDouble(0);
//
//
//            }while (cursor1.moveToNext());
//        }
//        db.close();
//        Log.d(TAG, "load data Successfuly");
//        return a;
//    }
//    public double thongkechiy11() {
//        double a=0;
//        String selectQuery = "SELECT SUM(SoTienChi) FROM " + TABLE_NAME_INFORMATION_OUTCOME + " WHERE strftime('%m',NgayChi)= '11' ";
//        SQLiteDatabase db=this.getWritableDatabase();
//        Cursor cursor1=db.rawQuery(selectQuery,null);
//        if(cursor1.moveToFirst())
//        {
//            do {
//                a=cursor1.getDouble(0);
//
//
//            }while (cursor1.moveToNext());
//        }
//        db.close();
//        Log.d(TAG, "load data Successfuly");
//        return a;
//    }
//    public double thongkechiy12() {
//        double a=0;
//        String selectQuery = "SELECT SUM(SoTienChi) FROM " + TABLE_NAME_INFORMATION_OUTCOME + " WHERE strftime('%m',NgayChi)= '12' ";
//        SQLiteDatabase db=this.getWritableDatabase();
//        Cursor cursor1=db.rawQuery(selectQuery,null);
//        if(cursor1.moveToFirst())
//        {
//            do {
//                a=cursor1.getDouble(0);
//
//
//            }while (cursor1.moveToNext());
//        }
//        db.close();
//        Log.d(TAG, "load data Successfuly");
//        return a;
//    }
//    //endregion
//    //region thutheonam
//    public double thongkethuy1() {
//        double a=0;
//        String selectQuery = "SELECT SUM(SoTienThu) FROM " + TABLE_NAME_INFORMATION_INCOME + " WHERE strftime('%m',NgayThu)= '01' ";
//        SQLiteDatabase db=this.getWritableDatabase();
//        Cursor cursor1=db.rawQuery(selectQuery,null);
//        if(cursor1.moveToFirst())
//        {
//            do {
//                a=cursor1.getDouble(0);
//
//
//            }while (cursor1.moveToNext());
//        }
//        db.close();
//        Log.d(TAG, "load data Successfuly");
//        return a;
//    }
//    public double thongkethuy2() {
//        double a=0;
//        String selectQuery = "SELECT SUM(SoTienThu) FROM " + TABLE_NAME_INFORMATION_INCOME + " WHERE strftime('%m',NgayThu)= '02' ";
//        SQLiteDatabase db=this.getWritableDatabase();
//        Cursor cursor1=db.rawQuery(selectQuery,null);
//        if(cursor1.moveToFirst())
//        {
//            do {
//                a=cursor1.getDouble(0);
//
//
//            }while (cursor1.moveToNext());
//        }
//        db.close();
//        Log.d(TAG, "load data Successfuly");
//        return a;
//    }
//    public double thongkethuy3() {
//        double a=0;
//        String selectQuery = "SELECT SUM(SoTienThu) FROM " + TABLE_NAME_INFORMATION_INCOME + " WHERE strftime('%m',NgayThu)= '03' ";
//        SQLiteDatabase db=this.getWritableDatabase();
//        Cursor cursor1=db.rawQuery(selectQuery,null);
//        if(cursor1.moveToFirst())
//        {
//            do {
//                a=cursor1.getDouble(0);
//
//
//            }while (cursor1.moveToNext());
//        }
//        db.close();
//        Log.d(TAG, "load data Successfuly");
//        return a;
//    }
//    public double thongkethuy4() {
//        double a=0;
//        String selectQuery = "SELECT SUM(SoTienThu) FROM " + TABLE_NAME_INFORMATION_INCOME + " WHERE strftime('%m',NgayThu)= '04' ";
//        SQLiteDatabase db=this.getWritableDatabase();
//        Cursor cursor1=db.rawQuery(selectQuery,null);
//        if(cursor1.moveToFirst())
//        {
//            do {
//                a=cursor1.getDouble(0);
//
//
//            }while (cursor1.moveToNext());
//        }
//        db.close();
//        Log.d(TAG, "load data Successfuly");
//        return a;
//    }
//    public double thongkethuy5() {
//        double a=0;
//        String selectQuery = "SELECT SUM(SoTienThu) FROM " + TABLE_NAME_INFORMATION_INCOME + " WHERE strftime('%m',NgayThu)= '05' ";
//        SQLiteDatabase db=this.getWritableDatabase();
//        Cursor cursor1=db.rawQuery(selectQuery,null);
//        if(cursor1.moveToFirst())
//        {
//            do {
//                a=cursor1.getDouble(0);
//
//
//            }while (cursor1.moveToNext());
//        }
//        db.close();
//        Log.d(TAG, "load data Successfuly");
//        return a;
//    }
//    public double thongkethuy6() {
//        double a=0;
//        String selectQuery = "SELECT SUM(SoTienThu) FROM " + TABLE_NAME_INFORMATION_INCOME + " WHERE strftime('%m',NgayThu)= '06' ";
//        SQLiteDatabase db=this.getWritableDatabase();
//        Cursor cursor1=db.rawQuery(selectQuery,null);
//        if(cursor1.moveToFirst())
//        {
//            do {
//                a=cursor1.getDouble(0);
//
//
//            }while (cursor1.moveToNext());
//        }
//        db.close();
//        Log.d(TAG, "load data Successfuly");
//        return a;
//    }
//    public double thongkethuy7() {
//        double a=0;
//        String selectQuery = "SELECT SUM(SoTienThu) FROM " + TABLE_NAME_INFORMATION_INCOME + " WHERE strftime('%m',NgayThu)= '07' ";
//        SQLiteDatabase db=this.getWritableDatabase();
//        Cursor cursor1=db.rawQuery(selectQuery,null);
//        if(cursor1.moveToFirst())
//        {
//            do {
//                a=cursor1.getDouble(0);
//
//
//            }while (cursor1.moveToNext());
//        }
//        db.close();
//        Log.d(TAG, "load data Successfuly");
//        return a;
//    }
//    public double thongkethuy8() {
//        double a=0;
//        String selectQuery = "SELECT SUM(SoTienThu) FROM " + TABLE_NAME_INFORMATION_INCOME + " WHERE strftime('%m',NgayThu)= '08' ";
//        SQLiteDatabase db=this.getWritableDatabase();
//        Cursor cursor1=db.rawQuery(selectQuery,null);
//        if(cursor1.moveToFirst())
//        {
//            do {
//                a=cursor1.getDouble(0);
//
//
//            }while (cursor1.moveToNext());
//        }
//        db.close();
//        Log.d(TAG, "load data Successfuly");
//        return a;
//    }
//    public double thongkethuy9() {
//        double a=0;
//        String selectQuery = "SELECT SUM(SoTienThu) FROM " + TABLE_NAME_INFORMATION_INCOME + " WHERE strftime('%m',NgayThu)= '09' ";
//        SQLiteDatabase db=this.getWritableDatabase();
//        Cursor cursor1=db.rawQuery(selectQuery,null);
//        if(cursor1.moveToFirst())
//        {
//            do {
//                a=cursor1.getDouble(0);
//
//
//            }while (cursor1.moveToNext());
//        }
//        db.close();
//        Log.d(TAG, "load data Successfuly");
//        return a;
//    }
//    public double thongkethuy10() {
//        double a=0;
//        String selectQuery = "SELECT SUM(SoTienThu) FROM " + TABLE_NAME_INFORMATION_INCOME + " WHERE strftime('%m',NgayThu)= '10' ";
//        SQLiteDatabase db=this.getWritableDatabase();
//        Cursor cursor1=db.rawQuery(selectQuery,null);
//        if(cursor1.moveToFirst())
//        {
//            do {
//                a=cursor1.getDouble(0);
//
//
//            }while (cursor1.moveToNext());
//        }
//        db.close();
//        Log.d(TAG, "load data Successfuly");
//        return a;
//    }
//    public double thongkethuy11() {
//        double a=0;
//        String selectQuery = "SELECT SUM(SoTienThu) FROM " + TABLE_NAME_INFORMATION_INCOME + " WHERE strftime('%m',NgayThu)= '11' ";
//        SQLiteDatabase db=this.getWritableDatabase();
//        Cursor cursor1=db.rawQuery(selectQuery,null);
//        if(cursor1.moveToFirst())
//        {
//            do {
//                a=cursor1.getDouble(0);
//
//
//            }while (cursor1.moveToNext());
//        }
//        db.close();
//        Log.d(TAG, "load data Successfuly");
//        return a;
//    }
//    public double thongkethuy12() {
//        double a=0;
//        String selectQuery = "SELECT SUM(SoTienThu) FROM " + TABLE_NAME_INFORMATION_INCOME + " WHERE strftime('%m',NgayThu)= '12' ";
//        SQLiteDatabase db=this.getWritableDatabase();
//        Cursor cursor1=db.rawQuery(selectQuery,null);
//        if(cursor1.moveToFirst())
//        {
//            do {
//                a=cursor1.getDouble(0);
//
//
//            }while (cursor1.moveToNext());
//        }
//        db.close();
//        Log.d(TAG, "load data Successfuly");
//        return a;
//    }
//    //endregion
    //endregion
}

