package com.example.user.runtrack;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by user on 28/12/2016.
 */
public class SavedPlayedPreferences {
    private static final String PREF_SAVEDPLAYED = "savedPlayed";

    public static void setStoredPlayed(Context context, int value){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(PREF_SAVEDPLAYED, value);
        editor.apply();
    }

    public static int getStoredPlayed(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        int savedPlayed = sharedPreferences.getInt(PREF_SAVEDPLAYED, 0);
        return savedPlayed;
    }
}
