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
import vn.com.dtt.ungdung16doana.adapter.CustomAdapterLoaiVi;
import vn.com.dtt.ungdung16doana.data.DBmanager;
import vn.com.dtt.ungdung16doana.model.LoaiVi;

public class AddWalletType extends AppCompatActivity {



    private EditText Adminaddwallettype;

    private Button btnback;
    private Button btnSaveAdd;

    private List<LoaiVi> loaiVis;
    private ListView lvWallettype;
    private DBmanager dBmanager;
    private CustomAdapterLoaiVi customAdapterLoaiVi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_wallet_type);

        dBmanager=new DBmanager(this);

        lvWallettype=(ListView) findViewById(R.id.lvaddWallet);

        btnback=(Button)findViewById(R.id.btnAdminAddWalletTypeBack);
        btnSaveAdd=(Button)findViewById(R.id.btnSaveWalletType);

        Adminaddwallettype=(EditText) findViewById(R.id.edittextAddWalletTypeWT);

        loaiVis=dBmanager.GetAllLoaiVi();
        setAdapter();

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it6=new Intent(AddWalletType.this, AdminUIActivity.class);
                startActivity(it6);
                finish();
            }
        });
        btnSaveAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoaiVi loaiVi=CreateLoaiVi();
                if(loaiVi!=null){
                    dBmanager.addLoaiVi(loaiVi);
                    Adminaddwallettype.setText("");
                }
                updateListLoaiVi();
                setAdapter();

            }
        });
        lvWallettype.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                LoaiVi loaiVi = loaiVis.get(position);
                int result = dBmanager.deleteLoaiVi(loaiVi.getMaLoaiVi());
                if(result>0){
                    Toast.makeText(AddWalletType.this, "Delete successfuly", Toast.LENGTH_SHORT).show();
                    updateListLoaiVi();
                }else{
                    Toast.makeText(AddWalletType.this, "Delete fail", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }

    public void setAdapter(){
        if(customAdapterLoaiVi==null)
        {
            customAdapterLoaiVi=new CustomAdapterLoaiVi(this,R.layout.item_loaivi,loaiVis);
            lvWallettype.setAdapter(customAdapterLoaiVi);
        }
        else {
            customAdapterLoaiVi.notifyDataSetChanged();
            lvWallettype.setSelection(customAdapterLoaiVi.getCount()-1);
        }
    }
    public void updateListLoaiVi(){
        loaiVis.clear();
        loaiVis.addAll(dBmanager.GetAllLoaiVi());
        if (customAdapterLoaiVi!=null)
        {
            customAdapterLoaiVi.notifyDataSetChanged();
        }
    }
    private LoaiVi CreateLoaiVi(){

//        int id= Integer.valueOf(String.valueOf(Adminaddidwallettype.getText()));
        String name_wallet_type=Adminaddwallettype.getText().toString();

        LoaiVi loaiVi=new LoaiVi(name_wallet_type);
        return loaiVi;
    }
}
