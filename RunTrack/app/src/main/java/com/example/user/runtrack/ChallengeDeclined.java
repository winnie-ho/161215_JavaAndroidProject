package com.example.user.runtrack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by user on 04/01/2017.
 */
public class ChallengeDeclined extends AppCompatActivity{
    TextView challengeTitleTextView;
    TextView pointsAvailableTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.challenge_declined);

        challengeTitleTextView = (TextView)findViewById(R.id.challenge_title);


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        final int newScore = extras.getInt("newScore");
        final String challengeTitle = extras.getString("challengeTitle");
        final int challengeDistance = extras.getInt("challengeDistance");
        final String challengeType = extras.getString("challengeType");
        final int pointsAvailable = extras.getInt("pointsAvailable");

        challengeTitleTextView = (TextView) findViewById(R.id.challenge_title);
        pointsAvailableTextView = (TextView) findViewById(R.id.points_available);

        challengeTitleTextView.setText(challengeTitle);
        pointsAvailableTextView.setText(pointsAvailable + " points deducted!");

        Thread myThread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(5000);
                    Intent intent = new Intent(getApplicationContext(), ChallengeSelect.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();
    }
}

