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
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by user on 17/12/2016.
 */
public class ShowRun extends AppCompatActivity{
    TextView showTitleTextView;
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
        else if (item.getItemId() == R.id.run_roulette){
            Intent intent = new Intent(ShowRun.this, RunRoulette.class);
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
        showDistanceTextView = (TextView) findViewById(R.id.show_run_distance);
        showTimeTextView = (TextView) findViewById(R.id.show_run_time);
        showPaceTextView = (TextView) findViewById(R.id.show_run_pace);
        showRouteTextView = (TextView) findViewById(R.id.show_run_route);
        showTypeTextView = (TextView) findViewById(R.id.show_run_type);
        editButton = (Button) findViewById(R.id.button_editRun);
        deleteButton = (Button) findViewById(R.id.button_deleteRun);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        final int selectedRunId = extras.getInt("ID");
        final String selectedRunTitle = extras.getString("Title");
        final int selectedRunDistance = extras.getInt("Distance");
        final int selectedRunTime = extras.getInt("Time");
        final int selectedRunPace = extras.getInt("Pace");
        final String selectedRunRoute = extras.getString("Route");
        final String selectedRunType = extras.getString("Type");

        showTitleTextView.setText("Run: " + selectedRunTitle);
        showDistanceTextView.setText("Distance: " + selectedRunDistance + " km");
        showTimeTextView.setText("Time: " + selectedRunTime + " mins");
        showPaceTextView.setText("Pace: " + selectedRunPace + " mins/km");
        showRouteTextView.setText("Route: " + selectedRunRoute);
        showTypeTextView.setText("Type: " + selectedRunType);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("OriginalRunInfo", "RunToEdit: title: " + selectedRunTitle +
                        ", "  + selectedRunDistance + ", " + selectedRunTime + ", " +
                        selectedRunPace + ", " + selectedRunRoute + ", " + selectedRunType);

                Intent intent = new Intent(ShowRun.this, EditRun.class);
                intent.putExtra("ID", selectedRunId);
                intent.putExtra("Title", selectedRunTitle);
                intent.putExtra("Distance",selectedRunDistance);
                intent.putExtra("Time", selectedRunTime);
                intent.putExtra("Pace", selectedRunPace);
                intent.putExtra("Route", selectedRunRoute);
                intent.putExtra("Type", selectedRunType);
                startActivity(intent);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Log.d("Delete Run: ", "deleting run with ID:" + selectedRunId);
                db.deleteRun(selectedRunId);
                Intent intent = new Intent(ShowRun.this, AllRuns.class);
                startActivity(intent);
                Toast.makeText(ShowRun.this, "Run Deleted!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
