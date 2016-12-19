package com.example.user.runtrack;

import android.app.ActionBar;
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

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        final int selectedId = extras.getInt("ID");
        final String selectedTitle = extras.getString("Title");
        final int selectedDistance = extras.getInt("Distance");
        final int selectedTime = extras.getInt("Time");
        final int selectedPace = extras.getInt("Pace");
        final String selectedRoute = extras.getString("Route");
        final String selectedType = extras.getString("Type");

        titleEditText.setText(selectedTitle);
        distanceEditText.setText("" + selectedDistance);
        timeEditText.setText("" + selectedTime);
        paceEditText.setText("" + selectedPace);
        routeEditText.setText(selectedRoute);
        typeEditText.setText(selectedType);

        editRunButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = titleEditText.getText().toString();
                int distance = Integer.parseInt(distanceEditText.getText().toString());
                int time = Integer.parseInt(timeEditText.getText().toString());
                int pace = Integer.parseInt(paceEditText.getText().toString());
                String route = routeEditText.getText().toString();
                String type = typeEditText.getText().toString();

                Run runToEdit = new Run(selectedId, title, distance, time, pace, route, type);
                db.updateRun(runToEdit);
                Log.d("Edit:", "Editing run.." + title + ", " + distance + " k");

                Intent intent = new Intent(EditRun.this, AllRuns.class);
                intent.putExtra("ID", selectedId);
                intent.putExtra("Title", selectedTitle);
                intent.putExtra("Distance",selectedDistance);
                intent.putExtra("Time", selectedTime);
                intent.putExtra("Pace", selectedPace);
                intent.putExtra("Route", selectedRoute);
                intent.putExtra("Type", selectedType);
                startActivity(intent);
            }
        });
    }


}
