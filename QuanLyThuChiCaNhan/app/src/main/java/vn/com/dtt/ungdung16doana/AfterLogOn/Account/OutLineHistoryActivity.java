package vn.com.dtt.ungdung16doana.AfterLogOn.Account;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import vn.com.dtt.ungdung16doana.R;

public class OutLineHistoryActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_line_history);
        btn1=(Button) findViewById(R.id.button1);
        btn2=(Button) findViewById(R.id.button2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a1=new Intent(OutLineHistoryActivity.this, IncomeHistoryActivity.class);
                startActivity(a1);
                finish();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a2=new Intent(OutLineHistoryActivity.this, OutcomeHistoryActivity.class);
                startActivity(a2);
                finish();
            }
        });
    }
}
