package hitesh.asimplegame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class RankingActivity extends AppCompatActivity {

    List<User> userList;
    private Button btnEasy;
    private Button btnNormal;
    private Button btnHard;
    private Button btnRhythm;
    private TextView ranking;

    QuizDBOpenHelper db = new QuizDBOpenHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        ranking = (TextView) findViewById(R.id.textView_ranking);
      QuizDBOpenHelper db = new QuizDBOpenHelper(this);
        Bundle b = getIntent().getExtras();
        String level = b.getString("level");
      if(level.equals("easy")) {
          userList = db.getEasyRank();
          ListView listView = (ListView) findViewById(R.id.rank_list);
          final adapter adapt = new adapter(this, (ArrayList<User>) userList,1);
          listView.setAdapter(adapt);
          ranking.setText("Easy Ranking");
      }
        else if(level.equals("normal")) {
            userList = db.getNormalRank();
            ListView listView = (ListView) findViewById(R.id.rank_list);
            final adapter adapt = new adapter(this, (ArrayList<User>) userList,2);
            listView.setAdapter(adapt);
          ranking.setText("Normal Ranking");
        }
        else if(level.equals("hard")) {
            userList = db.getHardRank();
            ListView listView = (ListView) findViewById(R.id.rank_list);
            final adapter adapt = new adapter(this, (ArrayList<User>) userList,3);
            listView.setAdapter(adapt);
          ranking.setText("Hard Ranking");
        }
        else if(level.equals("rhythm")) {
            userList = db.getRhythmRank();
            ListView listView = (ListView) findViewById(R.id.rank_list);
            final adapter adapt = new adapter(this, (ArrayList<User>) userList,4);
            listView.setAdapter(adapt);
          ranking.setText("Rhythm Ranking");
        }

        btnEasy = (Button) findViewById(R.id.btneasy);
        btnEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(RankingActivity.this, RankingActivity.class);
                Bundle b=new Bundle();
                b.putString("level","easy");
                I.putExtras(b);
                startActivity(I);
                finish();
            }
        });
        btnNormal = (Button) findViewById(R.id.btnnormal);
        btnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(RankingActivity.this, RankingActivity.class);
                Bundle b=new Bundle();
                b.putString("level","normal");
                I.putExtras(b);
                startActivity(I);
                finish();
            }
        });
        btnHard = (Button) findViewById(R.id.btnhard);
        btnHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(RankingActivity.this, RankingActivity.class);
                Bundle b=new Bundle();
                b.putString("level","hard");
                I.putExtras(b);
                startActivity(I);
                finish();
            }
        });
        btnRhythm = (Button) findViewById(R.id.btnrhythm);
        btnRhythm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(RankingActivity.this, RankingActivity.class);
                Bundle b=new Bundle();
                b.putString("level","rhythm");
                I.putExtras(b);
                startActivity(I);
                finish();

            }
        });

    }

//        int size=userList.size();
//        if (size > 10) size = 10;
//
//        for (int i = 0; i < size; i++) {
//            User user = userList.get(i);
//
//            adapt.addItem(user.getUserRank(),user.getUserName(), user.getUserScore());//순위, 유저이름, 스코어
//        }
//        listView.setAdapter(adapt);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                      Toast.makeText(getApplicationContext(),adapt.getItem(position).getUserName(), Toast.LENGTH_LONG).show();
//            }
//        });


//        ArrayAdapter<String> rankAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,userList);
//
//        listview=(ListView) findViewById(R.id.rank_list);
//         listview.setAdapter(rankAdapter);



    }



