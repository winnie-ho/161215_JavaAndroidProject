package com.example.user.runtrack;

import android.app.Application;

/**
 * Created by user on 16/12/2016.
 */
public class MainApplication extends Application {
    DBHandler db;

    @Override
    public void onCreate(){
        super.onCreate();
        db = new DBHandler(this);
    }
}
