package com.CS.sound_ccis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.CS.sound_ccis.R;

public class LogIn extends AppCompatActivity {

        Intent intent;
   TextView forgetPassword    ;
        EditText Email         ;
        EditText  Password      ;
        RadioGroup Choes ;
        SQL sql =new SQL();
        String choes="User";
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        Email=findViewById(R.id.Email)  ;
        Choes=findViewById(R.id.Choes)     ;
        Password=findViewById(R.id.Password)  ;
        Button entry =findViewById(R.id.entry)      ;
        forgetPassword=findViewById(R.id.forgetPassword) ;



        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent =new Intent(LogIn.this,Forget_password.class)      ;
                startActivity(intent);
            }
        });


        Choes.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (i){
                    case R.id.Admin :
                        choes= "Admin"    ;
                            break;
                    case R.id.User :

                        choes= "User"    ;
                           break;


                }
            }
        });


        entry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                SharedPreferences.Editor edit=sp.edit();
                edit.putString("Choes",choes);

                edit.apply();
                if(choes.equals("User")) {
                    sql.login(LogIn.this, Email.getText().toString(), Password.getText().toString(), 1);


            }

             else if(choes.equals("Admin"))
                     sql.login(LogIn.this,Email.getText().toString(),Password.getText().toString(),2);


        }
        });

    }

    @Override
    public void onBackPressed() {


        Intent intent = new Intent(LogIn.this, MainPage.class);
        startActivity(intent);


    }
}