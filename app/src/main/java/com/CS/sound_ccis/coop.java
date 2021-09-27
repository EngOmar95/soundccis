package com.CS.sound_ccis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.CS.sound_ccis.R;

import java.util.ArrayList;

public class coop extends AppCompatActivity {
       TextView back;
    TextView edit ;
    TextView done ;
    EditText  coordinater_CS;
    EditText  coordinater_CS_Email;
    EditText  coordinater_CS_in;
    EditText  coordinater_CS_in_Email;
    EditText  coordinater_IT;
    EditText  coordinater_IT_Email;
    EditText  coordinater_IS;
    EditText  coordinater_IS_Email;
    EditText  coordinater_IS_2;
    EditText  coordinater_IS_2_Email;

    Dailog_update_plan dailog_update_plan;


    EditText  id_coor_CS;
    EditText  id_coor_CS2;
    EditText  id_coor_IT;
    EditText  id_coor_IS;
    EditText  id_coor_IS2;

    SQL sql =new SQL();

    ArrayList<DATA>arrayList;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coop);
        edit =findViewById(R.id.edit)   ;
        done =findViewById(R.id.done)   ;




        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String choes =   sharedPreferences.getString("Choes","0")  ;
        if(choes.equals("User")){

            edit.setVisibility(View.GONE);
            done.setVisibility(View.GONE);
        }
        back=findViewById(R.id.back);
          id_coor_CS=findViewById(R.id.id_coor_CS);
          id_coor_CS2=findViewById(R.id.id_coor_CS2);
          id_coor_IT=findViewById(R.id.id_coor_IT);
          id_coor_IS=findViewById(R.id.id_coor_IS);
          id_coor_IS2=findViewById(R.id.id_coor_IS2);


          coordinater_CS=findViewById(R.id.coordinater_CS);
          coordinater_CS_Email=findViewById(R.id.coordinater_CS_Email);
          coordinater_CS_in=findViewById(R.id.coordinater_CS_in);
          coordinater_CS_in_Email=findViewById(R.id.coordinater_CS_in_Email);
          coordinater_IT=findViewById(R.id.coordinater_IT);
          coordinater_IT_Email=findViewById(R.id.coordinater_IT_Email);
          coordinater_IS=findViewById(R.id.coordinater_IS);
          coordinater_IS_Email=findViewById(R.id.coordinater_IS_Email);
          coordinater_IS_2=findViewById(R.id.coordinater_IS_2);
          coordinater_IS_2_Email=findViewById(R.id.coordinater_IS_2_Email);

          coordinater_CS.setEnabled(false);

          coordinater_CS_in.setEnabled(false);

          coordinater_IT.setEnabled(false);

          coordinater_IS.setEnabled(false);

          coordinater_IS_2.setEnabled(false);

          done.setVisibility(View.GONE);



        arrayList=new ArrayList<>();



        arrayList.add(new DATA("Name_Coordinators",coordinater_CS))  ;
        arrayList.add(new DATA("Email_Coordinators",coordinater_CS_Email));
        arrayList.add(new DATA("id_Coordinators",id_coor_CS))  ;

        arrayList.add(new DATA("Name_Coordinators",coordinater_CS_in))  ;
        arrayList.add(new DATA("Email_Coordinators",coordinater_CS_in_Email));
        arrayList.add(new DATA("id_Coordinators",id_coor_CS2))  ;

        arrayList.add(new DATA("Name_Coordinators",coordinater_IT))  ;
        arrayList.add(new DATA("Email_Coordinators",coordinater_IT_Email));
        arrayList.add(new DATA("id_Coordinators",id_coor_IT))  ;

        arrayList.add(new DATA("Name_Coordinators",coordinater_IS))  ;
        arrayList.add(new DATA("Email_Coordinators",coordinater_IS_Email));
        arrayList.add(new DATA("id_Coordinators",id_coor_IS))  ;


        arrayList.add(new DATA("Name_Coordinators",coordinater_IS_2))  ;
        arrayList.add(new DATA("Email_Coordinators",coordinater_IS_2_Email));
        arrayList.add(new DATA("id_Coordinators",id_coor_IS2))  ;


        sql.Show_database(coop.this,"https://soundccis.000webhostapp.com/ShowData.php",arrayList,null,"4");

       edit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               coordinater_CS.setEnabled(true);

               coordinater_CS_in.setEnabled(true);

               coordinater_IT.setEnabled(true);

               coordinater_IS.setEnabled(true);

               coordinater_IS_2.setEnabled(true);

               edit.setVisibility(View.GONE);
               done.setVisibility(View.VISIBLE);


               coordinater_CS.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {

                       dailog_update_plan = new Dailog_update_plan(coordinater_CS, coordinater_CS_Email, id_coor_CS.getText().toString(), "coop");

                       dailog_update_plan.show(getSupportFragmentManager(), "");


                   }
               });

               coordinater_CS_in.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       dailog_update_plan = new Dailog_update_plan(coordinater_CS_in, coordinater_CS_in_Email, id_coor_CS2.getText().toString(), "coop");

                       dailog_update_plan.show(getSupportFragmentManager(), "");
                   }
               });

               coordinater_IT.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {

                       dailog_update_plan = new Dailog_update_plan(coordinater_IT, coordinater_IT_Email, id_coor_IT.getText().toString(), "coop");

                       dailog_update_plan.show(getSupportFragmentManager(), "");
                   }


               });

               coordinater_IS.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       dailog_update_plan = new Dailog_update_plan(coordinater_IS, coordinater_IS_Email, id_coor_IS.getText().toString(), "coop");

                       dailog_update_plan.show(getSupportFragmentManager(), "");

                   }
               });

               coordinater_IS_2.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       dailog_update_plan = new Dailog_update_plan(coordinater_IS_2, coordinater_IS_2_Email, id_coor_IS2.getText().toString(), "coop");

                       dailog_update_plan.show(getSupportFragmentManager(), "");
                   }
               });
           }
       });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                coordinater_CS.setEnabled(false);
                coordinater_CS_Email.setEnabled(false);
                coordinater_CS_in.setEnabled(false);
                coordinater_CS_in_Email.setEnabled(false);
                coordinater_IT.setEnabled(false);
                coordinater_IT_Email.setEnabled(false);
                coordinater_IS.setEnabled(false);
                coordinater_IS_Email.setEnabled(false);
                coordinater_IS_2.setEnabled(false);
                coordinater_IS_2_Email.setEnabled(false);
                done.setVisibility(View.GONE);
                edit.setVisibility(View.VISIBLE);
             
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });





    }
}