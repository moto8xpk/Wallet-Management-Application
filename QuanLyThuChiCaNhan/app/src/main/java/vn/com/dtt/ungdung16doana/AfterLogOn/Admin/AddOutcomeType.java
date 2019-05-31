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
import vn.com.dtt.ungdung16doana.adapter.CustomAdapterLoaiChi;
import vn.com.dtt.ungdung16doana.data.DBmanager;
import vn.com.dtt.ungdung16doana.model.LoaiChi;

public class AddOutcomeType extends AppCompatActivity {

    private EditText Adminaddoutcometype;
//    private EditText Adminaddidoutcometype;

    private Button btnback;
    private Button btnSaveAdd;

    private List<LoaiChi> loaiChis;
    private ListView lvOutcometype;
    private DBmanager dBmanager;
    private CustomAdapterLoaiChi customAdapterLoaiChi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_outcome_type);

        dBmanager=new DBmanager(this);

        lvOutcometype=(ListView) findViewById(R.id.lvaddOutcome);

        btnback=(Button)findViewById(R.id.btnAdminAddOutcomeTypeBack);
        btnSaveAdd=(Button)findViewById(R.id.btnSaveOutcomeType);

        Adminaddoutcometype=(EditText) findViewById(R.id.edittextAddOutcomeTypeWT);
   //     Adminaddidoutcometype=(EditText) findViewById(R.id.edittextAddIDOutcomeTypeWT);

        loaiChis=dBmanager.GetAllLoaiChi();
        setAdapter();
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it10=new Intent(AddOutcomeType.this, AdminUIActivity.class);
                startActivity(it10);
                finish();
            }
        });
        btnSaveAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoaiChi loaiChi=CreateLoaiChi();
                if(loaiChi!=null){
                    dBmanager.addLoaiChi(loaiChi);
                    Adminaddoutcometype.setText("");
       //             Adminaddidoutcometype.setText("");
                }
                updateListLoaiChi();
                setAdapter();

            }
        });
        lvOutcometype.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                LoaiChi loaiChi = loaiChis.get(position);
                int result = dBmanager.deleteLoaiChi(loaiChi.getMaChi());
                if(result>0){
                    Toast.makeText(AddOutcomeType.this, "Delete successfuly", Toast.LENGTH_SHORT).show();
                    updateListLoaiChi();
                }else{
                    Toast.makeText(AddOutcomeType.this, "Delete fail", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }
    public void setAdapter(){
        if(customAdapterLoaiChi==null)
        {
            customAdapterLoaiChi=new CustomAdapterLoaiChi(this,R.layout.item_loaichitieu,loaiChis);
            lvOutcometype.setAdapter(customAdapterLoaiChi);
        }
        else {
            customAdapterLoaiChi.notifyDataSetChanged();
            lvOutcometype.setSelection(customAdapterLoaiChi.getCount()-1);
        }
    }
    public void updateListLoaiChi(){
        loaiChis.clear();
        loaiChis.addAll(dBmanager.GetAllLoaiChi());
        if (customAdapterLoaiChi!=null)
        {
            customAdapterLoaiChi.notifyDataSetChanged();
        }
    }
    private LoaiChi CreateLoaiChi(){

    //    int id= Integer.valueOf(String.valueOf(Adminaddidoutcometype.getText()));
        String name_outcome_type=Adminaddoutcometype.getText().toString();

        LoaiChi loaiChi=new LoaiChi(name_outcome_type);
        return loaiChi;
    }
}
