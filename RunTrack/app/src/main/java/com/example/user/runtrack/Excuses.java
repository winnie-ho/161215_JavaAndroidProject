package com.example.user.runtrack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by user on 18/12/2016.
 */
public class Excuses extends AppCompatActivity {
    EditText getExcuseEditText;
    Button giveExcuseButton;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        if (item.getItemId() == R.id.add_run) {
            Intent intent = new Intent(Excuses.this, NewRun.class);
            this.startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.all_runs) {
            Intent intent = new Intent(Excuses.this, AllRuns.class);
            this.startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.run_roulette) {
            Intent intent = new Intent(Excuses.this, RunRoulette.class);
            this.startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.excuses);

        getExcuseEditText = (EditText)findViewById(R.id.excuse_text);
        giveExcuseButton = (Button)findViewById(R.id.give_excuse);

//        giveExcuseButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Excuses.this, RandomRun.class);
//                startActivity(intent);
//            }
//        });


    }
}
