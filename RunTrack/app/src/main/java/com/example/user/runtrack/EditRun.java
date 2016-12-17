package com.example.user.runtrack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by user on 17/12/2016.
 */
public class EditRun extends AppCompatActivity{
    EditText titleEditText;
    EditText distanceEditText;
    EditText timeEditText;
    EditText paceEditText;
    EditText routeEditText;
    EditText typeEditText;
    Button editRunButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final DBHandler db = ((MainApplication)getApplication()).db;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_run);

        titleEditText = (EditText)findViewById(R.id.run_title);
        distanceEditText = (EditText)findViewById(R.id.distance);
        timeEditText = (EditText)findViewById(R.id.time);
        paceEditText = (EditText)findViewById(R.id.pace);
        routeEditText = (EditText)findViewById(R.id.route);
        typeEditText = (EditText)findViewById(R.id.type);
        editRunButton = (Button)findViewById(R.id.button_add_run);

        editRunButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleEditText.getText().toString();
                int distance = Integer.parseInt(distanceEditText.getText().toString());
                int time = Integer.parseInt(timeEditText.getText().toString());
                int pace = Integer.parseInt(paceEditText.getText().toString());
                String route = routeEditText.getText().toString();
                String type = typeEditText.getText().toString();

                Run runToEdit = new Run(title, distance, time, pace, route, type);
                db.updateRun(runToEdit);
                Log.d("Edit:", "Editing run.." + title + " " + distance + "k");
                backToMainScreen();
            }
        });
    }

    private void backToMainScreen() {
        Intent intent = new Intent(EditRun.this, MainActivity.class);
        startActivity(intent);
    }

}
