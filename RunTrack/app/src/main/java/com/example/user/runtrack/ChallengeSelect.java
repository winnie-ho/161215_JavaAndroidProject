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
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by user on 20/12/2016.
 */
public class ChallengeSelect extends AppCompatActivity {
    Button shortButton;
    Button longButton;
    Button intervalsButton;
    Button hillButton;
    TextView pointsTextView;
    TextView scoreTextView;
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
        } else if (item.getItemId() == R.id.challenges) {
            Intent intent = new Intent(ChallengeSelect.this, Challenges.class);
            this.startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.challenge_select);

        shortButton = (Button)findViewById(R.id.type_short);
        longButton = (Button)findViewById(R.id.type_long);
        intervalsButton = (Button)findViewById(R.id.type_intervals);
        hillButton = (Button)findViewById(R.id.type_hills);
        pointsTextView = (TextView)findViewById(R.id.points);
        scoreTextView = (TextView)findViewById(R.id.points_score);
        challengeTitleTextView = (TextView)findViewById(R.id.challenges);

        int savedScoreFromPreferences = SavedScorePreferences.getStoredScore(this);

        final int score = 0;
        scoreTextView.setText("" + savedScoreFromPreferences);


        final ChallengeSet challengeSet = new ChallengeSet();

        shortButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Context context = v.getContext();
                SavedScorePreferences.setStoredScore(context, score);

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

                String selectedType = "Hills";
                Intent intent = new Intent(ChallengeSelect.this, Challenges.class);
                intent.putExtra("selectedType", selectedType);
                intent.putExtra("score", score);
                startActivity(intent);
            }
        });
    }
}
