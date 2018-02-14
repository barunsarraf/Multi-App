package com.example.barun.more;

        import android.Manifest;
        import android.content.Context;
        import android.content.Intent;
        import android.content.pm.PackageManager;
        import android.net.Uri;
        import android.support.v4.app.ActivityCompat;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import com.example.barun.more.R;

public class Calling extends AppCompatActivity
{ Button btn; EditText numTxt;
    String sNum;
    @Override protected void onCreate(Bundle savedInstanceState)
    { super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calling);
        btn = (Button) findViewById(R.id.idbtnCall);
        numTxt = (EditText) findViewById(R.id.idNumtxt);
    }
    public void btncall(View v)
    {
        Intent i = new Intent(Intent.ACTION_CALL);
        sNum = numTxt.getText().toString();
        if(sNum.trim().isEmpty())
        { i.setData(Uri.parse("tel:7788994455")); }
        else{ i.setData(Uri.parse("tel:"+sNum)); }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
        { Toast.makeText(this,"Please grant the permission to call",Toast.LENGTH_SHORT).show();
            requestPermission(); }
        else { startActivity(i); } }
    private void requestPermission()
    { ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE},1); } }