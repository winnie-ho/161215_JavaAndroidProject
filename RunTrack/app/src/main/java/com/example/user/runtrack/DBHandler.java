package com.example.user.runtrack;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.w3c.dom.Text;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by user on 16/12/2016.
 */
public class DBHandler extends SQLiteOpenHelper {
    //Database Version
    private static final int DATABASE_VERSION = 1;
    //Database Name
    private static final String DATABASE_NAME = "runTrack";
    //Table name
    private static final String TABLE_RUNS = "runs";
    //Runs table column names
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_DAY = "day";
    private static final String KEY_MONTH = "month";
    private static final String KEY_YEAR = "year";
    private static final String KEY_DISTANCE = "distance";
    private static final String KEY_HOURS = "hours";
    private static final String KEY_MINUTES = "minutes";
    private static final String KEY_SECONDS = "seconds";
    private static final String KEY_PACE = "pace";
    private static final String KEY_TYPE = "type";
    private static final String KEY_COMMENT = "comment";


    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    /*    CREATE TABLE runs(
          id INTEGER PRIMARY KEY,
          title TEXT,
          day INTEGER,
          month INTEGER,
          year INTEGER,
          distance FLOAT,
          hours FLOAT,
          minutes FLOAT,
          seconds FLOAT,
          pace FLOAT,
          type TEXT
          comment TEXT,

    )
*/
        String CREATE_TABLE = "CREATE TABLE " + TABLE_RUNS + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_TITLE + " TEXT," + KEY_DAY + " INTEGER," + KEY_MONTH + " INTEGER," +
                KEY_YEAR + " INTEGER," + KEY_DISTANCE + " FLOAT," + KEY_HOURS + " FLOAT," +
                KEY_MINUTES + " FLOAT," + KEY_SECONDS + " FLOAT," + KEY_PACE + " FLOAT," +
                KEY_TYPE + " TEXT," + KEY_COMMENT + " TEXT )";
        db.execSQL(CREATE_TABLE);
    }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            //Drop older table if Runs table exists;

            db.execSQL("DROP TABLE IF EXISTS " + TABLE_RUNS);
            //Create the Runs table again
            onCreate(db);
        }
    //SQLRunner
        private void SQLrunner(String sql){
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL(sql);
        }

    //CRUD METHODS
        public void addRun(Run run){
            String title = run.getRunTitle();
            Integer day = run.getDay();
            Integer month = run.getMonth();
            Integer year = run.getYear();
            float distance = run.getDistance();
            float hours = run.getHours();
            float minutes = run.getMinutes();
            float seconds = run.getSeconds();
            float pace = run.getPace();
            String type = run.getType();
            String comment = run.getComment();

            String sql = "INSERT INTO " + TABLE_RUNS + " ('" + KEY_TITLE + "', " + KEY_DAY + ", " + KEY_MONTH + ", " + KEY_YEAR + ", " + KEY_DISTANCE + ", "
                    + KEY_HOURS + ", " + KEY_MINUTES + ", " + KEY_SECONDS + ", " + KEY_PACE + ", '" + KEY_TYPE + "', '" + KEY_COMMENT + "') VALUES ('" +
                    title + "', "+ day + ", " + month + ", " + year + ", " + Float.toString(distance) + ", " + Float.toString(hours) + ", " +
                    Float.toString(minutes) + ", " + Float.toString(seconds) + ", " + Float.toString(pace) + ",'"+ type + "', '" + comment + "')";
            SQLrunner(sql);
        }

        public void updateRun(Run run) {
            int id = run.getId();
            String title = run.getRunTitle();
            Integer day = run.getDay();
            Integer month = run.getMonth();
            Integer year = run.getYear();
            float distance = run.getDistance();
            float hours = run.getHours();
            float minutes = run.getMinutes();
            float seconds = run.getSeconds();
            float pace = run.getPace();
            String type = run.getType();
            String comment = run.getComment();

            String sql = "UPDATE " + TABLE_RUNS + " SET "
                    + KEY_TITLE + " = '" + title + "', "
                    + KEY_DAY + " = " + day + ", "
                    + KEY_MONTH + " = " + month + ", "
                    + KEY_YEAR + " = " + year + ", "
                    + KEY_DISTANCE + " = " + distance + ", "
                    + KEY_HOURS + " = " + hours + ", "
                    + KEY_MINUTES + " = " + minutes + ", "
                    + KEY_SECONDS + " = " + seconds + ", "
                    + KEY_PACE + " = " + pace + ", "
                    + KEY_TYPE + " = '" + type + "', "
                    + KEY_COMMENT + " = '" + comment + "' WHERE " + KEY_ID + " = " + id;
            Log.d("Running SQL: ",sql);
            SQLrunner(sql);
        }

        public int getTotalRun(int month){
            String sql = "SELECT count (" + KEY_TITLE + ") FROM " + TABLE_RUNS + " WHERE " + KEY_MONTH + " = " + month;
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(sql, null);
            cursor.moveToFirst();
            int totalRun = cursor.getInt(0);
            cursor.close();
            return totalRun;
        }

        public int getTotalRun(){
            String sql = "SELECT count (" + KEY_TITLE + ") FROM " + TABLE_RUNS;
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(sql, null);
            cursor.moveToFirst();
            int totalRun = cursor.getInt(0);
            cursor.close();
            return totalRun;
        }

        public float getTotalDistance(int month){
            String sql = "SELECT sum (" + KEY_DISTANCE + ") FROM " + TABLE_RUNS + " WHERE " + KEY_MONTH + " = " + month;
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(sql, null);
                cursor.moveToFirst();
                float totalDistance = cursor.getFloat(0);
                cursor.close();
            return totalDistance;
        }

        public float getTotalDistance(){
            String sql = "SELECT sum (" + KEY_DISTANCE + ") FROM " + TABLE_RUNS;
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(sql, null);
            cursor.moveToFirst();
            float totalDistance = cursor.getFloat(0);
            cursor.close();
            return totalDistance;
        }

        public Float getTotalHours(int month){
            String sql = "SELECT sum (" + KEY_HOURS + ") FROM " + TABLE_RUNS + " WHERE " + KEY_MONTH + " = " + month;
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(sql, null);
            cursor.moveToFirst();
            float totalTime = cursor.getFloat(0);
            cursor.close();
            return totalTime;
        }

        public Float getTotalHours(){
            String sql = "SELECT sum (" + KEY_HOURS + ") FROM " + TABLE_RUNS;
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(sql, null);
            cursor.moveToFirst();
            float totalTime = cursor.getFloat(0);
            cursor.close();
            return totalTime;
        }

    public Float getTotalMinutes(int month){
        String sql = "SELECT sum (" + KEY_MINUTES + ") FROM " + TABLE_RUNS + " WHERE " + KEY_MONTH + " = " + month;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        float totalTime = cursor.getFloat(0);
        cursor.close();
        return totalTime;
    }

    public Float getTotalMinutes(){
        String sql = "SELECT sum (" + KEY_MINUTES + ") FROM " + TABLE_RUNS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        float totalTime = cursor.getFloat(0);
        cursor.close();
        return totalTime;
    }

    public Float getTotalSeconds(int month){
        String sql = "SELECT sum (" + KEY_SECONDS + ") FROM " + TABLE_RUNS + " WHERE " + KEY_MONTH + " = " + month;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        float totalTime = cursor.getFloat(0);
        cursor.close();
        return totalTime;
    }

    public Float getTotalSeconds(){
        String sql = "SELECT sum (" + KEY_SECONDS + ") FROM " + TABLE_RUNS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        float totalTime = cursor.getFloat(0);
        cursor.close();
        return totalTime;
    }

    //Calculating total time
    public String getTotalTime(){
        float totalSeconds = getTotalSeconds();
        float rSeconds = totalSeconds%60;
        float sToM = (totalSeconds - rSeconds)/60;

        float totalMinutes = getTotalMinutes();
        float rMinutes = (totalMinutes + sToM)%60;
        float mToH = ((totalMinutes + sToM)-rMinutes)/60;

        float totalHours = getTotalHours();
        float rHours = totalHours + mToH;


        return (String.format("%.0f",rHours) + ":" + String.format("%.0f", rMinutes) + ":" + String.format("%.0f",rSeconds));
    }







    public Run getRun(int id){
            String sql = "SELECT * FROM " + TABLE_RUNS + " WHERE " + KEY_ID + " = " + id;

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(sql, null);
            if (cursor != null){
                cursor.moveToFirst();

                Run run = getRunFromDBCursor(cursor);
                return run;
            }
            return null;
        }


        public Run getRun(String title){
            String sql = "SELECT * FROM " + TABLE_RUNS + " WHERE " + KEY_TITLE + " = '" + title + "'";

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(sql, null);
            if (cursor != null) {
                cursor.moveToFirst();

                Run run = getRunFromDBCursor(cursor);
                return run;
            }
            return null;
        }

        public ArrayList<Run> getAllRuns() {
            ArrayList<Run> runList = new ArrayList<Run>();

            String sql = "SELECT * FROM " + TABLE_RUNS + " ORDER BY " + KEY_YEAR + " ASC, " + KEY_MONTH + " ASC, " + KEY_DAY + " ASC";

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(sql, null);

            if (cursor.moveToFirst()){
                do {
                    Run run = getRunFromDBCursor(cursor);
                    runList.add(run);
                } while(cursor.moveToNext());
            }
            return runList;
        }

        public ArrayList<Run> getAllRuns(int month) {
            ArrayList<Run> runList = new ArrayList<Run>();

            String sql = "SELECT * FROM " + TABLE_RUNS + " WHERE " + KEY_MONTH + " = " + month;

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(sql, null);

            if (cursor.moveToFirst()){
                do {
                    Run run = getRunFromDBCursor(cursor);
                    runList.add(run);
                } while(cursor.moveToNext());
            }
            return runList;
        }

        public void deleteRun(Run run){
            int id = run.getId();

            String sql = "DELETE FROM " + TABLE_RUNS + " WHERE" + KEY_ID + " = " + id;
            SQLrunner(sql);
        }

        public void deleteRun(int id) {
            String sql = "DELETE FROM " + TABLE_RUNS + " WHERE " + KEY_ID + " = " + id;
            SQLrunner(sql);
        }

        public void deleteAllRuns() {
            String sql = "DELETE FROM " + TABLE_RUNS;
            SQLrunner(sql);
        }


        private Run getRunFromDBCursor(Cursor cursor) {

        // Get column index for each table column
            int idColumnNum = cursor.getColumnIndex(KEY_ID);
            int titleColumnNum = cursor.getColumnIndex(KEY_TITLE);
            int dayColumnNum = cursor.getColumnIndex(KEY_DAY);
            int monthColumnNum = cursor.getColumnIndex(KEY_MONTH);
            int yearColumnNum = cursor.getColumnIndex(KEY_YEAR);
            int distanceColumnNum = cursor.getColumnIndex(KEY_DISTANCE);
            int hoursColumnNum = cursor.getColumnIndex(KEY_HOURS);
            int minutesColumnNum = cursor.getColumnIndex(KEY_MINUTES);
            int secondsColumnNum = cursor.getColumnIndex(KEY_SECONDS);
            int paceColumnNum = cursor.getColumnIndex(KEY_PACE);
            int typeColumnNum = cursor.getColumnIndex(KEY_TYPE);
            int commentColumnNum = cursor.getColumnIndex(KEY_COMMENT);

        // Retrieve data in the column field
            int id = Integer.parseInt(cursor.getString(idColumnNum));
            String title = cursor.getString(titleColumnNum);
            int day = cursor.getInt(dayColumnNum);
            int month = cursor.getInt(monthColumnNum);
            int year = cursor.getInt(yearColumnNum);
            float distance = Float.parseFloat(cursor.getString(distanceColumnNum));
            float hours = Float.parseFloat(cursor.getString(hoursColumnNum));
            float minutes = Float.parseFloat(cursor.getString(minutesColumnNum));
            float seconds = Float.parseFloat(cursor.getString(secondsColumnNum));
            float pace = Float.parseFloat(cursor.getString(paceColumnNum));
            String comment = cursor.getString(commentColumnNum);
            String type = cursor.getString(typeColumnNum);

            Run run = new Run(id, title, day, month, year, distance, hours, minutes, seconds, type, comment);

            return run;
    }
}


