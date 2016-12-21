package com.example.user.runtrack;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by user on 21/12/2016.
 */
public class SavedScorePreferences {
    private static final String PREF_SAVEDSCORE = "savedScore";

    public static void setStoredScore(Context context, int value){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(PREF_SAVEDSCORE, value);
        editor.apply();
    }

    public static int getStoredScore(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        int savedScore = sharedPreferences.getInt(PREF_SAVEDSCORE, 0);
        return savedScore;
    }
}
