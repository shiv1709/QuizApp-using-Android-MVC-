package com.example.shiv.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

//Here in this App,MainActivity is controller here acc. to MVC arch.
//A Controller is a focus point that allows us to connect everything else around
//Views are basically Layouts (here in this app,activity_main.xml is View part acc. to MVC arch. )

/*
MVC has three layers: Model,View(Layouts) and Controller
The adv. of MVC arch. is that if you make changes in one Layer ,it will not affect other Layers
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mNextButton;
    private ImageButton mPreviousButton;
    private TextView mQueTextView;
    public String TAG = "Question Class" ;

    private int currQueArrayIndex = 0;

    private Question[] mQuestionsArray = new Question[]{
            new Question(R.string.earth_que,false),
            new Question(R.string.sun_que,true),
            new Question(R.string.venus_que,true),
            new Question(R.string.jupiter_que,false),
            new Question(R.string.eclipse_que,false),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTrueButton = (Button) findViewById(R.id.true_btn);
        mFalseButton = (Button) findViewById(R.id.false_btn);
        mNextButton = (ImageButton) findViewById(R.id.next_img_btn);
        mPreviousButton = (ImageButton) findViewById(R.id.previous_img_btn);
        mQueTextView = (TextView) findViewById(R.id.que_text_view);

        bindToViews();
        updateQuestion();
    }

    private void bindToViews() {

        //bind all views here having onClickListener
        mTrueButton.setOnClickListener(this);//register our buttons here
        mFalseButton.setOnClickListener(this);
        mNextButton.setOnClickListener(this);
        mPreviousButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){ //every view has an id assoiciated with it in android

            case R.id.true_btn :
                checkAnswer(true);
                /*Toast.makeText(MainActivity.this,
                        "True :That's correct answer",
                        Toast.LENGTH_SHORT).show();*/
                break;
            case R.id.false_btn :
                checkAnswer(false);
                /*Toast.makeText(MainActivity.this,
                        "False :That's incorrect answer",
                        Toast.LENGTH_SHORT).show();*/
                break;
            case R.id.next_img_btn :
                //Go to next que
                if(currQueArrayIndex< mQuestionsArray.length -1)
                {
                    currQueArrayIndex++;
                    updateQuestion();
                }
                else {
                    Toast.makeText(MainActivity.this,
                            "Hurray !! All question completed now",Toast.LENGTH_SHORT).show();
                }
                Log.d(TAG,"current que index " + currQueArrayIndex);
                break;

            case R.id.previous_img_btn :
                //Go to previous que
                Log.d(TAG,"current que index " + currQueArrayIndex);
                if(currQueArrayIndex == 0){
                    Toast.makeText(MainActivity.this,
                            "Reached starting question of Quiz",Toast.LENGTH_SHORT).show();
                }
                else {
                    currQueArrayIndex--;
                    updateQuestion();
                }

                Log.d(TAG,"current que index " + currQueArrayIndex);
                break;
        }
    }

    private void updateQuestion(){
        mQueTextView.setText(mQuestionsArray[currQueArrayIndex].getmAnswerResId());
        Log.d(TAG,"index" + mQuestionsArray[currQueArrayIndex].getmAnswerResId());
    }

    private void checkAnswer(boolean userAns){

        boolean ansIsTrue = mQuestionsArray[currQueArrayIndex].ismAnswerTrue();
        int toastMessageId = 0 ;

        if(userAns == ansIsTrue){
            toastMessageId = R.string.correct_ans;
        }
        else{
            toastMessageId = R.string.incorrect_ans;
        }
        Toast.makeText(MainActivity.this,
                toastMessageId,Toast.LENGTH_SHORT).show();
    }
}
