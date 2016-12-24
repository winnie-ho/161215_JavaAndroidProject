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

import java.util.ArrayList;

/**
 * Created by user on 16/12/2016.
 */
public class AllRuns extends AppCompatActivity {
    //Activity Items
    Spinner monthSpinner;
    ListView allRunList;
    Button addRun;
    EditText titleEditText;
    EditText distanceEditText;
    TextView totalRunTextView;
    TextView totalDistanceTextView;
    TextView totalTimeTextView;

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
        monthSpinner = (Spinner) findViewById(R.id.month_spinner);
        allRunList = (ListView) findViewById(R.id.run_list);
        addRun = (Button) findViewById(R.id.button_newRun);
        titleEditText = (EditText) findViewById(R.id.run_title);
        distanceEditText = (EditText) findViewById(R.id.distance);
        totalRunTextView = (TextView) findViewById(R.id.total_runs);
        totalDistanceTextView = (TextView) findViewById(R.id.total_distance);
        totalTimeTextView = (TextView) findViewById(R.id.total_time);

        totalRunTextView.setText("RUNS \n" + db.getTotalRun());
        totalDistanceTextView.setText("DISTANCE \n" + db.getTotalDistance() + " km");
        totalTimeTextView.setText("TIME \n" + db.getTotalTime() + " mins");

        monthSpinner.setOnItemSelectedListener(new SpinnerActivity());


        //Add New Run Button
        addRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Runs: ", "new run button clicked");
                Intent intent = new Intent(AllRuns.this, NewRun.class);
                startActivity(intent);
            }
        });


        //Showing data as a List View through and Array Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getAllRuns(db));
        allRunList.setAdapter(adapter);

        allRunList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = (String) allRunList.getItemAtPosition(position);
                Log.d("ListView:", selected + " selected, position: " + position + ", id: " + id);

                Run selectedRun = db.getRun(position + 1);
                Log.d("Selected Run: ", "Selected run: " + selectedRun);

                Intent intent = new Intent(AllRuns.this, ShowRun.class);

                Log.d("SelectedRunInfo", "Selected run: " + selectedRun.getId() + ", " + selectedRun.getRunTitle() +
                        ", " + selectedRun.getDistance() + ", " + selectedRun.getTime() + ", " +
                        selectedRun.getPace() + ", " + selectedRun.getRoute() + ", " + selectedRun.getType());

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


        ArrayAdapter<CharSequence> adapterMonth = ArrayAdapter.createFromResource(this,
                R.array.month_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapterMonth.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        monthSpinner.setAdapter(adapterMonth);

    }

    //Accessing all Runs in DB and returning all runs in runLog to make available for Array List
    private ArrayList<String> getAllRuns(DBHandler db) {
        ArrayList<String> runLog = new ArrayList<String>();

        ArrayList<Run> runs = db.getAllRuns();
        for (Run run : runs) {
            runLog.add(run.getDay() + "/" + run.getMonth() + "/" + run.getYear() + "         " + run.getRunTitle() + "        " + run.getDistance() + "km");
            Log.d("Showing:", "Showing" + run.getRunTitle());
        }
        return runLog;
    }

}
