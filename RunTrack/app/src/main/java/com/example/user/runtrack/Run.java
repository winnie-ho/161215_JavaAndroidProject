package com.example.user.runtrack;

import java.sql.Time;
import java.util.Date;

/**
 * Created by user on 16/12/2016.
 */
public class Run {
    private int id;
    private String title;
    private float distance;
    private float time;
    private float pace;
    private String route;
    private String type;

    //Full Run Constructor for DB
    public Run(int id, String title, float distance, float time, float pace, String route, String type){
        this.id = id;
        this.title = title;
        this.distance = distance;
        this.time = time;
        this.pace = pace;
        this.route = route;
        this.type = type;
    }

    //Full Run Constructor
    public Run(String title, float distance, float time, float pace, String route, String type){
        this.title = title;
        this.distance = distance;
        this.time = time;
        this.pace = pace;
        this.route = route;
        this.type = type;
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

    public float getDistance(){
        return this.distance;
    }

    public float getTime(){
        return this.time;
    }

    public float getPace(){
        return this.pace;
    }

    public String getRoute(){
        return this.route;
    }

    public String getType(){
        return this.type;
    }


    //Methods


}
