package com.example.user.runtrack;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by user on 20/12/2016.
 */
public class ChallengeSelect extends AppCompatActivity {
    RelativeLayout shortButton;
    RelativeLayout longButton;
    RelativeLayout intervalsButton;
    RelativeLayout hillButton;
    TextView pointsTextView;
    TextView scoreTextView;
    TextView playedTextView;
    TextView completeTextView;
    TextView failedTextView;
    TextView challengeTitleTextView;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        if (item.getItemId() == R.id.add_run) {
            Intent intent = new Intent(ChallengeSelect.this, NewRun.class);
            this.startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.all_runs) {
            Intent intent = new Intent(ChallengeSelect.this, AllRuns.class);
            this.startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.challenge_select) {
            Intent intent = new Intent(ChallengeSelect.this, ChallengeSelect.class);
            this.startActivity(intent);
            return true;
        }else if (item.getItemId() == R.id.home){
            Intent intent = new Intent(ChallengeSelect.this, MainActivity.class);
            this.startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.challenge_select);

        shortButton = (RelativeLayout) findViewById(R.id.type_short);
        longButton = (RelativeLayout)findViewById(R.id.type_long);
        intervalsButton = (RelativeLayout) findViewById(R.id.type_intervals);
        hillButton = (RelativeLayout)findViewById(R.id.type_hills);
        pointsTextView = (TextView)findViewById(R.id.points);
        scoreTextView = (TextView)findViewById(R.id.points_score);
        playedTextView = (TextView)findViewById(R.id.played);
        completeTextView = (TextView)findViewById(R.id.complete);
        failedTextView = (TextView)findViewById(R.id.failed);
        challengeTitleTextView = (TextView)findViewById(R.id.challenge_select);

        int savedScoreFromPreferences = SavedScorePreferences.getStoredScore(this);
        final int score = savedScoreFromPreferences;

        int savedPlayedFromPreferences = SavedPlayedPreferences.getStoredPlayed(this);
        final int played = savedPlayedFromPreferences;

        int savedCompleteFromPreferences = SavedCompletePreferences.getStoredComplete(this);
        final int complete = savedCompleteFromPreferences;

        int savedFailedFromPreferences = SavedFailedPreferences.getStoredFailed(this);
        final int failed = savedFailedFromPreferences;

            scoreTextView.setText("" + savedScoreFromPreferences);
            playedTextView.setText("PLAYED\n" + savedPlayedFromPreferences);
            completeTextView.setText("COMPLETE\n" + savedCompleteFromPreferences);
            failedTextView.setText("FAILED\n" + savedFailedFromPreferences);


        final HillChallenge challengeSet = new HillChallenge();

        shortButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Context context = v.getContext();
                SavedScorePreferences.setStoredScore(context, score);
                SavedPlayedPreferences.setStoredPlayed(context, played + 1);

                String selectedType = "Short";
                Intent intent = new Intent(ChallengeSelect.this, Challenges.class);
                intent.putExtra("selectedType", selectedType);
                intent.putExtra("score", score);
                startActivity(intent);
            }
        });

        longButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Context context = v.getContext();
                SavedScorePreferences.setStoredScore(context, score);
                SavedPlayedPreferences.setStoredPlayed(context, played + 1);

                String selectedType = "Long";
                Intent intent = new Intent(ChallengeSelect.this, Challenges.class);
                intent.putExtra("selectedType", selectedType);
                intent.putExtra("score", score);;
                startActivity(intent);
            }
        });

        intervalsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Context context = v.getContext();
                SavedScorePreferences.setStoredScore(context, score);
                SavedPlayedPreferences.setStoredPlayed(context, played + 1);

                String selectedType = "Intervals";
                Intent intent = new Intent(ChallengeSelect.this, Challenges.class);
                intent.putExtra("selectedType", selectedType);
                intent.putExtra("score", score);
                startActivity(intent);
            }
        });

        hillButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Context context = v.getContext();
                SavedScorePreferences.setStoredScore(context, score);
                SavedPlayedPreferences.setStoredPlayed(context, played +1);

                String selectedType = "Hills";
                Intent intent = new Intent(ChallengeSelect.this, Challenges.class);
                intent.putExtra("selectedType", selectedType);
                intent.putExtra("score", score);
                startActivity(intent);
            }
        });
    }
}
