package hitesh.asimplegame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class StageActivity extends AppCompatActivity {
    private int stageid = 0;
    private String email;
    private Button stage1;
    private Button stage2;
    private Button stage3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage);

        View[] buttons = new View[3];

        Bundle b = getIntent().getExtras();
        email=b.getString("email");
        stageid = b.getInt("stageid");

        stage1=(Button) findViewById(R.id.stage1);
        stage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stageid+=1;
                Intent I = new Intent(StageActivity.this, QuestionActivity.class);
                Bundle b = new Bundle();
                b.putInt("stageid", stageid);
                b.putString("email",email);
                b.putInt("score",0);
                I.putExtras(b);
                startActivity(I);
                finish();
            }
        });
        stage2=(Button) findViewById(R.id.stage2);
        stage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stageid+=2;
                Intent I = new Intent(StageActivity.this, QuestionActivity.class);
                Bundle b = new Bundle();
                b.putInt("stageid", stageid);
                b.putString("email",email);
                b.putInt("score",0);
                I.putExtras(b);
                startActivity(I);
                finish();
            }
        });
        stage3=(Button) findViewById(R.id.stage3);
        stage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stageid+=3;
                Intent I = new Intent(StageActivity.this, QuestionActivity.class);
                Bundle b = new Bundle();
                b.putInt("stageid", stageid);
                b.putString("email",email);
                b.putInt("score",0);
                I.putExtras(b);
                startActivity(I);
                finish();

            }
        });
        }

    }

