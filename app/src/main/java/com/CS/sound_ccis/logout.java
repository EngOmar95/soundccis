package com.CS.sound_ccis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.CS.sound_ccis.R;

public class logout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);



        Thread thread =new Thread() {
            ;

            @Override
            public void run() {
                try {
                    sleep(2000);

                    Intent start = new Intent(logout.this, LogIn.class);
                    startActivities(new Intent[]{start});

                     finish();
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }

            }
        };

        thread.start();
    }


    @Override
    public void onBackPressed() {




    } }
