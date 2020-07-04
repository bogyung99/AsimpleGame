package hitesh.asimplegame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private Button btnLogOut;
    private Button btnEasy;
    private Button btnNormal;
    private Button btnHard;
    private Button btnRanking;
    private Button btnRhythm;
    private String email;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=getIntent();
        Bundle b = intent.getExtras();
        email= b.getString("email");


        btnLogOut = (Button) findViewById(R.id.logout);
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseAuth.getInstance().signOut();
                Intent I = new Intent(MainActivity.this, LogInActivity.class);
                startActivity(I);

            }
        });

        btnEasy = (Button) findViewById(R.id.button1);
        btnEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent I = new Intent(MainActivity.this, StageActivity.class);
                Bundle b = new Bundle();
                b.putInt("stageid", 10);
                b.putString("email",email);
                b.putInt("score",0);
                I.putExtras(b);
                startActivity(I);
            }
        });
        btnNormal = (Button) findViewById(R.id.button2);
        btnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent I = new Intent(MainActivity.this, StageActivity.class);
                Bundle b = new Bundle();
                b.putInt("stageid", 20);
                b.putString("email",email);
                I.putExtras(b);
                startActivity(I);
            }
        });
        btnHard = (Button) findViewById(R.id.button3);
        btnHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent I = new Intent(MainActivity.this, StageActivity.class);
                Bundle b = new Bundle();
                b.putInt("stageid", 30);
                b.putString("email",email);
                I.putExtras(b);
                startActivity(I);
            }
        });

        btnRhythm = (Button) findViewById(R.id.button4);
        btnRhythm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent I = new Intent(getApplicationContext(), RhythmActivity.class);
                Bundle b = new Bundle();
                b.putString("email",email);
                I.putExtras(b);
                startActivity(I);

            }
        });

        btnRanking = (Button) findViewById(R.id.button5);
        btnRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent I = new Intent(MainActivity.this, RankingActivity.class);
                Bundle b=new Bundle();
                b.putString("level","easy");
                I.putExtras(b);
                startActivity(I);

            }
        });
    }

}
