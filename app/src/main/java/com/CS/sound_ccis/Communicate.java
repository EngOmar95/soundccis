package com.CS.sound_ccis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.CS.sound_ccis.R;

public class Communicate extends AppCompatActivity {
    EditText Name;
    EditText subject;
    EditText Email;
    EditText Body;
    Button   send;
    TextView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.communicate);


         Name =findViewById(R.id.Name);
         subject=findViewById(R.id.subject);
         Email=findViewById(R.id.Email);
         Body=findViewById(R.id.Body);
         send=findViewById(R.id.send);
         back=findViewById(R.id.back);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

         send.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent send =new Intent(Intent.ACTION_SEND)  ;
                 send.setData(Uri.parse("mailto: "))       ;
                 send.setType("message/rfc822");    ;
                  ///Email to
                 send.putExtra(android.content.Intent.EXTRA_EMAIL,new String[] { Email.getText().toString() });
                  //subject
                 send.putExtra(Intent.EXTRA_SUBJECT,subject.getText().toString() +" .... "+Name.getText().toString())  ;

                 //body
                 send.putExtra(Intent.EXTRA_TEXT,Body.getText().toString())  ;

                 startActivity(send);
             }
         });
    }
}