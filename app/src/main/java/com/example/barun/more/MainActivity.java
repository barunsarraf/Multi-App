package com.example.barun.more;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity{
    private ProgressDialog mprogress;
    private EditText emaili;
    private EditText passi;
    private Button loglog,reg;
    private FirebaseAuth firebaseAuth;
    private TextView change;
    boolean haveConnectedWifi = false;
    boolean haveConnectedMobile = false;
    private boolean x;

    FirebaseAuth authe = FirebaseAuth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emaili = (EditText) findViewById(R.id.emailid);
        passi = (EditText) findViewById(R.id.pwd);
        change=(TextView) findViewById(R.id.textView3);

        loglog = (Button) findViewById(R.id.login);
        reg= (Button) findViewById(R.id.button4);

        checkin();

        //getting problem here for email to login email
        /*
        String val;
        val=getIntent().getExtras().getString("value");
        emaili.setText(val);*/

        firebaseAuth=FirebaseAuth.getInstance();
        mprogress=new ProgressDialog(MainActivity.this);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rg=new Intent(MainActivity.this,Registerfornew.class);
                startActivity(rg);
            }
        });
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View viewalert = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_demoalert, null);

                final EditText resemail = (EditText) viewalert.findViewById(R.id.editText);


                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Chnage Password").setView(viewalert)
                        .setPositiveButton("Submit",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {

                                        String emailres=resemail.getText().toString();

                                        if (!TextUtils.isEmpty(emailres)) {

                                            authe.sendPasswordResetEmail(emailres).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {


                                                    if (task.isSuccessful()) {
                                                        Toast.makeText(MainActivity.this, "Submitted | Check your mail", Toast.LENGTH_LONG).show();

                                                    } else {
                                                        Toast.makeText(MainActivity.this, "Error Occured", Toast.LENGTH_LONG).show();
                                                    }


                                                }
                                            });
                                        }
                                        else
                                        {
                                            Toast.makeText(MainActivity.this, "Please enter email", Toast.LENGTH_LONG).show();
                                        }
                                        // Write your code here to execute after dialog


                                    }
                                })
                        .setNegativeButton("Cancel", null).setCancelable(false);
                AlertDialog alert = builder.create();
                alert.show();
            }
        });


        loglog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final String e=emaili.getText().toString().trim();
              final  String p=passi.getText().toString().trim();


                if(TextUtils.isEmpty(e) || TextUtils.isEmpty(p))
                {
                    Toast.makeText(MainActivity.this,"Fill all the details",Toast.LENGTH_LONG).show();
                    //check thsi return in future if error exits
                    return;
                }
                mprogress.setMessage("Logging in..."+ e);
                mprogress.show();

                firebaseAuth.signInWithEmailAndPassword(e,p).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            mprogress.dismiss();


                            Intent back=new Intent(MainActivity.this,Max.class);
                            back.putExtra("value",e);
                            startActivity(back);
                        }

                        else{
                            mprogress.dismiss();
                            Toast.makeText(MainActivity.this,"Failed To Login.Try again",Toast.LENGTH_LONG).show();}

                    }
                });



            }
        });

    }

    private void checkin()
    {

        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected())
        {
            Toast t =Toast.makeText(MainActivity.this, "Internet Acess",Toast.LENGTH_SHORT);
            t.show();
        }

        else
        {
            Toast t =Toast.makeText(MainActivity.this, "No Internet Acess",Toast.LENGTH_SHORT);
            t.show();


        }
        return;

    }
}
