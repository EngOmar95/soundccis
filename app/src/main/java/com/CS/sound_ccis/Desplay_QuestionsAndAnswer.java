package com.CS.sound_ccis;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.CS.sound_ccis.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class Desplay_QuestionsAndAnswer extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {




        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference databaseReference = database.getReference("Questions");
        final View root = inflater.inflate(R.layout.desplay_questions_and_answer, container, false);
         final ListView listView =root.findViewById(R.id.listViwe)   ;

        FloatingActionButton ADD=root.findViewById(R.id.ADD);
        ADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dailog_Add dd =new Dailog_Add();

                dd.show(getFragmentManager(),"");
            }
        });



        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

              

                ArrayList<Mang_Info> arrayList=new ArrayList<>();
                for(DataSnapshot s: snapshot.getChildren()){
                    Mang_Info n =s.getValue(Mang_Info.class);
                    arrayList .add(n);
                }
                List_Adpater adp =new List_Adpater (arrayList,getContext());

                listView.setAdapter(adp);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    



        return root;
    }


}