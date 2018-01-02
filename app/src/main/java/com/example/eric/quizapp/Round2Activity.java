package com.example.eric.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Round2Activity extends AppCompatActivity {

    private TextView question = null;
    private Button btn = null;
    private ImageView image = null;
    private EditText questionBox = null;

    public int questionCounter = 0;
    public int score = 0;

    public ArrayList<Question> questions = new ArrayList<Question>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round2);

        //get score from bundle
        score = getIntent().getExtras().getInt("score");


        //Question set is based on Computer Science Trivia
        Question q5 = new Question("What does android use for UI development?", "XML");
        Question q6 = new Question("What language is used for IOS development?", "C#");
        Question q7 = new Question("HCI stands for? ", "Human Computer Interaction");
        Question q8 = new Question("Which layer of the OSI model does a Router reside in? ", "3");
        Question q9 = new Question("Which layer of the OSI model does a Router reside in? ", "3");

        questions.add(q5);
        questions.add(q6);
        questions.add(q7);
        questions.add(q8);
        questions.add(q9);

        image = (ImageView) findViewById(R.id.image);

        question = (TextView) findViewById(R.id.Question);
        questionBox = (EditText) findViewById(R.id.questionBox);

        //set all strings
        question.setText(questions.get(questionCounter).question);
        setBg();

    }

    public void submitAnswer(View view) {


        String ans = questionBox.getText().toString();
        if (ans.equalsIgnoreCase(questions.get(questionCounter).answer)) {
            score++;
            questionCounter++;
            Toast.makeText(this, "thank you : " + score, Toast.LENGTH_SHORT).show();

        } else {
            questionCounter++;
            Toast.makeText(this, "thank you : " + score, Toast.LENGTH_SHORT).show();

        }

        questionBox.setText("");
        question.setText(questions.get(questionCounter).question);
        setBg();

        check();

    }

    public void setBg() {
        if (questionCounter == 0) {
            image.setImageResource(R.drawable.q5);
        }
        if (questionCounter == 1) {
            image.setImageResource(R.drawable.q6);
        }
        if (questionCounter == 2) {
            image.setImageResource(R.drawable.q7);
        }
        if (questionCounter == 3) {
            image.setImageResource(R.drawable.q8);
        }


    }

    public void check() {
        Log.d("eric", "score is " + score);
        if (questionCounter > 3) {
            //next round
            Intent i = new Intent(this, Round3Activity.class);
            i.putExtra("score", score);
            startActivity(i);

        }
    }
}


