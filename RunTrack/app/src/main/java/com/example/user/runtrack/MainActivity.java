package com.example.user.runtrack;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by user on 17/12/2016.
 */
public class MainActivity extends AppCompatActivity {
    TextView progressMessageTextView;
    TextView totalRunTextView;
    TextView totalDistanceTextView;
    TextView totalTimeTextView;
    TextView scoreTextView;
    TextView playedTextView;
    TextView completeTextView;
    TextView failedTextView;
    ImageView challengesButton;
    ImageView allRunButton;
    ImageView homeButton;
    ImageView addRunButton;

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

        //Logo in action bar
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.action_bar_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        View mCustomView = getSupportActionBar().getCustomView();

        //Creating database
        final DBHandler db = ((MainApplication) getApplication()).db;
        //Creating messages array list
        Message message = new Message();

        progressMessageTextView = (TextView)findViewById(R.id.progress_message);
        totalRunTextView = (TextView)findViewById(R.id.total_runs);
        totalDistanceTextView = (TextView)findViewById(R.id.total_distance);
        totalTimeTextView = (TextView)findViewById(R.id.total_time);
        scoreTextView = (TextView)findViewById(R.id.points_score);
        playedTextView = (TextView)findViewById(R.id.played);
        completeTextView = (TextView)findViewById(R.id.complete);
        failedTextView = (TextView)findViewById(R.id.failed);
        allRunButton = (ImageView)findViewById(R.id.all_runs);
        challengesButton = (ImageView) findViewById(R.id.challenges);
        homeButton = (ImageView)findViewById(R.id.home_button);
        addRunButton = (ImageView)findViewById(R.id.addrun_button);

        int savedScoreFromPreferences = SavedScorePreferences.getStoredScore(this);
        final int score = savedScoreFromPreferences;

        int savedPlayedFromPreferences = SavedPlayedPreferences.getStoredPlayed(this);
        final int played = savedPlayedFromPreferences;

        int savedCompleteFromPreferences = SavedCompletePreferences.getStoredComplete(this);
        final int complete = savedCompleteFromPreferences;

        int savedFailedFromPreferences = SavedFailedPreferences.getStoredFailed(this);
        final int failed = savedFailedFromPreferences;

        progressMessageTextView.setText(message.getMessage());
        totalRunTextView.setText("RUNS \n" + db.getTotalRun());
        totalDistanceTextView.setText("DISTANCE \n" + db.getTotalDistance()+ " km");
        totalTimeTextView.setText("TIME \n" + db.getTotalTime());
        scoreTextView.setText("CHALLENGE POINTS: " + savedScoreFromPreferences);
        playedTextView.setText("PLAYED \n" + savedPlayedFromPreferences);
        completeTextView.setText("COMPLETE \n" + savedCompleteFromPreferences);
        failedTextView.setText("FAILED \n" + savedFailedFromPreferences);

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

        homeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        addRunButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, NewRun.class);
                startActivity(intent);
            }
        });

    }
}