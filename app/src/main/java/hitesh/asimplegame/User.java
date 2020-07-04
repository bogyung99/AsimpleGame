package hitesh.asimplegame;


import java.util.HashMap;
import java.util.Map;

public class User {
    private int ID,  scoreE, scoreN,scoreH,scoreR, rank;
    private String name, email;

    public User(){
        ID=0; rank=0; name=""; email="";
        scoreE=0; scoreN=0; scoreH=0; scoreR=0;
    }
    public User(int rank,String name, int scoreE,int scoreN,int scoreH,int scoreR,String email){
        this.rank=rank;
        this.name=name;
        this.scoreE=scoreE;
        this.scoreN=scoreN;
        this.scoreH=scoreH;
        this.scoreR=scoreR;
        this.email=email;
    }

    public String getUserName(){
        return name;
    }
    public int getEasyScore(){
        return scoreE;
    }
    public int getNormalScore(){
        return scoreN;
    }
    public int getHardScore(){
        return scoreH;
    }
    public int getRhythmScore(){
        return scoreR;
    }
    public int getUserRank(){
        return rank;
    }
    public String getUserEmail(){
        return email;
    }
    public int getUserID() {
        return ID;
    }
    public void setUserID(int ID){
        this.ID=ID;
    }
    public void setUserEmail(String email){
        this.email=email;
    }
    public void setUserName(String name){
        this.name=name;
    }
    public void setEasyScore(int scoreE){
        this.scoreE=scoreE;
    }
    public void setNormalScore(int scoreN){
        this.scoreN=scoreN;
    }
    public void setHardScore(int scoreH){
        this.scoreH=scoreH;
    }
    public void setRhythmScore(int scoreR){
        this.scoreR=scoreR;
    }
    public void setUserRank(int rank){
        this.rank=rank;
    }
//    public Map<String,Object> toMap(){
//        HashMap<String, Object> result=new HashMap<>();
//        result.put("id",id);
//        result.put("user",name);
//        result.put("score",score);
//        return result;
//    }
}
