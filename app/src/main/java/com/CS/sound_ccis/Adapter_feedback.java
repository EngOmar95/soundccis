package com.CS.sound_ccis;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.CS.sound_ccis.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Adapter_feedback extends BaseAdapter {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = database.getReference("Feedback");
    ArrayList<FeedBack_info> Array;
    Context context;

    public Adapter_feedback(ArrayList<FeedBack_info> array, Context context) {
        Array = array;
        this.context = context;
    }
    @Override
    public int getCount() {
        return Array.size();
    }

    @Override
    public FeedBack_info getItem(int i) {
        return Array.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        View v =view;


        if(v==null){

            v= LayoutInflater.from(context).inflate(R.layout.display_feedback,null,false) ;
        }

        final TextView feedback =v.findViewById(R.id.feedback)    ;
        final TextView userName =v.findViewById(R.id.userName)    ;

        ImageButton Delete =v.findViewById(R.id.Delete)  ;




        feedback.setText(getItem(i).Comment);
        userName.setText(getItem(i).name);




        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                databaseReference.child(getItem(i).id).removeValue()    ;

            }
        });





        return v;
    }
}
