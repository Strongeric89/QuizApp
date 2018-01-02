package com.example.eric.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    private TextView result = null;
    private Button btn = null;
    public int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        //get bundle score
        score = getIntent().getExtras().getInt("score");


    }

    public void submitAnswer(View view) {

        result = (TextView) findViewById(R.id.score);
        result.setText("your score is: " + score);


    }
}
