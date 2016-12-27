package com.example.user.runtrack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by user on 21/12/2016.
 */
public class NewRunC extends AppCompatActivity {
    EditText titleEditText;
    EditText dayEditText;
    EditText monthEditText;
    EditText yearEditText;
    EditText distanceEditText;
    EditText timeEditText;
    EditText routeEditText;
    EditText typeEditText;
    Button addRunButton;

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main,menu);
        return true ;
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item){
        if (item.getItemId() == R.id.add_run){
            Intent intent = new Intent(NewRunC.this, NewRun.class);
            this.startActivity(intent);
            return true;
        }
        else if (item.getItemId() == R.id.all_runs){
            Intent intent = new Intent(NewRunC.this, AllRuns.class);
            this.startActivity(intent);
            return true;
        }
        else if (item.getItemId() == R.id.challenge_select){
            Intent intent = new Intent(NewRunC.this, ChallengeSelect.class);
            this.startActivity(intent);
            return true;
        }
        else if (item.getItemId() == R.id.home){
            Intent intent = new Intent(NewRunC.this, MainActivity.class);
            this.startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final DBHandler db = ((MainApplication)getApplication()).db;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_run);


        titleEditText = (EditText)findViewById(R.id.run_title);
        dayEditText = (EditText)findViewById(R.id.run_day);
        monthEditText = (EditText)findViewById(R.id.run_month);
        yearEditText = (EditText)findViewById(R.id.run_year);
        distanceEditText = (EditText)findViewById(R.id.distance);
        timeEditText = (EditText)findViewById(R.id.time);
        routeEditText = (EditText)findViewById(R.id.route);
        typeEditText = (EditText)findViewById(R.id.type);
        addRunButton = (Button)findViewById(R.id.button_add_run);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        final int newScore = extras.getInt("newScore");
        final String challengeTitle = extras.getString("challengeTitle");
        final int challengeDistance = extras.getInt("challengeDistance");
        final String challengeType = extras.getString("challengeType");
        final int pointsAvailable = extras.getInt("pointsAvailable");

        titleEditText.setText(challengeTitle);
        distanceEditText.setText("" + challengeDistance);
        typeEditText.setText(challengeType);



        addRunButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleEditText.getText().toString();
                int day = Integer.parseInt(dayEditText.getText().toString());
                int month = Integer.parseInt(monthEditText.getText().toString());
                int year = Integer.parseInt(yearEditText.getText().toString());
                float distance = Float.parseFloat(distanceEditText.getText().toString());
                float time = Float.parseFloat(timeEditText.getText().toString());
                String route = routeEditText.getText().toString();
                String type = typeEditText.getText().toString();

                Run newRun = new Run(title, day, month, year, distance, time, route, type);
                db.addRun(newRun);
                Log.d("Add:", "Adding new run.." + title + ", " + distance + "k");
                Toast.makeText(NewRunC.this, "Run Added!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(NewRunC.this, AllRuns.class);
                startActivity(intent);
            }
        });
    }
}
