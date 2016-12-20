package com.example.user.runtrack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by user on 17/12/2016.
 */
public class Challenges extends AppCompatActivity {
    Button shortButton;
    Button longButton;
    Button intervalsButton;
    Button randomButton;
    TextView challengeTitleTextView;
    TextView challengeTypeTextView;
    TextView challengeDescriptionTextView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        if (item.getItemId() == R.id.add_run) {
            Intent intent = new Intent(Challenges.this, NewRun.class);
            this.startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.all_runs) {
            Intent intent = new Intent(Challenges.this, AllRuns.class);
            this.startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.challenges) {
            Intent intent = new Intent(Challenges.this, Challenges.class);
            this.startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.challenges);

        ChallengeSet challengeSet = new ChallengeSet();

        shortButton = (Button)findViewById(R.id.type_short);
        longButton = (Button)findViewById(R.id.type_long);
        intervalsButton = (Button)findViewById(R.id.type_intervals);
        randomButton = (Button)findViewById(R.id.type_random);
        challengeTitleTextView = (TextView)findViewById(R.id.challenge_title);
        challengeTypeTextView = (TextView)findViewById(R.id.challenge_description);
        challengeDescriptionTextView = (TextView)findViewById(R.id.challenge_type);

        Challenge challenge1 = challengeSet.retrieveChallenge(0);
        challengeTitleTextView.setText(challenge1.getTitle());
        challengeTypeTextView.setText(challenge1.getType());
        challengeDescriptionTextView.setText(challenge1.getDescription());



    }
}