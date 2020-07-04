package hitesh.asimplegame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;


public class ResultActivity extends Activity {
	QuizDBOpenHelper db = new QuizDBOpenHelper(this);
	private int stageid;
	private int id;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);

		TextView textInfo=(TextView)findViewById(R.id.textinfo);
		TextView textResult = (TextView) findViewById(R.id.textResult);

		Bundle b = getIntent().getExtras();
		int score = b.getInt("score");
		stageid=b.getInt("stageid");
		id=b.getInt("id");
		String email=b.getString("email");
		String info=b.getString("info");
		int level=stageid/10;
		db.updateUser(email,score,level);
		textInfo.setText(info);
        textResult.setText("Your score is " + " " + score + ". Thanks for playing my game.");
	}
	public void playagain(View o) {
		if(id==1) {
			Intent intent = new Intent(this, QuestionActivity.class);
			Bundle b = new Bundle();
			int score = 0;
			b.putInt("stageid", stageid);
			b.putInt("score", score); // Your score
			intent.putExtras(b);
			startActivity(intent);
			finish();
		}
		else {
			Intent intent = new Intent(this, RhythmActivity.class);
			startActivity(intent);
			finish();
		}
	}
	public void rank(View o){
		Intent intent=new Intent(this, RankingActivity.class);
		Bundle b=new Bundle();
		if(stageid/10==1){
			b.putString("level","easy");
		}
		else if(stageid/10==2){
			b.putString("level","normal");
		}
		else if(stageid/10==3){
			b.putString("level","hard");
		}
		else if(stageid/10==4){
			b.putString("level","rhythm");
		}
		intent.putExtras(b);
		startActivity(intent);
		finish();
	}
}