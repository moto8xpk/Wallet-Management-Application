package vn.com.dtt.ungdung16doana.Register;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import vn.com.dtt.ungdung16doana.AfterLogOn.Account.IncomeBarGraphActivity;
import vn.com.dtt.ungdung16doana.AfterLogOn.Ui1Activity;
import vn.com.dtt.ungdung16doana.LogOnActivity;
import vn.com.dtt.ungdung16doana.R;
import vn.com.dtt.ungdung16doana.data.DBmanager;
import vn.com.dtt.ungdung16doana.model.NguoiDung;

public class RegisterActivity extends AppCompatActivity {

    private EditText editAWname;
    private EditText editAWaccount;
    private EditText editAWpassword;
    private EditText editAWemail;
    private Button btnRegisters;
    Boolean quyen1=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final DBmanager dbmanager=new DBmanager(this);
        editAWname=(EditText) findViewById(R.id.etAWName);
        editAWaccount=(EditText) findViewById(R.id.editTNameAccount);
        editAWpassword=(EditText) findViewById(R.id.etAWPassword);
        editAWemail=(EditText) findViewById(R.id.etAWEmail);
        btnRegisters=(Button) findViewById(R.id.buttonReg);

        btnRegisters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NguoiDung nguoidung=CreateNguoiDung();
                if(nguoidung!=null){
                    dbmanager.addNguoiDung(nguoidung);
                    editAWname.setText("");
                    editAWaccount.setText("");
                    editAWpassword.setText("");
                    editAWemail.setText("");
                }

            }
        });

    }

    private NguoiDung CreateNguoiDung(){

        String name=editAWname.getText().toString();
        String account=editAWaccount.getText().toString();
        String password=editAWpassword.getText().toString();
        String email=editAWemail.getText().toString();
        Boolean quyen=quyen1;

        NguoiDung nguoiDung=new NguoiDung(name,account,password,email,quyen);
        return nguoiDung;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_popup,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.menuExit:
                Intent back= new Intent(RegisterActivity.this, LogOnActivity.class);
                startActivity(back);
                finish();
                Toast.makeText(this, "Exit", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuSetting:
                Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuAccounts:
                Toast.makeText(this, "Account", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuChangePass:
                Toast.makeText(this, "Change Password", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
