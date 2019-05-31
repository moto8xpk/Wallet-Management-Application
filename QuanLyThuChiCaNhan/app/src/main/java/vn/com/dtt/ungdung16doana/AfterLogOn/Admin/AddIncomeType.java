package vn.com.dtt.ungdung16doana.AfterLogOn.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import vn.com.dtt.ungdung16doana.AfterLogOn.AdminUIActivity;
import vn.com.dtt.ungdung16doana.R;
import vn.com.dtt.ungdung16doana.adapter.CustomAdapterLoaiThu;
import vn.com.dtt.ungdung16doana.data.DBmanager;
import vn.com.dtt.ungdung16doana.model.LoaiThu;

public class AddIncomeType extends AppCompatActivity {

    private EditText Adminaddincometype;
//    private EditText Adminaddidincometype;

    private Button btnback;
    private Button btnSaveAdd;

    private List<LoaiThu> loaiThus;
    private ListView lvIncometype;
    private DBmanager dBmanager;
    private CustomAdapterLoaiThu customAdapterLoaiThu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_income_type);

        dBmanager=new DBmanager(this);

        lvIncometype=(ListView) findViewById(R.id.lvaddIncome);

        btnback=(Button)findViewById(R.id.btnAdminAddIncomeTypeBack);
        btnSaveAdd=(Button)findViewById(R.id.btnSaveIncomeType);

        Adminaddincometype=(EditText) findViewById(R.id.edittextAddIncomeTypeWT);
 //       Adminaddidincometype=(EditText) findViewById(R.id.edittextAddIDIncomeTypeWT);

        loaiThus=dBmanager.GetAllLoaiThu();
        setAdapter();
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it8=new Intent(AddIncomeType.this, AdminUIActivity.class);
                startActivity(it8);
                finish();
            }
        });
        btnSaveAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoaiThu loaiThu=CreateLoaiThu();
                if(loaiThu!=null){
                    dBmanager.addLoaiThu(loaiThu);
                    Adminaddincometype.setText("");
      //              Adminaddidincometype.setText("");
                }
                updateListLoaiThu();
                setAdapter();

            }
        });
        lvIncometype.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                LoaiThu loaiThu = loaiThus.get(position);
                int result = dBmanager.deleteLoaiThu(loaiThu.getMaThu());
                if(result>0){
                    Toast.makeText(AddIncomeType.this, "Delete successfuly", Toast.LENGTH_SHORT).show();
                    updateListLoaiThu();
                }else{
                    Toast.makeText(AddIncomeType.this, "Delete fail", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }
    public void setAdapter(){
        if(customAdapterLoaiThu==null)
        {
            customAdapterLoaiThu=new CustomAdapterLoaiThu(this,R.layout.item_loaithunhap,loaiThus);
            lvIncometype.setAdapter(customAdapterLoaiThu);
        }
        else {
            customAdapterLoaiThu.notifyDataSetChanged();
            lvIncometype.setSelection(customAdapterLoaiThu.getCount()-1);
        }
    }
    public void updateListLoaiThu(){
        loaiThus.clear();
        loaiThus.addAll(dBmanager.GetAllLoaiThu());
        if (customAdapterLoaiThu!=null)
        {
            customAdapterLoaiThu.notifyDataSetChanged();
        }
    }
    private LoaiThu CreateLoaiThu(){

   //     int id= Integer.valueOf(String.valueOf(Adminaddidincometype.getText()));
        String name_income_type=Adminaddincometype.getText().toString();

        LoaiThu loaiThu=new LoaiThu(name_income_type);
        return loaiThu;
    }
}
