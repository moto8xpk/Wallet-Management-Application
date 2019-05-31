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
import vn.com.dtt.ungdung16doana.model.ChiTietChi;

public class OutcomeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

//    EditText edittext_outcome_id;
//    EditText edittext_outcome_name;
    EditText edittext_outcome_money;
    EditText edittext_outcome_date;
    EditText edittext_outcome_note;

    Spinner spinner_outcome_type;
    Spinner spinner_outcome_wallet_type;

    Button button_outcome_save;
    Button button_outcome_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outcome);
        final DBmanager dbmanager=new DBmanager(this);

//        edittext_outcome_id=(EditText) findViewById(R.id.edittext_Outcome_ID);
//        edittext_outcome_name=(EditText) findViewById(R.id.edittext_Outcome_Name);
        edittext_outcome_money=(EditText) findViewById(R.id.edittext_Outcome_Money);
        edittext_outcome_date=(EditText) findViewById(R.id.edittext_Outcome_Date);
        edittext_outcome_note=(EditText) findViewById(R.id.edittext_Outcome_Note);

        spinner_outcome_type=(Spinner) findViewById(R.id.spinner_Outcome_Type);
        spinner_outcome_wallet_type=(Spinner) findViewById(R.id.spinner_Outcome_Wallet_Type);

        button_outcome_save=(Button) findViewById(R.id.button_Outcome_Save);
        button_outcome_back=(Button) findViewById(R.id.button_Outcome_Back);

        button_outcome_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChiTietChi chiTietChi=CreateChiTietChi();
                if(chiTietChi!=null){
                    dbmanager.addChiTietChi(chiTietChi);
//                    edittext_outcome_id.setText("");
//                    edittext_outcome_name.setText("");
                    edittext_outcome_money.setText("");
                    edittext_outcome_note.setText("");
                    edittext_outcome_date.setText("");
                }
            }
        });
        button_outcome_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent to=new Intent(OutcomeActivity.this, Ui1Activity.class);
                startActivity(to);
                finish();
            }
        });
        edittext_outcome_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChonNgay();
            }
        });
        spinner_outcome_type.setOnItemSelectedListener(this);
        spinner_outcome_wallet_type.setOnItemSelectedListener(this);
        loadSpinnerData1();
        loadSpinnerData2();
    }
    private void loadSpinnerData1() {
        // database handler
        DBmanager db = new DBmanager(getApplicationContext());

        // Spinner Drop down elements
        List<String> lables = db.GetAllOutComeType2();

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner_outcome_type.setAdapter(dataAdapter);
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
        spinner_outcome_wallet_type.setAdapter(dataAdapter);
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
                edittext_outcome_date.setText(simpleDateFormat.format(calendar.getTime())+" 00:00:00 ");
            }
        },nam,thang,ngay);
        datePickerDialog.show();
    }
    private ChiTietChi CreateChiTietChi(){
//        int id= Integer.valueOf(String.valueOf(edittext_outcome_id.getText()));
//        String tengiaodichchi=edittext_outcome_name.getText().toString();
        String tenloaichi=spinner_outcome_type.getSelectedItem().toString();
        String tenvichi=spinner_outcome_wallet_type.getSelectedItem().toString();
        double money=Double.valueOf(String.valueOf(edittext_outcome_money.getText()));
        String ngay=edittext_outcome_date.getText().toString();
        String note=edittext_outcome_note.getText().toString();

        ChiTietChi chiTietChi=new ChiTietChi(tenloaichi,tenvichi,money,ngay,note);
        return chiTietChi;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
