package com.example.user.runtrack;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 16/12/2016.
 */
public class MainActivity extends AppCompatActivity {
    //Activity Items
    ListView allRunList;
    Button addRun;
    EditText titleEditText;
    EditText distanceEditText;
    Button viewRunButton;


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main,menu);
        return true ;
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item){
        if (item.getItemId() == R.id.add_run){
            Intent intent = new Intent(MainActivity.this, NewRun.class);
            this.startActivity(intent);
            return true;
        }
        else if (item.getItemId() == R.id.all_runs){
            Intent intent = new Intent(MainActivity.this, AllRuns.class);
            this.startActivity(intent);
            return true;
        }
        else if (item.getItemId() == R.id.random){
            Intent intent = new Intent(MainActivity.this, Random.class);
            this.startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Allocating Activity Items an ID from activity_main
        allRunList = (ListView) findViewById(R.id.run_list);
        addRun = (Button)findViewById(R.id.button_newRun);
        titleEditText = (EditText) findViewById(R.id.run_title);
        distanceEditText = (EditText) findViewById(R.id.distance);
        viewRunButton = (Button) findViewById(R.id.button_view_run);

        //Creating database
        final DBHandler db = ((MainApplication) getApplication()).db;

        //Add New Run Button
        addRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d ("Runs: ", "new run button clicked");
                Intent intent = new Intent(MainActivity.this, NewRun.class);
                startActivity(intent);
            }
        });


        //Purge old logs
//        Log.d("Delete:", "Deleting..");
//        db.deleteAllRuns();

//        Code for Buttons
        viewRunButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("Add:", "Adding new run..");
            }
        });


        //Inserting test data
        Log.d("Insert: ", "Inserting..");

        //Showing data as a List View through and Array Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getAllRuns(db));
        allRunList.setAdapter(adapter);
    }



    //Accessing all Runs in DB and returning all runs in runLog to make available for Array List
    private ArrayList<String>getAllRuns(DBHandler db){
        ArrayList<String> runLog = new ArrayList<String>();

        ArrayList<Run>runs = db.getAllRuns();
        for (Run run : runs){
            runLog.add("- " + run.getRunTitle() + "  |  " + run.getDistance() +"km  |  " +
                    run.getTime() + "mins  |  " + run.getType());
            Log.d("Showing:", "Showing" + run.getRunTitle() );
        }
        return runLog;
    }
}
