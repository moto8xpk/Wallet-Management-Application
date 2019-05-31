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
import vn.com.dtt.ungdung16doana.adapter.CustomAdapterLoaiTienTe;
import vn.com.dtt.ungdung16doana.data.DBmanager;
import vn.com.dtt.ungdung16doana.model.TienTe;

public class AddCurrentMoney extends AppCompatActivity {

    private Button btnback;
    private Button btnsave;

    private EditText Adminaddcurrentmoneytype;
//    private EditText Adminaddidcurrentmoneytype;

    private List<TienTe> tienTes;
    private ListView lvcurrentmoneytype;
    private DBmanager dBmanager;
    private CustomAdapterLoaiTienTe customAdapterLoaiTienTe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_current_money);

        dBmanager=new DBmanager(this);

        btnback=(Button) findViewById(R.id.btnAdminAddCurrentMoneyTypeBack);
        btnsave=(Button)findViewById(R.id.btnSaveCurrentMoneyType);

        lvcurrentmoneytype=(ListView) findViewById(R.id.lvaddCurrentMoneyType);

        Adminaddcurrentmoneytype=(EditText) findViewById(R.id.edittextAddCurrentMoneyTypeWT);
  //      Adminaddidcurrentmoneytype=(EditText) findViewById(R.id.edittextAddIDCurrentTypeWT);

        tienTes=dBmanager.GetAllTienTe();
        setAdapter();

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TienTe tienTe=CreateLoaiTienTe();
                if(tienTe!=null){
                    dBmanager.addLoaiTienTe(tienTe);
                    Adminaddcurrentmoneytype.setText("");
        //            Adminaddidcurrentmoneytype.setText("");
                }
                updateListTienTe();
                setAdapter();

            }
        });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it7=new Intent(AddCurrentMoney.this, AdminUIActivity.class);
                startActivity(it7);
                finish();
            }
        });
        lvcurrentmoneytype.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                TienTe tienTe = tienTes.get(position);
                int result = dBmanager.deleteLoaiTienTe(tienTe.getMaTienTe());
                if(result>0){
                    Toast.makeText(AddCurrentMoney.this, "Delete successfuly", Toast.LENGTH_SHORT).show();
                    updateListTienTe();
                }else{
                    Toast.makeText(AddCurrentMoney.this, "Delete fail", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }
    public void setAdapter(){
        if(customAdapterLoaiTienTe==null)
        {
            customAdapterLoaiTienTe=new CustomAdapterLoaiTienTe(this,R.layout.item_loaitiente,tienTes);
            lvcurrentmoneytype.setAdapter(customAdapterLoaiTienTe);
        }
        else {
            customAdapterLoaiTienTe.notifyDataSetChanged();
            lvcurrentmoneytype.setSelection(customAdapterLoaiTienTe.getCount()-1);
        }
    }
    public void updateListTienTe(){
        tienTes.clear();
        tienTes.addAll(dBmanager.GetAllTienTe());
        if (customAdapterLoaiTienTe!=null)
        {
            customAdapterLoaiTienTe.notifyDataSetChanged();
        }
    }
    private TienTe CreateLoaiTienTe(){

     //   int id= Integer.valueOf(String.valueOf(Adminaddidcurrentmoneytype.getText()));
        String name_current_money_type=Adminaddcurrentmoneytype.getText().toString();

        TienTe tienTe=new TienTe(name_current_money_type);
        return tienTe;
    }
}
