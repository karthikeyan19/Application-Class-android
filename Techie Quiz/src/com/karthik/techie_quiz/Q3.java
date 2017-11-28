package com.karthik.techie_quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by android on 28/9/17.
 */
public class Q3 extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        TextView quizHeaderTextView = (TextView) findViewById(R.id.textview_ques_header);

        quizHeaderTextView.setText(getResources().getText(R.string.head_quiz).toString().replace('?', '3'));

        final QuizApplication quizApplication = QuizApplication.getInstance();

        TextView questionTextView = (TextView) findViewById(R.id.textview_question);
        questionTextView.setText(quizApplication.getQuestion(2));

        final String[] options = quizApplication.getOption(2).split(",");

        RadioButton op1RB = (RadioButton) findViewById(R.id.radio_button_1);
        op1RB.setText(options[0]);

        RadioButton op2RB = (RadioButton) findViewById(R.id.radio_button_2);
        op2RB.setText(options[1]);

        RadioButton op3RB = (RadioButton) findViewById(R.id.radio_button_3);
        op3RB.setText(options[2]);

        RadioButton op4RB = (RadioButton) findViewById(R.id.radio_button_4);
        op4RB.setText(options[3]);


        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_grp);

        Button nextButton = (Button) findViewById(R.id.button_next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int index = 0;
                    RadioButton ans = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                    for (int i = 0; i < options.length; i++) {
                        if (options[i].equals(ans.getText().toString())) {
                            index = i;
                            break;
                        }
                    }
                    quizApplication.updateAnswer(2, index);
                    Intent intent = new Intent(Q3.this,Q4.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){}
            }
        });







    }


}
