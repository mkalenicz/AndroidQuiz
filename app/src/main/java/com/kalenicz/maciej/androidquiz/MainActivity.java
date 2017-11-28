package com.kalenicz.maciej.androidquiz;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int goodAnswers;
    int badAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setQandA();
    }

    public void setQandA() {
        TextView question = (TextView) findViewById(R.id.question_text_view);
        question.setText(R.string.question_1);
        RadioButton radioButtonA = (RadioButton) findViewById(R.id.radioButtonA);
        radioButtonA.setText(R.string.answer_1a);
        RadioButton radioButtonB = (RadioButton) findViewById(R.id.radioButtonB);
        radioButtonB.setText(R.string.answer_1b);
        RadioButton radioButtonC = (RadioButton) findViewById(R.id.radioButtonC);
        radioButtonC.setText(R.string.answer_1c);
        RadioButton radioButtonD = (RadioButton) findViewById(R.id.radioButtonD);
        radioButtonD.setText(R.string.answer_1d);


        TextView question2 = (TextView) findViewById(R.id.question2_text_view);
        question2.setText(R.string.question_2);
        CheckBox checkBoxA = (CheckBox) findViewById(R.id.checkboxA);
        checkBoxA.setText(R.string.answer_2a);
        CheckBox checkBoxB = (CheckBox) findViewById(R.id.checkboxB);
        checkBoxB.setText(R.string.answer_2b);
        CheckBox checkBoxC = (CheckBox) findViewById(R.id.checkboxC);
        checkBoxC.setText(R.string.answer_2c);
        CheckBox checkBoxD = (CheckBox) findViewById(R.id.checkboxD);
        checkBoxD.setText(R.string.answer_2d);
        CheckBox checkBoxE = (CheckBox) findViewById(R.id.checkboxE);
        checkBoxE.setText(R.string.answer_2e);
        CheckBox checkBoxF = (CheckBox) findViewById(R.id.checkboxF);
        checkBoxF.setText(R.string.answer_2f);

        TextView question3 = (TextView) findViewById(R.id.question3_text_view);
        question3.setText(R.string.question_3);

        TextView question4 = (TextView) findViewById(R.id.question4_text_view);
        question4.setText(R.string.question_4);
        RadioButton radioButtonA4 = (RadioButton) findViewById(R.id.radioButtonA4);
        radioButtonA4.setText(R.string.answer_4a);
        RadioButton radioButtonB4 = (RadioButton) findViewById(R.id.radioButtonB4);
        radioButtonB4.setText(R.string.answer_4b);
        RadioButton radioButtonC4 = (RadioButton) findViewById(R.id.radioButtonC4);
        radioButtonC4.setText(R.string.answer_4c);
        RadioButton radioButtonD4 = (RadioButton) findViewById(R.id.radioButtonD4);
        radioButtonD4.setText(R.string.answer_4d);
    }


    public boolean firstQuestion() {
        RadioButton radioButtonA = (RadioButton) findViewById(R.id.radioButtonA);
        boolean hasButtonA = radioButtonA.isChecked();
        TextView firstQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        if (hasButtonA) {
            firstQuestionTextView.setTextColor(Color.parseColor("#8BC34A"));
            goodAnswers = goodAnswers + 1;
            return true;
        } else {
            firstQuestionTextView.setTextColor(Color.parseColor("#FF0000"));
            badAnswers = badAnswers + 1;
            return false;
        }
    }

    public void secondQuestion() {
        CheckBox checkBoxA = (CheckBox) findViewById(R.id.checkboxA);
        boolean hasCheckBoxA = checkBoxA.isChecked();
        CheckBox checkBoxB = (CheckBox) findViewById(R.id.checkboxB);
        boolean hasCheckBoxB = checkBoxB.isChecked();
        CheckBox checkBoxC = (CheckBox) findViewById(R.id.checkboxC);
        boolean hasCheckBoxC = checkBoxC.isChecked();
        CheckBox checkBoxD = (CheckBox) findViewById(R.id.checkboxD);
        boolean hasCheckBoxD = checkBoxD.isChecked();
        CheckBox checkBoxE = (CheckBox) findViewById(R.id.checkboxE);
        boolean hasCheckBoxE = checkBoxE.isChecked();
        CheckBox checkBoxF = (CheckBox) findViewById(R.id.checkboxF);
        boolean hasCheckBoxF = checkBoxF.isChecked();
        secondQuestionCheck(hasCheckBoxA, hasCheckBoxB, hasCheckBoxC, hasCheckBoxD, hasCheckBoxE, hasCheckBoxF);

    }

    private boolean secondQuestionCheck(boolean answerA, boolean answerB, boolean answerC, boolean answerD, boolean answerE, boolean answerF) {
        TextView secondQuestionTextView = (TextView) findViewById(R.id.question2_text_view);

        if (answerB & answerC & answerD & answerE & !answerA & !answerF) {
            secondQuestionTextView.setTextColor(Color.parseColor("#8BC34A"));
            goodAnswers = goodAnswers + 1;
            return true;
        } else {
            secondQuestionTextView.setTextColor(Color.parseColor("#FF0000"));
            badAnswers = badAnswers + 1;
            return false;
        }
    }

    public void thirdQuestion() {
        TextView thirdQuestionTextView = (TextView) findViewById(R.id.question3_text_view);
        EditText editTextThird = (EditText) findViewById(R.id.edit_text_third);
        String text = editTextThird.getText().toString().trim();
        if (text.equalsIgnoreCase(getString(R.string.answer_3))) {
            thirdQuestionTextView.setTextColor(Color.parseColor("#8BC34A"));
            goodAnswers = goodAnswers + 1;
        } else {
            thirdQuestionTextView.setTextColor(Color.parseColor("#FF0000"));
            badAnswers = badAnswers + 1;
        }
    }

    public void fourthQuestion() {
        RadioButton radioButtonC4 = (RadioButton) findViewById(R.id.radioButtonC4);
        boolean hasButtonC4 = radioButtonC4.isChecked();

        TextView fourthQuestionTextView = (TextView) findViewById(R.id.question4_text_view);
        if (hasButtonC4) {
            fourthQuestionTextView.setTextColor(Color.parseColor("#8BC34A"));
            goodAnswers = goodAnswers + 1;
        } else {
            fourthQuestionTextView.setTextColor(Color.parseColor("#FF0000"));
            badAnswers = badAnswers + 1;

        }
    }

    private void displayScore() {
        String message;
        message = goodAnswers + " answers was correct";
        message += "\n" + badAnswers + " anwers was incorrect";
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void checkAllQuestions(View view) {
        secondQuestion();
        firstQuestion();
        thirdQuestion();
        fourthQuestion();
        displayScore();
        goodAnswers = 0;
        badAnswers = 0;
    }

    public void reset(View view) {
        TextView firstQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        firstQuestionTextView.setTextColor(Color.parseColor("#000000"));
        TextView secondQuestionTextView = (TextView) findViewById(R.id.question2_text_view);
        secondQuestionTextView.setTextColor(Color.parseColor("#000000"));
        TextView thirdQuestionTextView = (TextView) findViewById(R.id.question3_text_view);
        thirdQuestionTextView.setTextColor(Color.parseColor("#000000"));
        TextView fourthQuestionTextView = (TextView) findViewById(R.id.question4_text_view);
        fourthQuestionTextView.setTextColor(Color.parseColor("#000000"));
        CheckBox checkBoxA = (CheckBox) findViewById(R.id.checkboxA);
        checkBoxA.setChecked(false);
        CheckBox checkBoxB = (CheckBox) findViewById(R.id.checkboxB);
        checkBoxB.setChecked(false);
        CheckBox checkBoxC = (CheckBox) findViewById(R.id.checkboxC);
        checkBoxC.setChecked(false);
        CheckBox checkBoxD = (CheckBox) findViewById(R.id.checkboxD);
        checkBoxD.setChecked(false);
        CheckBox checkBoxE = (CheckBox) findViewById(R.id.checkboxE);
        checkBoxE.setChecked(false);
        CheckBox checkBoxF = (CheckBox) findViewById(R.id.checkboxF);
        checkBoxF.setChecked(false);
        EditText editTextThird = (EditText) findViewById(R.id.edit_text_third);
        editTextThird.setText(null);
        RadioButton radioButtonA = (RadioButton) findViewById(R.id.radioButtonA);
        radioButtonA.setChecked(false);
        RadioButton radioButtonB = (RadioButton) findViewById(R.id.radioButtonB);
        radioButtonB.setChecked(false);
        RadioButton radioButtonC = (RadioButton) findViewById(R.id.radioButtonC);
        radioButtonC.setChecked(false);
        RadioButton radioButtonD = (RadioButton) findViewById(R.id.radioButtonD);
        radioButtonD.setChecked(false);
        RadioButton radioButtonA4 = (RadioButton) findViewById(R.id.radioButtonA4);
        radioButtonA4.setChecked(false);
        RadioButton radioButtonB4 = (RadioButton) findViewById(R.id.radioButtonB4);
        radioButtonB4.setChecked(false);
        RadioButton radioButtonC4 = (RadioButton) findViewById(R.id.radioButtonC4);
        radioButtonC4.setChecked(false);
        RadioButton radioButtonD4 = (RadioButton) findViewById(R.id.radioButtonD4);
        radioButtonD4.setChecked(false);

    }

}
