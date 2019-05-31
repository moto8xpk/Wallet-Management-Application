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
import vn.com.dtt.ungdung16doana.model.Vi;


public class CustomAdapterVi extends ArrayAdapter<Vi> {
    private Context context;
    private int resource;
    private List<Vi> listvi;

    public CustomAdapterVi(@NonNull Context context, @LayoutRes int resource, @NonNull List<Vi> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.listvi= objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHodler viewHodler;
        if(convertView==null)
        {
            convertView= LayoutInflater.from(context).inflate(R.layout.item_vi,parent,false);
            viewHodler=new ViewHodler();
            viewHodler.tvmavi=(TextView)convertView.findViewById(R.id.tv_MaVi);
            viewHodler.tvtenvi=(TextView)convertView.findViewById(R.id.tv_TenVi);
            viewHodler.tvloaivi=(TextView)convertView.findViewById(R.id.tv_LoaiVi);
            viewHodler.tvsodu=(TextView)convertView.findViewById(R.id.tv_SoDu);
            viewHodler.tvloaitiente=(TextView)convertView.findViewById(R.id.tv_LoaiTienTe);

            convertView.setTag(viewHodler);
        }else{
            viewHodler=(ViewHodler) convertView.getTag();
        }
        Vi vi=listvi.get(position);

        viewHodler.tvmavi.setText(String.valueOf(vi.getMaVi()));
        viewHodler.tvtenvi.setText(vi.getTenVi());
        viewHodler.tvloaivi.setText(vi.getLoaiVi());
        viewHodler.tvsodu.setText(chuyenchuoi(vi.getSoDu()));
        viewHodler.tvloaitiente.setText(vi.getLoaiTienTe());

        return convertView;
    }

    public class ViewHodler {
        private TextView tvmavi;
        private TextView tvtenvi;
        private TextView tvloaivi;
        private TextView tvsodu;
        private TextView tvloaitiente;

    }
    public String chuyenchuoi(double money)
    {
        String pattern="###,###";
        DecimalFormat decimalFormat=new DecimalFormat(pattern);
        String output=decimalFormat.format(money);
        return output;
    }
}
