package vn.com.dtt.ungdung16doana.adapter;

import android.content.Context;
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
import vn.com.dtt.ungdung16doana.model.StatisticOutcome;



public class CustomAdapterStatisticOutcome extends ArrayAdapter<StatisticOutcome> {
    private Context context;
    private int resource;
    private List<StatisticOutcome> listStatisticOutcome ;


    public CustomAdapterStatisticOutcome(@NonNull Context context, int resource, @NonNull List<StatisticOutcome> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.listStatisticOutcome=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        CustomAdapterStatisticOutcome.ViewHodler viewHodler;
        if(convertView==null)
        {
            convertView= LayoutInflater.from(context).inflate(R.layout.item_min_statistic_income,parent,false);
            viewHodler=new CustomAdapterStatisticOutcome.ViewHodler();
            viewHodler.tvTenLoaiChi=(TextView)convertView.findViewById(R.id.tv_Ten_DM_Thu);
            viewHodler.tvTongSoTienChi=(TextView)convertView.findViewById(R.id.tv_Tong_So_Tien);
            convertView.setTag(viewHodler);
        }else{
            viewHodler=(CustomAdapterStatisticOutcome.ViewHodler) convertView.getTag();
        }
        StatisticOutcome statisticOutcome=listStatisticOutcome.get(position);

        viewHodler.tvTenLoaiChi.setText(statisticOutcome.getTenLoaiChi());
        viewHodler.tvTongSoTienChi.setText(chuyenchuoi(statisticOutcome.getSoTienChi()));
        return convertView;
    }

    public class ViewHodler {
        private TextView tvTenLoaiChi;
        private TextView tvTongSoTienChi;
    }
    public String chuyenchuoi(double money)
    {
        String pattern="###,###";
        DecimalFormat decimalFormat=new DecimalFormat(pattern);
        String output=decimalFormat.format(money);
        return output;
    }
}
