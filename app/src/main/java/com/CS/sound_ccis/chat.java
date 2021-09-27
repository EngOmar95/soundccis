package com.CS.sound_ccis;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.CS.sound_ccis.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class chat extends AppCompatActivity {
    Adpater_chat adpater_chat;
    KMP kmp=new KMP();
    TextView back;
     ListView list_Messages;
     EditText textSend;
    ImageButton send ;
    ImageButton Voice ;
    Intent intent;
     ArrayList<chat_info> Array ;
     Calendar calendar;
    SimpleDateFormat simpleDateFormat;
    String dateTime;
    String Name;
    FirebaseDatabase  database = FirebaseDatabase.getInstance();
    final DatabaseReference databaseReference = database.getReference("Questions");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);



        back=findViewById(R.id. back);
       list_Messages =findViewById(R.id.list)     ;
         textSend=findViewById(R.id.t)     ;
        send =findViewById(R.id.sen)     ;
         Voice =findViewById(R.id.Voice)     ;
         Array =new ArrayList<>();
         intent=getIntent();


         Name= intent.getStringExtra("Name")  ;

      adpater_chat =new Adpater_chat(Array,this)   ;

        calendar=Calendar.getInstance();
        simpleDateFormat=  new SimpleDateFormat("hh:mm")   ;
        dateTime=  simpleDateFormat.format(calendar.getTime());

        Array.add(new chat_info("مرحبا "+Name+" كيف يمكنني مساعدتك؟",dateTime,"2"));
        list_Messages.setAdapter(adpater_chat);



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

       send.setOnClickListener(new View.OnClickListener() {

      

           @Override
              public void onClick(View view) {

        send_text(textSend.getText().toString());



              }
          });


       Voice.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent voic =new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)        ;
               voic.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)     ;
               voic.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault()) ;
               voic.putExtra(RecognizerIntent.EXTRA_PROMPT,R.string.title_voice);
               startActivityForResult(voic,1);
           }
       });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {

            final ArrayList<String> Data = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);


            send_text (Data.get(0));

        }



    }

public  void send_text (final String text){

    databaseReference.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

            calendar=Calendar.getInstance();
            simpleDateFormat=  new SimpleDateFormat("hh:mm")   ;
            dateTime=  simpleDateFormat.format(calendar.getTime());




            int  Cheack_Keyword=0;


            Array.add(new chat_info(text,dateTime,"1"))      ;
            for(DataSnapshot s: dataSnapshot.getChildren()) {
                Mang_Info mang_info = s.getValue(Mang_Info.class);



                  if(!mang_info.Keyword.equals("")){
                      Cheack_Keyword=kmp.KMP(text, mang_info.Keyword)  ;
                switch (Cheack_Keyword)  {

                    case 1 :
                        Cheack_Keyword=1;
                        Array.add(new chat_info(mang_info.Answer, dateTime, "2"));
                        break;

                    default:
                     //   Cheack_Keyword=0;
                        ;
                       break;





                }}

                if(!mang_info.Keyword_2.equals("")&&Cheack_Keyword==0) {
                    Cheack_Keyword=  kmp.KMP(text, mang_info.Keyword_2)  ;

                    switch (Cheack_Keyword)  {

                        case 1 :
                            Cheack_Keyword=1;
                            Array.add(new chat_info(mang_info.Answer, dateTime, "2"));
                            break;

                        default:
                           // Cheack_Keyword=0;

                            break;





                    }

                }

                if(!mang_info.Keyword_3.equals("")&&Cheack_Keyword==0) {
                    Cheack_Keyword=  kmp.KMP(text, mang_info.Keyword_3)  ;

                    switch (Cheack_Keyword)  {

                        case 1 :
                            Cheack_Keyword=1;
                            Array.add(new chat_info(mang_info.Answer, dateTime, "2"));
                            break;

                        default:


                            break;





                    }

                }
                if(Cheack_Keyword==1){

                    break;
                }


            }



        
           if(Cheack_Keyword==0){

                Array.add(new chat_info(getBaseContext().getString(R.string.message_no_keyword),dateTime,"2"))    ;

            }

            textSend.setText(null);
            list_Messages.setAdapter(adpater_chat);

            adpater_chat.notifyDataSetChanged();
            list_Messages.setSelection(Array.size());


        }

        @Override
        public void onCancelled(DatabaseError error) {

        }
    });


}
}