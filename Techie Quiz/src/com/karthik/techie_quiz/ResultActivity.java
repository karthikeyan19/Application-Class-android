package com.karthik.techie_quiz;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by android on 28/9/17.
 */
public class ResultActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        TextView markTextView = (TextView) findViewById(R.id.textview_mark);
        int mark = QuizApplication.getInstance().evaluate();
        markTextView.setText(mark+"");
        if(mark>=4){
            markTextView.setTextColor(getResources().getColor(R.color.color_green));
        }else  if(mark>=2){
            markTextView.setTextColor(getResources().getColor(R.color.color_yellow));
        }else{
            markTextView.setTextColor(getResources().getColor(R.color.color_red));
        }


        Button backButton = (Button) findViewById(R.id.button_back_to_home);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
