package com.example.user.runtrack;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.sql.Array;
import java.util.ArrayList;

/**
 * Created by user on 30/12/2016.
 */
public class Stats extends AppCompatActivity {
    TextView statTitleTextView;
    LineGraphSeries<DataPoint> series;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        if (item.getItemId() == R.id.add_run) {
            Intent intent = new Intent(Stats.this, NewRun.class);
            this.startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.all_runs) {
            Intent intent = new Intent(Stats.this, AllRuns.class);
            this.startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.challenge_select) {
            Intent intent = new Intent(Stats.this, ChallengeSelect.class);
            this.startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.home) {
            Intent intent = new Intent(Stats.this, MainActivity.class);
            this.startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final DBHandler db = ((MainApplication) getApplication()).db;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats);

        //Logo in action bar
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.action_bar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        View mCustomView = getSupportActionBar().getCustomView();
        TextView actionBarTitle = (TextView) mCustomView.findViewById(R.id.action_bar_title);
        ImageView actionBarIcon = (ImageView) mCustomView.findViewById(R.id.action_bar_icon);
        actionBarTitle.setText(R.string.stats);
        actionBarIcon.setImageResource(R.drawable.icon_long);


        statTitleTextView = (TextView) findViewById(R.id.stat_title);



        ArrayList<Run> allRuns = db.getAllRuns();

        double y, x;
        //x starts at zero
        x = 0;
        //y starts at zero;
        y = 0;

        GraphView stats_graph = (GraphView) findViewById(R.id.stats_graph);
        series = new LineGraphSeries<DataPoint>();

        for (Run run : allRuns) {
            x = x + run.getId();
            y = run.getDistance();
            series.appendData(new DataPoint(x, y),true, 5);
        }

        stats_graph.addSeries(series);


        stats_graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if (isValueX) {
                    // show normal x values
                    return super.formatLabel(value, isValueX);
                } else {
                    // show currency for y values
                    return super.formatLabel(value, isValueX) + " km";
                }
            }
        });

        }


}
