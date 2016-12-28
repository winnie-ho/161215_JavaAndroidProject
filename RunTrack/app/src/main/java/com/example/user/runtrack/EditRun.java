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
    EditText hoursEditText;
    EditText minutesEditText;
    EditText secondsEditText;
    EditText typeEditText;
    EditText commentEditText;
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
        hoursEditText = (EditText)findViewById(R.id.timeHours);
        minutesEditText = (EditText)findViewById(R.id.timeMins);
        secondsEditText = (EditText)findViewById(R.id.timeSecs);
        typeEditText = (EditText)findViewById(R.id.type);
        commentEditText = (EditText)findViewById(R.id.comment);
        editRunButton = (Button)findViewById(R.id.button_add_run);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        final int selectedId = extras.getInt("ID");
        final String selectedTitle = extras.getString("Title");
        final int selectedDay = extras.getInt("Day");
        final int selectedMonth = extras.getInt("Month");
        final int selectedYear = extras.getInt("Year");
        final float selectedDistance = extras.getFloat("Distance");
        final float selectedHours = extras.getFloat("Hours");
        final float selectedMinutes = extras.getFloat("Minutes");
        final float selectedSeconds = extras.getFloat("Seconds");
        final String selectedType = extras.getString("Type");
        final String selectedComment = extras.getString("Comment");

        titleEditText.setText(selectedTitle);
        dayEditText.setText("" + selectedDay);
        monthEditText.setText("" + selectedMonth);
        yearEditText.setText("" + selectedYear);
        distanceEditText.setText("" + selectedDistance);
        hoursEditText.setText(String.format("%.0f",selectedHours));
        minutesEditText.setText(String.format("%.0f",selectedMinutes));
        secondsEditText.setText(String.format("%.0f",selectedSeconds));
        typeEditText.setText(selectedType);
        commentEditText.setText(selectedComment);

        editRunButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = titleEditText.getText().toString();
                int day = Integer.parseInt(dayEditText.getText().toString());
                int month = Integer.parseInt(monthEditText.getText().toString());
                int year = Integer.parseInt(yearEditText.getText().toString());
                float distance = Float.parseFloat(distanceEditText.getText().toString());
                float hours = Float.parseFloat(hoursEditText.getText().toString());
                float minutes = Float.parseFloat(minutesEditText.getText().toString());
                float seconds = Float.parseFloat(secondsEditText.getText().toString());
                String type = typeEditText.getText().toString();
                String comment = commentEditText.getText().toString();

                Run runToEdit = new Run(selectedId, title, day, month, year, distance, hours, minutes, seconds, type, comment);
                db.updateRun(runToEdit);
                Log.d("Edit:", "Editing run.." + title + ", " + distance + " k");

                Intent intent = new Intent(EditRun.this, ShowRun.class);
                intent.putExtra("ID", selectedId);
                intent.putExtra("Title", title);
                intent.putExtra("Day", day);
                intent.putExtra("Month", month);
                intent.putExtra("Year", year);
                intent.putExtra("Distance",distance);
                intent.putExtra("Hours", hours);
                intent.putExtra("Minutes", minutes);
                intent.putExtra("Seconds", seconds);
                intent.putExtra("Type", type);
                intent.putExtra("Comment", comment);

                Toast.makeText(EditRun.this, "Run Updated!", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }
}
