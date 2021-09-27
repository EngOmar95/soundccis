package com.CS.sound_ccis;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.CS.sound_ccis.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class List_Adpater extends BaseAdapter {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = database.getReference("Questions");
    ArrayList<Mang_Info> Array;
    Context context;

    public List_Adpater(ArrayList<Mang_Info> array, Context context) {
        Array = array;
        this.context = context;
    }

    @Override
    public int getCount() {
        return Array.size();
    }

    @Override
    public Mang_Info getItem(int i) {
        return Array.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        View v = view;


        if (v == null) {

            v = LayoutInflater.from(context).inflate(R.layout.list, null, false);
        }

        final TextView Question = v.findViewById(R.id.Question);
        final TextView Answer = v.findViewById(R.id.Answer);
        final TextView KeyWord = v.findViewById(R.id.Keyword);
        final TextView Keyword_2 = v.findViewById(R.id.keyword_2);
        final TextView Keyword_3 = v.findViewById(R.id.keyword_3);
        ImageButton Update = v.findViewById(R.id.Update);
        ImageButton Delete = v.findViewById(R.id.Delete);
        Button but_add = v.findViewById(R.id.but_add);
        but_add.setVisibility(View.GONE);


        Question.setText(getItem(i).Question);
        Answer.setText(getItem(i).Answer);
        KeyWord.setText(getItem(i).Keyword);
        Keyword_2.setText(getItem(i).Keyword_2);
        Keyword_3.setText(getItem(i).Keyword_3);


        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Mang_Info n = new Mang_Info(getItem(i).id_Question, Question.getText().toString(), Answer.getText().toString(), KeyWord.getText().toString(), Keyword_2.getText().toString(), Keyword_3.getText().toString());

                databaseReference.child(getItem(i).id_Question).setValue(n);

            }
        });
        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                databaseReference.child(getItem(i).id_Question).removeValue();

            }
        });


        return v;
    }
}
