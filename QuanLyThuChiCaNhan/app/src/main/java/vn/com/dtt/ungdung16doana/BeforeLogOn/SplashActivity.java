package vn.com.dtt.ungdung16doana.BeforeLogOn;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import vn.com.dtt.ungdung16doana.LogOnActivity;
import vn.com.dtt.ungdung16doana.R;

public class SplashActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT=4000;
    Handler handler;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent= new Intent(SplashActivity.this,LogOnActivity.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
