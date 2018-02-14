package com.example.barun.more;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.barun.more.R;





public class Cameraa extends AppCompatActivity
{
    private Button btn;
    private static final int CAMERA_REQUEST =123 ;
    ImageView imageView;

    private Toolbar mtoolbar;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam);
        btn = (Button) findViewById(R.id.launch);
        imageView = (ImageView) findViewById(R.id.imageView);

        mtoolbar=(Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(mtoolbar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAMERA_REQUEST);

            }

        });

    }



    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK)
    {
        Bitmap photo = (Bitmap) data.getExtras().get("data");

        imageView.setImageBitmap(photo);
    }
    else
        {
            Toast.makeText(Cameraa.this,"Cannot Process",Toast.LENGTH_LONG).show();
        }


    }
}