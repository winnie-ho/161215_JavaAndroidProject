package com.example.user.runtrack;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by user on 17/12/2016.
 */
public class Challenges extends AppCompatActivity {
    ImageView mapImageView;
    TextView challengeTitleTextView;
    TextView pointsTextView;
    TextView challengeDistanceTextView;
    TextView challengeTypeTextView;
    TextView challengeDescriptionTextView;
    Button acceptButton;
    Button declineButton;

    ShortChallenge shortChallenge = new ShortChallenge();
    LongChallenge longChallenge = new LongChallenge();
    IntervalChallenge intervalChallenge = new IntervalChallenge();
    HillChallenge hillChallenge = new HillChallenge();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.challenges);

        mapImageView = (ImageView) findViewById(R.id.map);
        challengeTitleTextView = (TextView) findViewById(R.id.challenge_title);
        pointsTextView = (TextView)findViewById(R.id.challenge_points);
        challengeDistanceTextView = (TextView)findViewById(R.id.distance);
        challengeTypeTextView = (TextView) findViewById(R.id.challenge_type);
        challengeDescriptionTextView = (TextView) findViewById(R.id.challenge_description);
        acceptButton = (Button)findViewById(R.id.yea);
        declineButton = (Button)findViewById(R.id.wimp);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        final String selectedType = extras.getString("selectedType");
        final int scoreCarried = extras.getInt("score");

        final Challenge selectedChallenge = getSelectedChallenge(selectedType);
        giveChallenge(selectedChallenge);

        int savedCompleteFromPreferences = SavedCompletePreferences.getStoredComplete(this);
        final int complete = savedCompleteFromPreferences;

        int savedFailedFromPreferences = SavedFailedPreferences.getStoredFailed(this);
        final int failed = savedFailedFromPreferences;

        acceptButton.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View v){
                Context context = v.getContext();
                int distancePoints = getDistancePoints(selectedChallenge);
                int newScore = scoreCarried + distancePoints;

                SavedCompletePreferences.setStoredComplete(context, complete + 1);

                Intent intent = new Intent(Challenges.this, ChallengeAccepted.class);

                SavedScorePreferences.setStoredScore(context, newScore);
                intent.putExtra("newScore", newScore);
                intent.putExtra("challengeTitle", selectedChallenge.getTitle());
                intent.putExtra("challengeDistance",selectedChallenge.getDistance());
                intent.putExtra("challengeType",selectedChallenge.getType());
                intent.putExtra("pointsAvailable", distancePoints);
                startActivity(intent);
            }
        });

        declineButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Context context = v.getContext();
                int distancePoints = getDistancePoints(selectedChallenge);
                int newScore = scoreCarried - distancePoints;

                SavedFailedPreferences.setStoredFailed(context, failed + 1);

                Intent intent = new Intent(Challenges.this, ChallengeDeclined.class);

                SavedScorePreferences.setStoredScore(context, newScore);
                intent.putExtra("newScore", newScore);
                intent.putExtra("pointsAvailable", distancePoints);
                startActivity(intent);
            }
        });
    }

    //Generates random challenge depending on the selected category
    public Challenge getSelectedChallenge(String selectedType){
        Challenge selectedChallenge = null;
        if (selectedType.equals("Short")) {
            selectedChallenge = shortChallenge.getShortChallenge();
        } else if (selectedType.equals("Long")) {
            selectedChallenge = longChallenge.getLongChallenge();
        } else if (selectedType.equals("Intervals")) {
            selectedChallenge = intervalChallenge.getIntervalChallenge();
        } else if (selectedType.equals("Hills")) {
            selectedChallenge = hillChallenge.getHillChallenge();
        }
        return selectedChallenge ;
    }

    //Gives the details of the challenged selected to populate the views in activity screen
    public void giveChallenge(Challenge selectedChallenge) {
        int imageID = getResources().getIdentifier(selectedChallenge.getImage(), "drawable", getPackageName());
        Log.d("Image ID", "Image selected: " + selectedChallenge.getImage() + ", " + imageID);
        mapImageView.setImageResource(imageID);
        challengeTitleTextView.setText(selectedChallenge.getTitle().toUpperCase()+" -");
        pointsTextView.setText(selectedChallenge.getDistance()*10 + " points");
        challengeDistanceTextView.setText(selectedChallenge.getDistance()+" km");
        challengeTypeTextView.setText(selectedChallenge.getType().toUpperCase() + " CHALLENGE! ARE YOU GAME?");
        challengeDescriptionTextView.setText(selectedChallenge.getDescription());
    }

    public int getDistancePoints(Challenge selectedChallenge){
        int distanceValue = (selectedChallenge.getDistance() * 10);
        return distanceValue;
    }
}

