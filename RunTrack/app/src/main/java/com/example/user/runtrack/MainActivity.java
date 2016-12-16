package com.example.user.runtrack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 16/12/2016.
 */
public class MainActivity extends AppCompatActivity {
    ListView allRunList;
    Button addRun;

    EditText titleEditText;
    EditText distanceEditText;
    Button addRunButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        allRunList = (ListView) findViewById(R.id.run_list);
//        addRun = (Button)findViewById(R.id.button_newRun);

        titleEditText = (EditText) findViewById(R.id.run_title);
        distanceEditText = (EditText) findViewById(R.id.distance);
        addRunButton = (Button) findViewById(R.id.button_add_run);

        final DBHandler db = ((MainApplication) getApplication()).db;

//        addRun.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d ("Runs: ", "new run button clicked");
//                Intent intent = new Intent(MainActivity.this, NewRun.class);
//                startActivity(intent);
//            }
//        });

        addRunButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleEditText.getText().toString();
                int distance = Integer.parseInt(distanceEditText.getText().toString());

                Run newRun = new Run(title, distance);
                db.addRun(newRun);
                Log.d("Add:", "Adding new run.." + title + " " + distance + "k");
            }
        });

        Log.d("Delete:", "Deleting..");
        db.deleteAllRuns();

        Log.d("Insert: ", "Inserting..");
        db.addRun(new Run("run",10,10,5,"Park Run","Long"));
        db.addRun(new Run("Run Club Intervals",5,10,5,"Johnston Terrace Hills","Session"));
        db.addRun(new Run("After work",7,30,5,"WoL","Long"));
        db.addRun(new Run("Fox Trail 13k", 13, 65, 5,"Foxlake", "Trail"));


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getAllRuns(db));
        allRunList.setAdapter(adapter);


    }

    private ArrayList<String>getAllRuns(DBHandler db){
        ArrayList<String> runLog = new ArrayList<String>();

        ArrayList<Run>runs = db.getAllRuns();
        for (Run run : runs){
            runLog.add(run.getRunTitle() + "  " + run.getDistance() +"km  " + run.getTime() + "mins  ");
            Log.d("Showing:", "Showing" + run.getRunTitle());
        }
        return runLog;

    }



}
