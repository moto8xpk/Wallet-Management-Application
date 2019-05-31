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

import java.text.DecimalFormat;
import java.util.List;

import vn.com.dtt.ungdung16doana.R;
import vn.com.dtt.ungdung16doana.model.ChiTietThu;

public class CustomAdapterChiTietThu extends ArrayAdapter<ChiTietThu> {
    private Context context;
    private int resource;
    private List<ChiTietThu> listchitietcthu ;


    public CustomAdapterChiTietThu(@NonNull Context context, @LayoutRes int resource, @NonNull List<ChiTietThu> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.listchitietcthu=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHodler viewHodler;
        if(convertView==null)
        {
            convertView= LayoutInflater.from(context).inflate(R.layout.item_chitietthu,parent,false);
            viewHodler=new ViewHodler();

            viewHodler.tvMaGiaoDichThu=(TextView)convertView.findViewById(R.id.tv_MaGiaoDichThu);
//            viewHodler.tvTenGiaoDichThu=(TextView)convertView.findViewById(R.id.tv_TenGiaoDichThu);
            viewHodler.tvTenLoaiThu=(TextView)convertView.findViewById(R.id.tv_TenLoaiThu);
            viewHodler.tvTenViThu=(TextView)convertView.findViewById(R.id.tv_TenViThu);
            viewHodler.tvSoTienThu=(TextView)convertView.findViewById(R.id.tv_SoTienThu);
            viewHodler.tvNgayThu=(TextView)convertView.findViewById(R.id.tv_NgayThu);
            viewHodler.tvDienGiaiThu=(TextView)convertView.findViewById(R.id.tv_DienGiaiThu);

            convertView.setTag(viewHodler);
        }else{
            viewHodler=(ViewHodler) convertView.getTag();
        }
        ChiTietThu chiTietThu=listchitietcthu.get(position);

        viewHodler.tvMaGiaoDichThu.setText(String.valueOf(chiTietThu.getMaGiaoDichThu()));
//        viewHodler.tvTenGiaoDichThu.setText(chiTietThu.getTenGiaoDichThu());
        viewHodler.tvTenLoaiThu.setText(chiTietThu.getTenLoaiThu());
        viewHodler.tvTenViThu.setText(chiTietThu.getTenViThu());
        viewHodler.tvSoTienThu.setText(chuyenchuoi(chiTietThu.getSoTienThu()));
        viewHodler.tvNgayThu.setText(chiTietThu.getNgayThu());
        viewHodler.tvDienGiaiThu.setText(chiTietThu.getDienGiaiThu());
        return convertView;
    }
    public class ViewHodler {
        private TextView tvMaGiaoDichThu;
//        private TextView tvTenGiaoDichThu;
        private TextView tvTenLoaiThu;
        private TextView tvTenViThu;
        private TextView tvSoTienThu;
        private TextView tvNgayThu;
        private TextView tvDienGiaiThu;
    }
    public String chuyenchuoi(double money)
    {
        String pattern="###,###";
        DecimalFormat decimalFormat=new DecimalFormat(pattern);
        String output=decimalFormat.format(money);
        return output;
    }
}
