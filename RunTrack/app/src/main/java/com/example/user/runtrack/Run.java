package com.example.user.runtrack;

import org.w3c.dom.Text;

import java.sql.Time;
import java.util.Date;

/**
 * Created by user on 16/12/2016.
 */
public class Run {
    private int id;
    private String title;
    private int day;
    private int month;
    private int year;
    private float distance;
    private float time;
    private float pace;
    private String type;
    private String comment;


    //Full Run Constructor for DB
    public Run(int id, String title, int day, int month, int year, float distance, float time, String type, String comment){
        this.id = id;
        this.title = title;
        this.day = day;
        this.month = month;
        this.year = year;
        this.distance = distance;
        this.time = time;
        this.type = type;
        this.comment = comment;
    }

    //Full Run Constructor
    public Run(String title, int day, int month, int year, float distance, float time, String type, String comment){
        this.title = title;
        this.day = day;
        this.month = month;
        this.year = year;
        this.distance = distance;
        this.time = time;
        this.type = type;
        this.comment = comment;
    }

    //Simple Run Constructor
    public Run(String title, float distance){
        this.title = title;
        this.distance = distance;
    }


    //Getters
    public int getId(){
        return this.id;
    }

    public String getRunTitle(){
        return this.title;
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public float getDistance(){
        return this.distance;
    }

    public float getTime(){
        return this.time;
    }

    public float getPace(){
        this.pace = this.time/this.distance;
        return this.pace;
    }

    public String getType(){
        return this.type;
    }

    public String getComment(){
        return this.comment;
    }
    //Methods


}
