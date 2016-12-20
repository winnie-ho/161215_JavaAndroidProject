package com.example.user.runtrack;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by user on 17/12/2016.
 */
public class Challenges extends AppCompatActivity {
    ImageView mapImageView;
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

        mapImageView = (ImageView) findViewById(R.id.map);
        challengeTitleTextView = (TextView) findViewById(R.id.challenge_title);
        challengeTypeTextView = (TextView) findViewById(R.id.challenge_type);
        challengeDescriptionTextView = (TextView) findViewById(R.id.challenge_description);


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        final String selectedType = extras.getString("selectedType");

        final ChallengeSet challengeSet = new ChallengeSet();



        if (selectedType.equals("Short")) {
            Challenge selectedChallenge = challengeSet.getShortChallenge();
            giveChallenge(selectedChallenge);
        } else if (selectedType.equals("Long")) {
            Challenge selectedChallenge = challengeSet.getLongChallenge();
            giveChallenge(selectedChallenge);
        } else if (selectedType.equals("Intervals")) {
            Challenge selectedChallenge = challengeSet.getIntervalChallenge();
            giveChallenge(selectedChallenge);
        } else if (selectedType.equals("Hills")) {
            Challenge selectedChallenge = challengeSet.getHillChallenge();
            giveChallenge(selectedChallenge);
        }
    }


    public void giveChallenge(Challenge selectedChallenge) {
        int imageID = getResources().getIdentifier(selectedChallenge.getImage(), "drawable", getPackageName());
        Log.d("Image ID", "Image selected: " + selectedChallenge.getImage() + ", " + imageID);
        mapImageView.setImageResource(imageID);
        challengeTitleTextView.setText(selectedChallenge.getTitle());
        challengeTypeTextView.setText(selectedChallenge.getType() + " challenge selected. Are you game?");
        challengeDescriptionTextView.setText(selectedChallenge.getDescription());
    }
}


//        shortButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                Challenge selectedChallenge = challengeSet.getShortChallenge();
//                giveChallenge(selectedChallenge);
//            }
//        });
//
//        longButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                Challenge selectedChallenge = challengeSet.getLongChallenge();
//                giveChallenge(selectedChallenge);
//            }
//        });
//
//        intervalsButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                Challenge selectedChallenge = challengeSet.getIntervalChallenge();
//                giveChallenge(selectedChallenge);
//            }
//        });
//
//        hillButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                Challenge selectedChallenge = challengeSet.getHillChallenge();
//                giveChallenge(selectedChallenge);
//            }
//        });
//
//
//    }




