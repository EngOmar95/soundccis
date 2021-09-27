package com.CS.sound_ccis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.CS.sound_ccis.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FeedBack extends AppCompatActivity {

    EditText textFeedback ;
    Button send;
    Intent intent;
    String message;
    SharedPreferences sp ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);

         textFeedback =findViewById(R.id.textFeedback) ;
         send =findViewById(R.id.send) ;

         intent=getIntent();
         message=intent.getStringExtra("message") ;


        textFeedback.setText("["+message+"]");

        sp = PreferenceManager.getDefaultSharedPreferences(FeedBack.this);
        final String FullName =   sp.getString("first_name","0") +" "+  sp.getString("last_name","0");
       // String EMAIL =   sp.getString("Email","0")  ;


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();//obiect
                DatabaseReference databaseReference = database.getReference("Feedback");
                String Key = databaseReference.push().getKey();


                FeedBack_info feedBack_info = new FeedBack_info(FullName,textFeedback.getText().toString(),Key);

                databaseReference.child(Key).setValue(feedBack_info);

                Toast.makeText(FeedBack.this, "تم الأرسال", Toast.LENGTH_SHORT).show();


            }
        });





    }

}