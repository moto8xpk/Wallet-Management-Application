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
import vn.com.dtt.ungdung16doana.model.NguoiDung;

public class CustomAdapter extends ArrayAdapter {

    private  Context context;
    private int resource;
    private List<NguoiDung> listnguoidung;

    public CustomAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<NguoiDung> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.listnguoidung= objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHodler viewHodler;
        if(convertView==null)
        {
            convertView= LayoutInflater.from(context).inflate(R.layout.item_nguoidung,parent,false);
            viewHodler=new ViewHodler();
            viewHodler.tvMaNguoiDung=(TextView)convertView.findViewById(R.id.tv_MaNguoiDung);
            viewHodler.tvName=(TextView)convertView.findViewById(R.id.tv_Name);
            viewHodler.tvAccount=(TextView)convertView.findViewById(R.id.tv_Account);
            viewHodler.tvPassword=(TextView)convertView.findViewById(R.id.tv_Password);
            viewHodler.tvEmail=(TextView)convertView.findViewById(R.id.tv_Email);

            convertView.setTag(viewHodler);
        }else{
            viewHodler=(ViewHodler) convertView.getTag();
        }
        NguoiDung nguoiDung=listnguoidung.get(position);

        viewHodler.tvMaNguoiDung.setText(String.valueOf(nguoiDung.getManguoidung()));
        viewHodler.tvName.setText(nguoiDung.getHoten());
        viewHodler.tvAccount.setText(nguoiDung.getTentaikhoan());
        viewHodler.tvPassword.setText(nguoiDung.getMatkhau());
        viewHodler.tvEmail.setText(nguoiDung.getEmail());

        return convertView;
    }
    public class ViewHodler {
        private TextView tvMaNguoiDung;
        private TextView tvName;
        private TextView tvAccount;
        private TextView tvPassword;
        private TextView tvEmail;

    }
}
