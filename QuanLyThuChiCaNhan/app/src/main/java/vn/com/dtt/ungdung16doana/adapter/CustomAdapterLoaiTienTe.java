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
import vn.com.dtt.ungdung16doana.model.TienTe;

public class CustomAdapterLoaiTienTe extends ArrayAdapter<TienTe> {
    private Context context;
    private int resource;
    private List<TienTe> listtiente;

    public CustomAdapterLoaiTienTe(@NonNull Context context, @LayoutRes int resource, @NonNull List<TienTe> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.listtiente=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHodler viewHodler;
        if(convertView==null)
        {
            convertView= LayoutInflater.from(context).inflate(R.layout.item_loaitiente,parent,false);
            viewHodler=new ViewHodler();
            viewHodler.tvMaTienTe=(TextView)convertView.findViewById(R.id.tv_MaTienTe);
            viewHodler.tvName_Current_Money_Type=(TextView)convertView.findViewById(R.id.tv_Name_Current_Money_Type);

            convertView.setTag(viewHodler);
        }else{
            viewHodler=(ViewHodler) convertView.getTag();
        }
        TienTe tienTe=listtiente.get(position);

        viewHodler.tvMaTienTe.setText(String.valueOf(tienTe.getMaTienTe()));
        viewHodler.tvName_Current_Money_Type.setText(tienTe.getTenTienTe());

        return convertView;
    }
    public class ViewHodler {
        private TextView tvMaTienTe;
        private TextView tvName_Current_Money_Type;
    }
}
