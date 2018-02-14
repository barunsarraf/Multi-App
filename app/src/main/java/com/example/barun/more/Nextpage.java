package com.example.barun.more;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;



public class Nextpage extends AppCompatActivity {
    private Button quizstart,touchme;

    private Button Gam1;
    private Button Call;
    private Button Msg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nextpage);


        Gam1=(Button)findViewById(R.id.gal);
        Call=(Button)findViewById(R.id.kall);
        Msg=(Button)findViewById(R.id.sendsms);
        quizstart=(Button)findViewById(R.id.cal);
        touchme=(Button)findViewById(R.id.touchme);


        Gam1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rege = new Intent(Nextpage.this,Gallery.class);
                startActivity(rege);
            }
        });
        Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ram = new Intent(Nextpage.this,Calling.class);
                startActivity(ram);

            }
        });
        Msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rege = new Intent(Nextpage.this,Message.class);
                startActivity(rege);
            }
        });


        quizstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(Nextpage.this,Quizactivity.class);
                startActivity(j);
            }
        });



        touchme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tou = new Intent(Nextpage.this,Touchme.class);
                startActivity(tou);
            }
        });
    }
}
