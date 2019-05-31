package vn.com.dtt.ungdung16doana.AfterLogOn.Account;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import vn.com.dtt.ungdung16doana.AfterLogOn.Ui1Activity;
import vn.com.dtt.ungdung16doana.R;
import vn.com.dtt.ungdung16doana.data.DBmanager;
import vn.com.dtt.ungdung16doana.model.ChiTietThu;

public class IncomeActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {


//    EditText edittext_income_id;
//    EditText edittext_income_name;
    EditText edittext_income_money;
    EditText edittext_income_date;
    EditText edittext_income_note;

    Spinner spinner_income_type;
    Spinner spinner_income_wallet_type;

    Button button_income_save;
    Button button_income_back;

    DBmanager dBmanager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

        final DBmanager dbmanager=new DBmanager(this);

//        edittext_income_id=(EditText) findViewById(R.id.edittext_Income_ID);
//        edittext_income_name=(EditText) findViewById(R.id.edittext_Income_Name);
        edittext_income_money=(EditText) findViewById(R.id.edittext_Income_Money);
        edittext_income_date=(EditText) findViewById(R.id.edittext_Income_Date);
        edittext_income_note=(EditText) findViewById(R.id.edittext_Income_Note);

        spinner_income_type=(Spinner) findViewById(R.id.spinner_Income_Type);
        spinner_income_wallet_type=(Spinner) findViewById(R.id.spinner_Income_Wallet_Type);

        button_income_save=(Button) findViewById(R.id.button_Income_Save);
        button_income_back=(Button) findViewById(R.id.button_Income_Back);

        button_income_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChiTietThu chiTietThu=CreateChiTietThu();
                if(chiTietThu!=null){
                    dbmanager.addChiTietThu(chiTietThu);
//                    edittext_income_id.setText("");
//                    edittext_income_name.setText("");
                    edittext_income_money.setText("");
                    edittext_income_note.setText("");
                    edittext_income_date.setText("");
                }
            }
        });

        button_income_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent to=new Intent(IncomeActivity.this, Ui1Activity.class);
                startActivity(to);
                finish();
            }
        });
        edittext_income_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChonNgay();
            }
        });
        spinner_income_type.setOnItemSelectedListener(this);
        spinner_income_wallet_type.setOnItemSelectedListener(this);
        loadSpinnerData1();
        loadSpinnerData2();
    }
    private void ChonNgay()
    {
        final Calendar calendar=Calendar.getInstance();
        int ngay =calendar.get(Calendar.DATE);
        int thang =calendar.get(Calendar.MONTH);
        int nam =calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
                edittext_income_date.setText(simpleDateFormat.format(calendar.getTime())+" 00:00:00 ");
            }
        },nam,thang,ngay);
        datePickerDialog.show();
    }
    private void loadSpinnerData1() {
        // database handler
        DBmanager db = new DBmanager(getApplicationContext());

        // Spinner Drop down elements
        List<String> lables = db.GetAllInComeType2();

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner_income_type.setAdapter(dataAdapter);
    }
    private void loadSpinnerData2() {
        // database handler
        DBmanager db = new DBmanager(getApplicationContext());

        // Spinner Drop down elements
        List<String> lables = db.GetAllVi2();

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner_income_wallet_type.setAdapter(dataAdapter);
    }

    private ChiTietThu CreateChiTietThu(){
//        int id= Integer.valueOf(String.valueOf(edittext_income_id.getText()));
//        String tengiaodichthu=edittext_income_name.getText().toString();
        String tenloaithu=spinner_income_type.getSelectedItem().toString();
        String tenvithu=spinner_income_wallet_type.getSelectedItem().toString();
        double money=Double.valueOf(String.valueOf(edittext_income_money.getText()));
        String ngay=edittext_income_date.getText().toString();
        String note=edittext_income_note.getText().toString();

        ChiTietThu chiTietThu=new ChiTietThu(tenloaithu,tenvithu,money,ngay,note);
        return chiTietThu;
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
