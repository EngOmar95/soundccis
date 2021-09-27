package com.CS.sound_ccis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.CS.sound_ccis.R;

import java.util.ArrayList;

public class profile extends AppCompatActivity {
    EditText FristName   ;
    EditText  LastName     ;
    EditText  Email         ;
    EditText  Password      ;
    TextView back;
    EditText  password_confirmation;
    Button Save         ;
    SharedPreferences sp ;
    final AwesomeValidation awesomeValidation=new AwesomeValidation(ValidationStyle.BASIC);
    SQL sql=new SQL();
    ArrayList <DATA>arrayList;
    ArrayList <DATA>Search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView Full_Name=findViewById(R.id.FullName)      ;
        TextView E_mail=findViewById(R.id.E_mail)      ;

        FristName =findViewById(R.id.FristName)  ;
        LastName=findViewById(R.id.LastName)  ;
        Email=findViewById(R.id.Email)  ;
        Password=findViewById(R.id.Password)  ;
        password_confirmation=findViewById(R.id.password_confirmation)  ;
        Save=findViewById(R.id.save)  ;
        arrayList =new ArrayList<>();
        Search =new ArrayList<>();
        back =findViewById(R.id.back);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        awesomeValidation.addValidation(this, R.id.FristName, RegexTemplate.NOT_EMPTY,R.string.Invalid_FristAndlast_Name);
        awesomeValidation.addValidation(this, R.id.LastName, RegexTemplate.NOT_EMPTY,R.string.Invalid_FristAndlast_Name);

        awesomeValidation.addValidation(this, R.id.Password, "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$",R.string.password_Strong);

        awesomeValidation.addValidation(this, R.id.password_confirmation, R.id.Password,R.string.Invalid_ConfPassword);
        awesomeValidation.addValidation(this, R.id.Email, Patterns.EMAIL_ADDRESS ,R.string.Invalid_Emil);



        sp = PreferenceManager.getDefaultSharedPreferences(profile.this);
        String FullName =   sp.getString("first_name","0") +" "+  sp.getString("last_name","0");
        String EMAIL =   sp.getString("Email","0")  ;
  ;
        final String choes =   sp.getString("Choes","0")  ;
        final String checkIn =   sp.getString("checkIn","0")  ;

        Full_Name.setText(FullName);
        E_mail.setText(EMAIL);




        arrayList.add(new DATA("Email",Email));
        arrayList.add(new DATA("Password",Password));
        arrayList.add(new DATA("Password",password_confirmation));


        if(choes.equals("User")) {
            Search.add(new DATA("user_id",checkIn));
            arrayList.add(new DATA("first_name",FristName));
            arrayList.add(new DATA("last_name",LastName));
            sql.Show_database(profile.this, "https://soundccis.000webhostapp.com/ShowData.php", arrayList, Search, "1");

        } else {
            Search.add(new DATA("admin_id",checkIn));

            FristName.setText("Admin");
            LastName.setText("A");

            LastName.setEnabled(false);
            FristName.setEnabled(false);
            
            sql.Show_database(profile.this, "https://soundccis.000webhostapp.com/ShowData.php", arrayList, Search, "2")  ;

        }
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor edit=sp.edit();
                         arrayList.clear();

                if(choes.equals("User")) {
                arrayList.add(new DATA("first_name",FristName.getText().toString()));
                arrayList.add(new DATA("last_name",LastName.getText().toString()));
                arrayList.add(new DATA("Email",Email.getText().toString()));
                arrayList.add(new DATA("Password",Password.getText().toString()));
                arrayList.add(new DATA("user_id",checkIn));

                    if(awesomeValidation.validate()){
                sql.Insert_Update(profile.this,"https://soundccis.000webhostapp.com/Insert_user.php",arrayList,"2");


                    edit.putString("first_name",FristName.getText().toString());
                    edit.putString("last_name",LastName.getText().toString());
                    edit.putString("Email",Email.getText().toString());}
            }
               else  {

                 
                    arrayList.add(new DATA("Email",Email.getText().toString()));
                    arrayList.add(new DATA("Password",Password.getText().toString()));
                    arrayList.add(new DATA("admin_id",checkIn));
                    if(awesomeValidation.validate()) {
                        sql.Insert_Update(profile.this, "https://soundccis.000webhostapp.com/update_Admin.php", arrayList, "2");

                        edit.putString("Email", Email.getText().toString());
                    }  }

                  edit.apply();

            }
        });


    }
}