package com.example.eric.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Question> questions = new ArrayList<Question>();

    private TextView question = null;
    private CheckBox quest1Box = null;
    private CheckBox quest2Box = null;
    private CheckBox quest3Box = null;
    private CheckBox quest4Box = null;
    private TextView option1 = null;
    private TextView option2 = null;
    private TextView option3 = null;
    private TextView option4 = null;
    private Button btn = null;
    private ImageView image = null;

    public int questionCounter = 0;
    public int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Question set is based on Computer Science Trivia
        Question q1 = new Question("What port is used for HTTP protocol?", "80", "443", "8080", "81");
        Question q2 = new Question("How many Layers are in the TCP/IP Model?", "4", "7", "6", "2");
        Question q3 = new Question("What Language uses a JVM ?", "java", "C", "C++", "Python");
        Question q4 = new Question("What Does MVC stand for?", "Model View Controller", "Make Verbose Contracts", "My Vitrual C", "Man View Controls");
        Question q5 = new Question("What Does MVC stand for?", "Model View Controller", "Make Verbose Contracts", "My Vitrual C", "Man View Controls");

        questions.add(q1);
        questions.add(q2);
        questions.add(q3);
        questions.add(q4);
        questions.add(q5);

        image = (ImageView) findViewById(R.id.image);

        question = (TextView) findViewById(R.id.Question);
        quest1Box = (CheckBox) findViewById(R.id.question1Box);
        option1 = (TextView) findViewById(R.id.question1BoxD);

        quest2Box = (CheckBox) findViewById(R.id.question2Box);
        option2 = (TextView) findViewById(R.id.question2BoxD);

        quest3Box = (CheckBox) findViewById(R.id.question3Box);
        option3 = (TextView) findViewById(R.id.question3BoxD);

        quest4Box = (CheckBox) findViewById(R.id.question4Box);
        option4 = (TextView) findViewById(R.id.question4BoxD);


        //set all strings
        question.setText(questions.get(questionCounter).question);
        option1.setText(questions.get(questionCounter).answer);
        option2.setText(questions.get(questionCounter).a2);
        option3.setText(questions.get(questionCounter).a3);
        option4.setText(questions.get(questionCounter).a4);

        setBg();


    }

    public void submitAnswer(View view) {


        if (quest1Box.isChecked()) {

            score++;
            questionCounter++;

            //toast
            Toast.makeText(this, "thank you for your answer:" + score, Toast.LENGTH_SHORT).show();

            //set all strings
            question.setText(questions.get(questionCounter).question);
            option1.setText(questions.get(questionCounter).answer);
            option2.setText(questions.get(questionCounter).a2);
            option3.setText(questions.get(questionCounter).a3);
            option4.setText(questions.get(questionCounter).a4);

            setBg();

            quest1Box.setChecked(false);
            quest2Box.setChecked(false);
            quest3Box.setChecked(false);
            quest4Box.setChecked(false);


        } else {
            questionCounter++;

            Toast.makeText(this, "thank you : " + score, Toast.LENGTH_SHORT).show();

            //set all strings
            question.setText(questions.get(questionCounter).question);
            option1.setText(questions.get(questionCounter).answer);
            option2.setText(questions.get(questionCounter).a2);
            option3.setText(questions.get(questionCounter).a3);
            option4.setText(questions.get(questionCounter).a4);

            quest1Box.setChecked(false);
            quest2Box.setChecked(false);
            quest3Box.setChecked(false);
            quest4Box.setChecked(false);

        }

        check();


    }

    public void setBg() {
        if (questionCounter == 0) {
            image.setImageResource(R.drawable.q1);
        }
        if (questionCounter == 1) {
            image.setImageResource(R.drawable.q2);
        }
        if (questionCounter == 2) {
            image.setImageResource(R.drawable.q3);
        }
        if (questionCounter == 3) {
            image.setImageResource(R.drawable.q4);
        }


    }

    public void check() {
        Log.d("eric", "score is " + score);
        if (questionCounter > 3) {
            //next round
            Intent i = new Intent(this, Round2Activity.class);
            i.putExtra("score", score);

            startActivity(i);


        }
    }
}
