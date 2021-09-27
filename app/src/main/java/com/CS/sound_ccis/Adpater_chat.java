package com.CS.sound_ccis;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import com.CS.sound_ccis.R;

import java.util.ArrayList;

public class Adpater_chat extends BaseAdapter {


        ArrayList<chat_info> arr ;
        Context context;

        public Adpater_chat(ArrayList<chat_info> arr, Context context) {
            this.arr = arr;
            this.context = context;
        }

        @Override
        public int getCount() {
            return arr.size();
        }

        @Override
        public chat_info getItem(int i) {
            return arr.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View   v=view;

            if(v==null){

                v = LayoutInflater.from(context).inflate(R.layout.text_chat,null,false);
                //text_chat
            }
            LinearLayout linearLayout =v.findViewById(R.id.layout)   ;



            final TextView text =v.findViewById(R.id.text);
            ImageView image_chat =v.findViewById(R.id.Image_chat)  ;
            TextView time =v.findViewById(R.id.time);
            CardView  card   =v.findViewById(R.id.card);




            if(getItem(i).chack.equals("2")) {
                card.setCardBackgroundColor(ContextCompat.getColor(context, R.color.color_bot_Message));
                text.setText(getItem(i).text);
                time.setText(getItem(i).time);
                linearLayout.setGravity(Gravity.LEFT);
                image_chat.setVisibility(View.VISIBLE);

                linearLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder dialog =new AlertDialog.Builder(context)  ;

                        dialog.setIcon(R.drawable.feedback)  ;

                        dialog.setTitle("Leave Feedback")    ;


                        dialog.setPositiveButton("نعم", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent =new Intent(context,FeedBack.class)      ;
                                intent.putExtra("message",text.getText().toString())  ;
                                context.startActivity(intent);


                            }
                        })   ;

                        dialog.setNegativeButton("لا", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })  ;

                        dialog.show();
                    }

                });



            }else {
                card.setCardBackgroundColor(ContextCompat.getColor(context, R.color.color_My_Message));
                text.setText(getItem(i).text);
                time.setText(getItem(i).time);
                linearLayout.setGravity(Gravity.RIGHT);
                image_chat.setVisibility(View.GONE);

            }



            return v;
        }
}
