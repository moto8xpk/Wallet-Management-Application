package vn.com.dtt.ungdung16doana.AfterLogOn.Account;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.List;

import vn.com.dtt.ungdung16doana.AfterLogOn.Ui1Activity;
import vn.com.dtt.ungdung16doana.R;
import vn.com.dtt.ungdung16doana.adapter.CustomAdapterChiTietThu;
import vn.com.dtt.ungdung16doana.data.DBmanager;
import vn.com.dtt.ungdung16doana.model.ChiTietThu;

public class IncomeHistoryActivity extends AppCompatActivity {

    private List<ChiTietThu> chiTietThus;
    private ListView lvchitietthu;
    private DBmanager dBmanager;
    private CustomAdapterChiTietThu customAdapterChiTietThu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_history);
        dBmanager = new DBmanager(this);

        lvchitietthu = (ListView) findViewById(R.id.lvChiTietThus);
        chiTietThus = dBmanager.GetAllChiTietThu();
        setAdapter();
        lvchitietthu.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                ChiTietThu chiTietThu = chiTietThus.get(position);
                int result = dBmanager.deleteChiTietThu(chiTietThu.getMaGiaoDichThu());
                if(result>0){
                    Toast.makeText(IncomeHistoryActivity.this, "Delete successfuly", Toast.LENGTH_SHORT).show();
                    updateListChiTietThu();
                }else{
                    Toast.makeText(IncomeHistoryActivity.this, "Delete fail", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

    }
    public void setAdapter() {
        if (customAdapterChiTietThu == null) {
            customAdapterChiTietThu = new CustomAdapterChiTietThu(this, R.layout.item_chitietthu, chiTietThus);
            lvchitietthu.setAdapter(customAdapterChiTietThu);
        } else {
            customAdapterChiTietThu.notifyDataSetChanged();
            lvchitietthu.setSelection(customAdapterChiTietThu.getCount() - 1);
        }
    }
    public void updateListChiTietThu(){
        chiTietThus.clear();
        chiTietThus.addAll(dBmanager.GetAllChiTietThu());
        if (customAdapterChiTietThu!=null)
        {
            customAdapterChiTietThu.notifyDataSetChanged();
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
                Intent out= new Intent(IncomeHistoryActivity.this,Ui1Activity.class);
                startActivity(out);
                finish();
                Toast.makeText(this, "Log Out", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuExit:
                Intent back= new Intent(IncomeHistoryActivity.this, Ui1Activity.class);
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
    public String chuyenchuoi(double money)
    {
        String pattern="###,###";
        DecimalFormat decimalFormat=new DecimalFormat(pattern);
        String output=decimalFormat.format(money);
        return output;
    }
}
