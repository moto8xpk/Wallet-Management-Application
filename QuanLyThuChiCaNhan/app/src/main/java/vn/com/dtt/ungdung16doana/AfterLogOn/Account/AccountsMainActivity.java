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

import java.util.List;

import vn.com.dtt.ungdung16doana.AfterLogOn.Ui1Activity;
import vn.com.dtt.ungdung16doana.LogOnActivity;
import vn.com.dtt.ungdung16doana.R;
import vn.com.dtt.ungdung16doana.adapter.CustomAdapterVi;
import vn.com.dtt.ungdung16doana.data.DBmanager;
import vn.com.dtt.ungdung16doana.model.Vi;

public class AccountsMainActivity extends AppCompatActivity {
    private List<Vi> vis;
    private ListView lvaccounts;
    private DBmanager dBmanager;
    private CustomAdapterVi customAdapterVi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts_main);

        dBmanager = new DBmanager(this);

        lvaccounts = (ListView) findViewById(R.id.lvAccounts);
        vis = dBmanager.GetAllVi();
        setAdapter();
        lvaccounts.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                Vi vi = vis.get(position);
                int result = dBmanager.deleteVi(vi.getMaVi());
                if(result>0){
                    Toast.makeText(AccountsMainActivity.this, "Delete successfuly", Toast.LENGTH_SHORT).show();
                    updateListVi();
                }else{
                    Toast.makeText(AccountsMainActivity.this, "Delete fail", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }

    public void setAdapter() {
        if (customAdapterVi == null) {
            customAdapterVi = new CustomAdapterVi(this, R.layout.item_vi, vis);
            lvaccounts.setAdapter(customAdapterVi);
        } else {
            customAdapterVi.notifyDataSetChanged();
            lvaccounts.setSelection(customAdapterVi.getCount() - 1);
        }
    }
    public void updateListVi(){
        vis.clear();
        vis.addAll(dBmanager.GetAllVi());
        if (customAdapterVi!=null)
        {
            customAdapterVi.notifyDataSetChanged();
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
                Intent out= new Intent(AccountsMainActivity.this, LogOnActivity.class);
                startActivity(out);
                finish();
                Toast.makeText(this, "Log Out", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuExit:
                Intent back= new Intent(AccountsMainActivity.this, Ui1Activity.class);
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
