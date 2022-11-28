package com.example.swapno_samity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        progressBar = findViewById(R.id.progressBarID);

        getSupportActionBar().hide();

        new Thread(new Runnable() {
            public void run() {
                setProgressBar();
                startApp();
                finish();
            }
        }).start();
    }

    private void setProgressBar() {
        for (int progress = 0; progress < 100; progress += 1) {
            try {
                Thread.sleep(50);
                progressBar.setProgress(progress);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    private void startApp() {
        Intent intent = new Intent(SplashScreen.this, LoginPage.class);
        startActivity(intent);
    }
}