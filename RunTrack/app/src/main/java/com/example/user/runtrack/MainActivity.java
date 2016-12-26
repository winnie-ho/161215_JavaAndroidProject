package com.example.user.runtrack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by user on 17/12/2016.
 */
public class MainActivity extends AppCompatActivity {
    TextView progressMessageTextView;
    TextView totalRunTextView;
    TextView totalDistanceTextView;
    TextView totalTimeTextView;
    TextView scoreTextView;
    Button allRunButton;
    Button challengesButton;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        if (item.getItemId() == R.id.add_run) {
            Intent intent = new Intent(MainActivity.this, NewRun.class);
            this.startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.all_runs) {
            Intent intent = new Intent(MainActivity.this, AllRuns.class);
            this.startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.challenge_select) {
            Intent intent = new Intent(MainActivity.this, ChallengeSelect.class);
            this.startActivity(intent);
            return true;
        }else if (item.getItemId() == R.id.home){
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            this.startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creating database
        final DBHandler db = ((MainApplication) getApplication()).db;
        //Creating messages array list
        Message message = new Message();

        progressMessageTextView = (TextView)findViewById(R.id.progress_message);
        totalRunTextView = (TextView)findViewById(R.id.total_runs);
        totalDistanceTextView = (TextView)findViewById(R.id.total_distance);
        totalTimeTextView = (TextView)findViewById(R.id.total_time);
        scoreTextView = (TextView)findViewById(R.id.points_score);
        allRunButton = (Button)findViewById(R.id.all_runs);
        challengesButton = (Button)findViewById(R.id.challenges);

        int savedScoreFromPreferences = SavedScorePreferences.getStoredScore(this);
        final int score = savedScoreFromPreferences;

        progressMessageTextView.setText(message.getMessage());
        totalRunTextView.setText("RUNS \n" + db.getTotalRun(3));
        totalDistanceTextView.setText("DISTANCE \n" + db.getTotalDistance(3)+ " km");
        totalTimeTextView.setText("TIME \n" + db.getTotalTime(3)+ " mins");
        scoreTextView.setText("CHALLENGE POINTS: " + savedScoreFromPreferences);

        allRunButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, AllRuns.class);
                startActivity(intent);
            }
        });

        challengesButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, ChallengeSelect.class);
                startActivity(intent);
            }
        });


    }
}