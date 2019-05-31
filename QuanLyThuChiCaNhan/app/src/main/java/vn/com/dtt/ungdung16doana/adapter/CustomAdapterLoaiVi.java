package vn.com.dtt.ungdung16doana.adapter;


import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import vn.com.dtt.ungdung16doana.R;
import vn.com.dtt.ungdung16doana.model.LoaiVi;

public class CustomAdapterLoaiVi extends ArrayAdapter<LoaiVi> {
    private Context context;
    private int resource;
    private List<LoaiVi> listloaivi ;


    public CustomAdapterLoaiVi(@NonNull Context context, @LayoutRes int resource, @NonNull List<LoaiVi> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.listloaivi=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHodler viewHodler;
        if(convertView==null)
        {
            convertView= LayoutInflater.from(context).inflate(R.layout.item_loaivi,parent,false);
            viewHodler=new ViewHodler();
            viewHodler.tvMaLoaiVi=(TextView)convertView.findViewById(R.id.tv_MaLoaiVi);
            viewHodler.tvName_Wallet_Type=(TextView)convertView.findViewById(R.id.tv_Name_Wallet_type);

            convertView.setTag(viewHodler);
        }else{
            viewHodler=(ViewHodler) convertView.getTag();
        }
        LoaiVi loaiVi=listloaivi.get(position);

        viewHodler.tvMaLoaiVi.setText(String.valueOf(loaiVi.getMaLoaiVi()));
        viewHodler.tvName_Wallet_Type.setText(loaiVi.getTenLoaiVi());

        return convertView;

    }

    public class ViewHodler {
        private TextView tvMaLoaiVi;
        private TextView tvName_Wallet_Type;
    }
}
