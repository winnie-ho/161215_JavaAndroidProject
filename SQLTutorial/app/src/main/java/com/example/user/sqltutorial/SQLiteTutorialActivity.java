package com.example.user.sqltutorial;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SQLiteTutorialActivity extends Activity {
    TextView databaseText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);

        Log.d("Insert: ", "Inserting ..");
        db.addContact(new Contact("Winnie", "9533333333"));
        db.addContact(new Contact("Hong", "9100000000"));
        db.addContact(new Contact("Jamgal", "1849350123"));

        String contactText = db.printAllContacts();
        String displayText = "Sample from database " + contactText;

        databaseText = (TextView) findViewById(R.id.db_text);
        databaseText.setText(displayText);


        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.getAllContacts();

        for (Contact cn : contacts) {
            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }

        Log.d("Delete:", "Deleting ..");
        db.deleteContact(new Contact("Winnie", "9533333333"));

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Contact> contacts2 = db.getAllContacts();

        for (Contact cn : contacts2) {
            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }
    }
}