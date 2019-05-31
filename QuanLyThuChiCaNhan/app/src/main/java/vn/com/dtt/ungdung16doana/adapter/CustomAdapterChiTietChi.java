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
import vn.com.dtt.ungdung16doana.model.ChiTietChi;

public class CustomAdapterChiTietChi extends ArrayAdapter<ChiTietChi>{
    private Context context;
    private int resource;
    private List<ChiTietChi> listchitietchi ;

    public CustomAdapterChiTietChi(@NonNull Context context, @LayoutRes int resource, @NonNull List<ChiTietChi> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.listchitietchi=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHodler viewHodler;
        if(convertView==null)
        {
            convertView= LayoutInflater.from(context).inflate(R.layout.item_chitietchi,parent,false);
            viewHodler=new ViewHodler();

            viewHodler.tvMaGiaoDichChi=(TextView)convertView.findViewById(R.id.tv_MaGiaoDichChi);
//            viewHodler.tvTenGiaoDichChi=(TextView)convertView.findViewById(R.id.tv_TenGiaoDichChi);
            viewHodler.tvTenLoaiChi=(TextView)convertView.findViewById(R.id.tv_TenLoaiChi);
            viewHodler.tvTenViChi=(TextView)convertView.findViewById(R.id.tv_TenViChi);
            viewHodler.tvSoTienChi=(TextView)convertView.findViewById(R.id.tv_SoTienChi);
            viewHodler.tvNgayChi=(TextView)convertView.findViewById(R.id.tv_NgayChi);
            viewHodler.tvDienGiaiChi=(TextView)convertView.findViewById(R.id.tv_DienGiaiChi);

            convertView.setTag(viewHodler);
        }else{
            viewHodler=(ViewHodler) convertView.getTag();
        }
        ChiTietChi chiTietChi=listchitietchi.get(position);

        viewHodler.tvMaGiaoDichChi.setText(String.valueOf(chiTietChi.getMaGiaoDichChi()));
//        viewHodler.tvTenGiaoDichChi.setText(chiTietChi.getTenGiaoDichChi());
        viewHodler.tvTenLoaiChi.setText(chiTietChi.getTenLoaiChi());
        viewHodler.tvTenViChi.setText(chiTietChi.getTenViChi());
        viewHodler.tvSoTienChi.setText(chuyenchuoi(chiTietChi.getSoTienChi()));
        viewHodler.tvNgayChi.setText(chiTietChi.getNgayChi());
        viewHodler.tvDienGiaiChi.setText(chiTietChi.getDienGiaiChi());
        return convertView;
    }
    public class ViewHodler {
        private TextView tvMaGiaoDichChi;
//        private TextView tvTenGiaoDichChi;
        private TextView tvTenLoaiChi;
        private TextView tvTenViChi;
        private TextView tvSoTienChi;
        private TextView tvNgayChi;
        private TextView tvDienGiaiChi;
    }
    public String chuyenchuoi(double money)
    {
        String pattern="###,###";
        DecimalFormat decimalFormat=new DecimalFormat(pattern);
        String output=decimalFormat.format(money);
        return output;
    }
}
