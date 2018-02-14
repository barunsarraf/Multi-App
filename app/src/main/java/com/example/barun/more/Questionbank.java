package com.example.barun.more;

/**
 * Created by barun on 03-07-2017.
 */

public class Questionbank {

    private String textQuestions [] = {
            "1. When did Google acquired Android?",
            "2. What is the name of build toolkit for Android Studio?",
            "3. What widget can replace any use of radio buttons?",
            "4. Android application implements principle of _____."

    };

    // array of multiple choices for each question
    private String multipleChoice [][] = {
            {"2003", "2004", "2005", "2006"},
            {"JVM", "Gradle", "Dalvik", "HAXM"},
            {"Toggle Button", "Spinner", "Switch Button", "ImageButton"},
            {"least privileges", "most privileges", "unique privileges", "none of the above"}
    };



    // array of correct answers - in the same order as array of questions
    private String mCorrectAnswers[] = {"2005", "Gradle", "Spinner", "least privileges"};

    // method returns number of questions
    public int getLength(){
        return textQuestions.length;
    }

    // method returns question from array textQuestions[] based on array index
    public String getQuestion(int a) {
        String question = textQuestions[a];
        return question;
    }

    // method return a single multiple choice item for question based on array index,
    // based on number of multiple choice item in the list - 1, 2, 3 or 4 as an argument
    public String getChoice(int index, int num) {
        String choice0 = multipleChoice[index][num-1];
        return choice0;
    }

    //  method returns correct answer for the question based on array index
    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }
}
