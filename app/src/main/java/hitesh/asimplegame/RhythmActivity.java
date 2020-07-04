package hitesh.asimplegame;

import java.util.List;
import java.util.concurrent.TimeUnit;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.common.server.converter.StringToIntConverter;

public class RhythmActivity extends AppCompatActivity {
    private static final String TAG = RhythmActivity.class.getSimpleName();

    private List<Question> questionList;
    private int score = 0;
    private int soundId;
    private int questionID = 0;
    private int life = 3; //목숨기능
    private static boolean now = false; // 박자알려주기
    private String info="";

    private static String gameTimes = ""; // 시간 경과

    private Question currentQ;
    private TextView txtQuestion, times, scored, heart;
    private Button button1, button2, button3;
    private ImageView colorImageView;
    private String email;


    private static AnswerClickSound answerClickSound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rhythm);

        Intent intent=getIntent();
        Bundle b = intent.getExtras();
        email = b.getString("email");

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.default_bgm); // 메인 음악 틀기

        mediaPlayer.start();

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.stop();
                mp.release();
            }
        });

        answerClickSound = new AnswerClickSound(this);

        QuizDBOpenHelper db = new QuizDBOpenHelper(this);  // my question bank class
        questionList = db.getAllQuestions();  // this will fetch all quetonall questions
        currentQ = questionList.get(questionID); // the current question

        txtQuestion = (TextView) findViewById(R.id.txtQuestion);
        // the textview in which the question will be displayed

        // the three buttons,
        // the idea is to set the text of three buttons with the options from question bank
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        // the textview in which score will be displayed
        scored = (TextView) findViewById(R.id.score);

        // the timer
        times = (TextView) findViewById(R.id.timers);

        heart = (TextView) findViewById(R.id.life);

        colorImageView = (ImageView) findViewById(R.id.color); // 리듬알려주는 원

        // method which will set the things up for our game
        setQuestionView();
        times.setText("00:02:00");

        // A timer of 60 seconds to play for, with an interval of 1 second (1000 milliseconds)
        RhythmActivity.CounterClass timer = new RhythmActivity.CounterClass(120000, 1000);
        timer.start(); // 시간제한 점점 줄어들기

        scored.setText("Score : " + score); // score 0으로 설정
        heart.setText("Life: " + life);

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
    }

    public void getAnswer(String AnswerString) {
        if (now) {
            if (currentQ.getANSWER().equals(AnswerString) && life > 0) { // 문제를 맞춤과 목숨이 있음
                // if conditions matches increase the int (score) by 1
                // and set the text of the score view
                score++;
                scored.setText("Score : " + score);
            } else {
                Log.d("RhythmActivity", "----- Called 1 -----");
                answerClickSound.playSound(); // 리듬이 맞아도 답이 틀리면 땡

                life--;

                if (life == 0) { // 목숨없음 게임 끝
                    // if unlucky start activity and finish the game
                    info="Game Over";
                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    // passing the int value
                    Bundle b = new Bundle();
                    b.putInt("score", score); // Your score
                    b.putString("info", info);
                    b.putInt("stageid",40);
                    b.putString("email",email);
                    intent.putExtras(b); // Put your score to your next
                    startActivity(intent);
                    finish();
                } else {
                    scored.setText("Score : " + score);
                    heart.setText("Life : " + life);
                }
            }
        } else {
            Log.d("RhythmActivity", "----- Called 2 -----");
            answerClickSound.playSound(); // 답이 맞든 틀리든 리듬이 안맞으면 땡

            life--;

            if (life == 0) { // 목숨없음 게임 끝
                // if unlucky start activity and finish the game
                info="Game Over";
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                // passing the int value
                Bundle b = new Bundle();
                b.putInt("score", score); // Your score
                b.putString("info", info);
                b.putString("email",email);
                b.putInt("stageid",40);
                intent.putExtras(b); // Put your score to your next
                startActivity(intent);
                finish();
            } else {
                scored.setText("Score : " + score);
                heart.setText("Life : " + life);
            }
        }

        if (life > 0) {
            if (questionID < 40) {
                // if questions are not over then do this
                currentQ = questionList.get(questionID);
                setQuestionView();
            } else {
                // if over do this // 다맞춤
                info="Stage Clear";
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                Bundle b = new Bundle();
                b.putInt("score", score); // Your score
                b.putString("info", info);
                b.putString("email",email);
                b.putInt("stageid",40);
                intent.putExtras(b); // Put your score to your next
                startActivity(intent);
                finish();
            }
        }
    }


    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("NewApi")
    public class CounterClass extends CountDownTimer {
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            times.setText("Time is up");
            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            long millis = millisUntilFinished;
            String hms = String.format("%02d:%02d:%02d",
                    TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis)
                            - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
                            .toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis)
                            - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                            .toMinutes(millis)));

            Log.d(TAG, "current time: " + hms);

            gameTimes = hms.substring(6, 8);
            times.setText(hms);

            if ((1 + Integer.parseInt(gameTimes)) % 4 == 0) {
                colorImageView.setSelected(true);
                now = true;
            } else {
                colorImageView.setSelected(false);
                now = false;
            }

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
}