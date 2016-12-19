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

        final String selectedRunTitle = extras.getString("Selected Run Title");
        final int selectedRunDistance = extras.getInt("Selected Run Distance");
        final int selectedRunTime = extras.getInt("Selected Run Time");
        final int selectedRunPace = extras.getInt("Selected Run Pace");
        final String selectedRunRoute = extras.getString("Selected Run Route");
        final String selectedRunType = extras.getString("Selected Run Type");

        showTitleTextView.setText("Run: " + selectedRunTitle);
        showDistanceTextView.setText("Distance: " + selectedRunDistance + " km");
        showTimeTextView.setText("Time: " + selectedRunTime + " mins");
        showPaceTextView.setText("Pace: " + selectedRunPace + " mins/km");
        showRouteTextView.setText("Route: " + selectedRunRoute);
        showTypeTextView.setText("Type: " + selectedRunType);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("OriginalRunInfo", "Selected run: title: " + selectedRunTitle +
                        ", "  + selectedRunDistance + ", " + selectedRunTime + ", " +
                        selectedRunPace + ", " + selectedRunRoute + ", " + selectedRunType);

                Intent intent = new Intent(ShowRun.this, EditRun.class);
                intent.putExtra("OriginalTitle", selectedRunTitle);
                intent.putExtra("OriginalDistance",selectedRunDistance);
                intent.putExtra("OriginalTime", selectedRunTime);
                intent.putExtra("OriginalPace", selectedRunPace);
                intent.putExtra("OriginalRoute", selectedRunRoute);
                intent.putExtra("OriginalType", selectedRunType);
                startActivity(intent);
            }
        });
    }
}
