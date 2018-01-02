package com.example.eric.quizapp;

/**
 * Created by eric on 01/01/2018.
 */

public class Question {

    public String question;
    public String answer;
    public String a2;
    public String a3;
    public String a4;

    public Question(String question, String answer, String a2, String a3, String a4) {
        this.question = question;
        this.answer = answer;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;

    }

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public Question(String question, String answer, String a2) {
        this.question = question;
        this.answer = answer;
        this.a2 = a2;
    }

    public String getAnswer() {
        return this.answer;
    }
}
