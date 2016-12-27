package com.example.user.runtrack;

import android.app.ActionBar;
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
 * Created by user on 17/12/2016.
 */
public class EditRun extends AppCompatActivity{
    EditText titleEditText;
    EditText dayEditText;
    EditText monthEditText;
    EditText yearEditText;
    EditText distanceEditText;
    EditText timeEditText;
    EditText routeEditText;
    EditText typeEditText;
    Button editRunButton;

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main,menu);
        return true ;
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item){
        if (item.getItemId() == R.id.add_run){
            Intent intent = new Intent(EditRun.this, NewRun.class);
            this.startActivity(intent);
            return true;
        }
        else if (item.getItemId() == R.id.all_runs){
            Intent intent = new Intent(EditRun.this, AllRuns.class);
            this.startActivity(intent);
            return true;
        }
        else if (item.getItemId() == R.id.challenge_select){
            Intent intent = new Intent(EditRun.this, ChallengeSelect.class);
            this.startActivity(intent);
            return true;
        }else if (item.getItemId() == R.id.home){
            Intent intent = new Intent(EditRun.this, MainActivity.class);
            this.startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final DBHandler db = ((MainApplication)getApplication()).db;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_run);

        titleEditText = (EditText)findViewById(R.id.run_title);
        dayEditText = (EditText)findViewById(R.id.run_day);
        monthEditText = (EditText)findViewById(R.id.run_month);
        yearEditText = (EditText)findViewById(R.id.run_year);
        distanceEditText = (EditText)findViewById(R.id.distance);
        timeEditText = (EditText)findViewById(R.id.time);
        routeEditText = (EditText)findViewById(R.id.route);
        typeEditText = (EditText)findViewById(R.id.type);
        editRunButton = (Button)findViewById(R.id.button_add_run);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        final int selectedId = extras.getInt("ID");
        final String selectedTitle = extras.getString("Title");
        final int selectedDay = extras.getInt("Day");
        final int selectedMonth = extras.getInt("Month");
        final int selectedYear = extras.getInt("Year");
        final float selectedDistance = extras.getFloat("Distance");
        final float selectedTime = extras.getFloat("Time");
        final String selectedRoute = extras.getString("Route");
        final String selectedType = extras.getString("Type");

        titleEditText.setText(selectedTitle);
        dayEditText.setText("" + selectedDay);
        monthEditText.setText("" + selectedMonth);
        yearEditText.setText("" + selectedYear);
        distanceEditText.setText("" + selectedDistance);
        timeEditText.setText("" + selectedTime);routeEditText.setText(selectedRoute);
        typeEditText.setText(selectedType);

        editRunButton.setOnClickListener(new View.OnClickListener() {
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

                Run runToEdit = new Run(selectedId, title, day, month, year, distance, time, route, type);
                db.updateRun(runToEdit);
                Log.d("Edit:", "Editing run.." + title + ", " + distance + " k");

                Intent intent = new Intent(EditRun.this, ShowRun.class);
                intent.putExtra("ID", selectedId);
                intent.putExtra("Title", title);
                intent.putExtra("Day", day);
                intent.putExtra("Month", month);
                intent.putExtra("Year", year);
                intent.putExtra("Distance",distance);
                intent.putExtra("Time", time);
                intent.putExtra("Route", route);
                intent.putExtra("Type", type);

                Toast.makeText(EditRun.this, "Run Updated!", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }


}
