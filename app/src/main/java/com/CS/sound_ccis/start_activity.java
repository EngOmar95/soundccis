package com.CS.sound_ccis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.CS.sound_ccis.R;

public class start_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_activity);


        Thread thread =new Thread() {
            ;

            @Override
            public void run() {
                try {
                    sleep(5000);

                    Intent start = new Intent(start_activity.this, MainPage.class);
                    startActivities(new Intent[]{start});

                    finish();
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }

            }
        };

        thread.start();
    }


    }
