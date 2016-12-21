package com.example.user.runtrack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by user on 17/12/2016.
 */
public class ShowRun extends AppCompatActivity{
    TextView showTitleTextView;
    TextView showDateTextView;
    TextView showDistanceTextView;
    TextView showTimeTextView;
    TextView showPaceTextView;
    TextView showRouteTextView;
    TextView showTypeTextView;
    Button editButton;
    Button deleteButton;

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main,menu);
        return true ;
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item){
        if (item.getItemId() == R.id.add_run){
            Intent intent = new Intent(ShowRun.this, NewRun.class);
            this.startActivity(intent);
            return true;
        }
        else if (item.getItemId() == R.id.all_runs){
            Intent intent = new Intent(ShowRun.this, AllRuns.class);
            this.startActivity(intent);
            return true;
        }
        else if (item.getItemId() == R.id.challenge_select){
            Intent intent = new Intent(ShowRun.this, ChallengeSelect.class);
            this.startActivity(intent);
            return true;
        }
        else if (item.getItemId() == R.id.home){
            Intent intent = new Intent(ShowRun.this, MainActivity.class);
            this.startActivity(intent);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final DBHandler db = ((MainApplication) getApplication()).db;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_run);

        showTitleTextView = (TextView) findViewById(R.id.show_run_title);
        showDateTextView = (TextView) findViewById(R.id.show_run_date);
        showDistanceTextView = (TextView) findViewById(R.id.show_run_distance);
        showTimeTextView = (TextView) findViewById(R.id.show_run_time);
        showPaceTextView = (TextView) findViewById(R.id.show_run_pace);
        showRouteTextView = (TextView) findViewById(R.id.show_run_route);
        showTypeTextView = (TextView) findViewById(R.id.show_run_type);
        editButton = (Button) findViewById(R.id.button_editRun);
        deleteButton = (Button) findViewById(R.id.button_deleteRun);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        final int Id = extras.getInt("ID");
        final String Title = extras.getString("Title");
        final String Date = extras.getString("Date");
        final float Distance = extras.getFloat("Distance");
        final float Time = extras.getFloat("Time");
        final float Pace = extras.getFloat("Pace");
        final String Route = extras.getString("Route");
        final String Type = extras.getString("Type");


        showTitleTextView.setText("Run: " + Title);
        showDateTextView.setText("Date: " + Date);
        showDistanceTextView.setText("Distance: " + Distance + " km");
        showTimeTextView.setText("Time: " + Time + " mins");
        showPaceTextView.setText("Pace: " + Pace + " mins/km");
        showRouteTextView.setText("Route: " + Route);
        showTypeTextView.setText("Type: " + Type);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("OriginalRunInfo", "RunToEdit: title: " + Title +
                        ", "  + Distance + ", " + Time + ", " +
                        Pace + ", " + Route + ", " + Type);

                Intent intent = new Intent(ShowRun.this, EditRun.class);
                intent.putExtra("ID", Id);
                intent.putExtra("Title", Title);
                intent.putExtra("Date", Date);
                intent.putExtra("Distance",Distance);
                intent.putExtra("Time", Time);
                intent.putExtra("Pace", Pace);
                intent.putExtra("Route", Route);
                intent.putExtra("Type", Type);
                startActivity(intent);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Log.d("Delete Run: ", "deleting run with ID:" + Id);
                db.deleteRun(Id);
                Intent intent = new Intent(ShowRun.this, AllRuns.class);
                startActivity(intent);
                Toast.makeText(ShowRun.this, "Run Deleted!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
