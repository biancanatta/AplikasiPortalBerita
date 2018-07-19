package com.bianca.aplikasiportalberita.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bianca.aplikasiportalberita.MainActivity;
import com.bianca.aplikasiportalberita.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler objectHandler = new Handler();
        objectHandler.postDelayed(new Runnable() {
            @Override
            public void run() {

                //intent ke halaman berita
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
                finish();

            }
        }, 2000); //in ms
    }
}
