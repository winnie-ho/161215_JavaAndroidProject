package com.example.user.runtrack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by user on 16/12/2016.
 */
public class NewRun extends AppCompatActivity {
    EditText titleEditText;
    EditText distanceEditText;
    Button addRunButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final DBHandler db = ((MainApplication)getApplication()).db;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_run);

        titleEditText = (EditText)findViewById(R.id.run_title);
        distanceEditText = (EditText)findViewById(R.id.distance);
        addRunButton = (Button)findViewById(R.id.button_add_run);

        addRunButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleEditText.getText().toString();
                int distance = Integer.parseInt(distanceEditText.getText().toString());

                Run newRun = new Run(title, distance);
                db.addRun(newRun);
                Log.d("Add:", "Adding new run.." + title + " " + distance + "k");
                backToMainScreen();
            }
        });
    }

    private void backToMainScreen() {
        Intent intent = new Intent(NewRun.this, MainActivity.class);
        startActivity(intent);
    }

}
