package com.CS.sound_ccis;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.CS.sound_ccis.R;

import java.util.ArrayList;

public class Dailog_update_plan extends AppCompatDialogFragment {
      EditText Name_coop_Or_plan;
      EditText Link_Or_Email;
    String id;
    String page;

    public Dailog_update_plan(EditText Name_coop_Or_plan, EditText Link_Or_Email,String id, String page) {
        this.Name_coop_Or_plan = Name_coop_Or_plan;
        this.id = id;
        this.Link_Or_Email = Link_Or_Email;
        this.page = page;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder b = new AlertDialog.Builder(getActivity());
        LayoutInflater i = getActivity().getLayoutInflater();
        View v = i.inflate(R.layout.dailog_update, null, false);
        b.setView(v);
        final SQL sql  =new SQL();
        final ArrayList<DATA>arrayList=new ArrayList<>();
      final EditText plan_Name = v.findViewById(R.id.plan_Name);
        final EditText link = v.findViewById(R.id.link);

        plan_Name.setText(Name_coop_Or_plan.getText().toString());
        link.setText(Link_Or_Email.getText().toString());
        Button updte =v.findViewById(R.id.updte)  ;




        updte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(page.equals("study_plan")) {
                arrayList.add(new DATA("Name_plane",plan_Name.getText().toString()))  ;
                arrayList.add(new DATA("Link_plan",link.getText().toString())) ;
                arrayList.add(new DATA("Id_plan",id)) ;
                Name_coop_Or_plan.setText(plan_Name.getText().toString());
                Link_Or_Email.setText(link.getText().toString());
                    sql.Insert_Update(getContext(),"https://soundccis.000webhostapp.com/Update_planAndtrined.php",arrayList,"3");}
                else {

                    arrayList.add(new DATA("Name_Coordinators",plan_Name.getText().toString()))  ;
                    arrayList.add(new DATA("Email_Coordinators",link.getText().toString())) ;
                    arrayList.add(new DATA("id_Coordinators",id)) ;
                    Name_coop_Or_plan.setText(plan_Name.getText().toString());
                    Link_Or_Email.setText(link.getText().toString());
                    sql.Insert_Update(getContext(),"https://soundccis.000webhostapp.com/Update_planAndtrined.php",arrayList,"4");

                }



                dismiss();

            }
        });


        return b.create();


    }


}
