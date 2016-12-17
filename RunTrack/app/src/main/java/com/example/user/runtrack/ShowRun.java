package com.example.user.runtrack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.widget.TextView;

/**
 * Created by user on 17/12/2016.
 */
public class ShowRun extends AppCompatActivity{
    TextView showTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final DBHandler db = ((MainApplication)getApplication()).db;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_run);

        showTextView = (TextView)findViewById(R.id.show_run);


    }

    private void backToMainScreen() {
        Intent intent = new Intent(ShowRun.this, MainActivity.class);
        startActivity(intent);
    }

}
