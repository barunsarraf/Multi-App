package com.example.barun.more;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Quizactivity extends AppCompatActivity {

    private Questionbank mQuestionLibrary = new Questionbank();
    private TextView mScoreView,mQuestionView;
    private Button m1,m2,m3,m4;

    private String mAnswer;
    private int currentscore = 0, mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizactivity);
        // setup screen for the first question with four alternative to answer
        mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.question);
        m1 = (Button)findViewById(R.id.choice1);
        m2 = (Button)findViewById(R.id.choice2);
        m3 = (Button)findViewById(R.id.choice3);
        m4 = (Button)findViewById(R.id.choice4);
        updateQuestion();

        updatecurrentscore(currentscore);
    }

    private void updateQuestion(){
        // check if we are not outside array bounds for questions
        if(mQuestionNumber  <  mQuestionLibrary.getLength() ){
            // set the text for new question, and new 4 alternative to answer on four buttons
            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            m1.setText(mQuestionLibrary.getChoice(mQuestionNumber, 1));
            m2.setText(mQuestionLibrary.getChoice(mQuestionNumber, 2));
            m3.setText(mQuestionLibrary.getChoice(mQuestionNumber, 3));
            m4.setText(mQuestionLibrary.getChoice(mQuestionNumber,4));
            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;
        }
        else {
            Toast.makeText(Quizactivity.this, "It was the last question!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Quizactivity.this, Highscore.class);
            intent.putExtra("score", currentscore); // pass the current score to the second screen
            startActivity(intent);
        }
    }

    // show current total score for the user
    private void updatecurrentscore(int point) {
        mScoreView.setText("" + currentscore+"/"+mQuestionLibrary.getLength());
    }







    public void onClick(View view) {
        //all logic for all answers buttons in one method
        Button answer = (Button) view;
        // if the answer is correct, increase the score
        if (answer.getText() == mAnswer){
            currentscore = currentscore + 1;
            Toast.makeText(Quizactivity.this, "Correct!", Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(Quizactivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
        // show current total score for the user
        updatecurrentscore(currentscore);
        // once user answer the question, we move on to the next one, if any
        updateQuestion();
    }
}