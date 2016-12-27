package com.example.user.runtrack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by user on 16/12/2016.
 */
public class AllRuns extends AppCompatActivity {
    //Activity Items
    ListView allRunList;
//    ArrayAdapter<String> adapter1;


    Button addRun;
    EditText titleEditText;
    EditText distanceEditText;
    TextView totalRunTextView;
    TextView totalDistanceTextView;
    TextView totalTimeTextView;

    Spinner monthSpinner;
    ArrayAdapter<CharSequence> adapter;



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        if (item.getItemId() == R.id.add_run) {
            Intent intent = new Intent(AllRuns.this, NewRun.class);
            this.startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.all_runs) {
            Intent intent = new Intent(AllRuns.this, AllRuns.class);
            this.startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.challenge_select) {
            Intent intent = new Intent(AllRuns.this, ChallengeSelect.class);
            this.startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.home) {
            Intent intent = new Intent(AllRuns.this, MainActivity.class);
            this.startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_runs);

        //Creating database
        final DBHandler db = ((MainApplication) getApplication()).db;

        //Allocating Activity Items an ID from all_runs

        allRunList = (ListView) findViewById(R.id.run_list);
        addRun = (Button) findViewById(R.id.button_newRun);
        titleEditText = (EditText) findViewById(R.id.run_title);
        distanceEditText = (EditText) findViewById(R.id.distance);
        totalRunTextView = (TextView) findViewById(R.id.total_runs);
        totalDistanceTextView = (TextView) findViewById(R.id.total_distance);
        totalTimeTextView = (TextView) findViewById(R.id.total_time);
        monthSpinner = (Spinner) findViewById(R.id.month_spinner);


        adapter = ArrayAdapter.createFromResource(this,R.array.month_array,android.R.layout.simple_spinner_item );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monthSpinner.setAdapter(adapter);

        monthSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                updateTotals(db,position);
                updateListView(db);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        });


        //Add New Run Button
        addRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Runs: ", "new run button clicked");
                Intent intent = new Intent(AllRuns.this, NewRun.class);
                startActivity(intent);
            }
        });

    }


    //Determining the totals bar
    private void updateTotals(DBHandler db, int month){
        if (month == 0) {
            totalRunTextView.setText("RUNS \n" + db.getTotalRun());
            totalDistanceTextView.setText("DISTANCE \n" + db.getTotalDistance() + " km");
            totalTimeTextView.setText("TIME \n" + db.getTotalTime() + "mins");
        }
        else if (month > 0) {
            totalRunTextView.setText("RUNS \n" + db.getTotalRun(month));
            totalDistanceTextView.setText("DISTANCE \n" + db.getTotalDistance(month) + " km");
            totalTimeTextView.setText("TIME \n" + db.getTotalTime(month) + "mins");
        }
    }


    //Accessing all Runs in DB and returning all runs in runLog to make available for Array List
    private ArrayList<Run> getAllRuns(DBHandler db, int month) {
        ArrayList<Run> runLog = new ArrayList<Run>();

        if (month == 0) {
            ArrayList<Run> runs = db.getAllRuns();
            for (Run run : runs) {
                runLog.add(run);
            }
        }
        else if (month > 0) {
            ArrayList<Run> runs = db.getAllRuns(month);
            for (Run run : runs) {
                runLog.add(run);
            }
        }
        return runLog;
    }


        public void updateListView(final DBHandler db) {
            ArrayList<Run>arrayOfRuns = getAllRuns(db, monthSpinner.getSelectedItemPosition());
            //Showing data as a List View through an Array Adapter
            RunsAdapter adapter1 = new RunsAdapter(this, arrayOfRuns);
            ListView listView = (ListView) findViewById(R.id.run_list);

//            adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getAllRuns(db, monthSpinner.getSelectedItemPosition()));
            allRunList.setAdapter(adapter1);
            allRunList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Run selectedRunFile = (Run)allRunList.getItemAtPosition(position);

                    Log.d("ListView:", "position: " + position + ", id: " + id + ", Run File: " + selectedRunFile + ", Run File ID: " + selectedRunFile);

                    Run selectedRun = db.getRun(selectedRunFile.getId());
                    Log.d("Selected Run: ", "Selected run: " + selectedRun);

                    Intent intent = new Intent(AllRuns.this, ShowRun.class);
                    intent.putExtra("ID", selectedRun.getId());
                    intent.putExtra("Title", selectedRun.getRunTitle());
                    intent.putExtra("Day", selectedRun.getDay());
                    intent.putExtra("Month", selectedRun.getMonth());
                    intent.putExtra("Year", selectedRun.getYear());
                    intent.putExtra("Distance", selectedRun.getDistance());
                    intent.putExtra("Time", selectedRun.getTime());
                    intent.putExtra("Pace", selectedRun.getPace());
                    intent.putExtra("Route", selectedRun.getRoute());
                    intent.putExtra("Type", selectedRun.getType());
                    startActivity(intent);
                }
            });
        }
}
