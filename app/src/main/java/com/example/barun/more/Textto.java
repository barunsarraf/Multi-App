package com.example.barun.more;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.LocaleList;
import android.speech.tts.TextToSpeech;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by barun on 01-07-2017.
 */

public class Textto extends AppCompatActivity {

    TextToSpeech t1;
    EditText ed1;
    Button b1;
    RadioGroup radioGroup;
    private TextView langset;
    private ImageView imageView;
    private Toolbar mtoolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textto);

        ed1=(EditText)findViewById(R.id.edittest);
        b1=(Button)findViewById(R.id.button);

        imageView=(ImageView) findViewById(R.id.imageView2);

        langset=(TextView) findViewById(R.id.textView2);

        radioGroup=(RadioGroup) findViewById(R.id.radiogroup);

        mtoolbar=(Toolbar)findViewById(R.id.toolbar5);
        setSupportActionBar(mtoolbar);




        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup , int checkedId) {

                switch (checkedId)
                {
                    case R.id.radiobutton1:

                        imageView.setImageResource(R.drawable.chinaa);


                     //   imageView.setImageDrawable(getDrawable(R.drawable.chine));

                        langset.setText("Language set to Chinese");
                        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                            @Override
                            public void onInit(int status) {
                                if(status != TextToSpeech.ERROR) {
                                    t1.setLanguage(Locale.CHINESE);
                                }
                            }
                        });

                        break;

                    case R.id.radiobutton2:
                        imageView.setImageResource(R.drawable.germ);

                        langset.setText("Language set to German");
                        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                            @Override
                            public void onInit(int status) {
                                if(status != TextToSpeech.ERROR) {
                                    t1.setLanguage(Locale.GERMAN);
                                }
                            }
                        });
                        break;

                    case R.id.radiobutton3:

                        imageView.setImageResource(R.drawable.italyy);

                        langset.setText("Language set to Italian");
                        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                            @Override
                            public void onInit(int status) {
                                if(status != TextToSpeech.ERROR) {
                                    t1.setLanguage(Locale.ITALIAN);
                                }
                            }
                        });
                        break;

                    case R.id.radiobutton4:
                        imageView.setImageResource(R.drawable.usa);

                        langset.setText("Language set to English");
                        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                            @Override
                            public void onInit(int status) {
                                if(status != TextToSpeech.ERROR) {
                                    t1.setLanguage(Locale.UK);
                                }
                            }
                        });
                        break;
                }
                return;


            }
        });

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String toSpeak = ed1.getText().toString();
                Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                t1.speak(toSpeak,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
    }

    public void onPause(){
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }
}
