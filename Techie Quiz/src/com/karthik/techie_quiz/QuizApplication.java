package com.karthik.techie_quiz;

import android.app.Application;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by android on 22/9/17.
 */
public class QuizApplication extends Application {
    static QuizApplication mInstance ;
    private String[] questions;
    private String[] options;
    private Map<Integer,Integer> answers ;
    private Map<Integer,Integer> userAns;
    public static QuizApplication getInstance(){
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public void createQuiz(){

        questions = getApplicationContext().getResources().getStringArray(R.array.questions);
        options = getApplicationContext().getResources().getStringArray(R.array.options);
        if(answers==null)answers = new HashMap<>();
        answers.put(0,1);
        answers.put(1,2);
        answers.put(2,3);
        answers.put(3,0);
        answers.put(4,0);
        userAns = new HashMap<>();
    }


    public String getQuestion(int index){return questions[index];}

    public String getOption(int index){return options[index];}

    public void updateAnswer(int index, int ans){

         userAns.put(index,ans);

    }

    public int evaluate(){
        int result = 0;

        for(int i=0; i<answers.size(); i++){
            if(answers.get(i).equals(userAns.get(i))){
                result += 1;
            }

        }

        return result;
    }

}
