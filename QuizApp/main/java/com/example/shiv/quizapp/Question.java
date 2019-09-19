package com.example.shiv.quizapp;

public class Question {
    private int mAnswerResId;
    private boolean mAnswerTrue;

    public Question(int mAnswerResId, boolean mAnswerTrue) {
        this.mAnswerResId = mAnswerResId;
        this.mAnswerTrue = mAnswerTrue;
    }

    public int getmAnswerResId() {
        return mAnswerResId;
    }

    public boolean ismAnswerTrue() {
        return mAnswerTrue;
    }


}
