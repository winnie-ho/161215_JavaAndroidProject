package com.example.user.runtrack;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by user on 21/12/2016.
 */
public class ChallengeAccepted extends AppCompatActivity {

    TextView challengeAcceptedTextView;
    TextView challengeTitleTextView;
    TextView pointsAvailableTextView;
    Button addToLogButton;



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        if (item.getItemId() == R.id.add_run) {
            Intent intent = new Intent(ChallengeAccepted.this, NewRun.class);
            this.startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.all_runs) {
            Intent intent = new Intent(ChallengeAccepted.this, AllRuns.class);
            this.startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.challenge_select) {
            Intent intent = new Intent(ChallengeAccepted.this, ChallengeSelect.class);
            this.startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.home){
            Intent intent = new Intent(ChallengeAccepted.this, MainActivity.class);
            this.startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.challenge_accepted);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        final int newScore = extras.getInt("newScore");
        final String challengeTitle = extras.getString("challengeTitle");
        final int challengeDistance = extras.getInt("challengeDistance");
        final String challengeType = extras.getString("challengeType");
        final int pointsAvailable = extras.getInt("pointsAvailable");


        Log.d("carriedInfo", challengeTitle +", " + pointsAvailable + ", " + challengeType);


        challengeAcceptedTextView = (TextView) findViewById(R.id.challenge_accepted);
        challengeTitleTextView = (TextView) findViewById(R.id.challenge_title);
        pointsAvailableTextView = (TextView) findViewById(R.id.points_available);
        addToLogButton = (Button) findViewById(R.id.add_to_log);

        challengeTitleTextView.setText(challengeTitle);
        pointsAvailableTextView.setText(pointsAvailable + " points");

        addToLogButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent(ChallengeAccepted.this, NewRunC.class);
                Context context = v.getContext();
                SavedScorePreferences.setStoredScore(context, newScore);
                intent.putExtra("newScore", newScore);
                intent.putExtra("challengeTitle", challengeTitle);
                intent.putExtra("challengeDistance", challengeDistance);
                intent.putExtra("challengeType", challengeType);
                intent.putExtra("pointsAvailable", pointsAvailable);
                startActivity(intent);
            }
        });

    }
}
