package com.example.user.runtrack;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by user on 16/12/2016.
 */
public class NewRun extends AppCompatActivity {
    EditText titleEditText;
    EditText distanceEditText;
    EditText timeEditText;
    EditText paceEditText;
    EditText routeEditText;
    EditText typeEditText;
    Button addRunButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final DBHandler db = ((MainApplication)getApplication()).db;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_run);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);

        titleEditText = (EditText)findViewById(R.id.run_title);
        distanceEditText = (EditText)findViewById(R.id.distance);
        timeEditText = (EditText)findViewById(R.id.time);
        paceEditText = (EditText)findViewById(R.id.pace);
        routeEditText = (EditText)findViewById(R.id.route);
        typeEditText = (EditText)findViewById(R.id.type);
        addRunButton = (Button)findViewById(R.id.button_add_run);

        addRunButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleEditText.getText().toString();
                int distance = Integer.parseInt(distanceEditText.getText().toString());
                int time = Integer.parseInt(timeEditText.getText().toString());
                int pace = Integer.parseInt(paceEditText.getText().toString());
                String route = routeEditText.getText().toString();
                String type = typeEditText.getText().toString();

                Run newRun = new Run(title, distance, time, pace, route, type);
                db.addRun(newRun);
                Log.d("Add:", "Adding new run.." + title + " " + distance + "k");
                Toast.makeText(NewRun.this, "Run Added!", Toast.LENGTH_SHORT).show();
                backToMainScreen();
            }
        });
    }

    private void backToMainScreen() {
        Intent intent = new Intent(NewRun.this, MainActivity.class);
        startActivity(intent);
    }

}
