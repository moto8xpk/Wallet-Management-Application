package vn.com.dtt.ungdung16doana;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import vn.com.dtt.ungdung16doana.AfterLogOn.AdminUIActivity;
import vn.com.dtt.ungdung16doana.AfterLogOn.Ui1Activity;
import vn.com.dtt.ungdung16doana.Register.RegisterActivity;
import vn.com.dtt.ungdung16doana.adapter.CustomAdapter;
import vn.com.dtt.ungdung16doana.data.DBmanager;
import vn.com.dtt.ungdung16doana.model.NguoiDung;

public class LogOnActivity extends AppCompatActivity {
    private EditText editHoTen;
    private EditText editTenTaiKhoan;
    private EditText editPass;
    private EditText editmail;
    private TextView Textview1;
    private Button bt0enter;
    private Button bt1face;
    private Button bt2google;
    private EditText editUser;
    private EditText editPassword;

    public DBmanager dBmanager;
    private CustomAdapter customAdapter;
    private List<NguoiDung> nguoiDungs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_on);
        editUser=(EditText) findViewById(R.id.editUser);
        editPassword=(EditText) findViewById(R.id.editLogPass);

        dBmanager=new DBmanager(this);

        Textview1=(TextView) findViewById(R.id.tvRegis) ;

        //region textview1
        Textview1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent it2=new Intent(LogOnActivity.this,RegisterActivity.class);
                startActivity(it2);
                finish();
            }
        });
        //endregion

        bt0enter=(Button) findViewById(R.id.buttonEnter) ;

        //region btndangnhap1
        bt0enter.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String user="admin";
                String password="12345678";
                String user1=editUser.getText().toString();
                String password1=editPassword.getText().toString();
                String[] a=new String[2];

                a=dBmanager.timdata(user1,password1);



                if(editUser.getText().toString().equals(user) && editPassword.getText().toString().equals(password))
                {
                    Intent it4=new Intent(LogOnActivity.this,AdminUIActivity.class);
                    startActivity(it4);
                    finish();
                    Toast.makeText(getApplicationContext(),"Welcome My Administrator!",Toast.LENGTH_SHORT).show();
                }

                if(a[0]!=null) {
                    if (a[0].equals(user1) && a[1].equals(password1)) {
                        Intent it3 = new Intent(LogOnActivity.this, Ui1Activity.class);
                        startActivity(it3);
                        finish();
                        Toast.makeText(getApplicationContext(), "Welcome User!", Toast.LENGTH_SHORT).show();
                    }
                }else{
                        a[0] = "";
                        a[1] = "";
                    }

                        if (a[0].equals("") && a[1].equals("")) {
                            Toast.makeText(getApplicationContext(), "Not Exist!", Toast.LENGTH_SHORT).show();
                        }

            }
        });
        //endregion

        DBmanager dBmanager=new DBmanager(this);
        editHoTen=(EditText) findViewById(R.id.etAWName);
        editTenTaiKhoan=(EditText) findViewById(R.id.editTNameAccount);
        editPass=(EditText) findViewById(R.id.etAWPassword);
        editmail=(EditText) findViewById(R.id.etAWEmail);


    }





}
