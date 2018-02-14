package com.example.barun.more;

import android.content.DialogInterface;
import android.graphics.Camera;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;

import com.google.firebase.FirebaseApp;

/**
 * Created by barun on 01-07-2017.
 */

public class Max extends AppCompatActivity {

    String valfromlogin;
    private TextView emailname;
    private Button camera;
    private Button texttospeech;
    private Button music;
    private ImageButton morenext;
    private Toolbar mtoolbar;
    private Button cal;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maxxml);
        emailname = (TextView) findViewById(R.id.welcomeemail);
        texttospeech=(Button)findViewById(R.id.tt);
        valfromlogin = getIntent().getExtras().getString("value");
        emailname.setText(valfromlogin);
        camera=(Button)findViewById(R.id.cam);
        cal=(Button)findViewById(R.id.cal);

        mtoolbar=(Toolbar)findViewById(R.id.toolbar6);

        ImageButton morenext= (ImageButton)findViewById(R.id.next);

        setSupportActionBar(mtoolbar);

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Max.this,Cameraa.class);
                startActivity(i);
            }
        });


        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Max.this,Calci.class);
                startActivity(i);
            }
        });



        texttospeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(Max.this,Textto.class);
                startActivity(j);
            }
        });

        morenext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(Max.this,Nextpage.class);
                startActivity(k);

            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

}