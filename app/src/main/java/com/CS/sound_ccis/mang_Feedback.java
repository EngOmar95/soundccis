package com.CS.sound_ccis;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.CS.sound_ccis.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class mang_Feedback extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference databaseReference = database.getReference("Feedback");

        View root= inflater.inflate(R.layout.fragment_mang__feedback, container, false);

        final ListView listView =root.findViewById(R.id.listViwe)   ;





        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {



                ArrayList<FeedBack_info> arrayList=new ArrayList<>();
                for(DataSnapshot s: snapshot.getChildren()){
                    FeedBack_info n =s.getValue(FeedBack_info.class);
                    arrayList .add(n);
                }
                Adapter_feedback adp =new Adapter_feedback (arrayList,getContext());

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