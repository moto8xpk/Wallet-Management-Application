package vn.com.dtt.ungdung16doana.AfterLogOn.Account;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import vn.com.dtt.ungdung16doana.AfterLogOn.Ui1Activity;
import vn.com.dtt.ungdung16doana.R;
import vn.com.dtt.ungdung16doana.adapter.CustomAdapterStatisticIncome;
import vn.com.dtt.ungdung16doana.data.DBmanager;
import vn.com.dtt.ungdung16doana.model.StatisticIncome;

public class IncomeBarGraphActivity extends AppCompatActivity {

    BarChart barChart;
    private DBmanager dBmanager;
    TextView statistic;
    private List<StatisticIncome> statistics;
    private ListView lvstatistic;
    private CustomAdapterStatisticIncome customAdapterStatisticIncome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_bar_graph);
        dBmanager=new DBmanager(this);

        barChart=(BarChart) findViewById(R.id.BarGraph);
        statistic=(TextView) findViewById(R.id.tv_statistic);
        lvstatistic = (ListView) findViewById(R.id.lv_statistic);

        statistic.setText(chuyenchuoi(dBmanager.thongkethuy1()));

        statistics=dBmanager.GetAllDMThongKeThu();

        setAdapter();

        ArrayList<BarEntry> barEntries=new ArrayList<>();

        barEntries.add(new BarEntry(1f, (float) dBmanager.thongkethu1()));
        barEntries.add(new BarEntry(2f, (float) dBmanager.thongkethu2()));
        barEntries.add(new BarEntry(3f,(float) dBmanager.thongkethu3()));
        barEntries.add(new BarEntry(4f,(float) dBmanager.thongkethu4()));
        barEntries.add(new BarEntry(5f,(float) dBmanager.thongkethu5()));
        barEntries.add(new BarEntry(6f,(float) dBmanager.thongkethu6()));
        barEntries.add(new BarEntry(7f,(float) dBmanager.thongkethu7()));
        barEntries.add(new BarEntry(8f,(float) dBmanager.thongkethu8()));
        barEntries.add(new BarEntry(9f,(float) dBmanager.thongkethu9()));
        barEntries.add(new BarEntry(10f,(float) dBmanager.thongkethu10()));
        barEntries.add(new BarEntry(11f,(float) dBmanager.thongkethu11()));
        barEntries.add(new BarEntry(12f,(float) dBmanager.thongkethu12()));

        BarDataSet barDataSet1=new BarDataSet(barEntries,"Months");

//        final String[]  String[]{
//                "January","February","March","April","May","June","July","August","September","October","November","December"
//        } ;
        final ArrayList<String >theDates=new ArrayList<String>();

        theDates.add("Dec");

        theDates.add("Jan");

        theDates.add("Feb");

        theDates.add("Mar");

        theDates.add("Apr");

        theDates.add("May");

        theDates.add("Jun");

        theDates.add("Jul");

        theDates.add("Aug");

        theDates.add("Sep");

        theDates.add("Oct");

        theDates.add("Nov");


        XAxis xAxis=barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisMinimum(0.5f);
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {

                return theDates.get((int) value % theDates.size());
            }
        });


        BarData Data1 = new BarData(barDataSet1);

        barChart.setData(Data1);


        barChart.setTouchEnabled(true);
        barChart.setDragEnabled(true);
        barChart.setScaleEnabled(true);



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_popup,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.menuLogOut:
                Intent out= new Intent(IncomeBarGraphActivity.this,Ui1Activity.class);
                startActivity(out);
                finish();
                Toast.makeText(this, "Log Out", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuExit:
                Intent back= new Intent(IncomeBarGraphActivity.this, Ui1Activity.class);
                startActivity(back);
                finish();
                Toast.makeText(this, "Exit", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuSetting:
                Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuAccounts:
                Toast.makeText(this, "Account", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuChangePass:
                Toast.makeText(this, "Change Password", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public void setAdapter() {
        if (customAdapterStatisticIncome == null) {
            customAdapterStatisticIncome = new CustomAdapterStatisticIncome(this, R.layout.item_min_statistic_income, statistics);
            lvstatistic.setAdapter(customAdapterStatisticIncome);
        } else {
            customAdapterStatisticIncome.notifyDataSetChanged();
            lvstatistic.setSelection(customAdapterStatisticIncome.getCount() - 1);
        }
    }
    public void updateListstatistic(){
        statistics.clear();
        statistics.addAll(dBmanager.GetAllDMThongKeThu());
        if (customAdapterStatisticIncome!=null)
        {
            customAdapterStatisticIncome.notifyDataSetChanged();
        }
    }
    public String chuyenchuoi(double money)
    {
        String pattern="###,###";
        DecimalFormat decimalFormat=new DecimalFormat(pattern);
        String output=decimalFormat.format(money);
        return output;
    }
}
