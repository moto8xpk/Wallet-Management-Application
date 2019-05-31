package vn.com.dtt.ungdung16doana.AfterLogOn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import vn.com.dtt.ungdung16doana.AfterLogOn.Admin.AddCurrentMoney;
import vn.com.dtt.ungdung16doana.AfterLogOn.Admin.AddIncomeType;
import vn.com.dtt.ungdung16doana.AfterLogOn.Admin.AddOutcomeType;
import vn.com.dtt.ungdung16doana.AfterLogOn.Admin.AddWalletType;
import vn.com.dtt.ungdung16doana.LogOnActivity;
import vn.com.dtt.ungdung16doana.R;
import vn.com.dtt.ungdung16doana.adapter.CustomAdapter;
import vn.com.dtt.ungdung16doana.data.DBmanager;
import vn.com.dtt.ungdung16doana.model.NguoiDung;

public class AdminUIActivity extends AppCompatActivity {

    private DBmanager dBmanager;
    private Button btnView;
    private Button btnAddWallettype;
    private Button btnAddCurrentMoneyType;
    private Button btnAddIncomeType;
    private Button btnAddOutcomeType;
    private CustomAdapter customAdapter;
    private List<NguoiDung> nguoiDungs;
    private ListView lvNguoiDung;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_ui);

        dBmanager=new DBmanager(this);

        lvNguoiDung=(ListView) findViewById(R.id.lv_NguoiDung);
        btnView=(Button) findViewById(R.id.btnViewListUser);
        btnAddWallettype=(Button)findViewById(R.id.btnAdminAddWalletType);
        btnAddCurrentMoneyType=(Button) findViewById(R.id.btnAdminAddMoneyCurrent);
        btnAddIncomeType=(Button) findViewById(R.id.btnAdminAddIncomeType);
        btnAddOutcomeType=(Button)findViewById(R.id.btnAdminAddOutcomeType);

        nguoiDungs=dBmanager.GetAllNguoiDung();

        setAdapter();

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateListNguoiDung();
                setAdapter();
            }
        });
        btnAddWallettype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it5=new Intent(AdminUIActivity.this, AddWalletType.class);
                startActivity(it5);
                finish();
            }
        });
        btnAddCurrentMoneyType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it8=new Intent(AdminUIActivity.this, AddCurrentMoney.class);
                startActivity(it8);
                finish();
            }
        });
        btnAddIncomeType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it9=new Intent(AdminUIActivity.this, AddIncomeType.class);
                startActivity(it9);
                finish();
            }
        });
        btnAddOutcomeType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it11=new Intent(AdminUIActivity.this, AddOutcomeType.class);
                startActivity(it11);
                finish();
            }
        });
    }

    public void setAdapter(){
        if(customAdapter==null)
        {
            customAdapter=new CustomAdapter(this,R.layout.item_nguoidung,nguoiDungs);
            lvNguoiDung.setAdapter(customAdapter);
        }
        else {
            customAdapter.notifyDataSetChanged();
            lvNguoiDung.setSelection(customAdapter.getCount()-1);
        }
    }

    public void updateListNguoiDung(){
        nguoiDungs.clear();
        nguoiDungs.addAll(dBmanager.GetAllNguoiDung());
        if (customAdapter!=null)
        {
            customAdapter.notifyDataSetChanged();
        }
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
            case R.id.menuLogOut:
                Intent out= new Intent(AdminUIActivity.this, LogOnActivity.class);
                startActivity(out);
                finish();
                Toast.makeText(this, "Log Out", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuExit:
                /*Intent back= new Intent(AccountsMainActivity.this, Ui1Activity.class);
                startActivity(back);
                finish();*/
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
