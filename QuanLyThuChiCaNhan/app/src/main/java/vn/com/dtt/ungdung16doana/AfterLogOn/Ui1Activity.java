package vn.com.dtt.ungdung16doana.AfterLogOn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import vn.com.dtt.ungdung16doana.AfterLogOn.Account.AccountsMainActivity;
import vn.com.dtt.ungdung16doana.AfterLogOn.Account.AddAccountActivity;
import vn.com.dtt.ungdung16doana.AfterLogOn.Account.IncomeActivity;
import vn.com.dtt.ungdung16doana.AfterLogOn.Account.MakeStatisticActivity;
import vn.com.dtt.ungdung16doana.AfterLogOn.Account.OutcomeActivity;
import vn.com.dtt.ungdung16doana.LogOnActivity;
import vn.com.dtt.ungdung16doana.R;
import vn.com.dtt.ungdung16doana.AfterLogOn.Account.OutLineHistoryActivity;
import vn.com.dtt.ungdung16doana.data.DBmanager;

public class Ui1Activity extends AppCompatActivity {

    private Button btn1;
    Button btnmenuWM;
    Button btnmenuTM;
    Button btnmenuStatistic;
    TextView tvsotientong;
    TextView tvloaite;
    private DBmanager dBmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui1);
        btnmenuWM=(Button)findViewById(R.id.btnMenuWM);
        btnmenuTM=(Button)findViewById(R.id.btnMenuTM);
        btnmenuStatistic=(Button)findViewById(R.id.btnMenuStatistic);
        tvloaite=(TextView) findViewById(R.id.tv_loaitien);
        tvsotientong=(TextView) findViewById(R.id.tv_Money);
        dBmanager=new DBmanager(this);
        double sotien = 0;
        sotien=dBmanager.GetUpdateSoDu();
        String sotientext=chuyenchuoi(sotien);
        tvsotientong.setText(sotientext);
        String loaite=null;
        loaite=dBmanager.Gettypemoney();
        tvloaite.setText(loaite);
        btnmenuWM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowmenuWM();
            }
        });
        btnmenuTM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowmenuTM();
            }
        });
        btnmenuStatistic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowmenuStatistic();
            }
        });
//        btn1 = (Button) findViewById(R.id.btnAddWM);
//
//        btn1.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                Intent add = new Intent(Ui1Activity.this, AddAccountActivity.class);
//                startActivity(add);
//
//            }
//        });
    }

    private void ShowmenuWM(){
        PopupMenu popupMenu=new PopupMenu(this,btnmenuWM);
        popupMenu.getMenuInflater().inflate(R.menu.menu_list_wm,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menuAddAccount:
                        Intent add=new Intent(Ui1Activity.this, AddAccountActivity.class);
                        startActivity(add);
                        finish();
                        break;
                    case R.id.menuAccounts:
                        Intent acc=new Intent(Ui1Activity.this, AccountsMainActivity.class);
                        startActivity(acc);
                        finish();
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }
    private void ShowmenuTM(){
        PopupMenu popupMenu=new PopupMenu(this,btnmenuTM);
        popupMenu.getMenuInflater().inflate(R.menu.menu_list_tm,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menuIncomeTM:
                        Intent addincome=new Intent(Ui1Activity.this, IncomeActivity.class);
                        startActivity(addincome);
                        finish();
                        break;
                    case R.id.menuOutcomeTM:
                        Intent addoutcome=new Intent(Ui1Activity.this, OutcomeActivity.class);
                        startActivity(addoutcome);
                        finish();
                        break;
                    case R.id.menuTransactionHistoryTM:
                        Intent his=new Intent(Ui1Activity.this, OutLineHistoryActivity.class);
                        startActivity(his);
                        finish();
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }
    private void ShowmenuStatistic(){
        PopupMenu popupMenu=new PopupMenu(this,btnmenuStatistic);
        popupMenu.getMenuInflater().inflate(R.menu.menu_list_statistic,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menuMakeStatistic:
                        Intent h1=new Intent(Ui1Activity.this, MakeStatisticActivity.class);
                        startActivity(h1);
                        finish();
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
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
                Intent out= new Intent(Ui1Activity.this, LogOnActivity.class);
                startActivity(out);
                finish();
                Toast.makeText(this, "Log Out", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuExit:
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
    public String chuyenchuoi(double money)
    {
        String pattern="###,###";
        DecimalFormat decimalFormat=new DecimalFormat(pattern);
        String output=decimalFormat.format(money);
        return output;
    }
}


