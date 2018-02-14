package com.example.barun.more;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calci extends AppCompatActivity {
    EditText editText1, editText2;
    Button b_plus, b_minus, b_mul, b_div;
    TextView tv_result;
    double num1, num2, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calci);
        editText1 = (EditText) findViewById(R.id.etFirstNumber);

        editText2 = (EditText) findViewById(R.id.etSecondNumber);
        b_plus = (Button) findViewById(R.id.buttonAdd);
        b_minus = (Button) findViewById(R.id.buttonSubtract);
        b_mul = (Button) findViewById(R.id.buttonMultiply);
        b_div = (Button) findViewById(R.id.buttonDivide);

        tv_result = (TextView) findViewById(R.id.textView11);
        b_plus.setOnClickListener(new View.OnClickListener() {


                                      public void onClick(View v) {
                                          if (!editText1.getText().toString().equals("") || !editText2.getText().toString().equals("")) {
                                              num1 = Double.parseDouble(editText1.getText().toString());
                                              num2 = Double.parseDouble(editText2.getText().toString());
                                              result = num1 + num2;
                                              tv_result.setText("" + result);

                                          }

                                      }

                                  }
        );

        b_minus.setOnClickListener(new View.OnClickListener() {
                                       public void onClick(View v) {
                                           if (!editText1.getText().toString().equals("") || !editText2.getText().toString().equals("")) {
                                               num1 = Double.parseDouble(editText1.getText().toString());
                                               num2 = Double.parseDouble(editText2.getText().toString());
                                               result = num1 - num2;
                                               tv_result.setText("" + result);

                                           }
                                       }
                                   }


        );
        b_mul.setOnClickListener(new View.OnClickListener() {

                                     public void onClick(View v) {
                                         if (!editText1.getText().toString().equals("") || !editText2.getText().toString().equals("")) {
                                             num1 = Double.parseDouble(editText1.getText().toString());
                                             num2 = Double.parseDouble(editText2.getText().toString());
                                             result = num1 * num2;
                                             tv_result.setText("" + result);

                                         }
                                     }
                                 }


        );
        b_div.setOnClickListener(new View.OnClickListener() {
                                     public void onClick(View v) {
                                         if (!editText1.getText().toString().equals("") || !editText2.getText().toString().equals("")) {
                                             num1 = Double.parseDouble(editText1.getText().toString());
                                             num2 = Double.parseDouble(editText2.getText().toString());
                                             result = num1 / num2;
                                             tv_result.setText("" + result);

                                         }
                                     }
                                 }
        );

    }
}