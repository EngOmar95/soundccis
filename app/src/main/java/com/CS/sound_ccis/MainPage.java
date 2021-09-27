package com.CS.sound_ccis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.CS.sound_ccis.R;

public class MainPage extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);


        Button new_registar=findViewById(R.id.new_registar)    ;
        Button logIn=findViewById(R.id.logIn)    ;




        new_registar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent=new Intent(getBaseContext(),new_regeister.class)        ;
                startActivity(intent);

            }
        });

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent=new Intent(getBaseContext(),LogIn.class)        ;
                startActivity(intent);

            }
        });
    }

    @Override
    public void onBackPressed() {




    }
}