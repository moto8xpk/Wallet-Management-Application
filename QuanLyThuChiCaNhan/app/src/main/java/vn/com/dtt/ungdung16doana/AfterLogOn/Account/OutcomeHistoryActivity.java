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
import vn.com.dtt.ungdung16doana.adapter.CustomAdapterChiTietChi;
import vn.com.dtt.ungdung16doana.data.DBmanager;
import vn.com.dtt.ungdung16doana.model.ChiTietChi;

public class OutcomeHistoryActivity extends AppCompatActivity {

    private List<ChiTietChi> chiTietChis;
    private ListView lvchitietchi;
    private DBmanager dBmanager;
    private CustomAdapterChiTietChi customAdapterChiTietChi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outcome_history);
        dBmanager = new DBmanager(this);

        lvchitietchi = (ListView) findViewById(R.id.lvChiTietChis);
        chiTietChis = dBmanager.GetAllChiTietChi();
        setAdapter();
        lvchitietchi.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                ChiTietChi chiTietChi = chiTietChis.get(position);
                int result = dBmanager.deleteChiTietChi(chiTietChi.getMaGiaoDichChi());
                if(result>0){
                    Toast.makeText(OutcomeHistoryActivity.this, "Delete successfuly", Toast.LENGTH_SHORT).show();
                    updateListChiTietChi();
                }else{
                    Toast.makeText(OutcomeHistoryActivity.this, "Delete fail", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

    }
    public void setAdapter() {
        if (customAdapterChiTietChi == null) {
            customAdapterChiTietChi = new CustomAdapterChiTietChi(this, R.layout.item_chitietthu, chiTietChis);
            lvchitietchi.setAdapter(customAdapterChiTietChi);
        } else {
            customAdapterChiTietChi.notifyDataSetChanged();
            lvchitietchi.setSelection(customAdapterChiTietChi.getCount() - 1);
        }
    }
    public void updateListChiTietChi(){
        chiTietChis.clear();
        chiTietChis.addAll(dBmanager.GetAllChiTietChi());
        if (customAdapterChiTietChi!=null)
        {
            customAdapterChiTietChi.notifyDataSetChanged();
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
                Intent out= new Intent(OutcomeHistoryActivity.this,Ui1Activity.class);
                startActivity(out);
                finish();
                Toast.makeText(this, "Log Out", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuExit:
                Intent back= new Intent(OutcomeHistoryActivity.this, Ui1Activity.class);
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
