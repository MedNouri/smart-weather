package com.example.android.smartWeather.app;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.net.URL;

public class SplashActivity extends AppCompatActivity{
    public   boolean firstStart;
    public static final int REQUEST_CODE_INTRO = 1;
    private ProgressBar progressBar;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.INVISIBLE);
        setContentView(R.layout.activity_splash);
        progressBar =(ProgressBar) findViewById(R.id.progressbarloading);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        try {
            firstStart= preferences.getBoolean("PREF_KEY_FIRST_START",true);
        } catch (Exception e) {
            e.printStackTrace();
        }


        new LongOperation().execute("");
    }


    private class LongOperation extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    Thread.interrupted();
                }
            }
            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {
            progressBar.setVisibility(View.INVISIBLE);
            TextView txt = (TextView) findViewById(R.id.messageProgress);
            txt.setText("DONE");
            // check if this is the First time the User use the App
            if ((firstStart==true)){
            Intent intent = new Intent(SplashActivity.this, MainIntroActivity.class);
            startActivity(intent);
                Log.e("SplachScreen","First Time ");

            }
            else {
                // No need For Intro
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                Log.e("SplachScreen","Not the First Time ");

            }
            // Kill The Activity
            finish();

        }

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
        }


    }



}

