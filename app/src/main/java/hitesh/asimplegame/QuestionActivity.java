package hitesh.asimplegame;

/**
 * Created by H on 7/12/2015.
 */


import java.util.List;
import java.util.concurrent.TimeUnit;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;


public class QuestionActivity extends Activity {
    private static final String TAG = QuestionActivity.class.getSimpleName();

    private List<Question> questionList;
    private List<User> userList;
    private int stageid;
    private int score = 0;
    private int questionID ;
    private int life = 3; //목숨기능
    private int pass=3;
    private String email;
    private String info;

    private Question currentQ;
    private TextView txtQuestion, times, scored, stage, heart,txtpass;
    private Button button1, button2, button3,retry, btnpass;
    CounterClass timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        QuizDBOpenHelper db = new QuizDBOpenHelper(this);  // my question bank class

        Bundle b = getIntent().getExtras();
        stageid = b.getInt("stageid");
        email=b.getString("email");
        int questionIndex= getQuestionID(stageid);
        questionList = db.getAllQuestions(questionIndex);  // this will fetch all quetonall questions
        currentQ = questionList.get(questionID); // the current question
        if(stageid%10!=1){
            score=b.getInt("score");
        }
        txtQuestion = (TextView) findViewById(R.id.txtQuestion);
        // the textview in which the question will be displayed

        // the three buttons,
        // the idea is to set the text of three buttons with the options from question bank
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        retry=(Button)findViewById(R.id.reset);
        btnpass=(Button)findViewById(R.id.pass);

        // the textview in which score will be displayed
        scored = (TextView) findViewById(R.id.score);
        stage = (TextView) findViewById(R.id.stageid);
        heart = (TextView) findViewById(R.id.life);
        txtpass=(TextView) findViewById(R.id.test_pass);

        // the timer
        times = (TextView) findViewById(R.id.timers);


        // method which will set the things up for our game
        setQuestionView();
        times.setText("00:02:00");

        // A timer of 60 seconds to play for, with an interval of 1 second (1000 milliseconds)
        if(stageid/10==1) {
             timer = new CounterClass(60000, 1000);
            timer.start(); // 시간제한 점점 줄어들기 스테이지 마다 적용하면 되지않을까
        }
        else if(stageid/10==2){
            timer = new CounterClass(90000, 1000);
            timer.start();

        }
        else if(stageid/10==3){
            timer = new CounterClass(120000, 1000);
            timer.start();

        }

        scored.setText("Score : " + score); // score 0으로 설정
        heart.setText("Life: "+ life);
        stage.setText("Stage: "+ stageid%10);
        txtpass.setText("Pass: "+pass);

        // button click listeners
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // passing the button text to other method
                // to check whether the anser is correct or not
                // same for all three buttons
                getAnswer(button1.getText().toString());
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(button2.getText().toString());
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(button3.getText().toString());
            }
        });
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuestionActivity.this, QuestionActivity.class);
                Bundle b = new Bundle();
                b.putInt("stageid", stageid); // Your score
                b.putString("email",email);
                intent.putExtras(b); // Put your score to your next
                startActivity(intent);
                finish();
            }
        });
        btnpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                if(pass>0) {
                    currentQ = questionList.get(questionID);
                    setQuestionView();
                    pass--;
                    txtpass.setText("Pass: "+pass);
                }
                else{
                    Toast.makeText(getApplicationContext(),"기회를 모두 사용했습니다.",Toast.LENGTH_LONG).show();
                }
            }

        });
    }
    public int getQuestionID(int stageid){
        if(stageid==11) return 0;
        if(stageid==12) return 10;
        if(stageid==13) return 20;
        if(stageid==21) return 30;
        if(stageid==22) return 40;
        if(stageid==23) return 50;
        if(stageid==31) return 60;
        if(stageid==32) return 70;
        if(stageid==33) return 80;

        else return 0;
    }

    public void getAnswer(String AnswerString) {
        if (currentQ.getANSWER().equals(AnswerString) && life > 0) { // 문제를 맞춤과 목숨이 있음

            // if conditions matches increase the int (score) by 1
            // and set the text of the score view
            score++;
            scored.setText("Score : " + score);
        }
        else { // 문제틀렸는데 목숨이 있음
            if(life == 0){ // 목숨없음 게임 끝
                // if unlucky start activity and finish the game
                info="Game Over";
                Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);
                timer.cancel();
                // passing the int value
                Bundle b = new Bundle();
                b.putInt("id",1);
                b.putString("info",info);
                b.putInt("score", score); // Your score
                b.putString("email",email);
                b.putInt("stageid",stageid);
                intent.putExtras(b); // Put your score to your next
                startActivity(intent);
                finish();

            }
            else {
                life--;
                scored.setText("Score : " + score);
                heart.setText("Life : " + life);
            }
        }

        if(life > 0) {
            if (questionID%10 !=0) {
                // if questions are not over then do this
                currentQ = questionList.get(questionID);
                setQuestionView();
            }
            else{
                if(stageid%10<3){
                    timer.cancel();
                    Intent intent = new Intent(QuestionActivity.this, QuestionActivity.class);
                        Bundle b=new Bundle();
                        b.putInt("stageid", stageid + 1);
                        b.putInt("score",score);
                         b.putString("email",email);
                        intent.putExtras(b);
                        startActivity(intent);
                        finish();

                }
                else if(stageid%10==3){
                    info="Stage Clear";
                    timer.cancel();
                    Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("stageid",stageid);
                    b.putInt("id",1);
                    b.putString("info",info);
                    b.putInt("score", score); // Your score
                    b.putString("email",email);
                    intent.putExtras(b); // Put your score to your next
                    startActivity(intent);
                    finish();



                }
            }
        }
    }
//            else {
//                // if over do this // 다맞춤
////                Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);
////                Bundle b = new Bundle();
////                b.putInt("score", score); // Your score
////                intent.putExtras(b); // Put your score to your next
////                startActivity(intent);
////                finish();
//            }


    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("NewApi")
    public class CounterClass extends CountDownTimer
    {
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {

            times.setText("Time is up");
            info="Time Over";
            score=0;
            Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("stageid",stageid);
            b.putInt("id",1);
            b.putInt("score", score);
            b.putString("info",info);// Your score
            b.putString("email",email);
            intent.putExtras(b); // Put your score to your next
            startActivity(intent);
            finish();
        }

        @Override
        public void onTick(long millisUntilFinished) {
            long millis = millisUntilFinished;
            String hms = String.format( "%02d:%02d:%02d",
                    TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis)
                            - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
                            .toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis)
                            - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                            .toMinutes(millis)));

            Log.d(TAG, "current time: " + hms);
            times.setText(hms);
        }

    }

    private void setQuestionView() {
        // the method which will put all things together
        txtQuestion.setText(currentQ.getQUESTION());
        button1.setText(currentQ.getOPTA());
        button2.setText(currentQ.getOPTB());
        button3.setText(currentQ.getOPTC());

        questionID++;
    }
    @Override
    public void onBackPressed() {
        timer.cancel();
        super.onBackPressed();
    }



}
