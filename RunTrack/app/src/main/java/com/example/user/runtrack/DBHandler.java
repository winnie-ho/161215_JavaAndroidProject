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
    private static final String KEY_DISTANCE = "distance";
    private static final String KEY_TIME = "time";
    private static final String KEY_PACE = "pace";
    private static final String KEY_ROUTE = "route";
    private static final String KEY_TYPE = "type";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    /*    CREATE TABLE runs(
          id INTEGER PRIMARY KEY,
          title TEXT,
          distance INTEGER,
          time INTEGER,
          pace INTEGER,
          route TEXT,
          type TEXT
    )
*/
        String CREATE_TABLE = "CREATE TABLE " + TABLE_RUNS + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_TITLE + " TEXT," + KEY_DISTANCE + " INTEGER," + KEY_TIME + " INTEGER," + KEY_PACE +
                " INTEGER," + KEY_ROUTE + " TEXT," + KEY_TYPE + " TEXT )";
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
            int distance = run.getDistance();
            int time = run.getTime();
            int pace = run.getPace();
            String route = run.getRoute();
            String type = run.getType();

            String sql = "INSERT INTO " + TABLE_RUNS + " ('" + KEY_TITLE + "', " + KEY_DISTANCE + ", "
                    + KEY_TIME + ", "+ KEY_PACE + ", '" + KEY_ROUTE + "', '" + KEY_TYPE + "') VALUES ('" +
                    title + "', "+ Integer.toString(distance) + ", " + Integer.toString(time) + ", " +
                    Integer.toString(pace) + ",'"+ route + "', '" + type + "')";
            SQLrunner(sql);
        }

        public void updateRun(Run run) {
            int id = run.getId();
            String title = run.getRunTitle();
            int distance = run.getDistance();
            int time = run.getTime();
            int pace = run.getPace();
            String route = run.getRoute();
            String type = run.getType();

            String sql = "UPDATE " + TABLE_RUNS + " SET "
                    + KEY_TITLE + " = '" + title + "', "
                    + KEY_DISTANCE + " = '" + distance + "', "
                    + KEY_TIME + " = " + time + ", "
                    + KEY_PACE + " = " + pace + ", "
                    + KEY_ROUTE + " = '" + route + "', "
                    + KEY_TYPE + " = '" + type + "' WHERE " + KEY_ID + " = " + id;
            Log.d("Running SQL: ",sql);
            SQLrunner(sql);
        }

        public Run getRun(int id){
            String sql = "SELECT * FROM " + TABLE_RUNS + "WHERE " + KEY_ID + " = " + id;

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

            String sql = "SELECT * FROM " + TABLE_RUNS;

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
        int distanceColumnNum = cursor.getColumnIndex(KEY_DISTANCE);
        int timeColumnNum = cursor.getColumnIndex(KEY_TIME);
        int paceColumnNum = cursor.getColumnIndex(KEY_PACE);
        int routeColumnNum = cursor.getColumnIndex(KEY_ROUTE);
        int typeColumnNum = cursor.getColumnIndex(KEY_TYPE);

        // Retrieve data in the column field
        int id = Integer.parseInt(cursor.getString(idColumnNum));
        String title = cursor.getString(titleColumnNum);
        int distance = Integer.parseInt(cursor.getString(distanceColumnNum));
        int time = Integer.parseInt(cursor.getString(timeColumnNum));
        int pace = Integer.parseInt(cursor.getString(paceColumnNum));
        String route = cursor.getString(routeColumnNum);
        String type = cursor.getString(typeColumnNum);

        Run run = new Run(id, title, distance, time, pace, route, type);

        return run;
    }



    }


