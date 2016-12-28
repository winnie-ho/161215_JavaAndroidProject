package com.example.user.runtrack;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by user on 28/12/2016.
 */
public class SavedCompletePreferences {
    private static final String PREF_SAVEDCOMPLETE = "savedComplete";

    public static void setStoredComplete(Context context, int value){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(PREF_SAVEDCOMPLETE, value);
        editor.apply();
    }

    public static int getStoredComplete(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        int savedComplete = sharedPreferences.getInt(PREF_SAVEDCOMPLETE, 0);
        return savedComplete;
    }
}
