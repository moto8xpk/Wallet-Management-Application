package vn.com.dtt.ungdung16doana.AfterLogOn.Account;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.List;

import vn.com.dtt.ungdung16doana.AfterLogOn.Ui1Activity;
import vn.com.dtt.ungdung16doana.R;
import vn.com.dtt.ungdung16doana.adapter.CustomAdapterLoaiVi;
import vn.com.dtt.ungdung16doana.data.DBmanager;
import vn.com.dtt.ungdung16doana.model.LoaiVi;
import vn.com.dtt.ungdung16doana.model.Vi;


public class AddAccountActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener/*, AdapterView.OnItemClickListener*/ {

//    private  EditText edittextmavi1;
    private EditText etAWname1;
    private EditText edittextAWmoney1;


    private Button btnsave;
    private Button btnback;

    ListView lvAddAccountwallettype=null;
    Button btnAddAccountcancel=null;

    List<LoaiVi> loaiVis;
    DBmanager dBmanager = null;
    CustomAdapterLoaiVi customAdapterLoaiVi = null;

    Spinner spinnerwallettype;
    Spinner spinnercurrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);
        final DBmanager dbmanager=new DBmanager(this);

//        edittextmavi1=(EditText) findViewById(R.id.edittextMaVi);
        etAWname1=(EditText) findViewById(R.id.etAWName1);
        edittextAWmoney1=(EditText) findViewById(R.id.edittextAWMoney1);


        spinnerwallettype=(Spinner)findViewById(R.id.spinnerWalletType);
        spinnercurrent=(Spinner)findViewById(R.id.spinnerCurrent);

        btnsave=(Button) findViewById(R.id.btnAWSave1);
        btnback=(Button) findViewById(R.id.btnAWBack);

        spinnerwallettype.setOnItemSelectedListener(this);
//        spinnercurrent.setOnItemClickListener(this);

        loadSpinnerData1();
        loadSpinnerData2();

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Vi vi=CreateVi();
                if(vi!=null){
                    dbmanager.addVi(vi);
//                    edittextmavi1.setText("");
                    etAWname1.setText("");
                    edittextAWmoney1.setText("");
                }
            }
        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it12=new Intent(AddAccountActivity.this,Ui1Activity.class);
                startActivity(it12);
                finish();
            }
        });




    }
    private Vi CreateVi(){
//        int id= Integer.valueOf(String.valueOf(edittextmavi1.getText()));
        String walletname=etAWname1.getText().toString();
        String wallettype=spinnerwallettype.getSelectedItem().toString();
        String current=spinnercurrent.getSelectedItem().toString();
        double money=Double.valueOf(String.valueOf(edittextAWmoney1.getText()));

        Vi vi=new Vi(walletname,wallettype,money,current);
        return vi;
    }
    public void setAdapter(){
        if(customAdapterLoaiVi==null)
        {
            customAdapterLoaiVi=new CustomAdapterLoaiVi(this,R.layout.item_loaivi,loaiVis);
            lvAddAccountwallettype.setAdapter(customAdapterLoaiVi);
        }
        else {
            customAdapterLoaiVi.notifyDataSetChanged();
            lvAddAccountwallettype.setSelection(customAdapterLoaiVi.getCount()-1);
        }
    }
    private void loadSpinnerData1() {
        // database handler
        DBmanager db = new DBmanager(getApplicationContext());

        // Spinner Drop down elements
        List<String> lables = db.GetAllLoaiVi2();

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);

        // Drop down layout style - list view with radio button
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerwallettype.setAdapter(dataAdapter);
    }
    private void loadSpinnerData2() {
        // database handler
        DBmanager db = new DBmanager(getApplicationContext());

        // Spinner Drop down elements
        List<String> lables = db.GetAllTienTe2();

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);

        // Drop down layout style - list view with radio button
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnercurrent.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        /*String label = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "You selected: " + label,
                Toast.LENGTH_LONG).show();*/
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    /*@Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String label = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "You selected: " + label,
                Toast.LENGTH_LONG).show();
    }*/
}
