package com.CS.sound_ccis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.CS.sound_ccis.R;

import java.util.Random;

public class Forget_password extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        final EditText   Email_Valid;
        Button Vaildation;
        final SQL sql =new SQL();
        Email_Valid =findViewById(R.id.Email_Valid)  ;
        Vaildation=findViewById(R.id.Vaildation)   ;



        Vaildation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random random=new Random();
                int randomNumber=1000+random.nextInt(999);

                String PassWord="Ccis@"+String.valueOf(randomNumber);
                String message=PassWord+" : "+"مرحبا عزيزتي الرقم السري الجديد هو" ;


                sql.Forget_Password(Forget_password.this,Email_Valid.getText().toString(),PassWord,message);

            }
        });
    }
}