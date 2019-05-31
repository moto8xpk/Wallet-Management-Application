package vn.com.dtt.ungdung16doana.AfterLogOn.Account;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import vn.com.dtt.ungdung16doana.R;

public class MakeStatisticActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_statistic);
        btn1=(Button) findViewById(R.id.button1);
        btn2=(Button) findViewById(R.id.button2);
        btn3=(Button) findViewById(R.id.button3);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a1=new Intent(MakeStatisticActivity.this,IncomeBarGraphActivity.class);
                startActivity(a1);
                finish();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a1=new Intent(MakeStatisticActivity.this,OutcomeBarGraphActivity.class);
                startActivity(a1);
                finish();
            }
        });
    }
}
