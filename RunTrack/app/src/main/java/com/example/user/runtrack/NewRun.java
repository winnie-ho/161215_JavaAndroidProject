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
 * Created by user on 16/12/2016.
 */
public class NewRun extends AppCompatActivity {
    EditText titleEditText;
    EditText dateEditText;
    EditText distanceEditText;
    EditText timeEditText;
    EditText paceEditText;
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
            Intent intent = new Intent(NewRun.this, NewRun.class);
            this.startActivity(intent);
            return true;
        }
        else if (item.getItemId() == R.id.all_runs){
            Intent intent = new Intent(NewRun.this, AllRuns.class);
            this.startActivity(intent);
            return true;
        }
        else if (item.getItemId() == R.id.run_roulette){
            Intent intent = new Intent(NewRun.this, Challenges.class);
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
        dateEditText = (EditText)findViewById(R.id.run_date);
        distanceEditText = (EditText)findViewById(R.id.distance);
        timeEditText = (EditText)findViewById(R.id.time);
        paceEditText = (EditText)findViewById(R.id.pace);
        routeEditText = (EditText)findViewById(R.id.route);
        typeEditText = (EditText)findViewById(R.id.type);
        addRunButton = (Button)findViewById(R.id.button_add_run);

        addRunButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleEditText.getText().toString();
                String date = dateEditText.getText().toString();
                float distance = Float.parseFloat(distanceEditText.getText().toString());
                float time = Float.parseFloat(timeEditText.getText().toString());
                float pace = Float.parseFloat(paceEditText.getText().toString());
                String route = routeEditText.getText().toString();
                String type = typeEditText.getText().toString();

                Run newRun = new Run(title, date, distance, time, pace, route, type);
                db.addRun(newRun);
                Log.d("Add:", "Adding new run.." + title + " " + date + ", " + distance + "k");
                Toast.makeText(NewRun.this, "Run Added!", Toast.LENGTH_SHORT).show();
                backToMainScreen();
            }
        });
    }

    private void backToMainScreen() {
        Intent intent = new Intent(NewRun.this, AllRuns.class);
        startActivity(intent);
    }

}
