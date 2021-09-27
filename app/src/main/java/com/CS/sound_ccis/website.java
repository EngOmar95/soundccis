package com.CS.sound_ccis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.CS.sound_ccis.R;

public class website extends AppCompatActivity {
        WebView webView;
        TextView title_;
        TextView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);
        title_=findViewById(R.id.title)    ;
        back =findViewById(R.id.back);
        webView=findViewById(R.id.webView);
         webView.setWebViewClient(new WebViewClient());
        Intent intent=getIntent();
        String link =intent.getStringExtra("link") ;
        String title =intent.getStringExtra("title") ;
        title_.setText(title);


        webView.loadUrl(link);



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}