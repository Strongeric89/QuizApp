package com.example.eric.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Round3Activity extends AppCompatActivity {


    private TextView question = null;
    private Button btn = null;
    private ImageView image = null;
    private RadioGroup radioGroup = null;
    private RadioButton option1 = null;
    private RadioButton option2 = null;

    public int questionCounter = 0;
    public int score = 0;

    public ArrayList<Question> questions = new ArrayList<Question>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round3);

        //get bundle
        score = getIntent().getExtras().getInt("score");


        //Question set is based on Computer Science Trivia
        Question q9 = new Question("Android is the only Mobile Operating System? ", "false", "true");
        Question q10 = new Question("You enjoyed learning Android? ", "true", "false");
        Question q11 = new Question("You enjoyed learning Android? ", "true", "false");

        questions.add(q9);
        questions.add(q10);
        questions.add(q11);

        image = (ImageView) findViewById(R.id.image);

        question = (TextView) findViewById(R.id.Question);
        radioGroup = (RadioGroup) findViewById(R.id.group);
        option1 = (RadioButton) findViewById(R.id.option1);
        option2 = (RadioButton) findViewById(R.id.option2);


        //set all strings
        question.setText(questions.get(questionCounter).question);
        option1.setText(questions.get(questionCounter).answer);
        option2.setText(questions.get(questionCounter).a2);

        setBg();


    }

    public void submitAnswer(View view) {

        if (radioGroup.getId() == R.id.group) {
            score++;
            Log.d("eric", "score is " + score);
            questionCounter++;
            Toast.makeText(Round3Activity.this, "thank you : " + score, Toast.LENGTH_SHORT).show();

        } else {

            questionCounter++;
            Toast.makeText(Round3Activity.this, "thank you : " + score, Toast.LENGTH_SHORT).show();
        }

        question.setText(questions.get(questionCounter).question);
        option1.setText(questions.get(questionCounter).answer);
        option2.setText(questions.get(questionCounter).a2);
        setBg();
        check();

    }

    public void setBg() {
        if (questionCounter == 0) {
            image.setImageResource(R.drawable.q9);
        }
        if (questionCounter == 1) {
            image.setImageResource(R.drawable.q10);
        }

    }

    public void check() {

        if (questionCounter > 1) {
            //next round
            Intent i = new Intent(this, FinalActivity.class);
            i.putExtra("score", score);
            startActivity(i);

        }
    }
}
