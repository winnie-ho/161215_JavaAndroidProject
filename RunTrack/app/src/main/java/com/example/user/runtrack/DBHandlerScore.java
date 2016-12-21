package com.example.user.runtrack;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by user on 16/12/2016.
 */
public class DBHandlerScore extends SQLiteOpenHelper {
    //Database Version
    private static final int DATABASE_VERSION = 1;
    //Database Name
    private static final String DATABASE_NAME = "scoreTrack";
    //Table name
    private static final String TABLE_SCORES = "scores";
    //Runs table column names
    private static final String KEY_ID = "id";
    private static final String KEY_SCORE = "points";

    public DBHandlerScore(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    /*    CREATE TABLE scores(
          id INTEGER PRIMARY KEY,
          score INTEGER
    )
*/
        String CREATE_TABLE = "CREATE TABLE " + TABLE_SCORES + "(" + KEY_ID + " INTEGER PRIMARY KEY, "
                + KEY_SCORE + " INTEGER )";
        db.execSQL(CREATE_TABLE);
    }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            //Drop older table if Runs table exists;

            db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCORES);
            //Create the Runs table again
            onCreate(db);
        }
    //SQLRunner
        private void SQLrunner(String sql){
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL(sql);
        }

    //CRUD METHODS
        public void addScore(Score score){
            int points = score.getScore();

            String sql = "INSERT INTO " + TABLE_SCORES + " (" + KEY_SCORE + ") VALUES (" +
                    Integer.toString(points) + "')";
            SQLrunner(sql);
        }

        public void updateScore(Score score) {
            int id = score.getId();
            int points = score.getScore();

            String sql = "UPDATE " + TABLE_SCORES + " SET "
                    + KEY_SCORE + " = " + score + "' WHERE " + KEY_ID + " = " + id;
            Log.d("Running SQL: ",sql);
            SQLrunner(sql);
        }



        public Score getScore(int id){
            String sql = "SELECT * FROM " + TABLE_SCORES + " WHERE " + KEY_ID + " = " + id;

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(sql, null);
            if (cursor != null){
                cursor.moveToFirst();

                Score score = getScoreFromDBCursor(cursor);
                return score;
            }
            return null;
        }


        public void deleteScore(Score score){
            int id = score.getId();

            String sql = "DELETE FROM " + TABLE_SCORES + " WHERE" + KEY_ID + " = " + id;
            SQLrunner(sql);
        }


        private Score getScoreFromDBCursor(Cursor cursor) {

        // Get column index for each table column
            int idColumnNum = cursor.getColumnIndex(KEY_ID);
            int scoreColumnNum = cursor.getColumnIndex(KEY_SCORE);

        // Retrieve data in the column field
            int id = Integer.parseInt(cursor.getString(idColumnNum));
            int points = Integer.parseInt(cursor.getString(scoreColumnNum));

            Score score = new Score();

            return score;
    }
}


