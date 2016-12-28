package com.example.user.runtrack;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by user on 28/12/2016.
 */
public class SavedFailedPreferences {
    private static final String PREF_SAVEDFAILED = "savedFailed";

    public static void setStoredFailed(Context context, int value){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(PREF_SAVEDFAILED, value);
        editor.apply();
    }

    public static int getStoredFailed(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        int savedFailed = sharedPreferences.getInt(PREF_SAVEDFAILED, 0);
        return savedFailed;
    }
}
