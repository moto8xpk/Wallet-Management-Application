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
import vn.com.dtt.ungdung16doana.model.StatisticIncome;


public class CustomAdapterStatisticIncome extends ArrayAdapter<StatisticIncome> {

    private Context context;
    private int resource;
    private List<StatisticIncome> listStatisticIncome ;


    public CustomAdapterStatisticIncome(@NonNull Context context, int resource, @NonNull List<StatisticIncome> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.listStatisticIncome=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHodler viewHodler;
        if(convertView==null)
        {
            convertView= LayoutInflater.from(context).inflate(R.layout.item_min_statistic_income,parent,false);
            viewHodler=new ViewHodler();
            viewHodler.tvTenLoaiThu=(TextView)convertView.findViewById(R.id.tv_Ten_DM_Thu);
            viewHodler.tvTongSoTienThu=(TextView)convertView.findViewById(R.id.tv_Tong_So_Tien);
            convertView.setTag(viewHodler);
        }else{
            viewHodler=(ViewHodler) convertView.getTag();
        }
        StatisticIncome statisticIncome=listStatisticIncome.get(position);

        viewHodler.tvTenLoaiThu.setText(statisticIncome.getTenLoaiThu());
        viewHodler.tvTongSoTienThu.setText(chuyenchuoi(statisticIncome.getSoTienThu()));
        return convertView;
    }
    public class ViewHodler {
        private TextView tvTenLoaiThu;
        private TextView tvTongSoTienThu;
    }
    public String chuyenchuoi(double money)
    {
        String pattern="###,###";
        DecimalFormat decimalFormat=new DecimalFormat(pattern);
        String output=decimalFormat.format(money);
        return output;
    }
}
