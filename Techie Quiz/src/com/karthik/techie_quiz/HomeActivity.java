package com.karthik.techie_quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button quiz = (Button) findViewById(R.id.button_quiz);

        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(HomeActivity.this,Q1.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                QuizApplication.getInstance().createQuiz();
                startActivity(i);
            }
        });



    }

}
