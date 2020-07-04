package hitesh.asimplegame;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class QuizDBOpenHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "mathsone";
    // tasks table name
    private static final String TABLE_QUEST = "quest";
    // tasks Table Columns names
    private static final String TABLE_USER = "user";

    private static final String KEY_ID = "qid";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; // correct option
    private static final String KEY_OPTA = "opta"; // option a
    private static final String KEY_OPTB = "optb"; // option b
    private static final String KEY_OPTC = "optc"; // option c

    private static final String KEY_SCORE1="scoreE";
    private static final String KEY_SCORE2="scoreN";
    private static final String KEY_SCORE3="scoreH";
    private static final String KEY_SCORE4="scoreR";
    private static final String KEY_NAME="name";
    private static final String KEY_RANK="rank";
    private static final String KEY_EMAIL="email";

    private SQLiteDatabase database;

    public QuizDBOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        database = db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";
        String sql_user = "CREATE TABLE IF NOT EXISTS " + TABLE_USER + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_RANK + " INTEGER, " + KEY_NAME + " TEXT, " + KEY_SCORE1
                + " INTEGER, " + KEY_SCORE2 + " INTEGER, " + KEY_SCORE3
                + " INTEGER, " + KEY_SCORE4 + " INTEGER, " + KEY_EMAIL + " TEXT)";
        db.execSQL(sql);
        db.execSQL(sql_user);
        addQuestion();
        // db.close();
    }

    private void addQuestion() {
        Question q1 = new Question("5+2 = ?", "7", "8", "6", "7");
        addQuestion(q1);
        Question q2 = new Question("2+18 = ?", "18", "19", "20", "20");
        addQuestion(q2);
        Question q3 = new Question("10-3 = ?", "6", "7", "8", "7");
        addQuestion(q3);
        Question q4 = new Question("5+7 = ?", "12", "13", "14", "12");
        addQuestion(q4);
        Question q5 = new Question("3-1 = ?", "1", "3", "2", "2");
        addQuestion(q5);
        Question q6 = new Question("0+1 = ?", "1", "0", "10", "1");
        addQuestion(q6);
        Question q7 = new Question("9-9 = ?", "0", "9", "1", "0");
        addQuestion(q7);
        Question q8 = new Question("3+6 = ?", "8", "7", "9", "9");
        addQuestion(q8);
        Question q9 = new Question("1+5 = ?", "6", "7", "5", "6");
        addQuestion(q9);
        Question q10 = new Question("7-5 = ?", "3", "2", "6", "2");
        addQuestion(q10);

        Question q11 = new Question("7-2 = ?", "7", "6", "5", "5");
        addQuestion(q11);
        Question q12 = new Question("3+5 = ?", "8", "7", "5", "8");
        addQuestion(q12);
        Question q13 = new Question("0+6 = ?", "7", "6", "5", "6");
        addQuestion(q13);
        Question q14 = new Question("12-10 = ?", "1", "2", "3", "2");
        addQuestion(q14);
        Question q15 = new Question("12+2 = ?", "14", "15", "16", "14");
        addQuestion(q15);
        Question q16 = new Question("2-1 = ?", "2", "1", "0", "1");
        addQuestion(q16);
        Question q17 = new Question("6-6 = ?", "6", "12", "0", "0");
        addQuestion(q17);
        Question q18 = new Question("5-1 = ?", "4", "3", "2", "4");
        addQuestion(q18);
        Question q19 = new Question("4+2 = ?", "6", "7", "5", "6");
        addQuestion(q19);
        Question q20 = new Question("5+1 = ?", "6", "7", "5", "6");
        addQuestion(q20);

        Question q21 = new Question("5-4 = ?", "5", "4", "1", "1");
        addQuestion(q21);
        Question q22 = new Question("30-20 = ?", "5", "4", "10", "10");
        addQuestion(q22);
        Question q23 = new Question("55-41 = ?", "5", "14", "1", "14");
        addQuestion(q23);
        Question q24 = new Question("25-14 = ?", "9", "4", "11", "11");
        addQuestion(q24);
        Question q25 = new Question("15-14 = ?", "5", "4", "1", "1");
        addQuestion(q25);
        Question q26 = new Question("50-24 = ?", "26", "4", "1", "26");
        addQuestion(q26);
        Question q27 = new Question("20-16 = ?", "5", "4", "1", "4");
        addQuestion(q27);
        Question q28 = new Question("15+3 = ?", "5", "4", "18", "18");
        addQuestion(q28);
        Question q29 = new Question("8-4 = ?", "5", "4", "1", "4");
        addQuestion(q29);
        Question q30 = new Question("23-17 = ?", "5", "6", "1", "6");
        addQuestion(q30);

        Question q31 = new Question("5*4 = ?", "21", "30", "20", "20");
        addQuestion(q31);
        Question q32 = new Question("2*6 = ?", "15", "14", "12", "12");
        addQuestion(q32);
        Question q33 = new Question("3*7 = ?", "25", "27", "21", "21");
        addQuestion(q33);
        Question q34 = new Question("6*4 = ?", "15", "24", "18", "24");
        addQuestion(q34);
        Question q35 = new Question("9*2 = ?", "18", "14", "11", "18");
        addQuestion(q35);
        Question q36 = new Question("7*8 = ?", "56", "44", "51", "56");
        addQuestion(q36);
        Question q37 = new Question("5*7 = ?", "12", "35", "9", "35");
        addQuestion(q37);
        Question q38 = new Question("2*3 = ?", "6", "4", "12", "6");
        addQuestion(q38);
        Question q39 = new Question("3*8 = ?", "25", "24", "21", "24");
        addQuestion(q39);
        Question q40 = new Question("8*4 = ?", "27", "32", "30", "32");
        addQuestion(q40);

        Question q41 = new Question("15*4 = ?", "70", "50", "60", "60");
        addQuestion(q41);
        Question q42 = new Question("11*12 = ?", "142", "132", "122", "132");
        addQuestion(q42);
        Question q43 = new Question("15*16 = ?", "250", "240", "260", "240");
        addQuestion(q43);
        Question q44 = new Question("22*4 = ?", "88", "68", "78", "88");
        addQuestion(q44);
        Question q45 = new Question("45*3 = ?", "125", "145", "135", "135");
        addQuestion(q45);
        Question q46 = new Question("51*3 = ?", "153", "163", "143", "153");
        addQuestion(q46);
        Question q47 = new Question("19*5 = ?", "85", "95", "105", "95");
        addQuestion(q47);
        Question q48 = new Question("34*4 = ?", "146", "126", "136", "136");
        addQuestion(q48);
        Question q49 = new Question("12*13 = ?", "156", "146", "166", "156");
        addQuestion(q49);
        Question q50 = new Question("38*3 = ?", "154", "114", "124", "114");
        addQuestion(q50);

        Question q51 = new Question("56/7 = ?", "8", "4", "6", "8");
        addQuestion(q51);
        Question q52 = new Question("54/9 = ?", "5", "6", "7", "6");
        addQuestion(q52);
        Question q53 = new Question("48/4 = ?", "13", "12", "11", "12");
        addQuestion(q53);
        Question q54 = new Question("78/6 = ?", "15", "14", "13", "13");
        addQuestion(q54);
        Question q55 = new Question("78/3 = ?", "25", "26", "24", "26");
        addQuestion(q55);
        Question q56 = new Question("28/7 = ?", "5", "4", "1", "4");
        addQuestion(q56);
        Question q57 = new Question("32/8 = ?", "4", "5", "6", "4");
        addQuestion(q57);
        Question q58 = new Question("52/4 = ?", "15", "14", "13", "13");
        addQuestion(q58);
        Question q59 = new Question("85/5 = ?", "15", "16", "17", "17");
        addQuestion(q59);
        Question q60 = new Question("96/16 = ?", "6", "7", "5", "6");
        addQuestion(q60);

        Question q61 = new Question("2+5-4 = ?", "7", "6", "3", "3");
        addQuestion(q61);
        Question q62 = new Question("6-5+8 = ?", "5", "8", "9", "9");
        addQuestion(q62);
        Question q63 = new Question("9+6-2 = ?", "15", "14", "13", "13");
        addQuestion(q63);
        Question q64 = new Question("2+4-3 = ?", "5", "4", "3", "3");
        addQuestion(q64);
        Question q65 = new Question("6-4+8 = ?", "10", "11", "12", "10");
        addQuestion(q65);
        Question q66 = new Question("5+9-6 = ?", "5", "8", "7", "8");
        addQuestion(q66);
        Question q67 = new Question("5-9+5 = ?", "5", "4", "1", "1");
        addQuestion(q67);
        Question q68 = new Question("4+2-3 = ?", "5", "3", "1", "3");
        addQuestion(q68);
        Question q69 = new Question("8+6-1 = ?", "13", "14", "15", "13");
        addQuestion(q69);
        Question q70 = new Question("7-9+6 = ?", "5", "4", "3", "4");
        addQuestion(q70);

        Question q71 = new Question("5*2-4 = ?", "6", "4", "5", "6");
        addQuestion(q71);
        Question q72 = new Question("2*9-6 = ?", "15", "14", "12", "12");
        addQuestion(q72);
        Question q73 = new Question("9/3+6 = ?", "9", "8", "7", "9");
        addQuestion(q73);
        Question q74 = new Question("6*4-8 = ?", "15", "16", "17", "16");
        addQuestion(q74);
        Question q75 = new Question("4+2*6 = ?", "16", "12", "14", "16");
        addQuestion(q75);
        Question q76 = new Question("9-4*2 = ?", "5", "4", "1", "1");
        addQuestion(q76);
        Question q77 = new Question("2+6*5 = ?", "35", "34", "32", "32");
        addQuestion(q77);
        Question q78 = new Question("2*7-6 = ?", "5", "8", "6", "8");
        addQuestion(q78);
        Question q79 = new Question("1+6*2 = ?", "15", "14", "13", "13");
        addQuestion(q79);
        Question q80 = new Question("45/5-4 = ?", "5", "4", "6", "5");
        addQuestion(q80);

        Question q81 = new Question("5*4/2 = ?", "15", "10", "12", "10");
        addQuestion(q81);
        Question q82 = new Question("6/2*6 = ?", "16", "17", "18", "18");
        addQuestion(q82);
        Question q83 = new Question("2*6/3 = ?", "5", "4", "3", "4");
        addQuestion(q83);
        Question q84 = new Question("15/3*3 = ?", "15", "14", "13", "15");
        addQuestion(q84);
        Question q85 = new Question("16*3/4 = ?", "15", "14", "12", "12");
        addQuestion(q85);
        Question q86 = new Question("6*4/3 = ?", "5", "7", "8", "8");
        addQuestion(q86);
        Question q87 = new Question("16/4*3 = ?", "15", "12", "14", "12");
        addQuestion(q87);
        Question q88 = new Question("56/8*2 = ?", "15", "14", "16", "14");
        addQuestion(q88);
        Question q89 = new Question("8*4/16 = ?", "5", "4", "2", "2");
        addQuestion(q89);
        Question q90 = new Question("9*4/2 = ?", "16", "17", "18", "18");
        addQuestion(q90);



    }
    public void addUser(){
        User user=new User(0,"jceianv",0,0,0,0,"ajcoiewg");
        addUser(user);
    }

    public void addUser(User user){
        database = this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_RANK,user.getUserRank());
        values.put(KEY_NAME,user.getUserName());
        values.put(KEY_SCORE1,user.getEasyScore());
        values.put(KEY_SCORE2,user.getNormalScore());
        values.put(KEY_SCORE3,user.getHardScore());
        values.put(KEY_SCORE4,user.getRhythmScore());
        values.put(KEY_EMAIL,user.getUserEmail());

        database.insert(TABLE_USER,null,values);
    }
    public boolean isUser(User user){ //이름 중복된 유저 있는지 확인
        addUser();
        String name=user.getUserName();
        boolean check=true;
        Cursor cursor=database.rawQuery(" SELECT * FROM " + TABLE_USER,null);
        if(cursor.moveToFirst()){
            do{
                if(name==cursor.getString(2)){
                    check=false;
                }
            }while(cursor.moveToNext());
        }
        database.delete(TABLE_USER,"name=?",new String[] {"jceianv"});
        return check;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        // Create tables again
        onCreate(db);
    }

    // Adding new question
    public void addQuestion(Question quest) {
        // SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());

        // Inserting Row
        database.insert(TABLE_QUEST, null, values);
    }
    public void updateUser( String email,int score, int level){
//        int temp = 0;

        database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        if(level==1){
            values.put("scoreE", score);
        }
        else if(level==2){
            values.put("scoreN", score);
        }
        else if(level==3){
            values.put("scoreH", score);
        }
        else if(level==4){
            values.put("scoreR",score);
        }

        String emailAr[]={email};
        database.update(TABLE_USER,values," email=? ",emailAr);
        }
//        score+=temp;
//        Log.d(TAG,"Update Data"+score);
//        database = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put("score", score);
//
//        String emailAr[]={email};
//
//     int n= database.update(TABLE_USER,values," email=? ",emailAr);
//        Log.d(TAG,"n: "+n);

    public List<User> getEasyRank(){
        List<User> userList=new ArrayList<>();
        String selectQuery="SELECT * FROM "+ TABLE_USER +" ORDER BY "+ KEY_SCORE1 +" DESC ";
        database=this.getReadableDatabase();
        int rank=1;
        Cursor cursor=database.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{
                User user=new User();
                user.setUserID(cursor.getInt(0));
                user.setUserName(cursor.getString(2));
                user.setEasyScore(cursor.getInt(3));
                user.setUserRank(rank);
                user.setNormalScore(cursor.getInt(4));
                user.setHardScore(cursor.getInt(5));
                user.setRhythmScore(cursor.getInt(6));
                user.setUserEmail(cursor.getString(7));
                userList.add(user);
                rank++;
            }while(cursor.moveToNext());
        }
        return userList;
    }
    public List<User> getNormalRank(){
        List<User> userList=new ArrayList<>();
        String selectQuery="SELECT * FROM "+ TABLE_USER +" ORDER BY "+ KEY_SCORE2 +" DESC ";
        database=this.getReadableDatabase();
        int rank=1;
        Cursor cursor=database.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{
                User user=new User();
                user.setUserID(cursor.getInt(0));
                user.setUserName(cursor.getString(2));
                user.setEasyScore(cursor.getInt(3));
                user.setUserRank(rank);
                user.setNormalScore(cursor.getInt(4));
                user.setHardScore(cursor.getInt(5));
                user.setRhythmScore(cursor.getInt(6));
                user.setUserEmail(cursor.getString(7));
                userList.add(user);
                rank++;
            }while(cursor.moveToNext());
        }
        return userList;
    }
    public List<User> getHardRank(){
        List<User> userList=new ArrayList<>();
        String selectQuery="SELECT * FROM "+ TABLE_USER +" ORDER BY "+ KEY_SCORE3 +" DESC ";
        database=this.getReadableDatabase();
        int rank=1;
        Cursor cursor=database.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{
                User user=new User();
                user.setUserID(cursor.getInt(0));
                user.setUserName(cursor.getString(2));
                user.setEasyScore(cursor.getInt(3));
                user.setUserRank(rank);
                user.setNormalScore(cursor.getInt(4));
                user.setHardScore(cursor.getInt(5));
                user.setRhythmScore(cursor.getInt(6));
                user.setUserEmail(cursor.getString(7));
                userList.add(user);
                rank++;
            }while(cursor.moveToNext());
        }
        return userList;
    }
    public List<User> getRhythmRank(){
        List<User> userList=new ArrayList<>();
        String selectQuery="SELECT * FROM "+ TABLE_USER +" ORDER BY "+ KEY_SCORE4 +" DESC ";
        database=this.getReadableDatabase();
        int rank=1;
        Cursor cursor=database.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{
                User user=new User();
                user.setUserID(cursor.getInt(0));
                user.setUserName(cursor.getString(2));
                user.setRhythmScore(cursor.getInt(6));
                user.setUserRank(rank);
                user.setUserEmail(cursor.getString(7));
                userList.add(user);
                rank++;
            }while(cursor.moveToNext());
        }
        return userList;
    }

    public List<Question> getAllQuestions(int n) {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if(cursor.moveToPosition(n)){
            for(int i=0;i<10;i++){
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));

                quesList.add(quest);
                cursor.moveToNext();
            }
        }
        // return quest list
        return quesList;
    }

    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));

                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }
}
