package com.CS.sound_ccis;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.CS.sound_ccis.R;


public class HomeFragment extends Fragment {
    String FullName ;
    String Email ;
    SharedPreferences sp ;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle=getArguments();
        if(bundle!=null) {
            FullName = bundle.getString("Name");
            Email=    bundle.getString("Email");
        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        final String FullName =   sp.getString("first_name","0") +" "+  sp.getString("last_name","0");

        final View root = inflater.inflate(R.layout.fragment_home, container, false);

        final TextView Full_Name=root.findViewById(R.id.FullName)      ;
        TextView E_mail=root.findViewById(R.id.E_mail)      ;
        ImageButton Conecationn =root.findViewById(R.id.but_con)    ;
        ImageButton Who_we =root.findViewById(R.id.whoWe)    ;
        ImageButton Profile_p =root.findViewById(R.id.Profile_p)    ;
        ImageButton study_plan =root.findViewById(R.id.study_plan)    ;
        ImageButton coop =root.findViewById(R.id.coop)    ;
        ImageButton talkTo_us =root.findViewById(R.id.talkTo_us)    ;


        Full_Name.setText(FullName);
        E_mail.setText(Email);


        talkTo_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getContext(), chat.class)     ;
                intent.putExtra("Name",FullName)  ;
                startActivity(intent);
            }
        });

        coop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getContext(), coop.class)     ;
                startActivity(intent);

            }
        });

        study_plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getContext(), study_plan.class)     ;
                startActivity(intent);

            }
        });
        
        Conecationn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getContext(), Communicate.class)     ;
                startActivity(intent);

            }
        });


        Profile_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getContext(), profile.class)     ;
                startActivity(intent);
            }
        });


        Who_we.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getContext(), Who_We.class)     ;
                startActivity(intent);
            }
        });

        return root;
    }


}