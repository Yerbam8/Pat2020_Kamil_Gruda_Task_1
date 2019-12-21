package kamilgruda.simpleencoder;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;


public class SplashActivity extends AppCompatActivity {
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        runnable = new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        };

        handler = new Handler();

        int splashScreenTime = 5000;
        handler.postDelayed(runnable, splashScreenTime);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler != null && runnable != null)
            handler.removeCallbacks(runnable);
    }

}
