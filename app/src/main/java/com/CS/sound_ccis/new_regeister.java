package com.CS.sound_ccis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.CS.sound_ccis.R;

import java.util.ArrayList;

public class new_regeister extends AppCompatActivity {
    EditText  FristName   ;
    EditText  LastName     ;
    EditText  Email         ;
    EditText  Password      ;
    EditText  password_confirmation;
    final AwesomeValidation awesomeValidation=new AwesomeValidation(ValidationStyle.BASIC);
    Button Sign_up                  ;
    ArrayList<DATA> arrayList;
          SQL sql=new SQL();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_regeister);

         FristName =findViewById(R.id.FristName)  ;
         LastName=findViewById(R.id.LastName)  ;
         Email=findViewById(R.id.Email)  ;
         Password=findViewById(R.id.Password)  ;
         password_confirmation=findViewById(R.id.password_confirmation)  ;
         Sign_up=findViewById(R.id.Sign_up)  ;
         arrayList =new ArrayList<>();






        awesomeValidation.addValidation(this, R.id.FristName, RegexTemplate.NOT_EMPTY,R.string.Invalid_FristAndlast_Name);
        awesomeValidation.addValidation(this, R.id.LastName, RegexTemplate.NOT_EMPTY,R.string.Invalid_FristAndlast_Name);

        awesomeValidation.addValidation(this, R.id.Password, "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$",R.string.password_Strong);

        awesomeValidation.addValidation(this, R.id.password_confirmation, R.id.Password,R.string.Invalid_ConfPassword);
        awesomeValidation.addValidation(this, R.id.Email, Patterns.EMAIL_ADDRESS ,R.string.Invalid_Emil);
       

        Sign_up.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {

                   arrayList.add(new DATA("first_name",FristName.getText().toString()));
                   arrayList.add(new DATA("last_name",LastName.getText().toString()));
                   arrayList.add(new DATA("Email",Email.getText().toString()));
                   arrayList.add(new DATA("Password",Password.getText().toString()));
                   if(awesomeValidation.validate()){

                       sql.Insert_Update(new_regeister.this,"https://soundccis.000webhostapp.com/Insert_user.php",arrayList,"1");
               }    }
           });




    }
}