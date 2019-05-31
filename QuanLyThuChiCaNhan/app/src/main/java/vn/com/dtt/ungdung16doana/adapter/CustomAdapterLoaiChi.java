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
import vn.com.dtt.ungdung16doana.model.LoaiChi;

public class CustomAdapterLoaiChi extends ArrayAdapter<LoaiChi>{
    private Context context;
    private int resource;
    private List<LoaiChi> listloaichi ;

    public CustomAdapterLoaiChi(@NonNull Context context, @LayoutRes int resource, @NonNull List<LoaiChi> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.listloaichi=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHodler viewHodler;
        if(convertView==null)
        {
            convertView= LayoutInflater.from(context).inflate(R.layout.item_loaichitieu,parent,false);
            viewHodler=new ViewHodler();
            viewHodler.tvMaChi=(TextView)convertView.findViewById(R.id.tv_MaLoaiChi);
            viewHodler.tvName_Outcome_Type=(TextView)convertView.findViewById(R.id.tv_Name_Outcome_type);

            convertView.setTag(viewHodler);
        }else{
            viewHodler=(ViewHodler) convertView.getTag();
        }
        LoaiChi loaiChi=listloaichi.get(position);

        viewHodler.tvMaChi.setText(String.valueOf(loaiChi.getMaChi()));
        viewHodler.tvName_Outcome_Type.setText(loaiChi.getTenLoaiChi());
        return convertView;
    }

    public class ViewHodler {
        private TextView tvMaChi;
        private TextView tvName_Outcome_Type;
    }
}
