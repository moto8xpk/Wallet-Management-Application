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
import vn.com.dtt.ungdung16doana.model.LoaiThu;

public class CustomAdapterLoaiThu extends ArrayAdapter<LoaiThu> {

    private Context context;
    private int resource;
    private List<LoaiThu> listloaithu ;

    public CustomAdapterLoaiThu(@NonNull Context context, @LayoutRes int resource, @NonNull List<LoaiThu> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.listloaithu=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHodler viewHodler;
        if(convertView==null)
        {
            convertView= LayoutInflater.from(context).inflate(R.layout.item_loaithunhap,parent,false);
            viewHodler=new ViewHodler();
            viewHodler.tvMaThu=(TextView)convertView.findViewById(R.id.tv_MaLoaithu);
            viewHodler.tvName_Income_Type=(TextView)convertView.findViewById(R.id.tv_Name_Income_type);

            convertView.setTag(viewHodler);
        }else{
            viewHodler=(ViewHodler) convertView.getTag();
        }
        LoaiThu loaiThu=listloaithu.get(position);

        viewHodler.tvMaThu.setText(String.valueOf(loaiThu.getMaThu()));
        viewHodler.tvName_Income_Type.setText(loaiThu.getTenLoaiThu());

        return convertView;
    }

    public class ViewHodler {
        private TextView tvMaThu;
        private TextView tvName_Income_Type;
    }
}
