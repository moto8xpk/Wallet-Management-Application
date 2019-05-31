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

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import vn.com.dtt.ungdung16doana.AfterLogOn.Ui1Activity;
import vn.com.dtt.ungdung16doana.R;
import vn.com.dtt.ungdung16doana.adapter.CustomAdapterStatisticIncome;
import vn.com.dtt.ungdung16doana.adapter.CustomAdapterStatisticOutcome;
import vn.com.dtt.ungdung16doana.data.DBmanager;
import vn.com.dtt.ungdung16doana.model.StatisticOutcome;

public class OutcomeBarGraphActivity extends AppCompatActivity {

    BarChart barChart;
    private DBmanager dBmanager;
    TextView statistic;

    private List<StatisticOutcome> statistics;
    private ListView lvstatistic;
    private CustomAdapterStatisticOutcome customAdapterStatisticOutcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outcome_bar_graph);

        dBmanager=new DBmanager(this);
        barChart=(BarChart) findViewById(R.id.BarGraphOut);
        statistic=(TextView) findViewById(R.id.tv_statistic2);
        lvstatistic = (ListView) findViewById(R.id.lv_statistic1);

        statistic.setText(chuyenchuoi(dBmanager.thongkechiy()));

        statistics=dBmanager.GetAllDMThongKeChi();

        setAdapter();

        ArrayList<BarEntry> barEntries=new ArrayList<>();

        barEntries.add(new BarEntry(1f, (float) dBmanager.thongkechi1()));
        barEntries.add(new BarEntry(2f, (float) dBmanager.thongkechi2()));
        barEntries.add(new BarEntry(3f,(float) dBmanager.thongkechi3()));
        barEntries.add(new BarEntry(4f,(float) dBmanager.thongkechi4()));
        barEntries.add(new BarEntry(5f,(float) dBmanager.thongkechi5()));
        barEntries.add(new BarEntry(6f,(float) dBmanager.thongkechi6()));
        barEntries.add(new BarEntry(7f,(float) dBmanager.thongkechi7()));
        barEntries.add(new BarEntry(8f,(float) dBmanager.thongkechi8()));
        barEntries.add(new BarEntry(9f,(float) dBmanager.thongkechi9()));
        barEntries.add(new BarEntry(10f,(float) dBmanager.thongkechi10()));
        barEntries.add(new BarEntry(11f,(float) dBmanager.thongkechi11()));
        barEntries.add(new BarEntry(12f,(float) dBmanager.thongkechi12()));

        BarDataSet barDataSet1=new BarDataSet(barEntries,"Dates");

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
                Intent out= new Intent(OutcomeBarGraphActivity.this,Ui1Activity.class);
                startActivity(out);
                finish();
                Toast.makeText(this, "Log Out", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuExit:
                Intent back= new Intent(OutcomeBarGraphActivity.this, Ui1Activity.class);
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
        if (customAdapterStatisticOutcome == null) {
            customAdapterStatisticOutcome = new CustomAdapterStatisticOutcome(this, R.layout.item_min_statistic_income, statistics);
            lvstatistic.setAdapter(customAdapterStatisticOutcome);
        } else {
            customAdapterStatisticOutcome.notifyDataSetChanged();
            lvstatistic.setSelection(customAdapterStatisticOutcome.getCount() - 1);
        }
    }
    public void updateListstatistic(){
        statistics.clear();
        statistics.addAll(dBmanager.GetAllDMThongKeChi());
        if (customAdapterStatisticOutcome!=null)
        {
            customAdapterStatisticOutcome.notifyDataSetChanged();
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
