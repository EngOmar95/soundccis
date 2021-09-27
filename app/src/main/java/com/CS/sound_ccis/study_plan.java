package com.CS.sound_ccis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.CS.sound_ccis.R;

import java.util.ArrayList;

public class study_plan extends AppCompatActivity {
    TextView edit_1;
    TextView done_1;
   TextView back;
    SQL sql =new SQL();
    EditText plan_CS_new;
    EditText  plan_CS_link;
    EditText  plan_CS_old;
    EditText  plan_CS_old_link;
    EditText  plan_IT_new;
    EditText  plan_IT_new_link;
    EditText  plan_IT_old;
    EditText  plan_IT_old_link;
    EditText  plan_IS_new;
    EditText  plan_IS_new_link;
    EditText  plan_IS_old;
    EditText  plan_IS_old_link;
    TextView plan_CS_link_t;
    TextView plan_CS_old_link_t;
    TextView plan_IT_new_link_t;
    TextView plan_IT_old_link_t;
    TextView plan_IS_new_link_t ,  plan_IS_old_link_t;


    EditText CS1;
    EditText CS2;
    EditText IT1;
    EditText IT2;
    EditText IS1;

    EditText IS2;
    int ch=1;
    SharedPreferences sp ;
    ArrayList<DATA>arrayList;
    Dailog_update_plan dailog_update_plan;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_study_plan);
        edit_1 =findViewById(R.id.edit_1)   ;
        done_1 =findViewById(R.id.done_1)   ;
        back =findViewById(R.id.back);

        sp = PreferenceManager.getDefaultSharedPreferences(this);
        String choes =   sp.getString("Choes","0")  ;
        if(choes.equals("User")){

            edit_1.setVisibility(View.GONE);
            done_1.setVisibility(View.GONE);
        }





        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        CS1=findViewById(R.id.CS1);
         CS2=findViewById(R.id.CS2);
         IT1=findViewById(R.id.IT1);
         IT2=findViewById(R.id.IT2);
         IS1=findViewById(R.id.IS1);
         IS2=findViewById(R.id.IS2);

         plan_CS_link_t=findViewById(R.id.plan_CS_link_t);
         plan_CS_old_link_t=findViewById(R.id.plan_CS_old_link_t);
         plan_IT_new_link_t=findViewById(R.id.plan_IT_new_link_t);
         plan_IT_old_link_t=findViewById(R.id.plan_IT_old_link_t);
         plan_IS_new_link_t=findViewById(R.id.plan_IS_new_link_t);
         plan_IS_old_link_t=findViewById(R.id.plan_IS_old_link_t);

        plan_CS_new=findViewById(R.id.plan_CS_new);
        plan_CS_link=findViewById(R.id.plan_CS_link);
        plan_CS_old=findViewById(R.id.plan_CS_old);
        plan_CS_old_link=findViewById(R.id.plan_CS_old_link);
        plan_IT_new=findViewById(R.id.plan_IT_new);
        plan_IT_new_link=findViewById(R.id.plan_IT_new_link);
        plan_IT_old=findViewById(R.id.plan_IT_old);
        plan_IT_old_link=findViewById(R.id.plan_IT_old_link);
        plan_IS_new=findViewById(R.id.plan_IS_new);
        plan_IS_new_link=findViewById(R.id.plan_IS_new_link);
        plan_IS_old=findViewById(R.id.plan_IS_old);
        plan_IS_old_link=findViewById(R.id.plan_IS_old_link);


        done_1.setVisibility(View.GONE);

        arrayList=new ArrayList<>();

        arrayList.add(new DATA("Name_plane",plan_CS_new))  ;
        arrayList.add(new DATA("Link_plan",plan_CS_link));
        arrayList.add(new DATA("Id_plan",CS1))  ;



        arrayList.add(new DATA("Name_plane",plan_CS_old))  ;
        arrayList.add(new DATA("Link_plan",plan_CS_old_link));
        arrayList.add(new DATA("Id_plan",CS2))  ;
        

        arrayList.add(new DATA("Name_plane",plan_IT_new))  ;
       arrayList.add(new DATA("Link_plan",plan_IT_new_link));
        arrayList.add(new DATA("Id_plan",IT1))  ;

        arrayList.add(new DATA("Name_plane",plan_IT_old))  ;
        arrayList.add(new DATA("Link_plan",plan_IT_old_link));
        arrayList.add(new DATA("Id_plan",IT2))  ;

        arrayList.add(new DATA("Name_plane",plan_IS_new))  ;
        arrayList.add(new DATA("Link_plan",plan_IS_new_link));
        arrayList.add(new DATA("Id_plan",IS1))  ;

        arrayList.add(new DATA("Name_plane",plan_IS_old))  ;
        arrayList.add(new DATA("Link_plan",plan_IS_old_link));
        arrayList.add(new DATA("Id_plan",IS2))  ;





         sql.Show_database(study_plan.this,"https://soundccis.000webhostapp.com/ShowData.php",arrayList,null,"3");


        plan_CS_new.setVisibility(View.VISIBLE);



        plan_CS_link_t.setText(plan_CS_new.getText().toString());

        plan_CS_old_link_t.setText(plan_CS_old.getText().toString());

        plan_IT_new_link_t.setText(plan_IT_new.getText().toString());

        plan_IT_old_link_t.setText(plan_IT_old.getText().toString());

        plan_IS_new_link_t.setText(plan_IS_new.getText().toString());

        plan_IS_old_link_t.setText(plan_IS_old.getText().toString());





        plan_CS_link.setVisibility(View.GONE);
        plan_CS_old_link.setVisibility(View.GONE);
        plan_IT_new_link .setVisibility(View.GONE);
        plan_IT_old_link   .setVisibility(View.GONE);
        plan_IS_new_link  .setVisibility(View.GONE);
        plan_IS_old_link .setVisibility(View.GONE);

        edit_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                                  ch=2;




                plan_CS_link_t.setVisibility(View.GONE);

                plan_CS_old_link_t.setVisibility(View.GONE);

                plan_IT_new_link_t.setVisibility(View.GONE);

                plan_IT_old_link_t.setVisibility(View.GONE);

                plan_IS_new_link_t.setVisibility(View.GONE);

                plan_IS_old_link_t.setVisibility(View.GONE);






                plan_CS_new.setVisibility(View.VISIBLE);





                plan_CS_old.setVisibility(View.VISIBLE);

                plan_IT_new.setVisibility(View.VISIBLE);

                plan_IT_old.setVisibility(View.VISIBLE);

                plan_IS_new.setVisibility(View.VISIBLE);

                plan_IS_old.setVisibility(View.VISIBLE);

                plan_CS_link.setVisibility(View.VISIBLE);
                plan_CS_old_link.setVisibility(View.VISIBLE);
                plan_IT_new_link .setVisibility(View.VISIBLE);
                plan_IT_old_link   .setVisibility(View.VISIBLE);
                plan_IS_new_link  .setVisibility(View.VISIBLE);
                plan_IS_old_link .setVisibility(View.VISIBLE);

                edit_1.setVisibility(View.GONE);
                done_1.setVisibility(View.VISIBLE);
            }
        });

        plan_CS_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ch==2) {
                    dailog_update_plan= new Dailog_update_plan(plan_CS_new, plan_CS_link, CS1.getText().toString(), "study_plan");

                    dailog_update_plan.show(getSupportFragmentManager(), "");
                }   else {
                    Intent intent =new Intent(getBaseContext(),website.class)            ;
                    intent.putExtra("link",plan_CS_link.getText().toString())        ;
                    intent.putExtra("title",plan_CS_new.getText().toString())        ;
                    startActivity(intent);
                }

            }
        });

        plan_CS_old.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ch==2) {
                    dailog_update_plan = new Dailog_update_plan(plan_CS_old, plan_CS_old_link, CS2.getText().toString(), "study_plan");

                    dailog_update_plan.show(getSupportFragmentManager(), "");
                }
                   else {
                    Intent intent =new Intent(getBaseContext(),website.class)            ;
                    intent.putExtra("link",plan_CS_old_link.getText().toString())        ;
                    intent.putExtra("title",plan_CS_old.getText().toString())        ;
                    startActivity(intent);
                }
            }
        });

        plan_IS_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ch==2) {
                    dailog_update_plan = new Dailog_update_plan(plan_IS_new, plan_IS_new_link, IS1.getText().toString(), "study_plan");

                    dailog_update_plan.show(getSupportFragmentManager(), "");
                }else {

                    Intent intent =new Intent(getBaseContext(),website.class)            ;
                    intent.putExtra("link",plan_IS_new_link.getText().toString())        ;
                    intent.putExtra("title",plan_IS_new.getText().toString())        ;
                    startActivity(intent);
                }

            }
        });

        plan_IS_old.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 if(ch==2)  {


                     dailog_update_plan = new Dailog_update_plan(plan_IS_old, plan_IS_old_link, IS2.getText().toString(), "study_plan");

                     dailog_update_plan.show(getSupportFragmentManager(), "");
                }
                else {
                     Intent intent =new Intent(getBaseContext(),website.class)            ;
                     intent.putExtra("link",plan_IS_old_link.getText().toString())        ;
                     intent.putExtra("title",plan_IS_old.getText().toString())        ;
                     startActivity(intent);
                }

            }
        });

        plan_IT_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 if(ch==2) {
                     dailog_update_plan= new Dailog_update_plan(plan_IT_new, plan_IT_new_link, IT1.getText().toString(), "study_plan");

                     dailog_update_plan.show(getSupportFragmentManager(), "");
                }else {
                     Intent intent =new Intent(getBaseContext(),website.class)            ;
                     intent.putExtra("link",plan_IT_new_link.getText().toString())        ;
                     intent.putExtra("title",plan_IT_new.getText().toString())        ;
                     startActivity(intent);

                }
            }
        });

        plan_IT_old.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ch==2) {
                    dailog_update_plan = new Dailog_update_plan(plan_IT_old, plan_IT_old_link, IT2.getText().toString(), "study_plan");

                    dailog_update_plan.show(getSupportFragmentManager(), "");
                }else {
                    Intent intent =new Intent(study_plan.this,website.class)            ;
                    intent.putExtra("link",plan_IT_old_link.getText().toString())        ;
                    intent.putExtra("title",plan_IT_old.getText().toString())        ;
                    startActivity(intent);
                }

            }
        });



        done_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ch=1;

             plan_CS_link_t.setVisibility(View.VISIBLE);

                plan_CS_old_link_t.setVisibility(View.VISIBLE);

                plan_IT_new_link_t.setVisibility(View.VISIBLE);

                plan_IT_old_link_t.setVisibility(View.VISIBLE);

                plan_IS_new_link_t.setVisibility(View.VISIBLE);

                plan_IS_old_link_t.setVisibility(View.VISIBLE);



                plan_CS_link_t.setText(plan_CS_new.getText().toString());

                plan_CS_old_link_t.setText(plan_CS_old.getText().toString());

                plan_IT_new_link_t.setText(plan_IT_new.getText().toString());

                plan_IT_old_link_t.setText(plan_IT_old.getText().toString());

                plan_IS_new_link_t.setText(plan_IS_new.getText().toString());

                plan_IS_old_link_t.setText(plan_IS_old.getText().toString());


              plan_CS_new.setVisibility(View.GONE);

               plan_CS_old.setVisibility(View.GONE);

                plan_IT_new.setVisibility(View.GONE);

                plan_IT_old.setVisibility(View.GONE);

                plan_IS_new.setVisibility(View.GONE);

                plan_IS_old.setVisibility(View.GONE);

                plan_CS_link.setVisibility(View.GONE);
                plan_CS_old_link.setVisibility(View.GONE);
                plan_IT_new_link .setVisibility(View.GONE);
                plan_IT_old_link   .setVisibility(View.GONE);
                plan_IS_new_link  .setVisibility(View.GONE);
                plan_IS_old_link .setVisibility(View.GONE);

                plan_IS_old.setEnabled(false);
                done_1.setVisibility(View.GONE);
                edit_1.setVisibility(View.VISIBLE);

            }
        });


    //    plan_CS_link_t.setText(plan_CS_new.getText().toString());
        plan_CS_link_t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getBaseContext(),website.class)            ;
                intent.putExtra("link",plan_CS_link.getText().toString())        ;
                intent.putExtra("title",plan_CS_new.getText().toString())        ;
                startActivity(intent);
            }
        });


        plan_CS_old_link_t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getBaseContext(),website.class)            ;
                intent.putExtra("link",plan_CS_old_link.getText().toString())        ;
                intent.putExtra("title",plan_CS_old.getText().toString())        ;
                startActivity(intent);
            }
        });
        plan_IT_new_link_t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getBaseContext(),website.class)            ;
                intent.putExtra("link",plan_IT_new_link.getText().toString())        ;
                intent.putExtra("title",plan_IT_new.getText().toString())        ;
                startActivity(intent);
            }
        });
        plan_IT_old_link_t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getBaseContext(),website.class)            ;
                intent.putExtra("link",plan_IT_old_link.getText().toString())        ;
                intent.putExtra("title",plan_IT_old.getText().toString())        ;
                startActivity(intent);
            }
        });
        plan_IS_new_link_t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getBaseContext(),website.class)            ;
                intent.putExtra("link",plan_IS_new_link.getText().toString())        ;
                intent.putExtra("title",plan_IS_new.getText().toString())        ;
                startActivity(intent);
            }
        });
        plan_IS_old_link_t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getBaseContext(),website.class)            ;
                intent.putExtra("link",plan_IS_old_link.getText().toString())        ;
                intent.putExtra("title",plan_IS_old.getText().toString())        ;
                startActivity(intent);
            }
        });

         
    }


}