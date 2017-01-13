package com.example.user.runtrack;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by user on 13/01/2017.
 */
public class DateNow {
    private Date dateNow;

    //Constructor
    public DateNow() {
        this.dateNow = new Date();
    }

    //Getters
    public Date getDateNow() {
        return this.dateNow;
    }

    //Methods
    public int getYearNow() {
        DateFormat yearFormat = new SimpleDateFormat("yyyy");
        String yearNow = yearFormat.format(this.dateNow);
        int year = Integer.parseInt(yearNow);
        return year;
    }

    public int getMonthNow(){
        DateFormat monthFormat = new SimpleDateFormat("MM");
        String monthNow = monthFormat.format(this.dateNow);
        int month = Integer.parseInt(monthNow);
        return month;
    }

    public int getDayNow(){
        DateFormat dayFormat = new SimpleDateFormat("dd");
        String dayNow = dayFormat.format(this.dateNow);
        int day = Integer.parseInt(dayNow);
        return day;
    }
}
