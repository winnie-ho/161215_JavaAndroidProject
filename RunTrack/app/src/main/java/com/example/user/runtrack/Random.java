package com.example.user.runtrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;

/**
 * Created by user on 17/12/2016.
 */
public class Random extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main,menu);
        return true ;
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item){
        if (item.getItemId() == R.id.add_run){
            Intent intent = new Intent(Random.this, NewRun.class);
            this.startActivity(intent);
            return true;
        }
        else if (item.getItemId() == R.id.all_runs){
            Intent intent = new Intent(Random.this, AllRuns.class);
            this.startActivity(intent);
            return true;
        }
        else if (item.getItemId() == R.id.random){
            Intent intent = new Intent(Random.this, Random.class);
            this.startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
