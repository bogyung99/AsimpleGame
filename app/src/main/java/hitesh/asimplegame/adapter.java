package hitesh.asimplegame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class adapter extends BaseAdapter {
    Context context = null;
    LayoutInflater layoutInflater = null;
    List<User> userList;
    private int level;

    public adapter(Context context,List<User> userList, int level){
        this.context=context;
        this.userList=userList;
        layoutInflater=LayoutInflater.from(this.context);
        this.level=level;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public User getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.adapter, null);

        TextView rank = (TextView)view.findViewById(R.id.rank);
        TextView name = (TextView)view.findViewById(R.id.name);
        TextView score = (TextView)view.findViewById(R.id.score);

        rank.setText(String.valueOf(userList.get(position).getUserRank()));
        name.setText(userList.get(position).getUserName());
        if(level==1) {
            score.setText(String.valueOf(userList.get(position).getEasyScore()));
        }
        else if(level==2) {
            score.setText(String.valueOf(userList.get(position).getNormalScore()));
        }
        else if(level==3) {
            score.setText(String.valueOf(userList.get(position).getHardScore()));
        }
        else if(level==4) {
            score.setText(String.valueOf(userList.get(position).getRhythmScore()));
        }
        return view;

//       final int a=position;
//       final Context context=parent.getContext();
//
//       if(convertView==null){
//           LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//           convertView = inflater.inflate(R.layout.content_format, parent, false);
//       }
//       User user=userList.get(position);
//
//        View view=layoutInflater.inflate(R.layout.listview_custom,null);
//
//
//        return null;
    }
//    public void addItem(int rank,String name, int score) {
//        User user = new User();
//        user.setUserRank(rank);
//        user.setUserName(name);
//        user.setUserScore(score);
//        userList.add(user);
//    }
}
