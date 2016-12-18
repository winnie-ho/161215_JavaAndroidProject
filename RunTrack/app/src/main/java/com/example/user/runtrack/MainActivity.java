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
    TextView summaryTextView;
    TextView totalDistanceTextView;
    Button allRunButton;
    Button randomButton;


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
        } else if (item.getItemId() == R.id.run_roulette) {
            Intent intent = new Intent(MainActivity.this, RunRoulette.class);
            this.startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        summaryTextView = (TextView)findViewById(R.id.summary);
        totalDistanceTextView = (TextView)findViewById(R.id.total_distance);
        allRunButton = (Button)findViewById(R.id.all_runs);
        randomButton = (Button)findViewById(R.id.run_roulette);


        allRunButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, AllRuns.class);
                startActivity(intent);
            }
        });

        randomButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, RunRoulette.class);
                startActivity(intent);
            }
        });
    }
}