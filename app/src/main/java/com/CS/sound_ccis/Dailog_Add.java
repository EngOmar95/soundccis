package com.CS.sound_ccis;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.CS.sound_ccis.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Dailog_Add extends AppCompatDialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder b = new AlertDialog.Builder(getActivity());
        LayoutInflater i = getActivity().getLayoutInflater();
        View v = i.inflate(R.layout.list, null, false);
        b.setView(v);
        final EditText Question = v.findViewById(R.id.Question);
        final EditText Answer = v.findViewById(R.id.Answer);
        final EditText KeyWord = v.findViewById(R.id.Keyword);
        final EditText KeyWord_2 = v.findViewById(R.id.keyword_2);
        final EditText KeyWord_3 = v.findViewById(R.id.keyword_3);

        ImageButton Update = v.findViewById(R.id.Update);
        ImageButton Delete = v.findViewById(R.id.Delete);
        Button but_add =v.findViewById(R.id.but_add)  ;

        Delete.setVisibility(View.INVISIBLE);
        Update.setVisibility(View.INVISIBLE);

        but_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();//obiect
                DatabaseReference databaseReference = database.getReference("Questions");
                String Key = databaseReference.push().getKey();


                Mang_Info mang_info = new Mang_Info(Key, Question.getText().toString(), Answer.getText().toString(), KeyWord.getText().toString(),KeyWord_2.getText().toString(),KeyWord_3.getText().toString());

                databaseReference.child(Key).setValue(mang_info);


                dismiss();

            }
        });


        return b.create();


    }



}
