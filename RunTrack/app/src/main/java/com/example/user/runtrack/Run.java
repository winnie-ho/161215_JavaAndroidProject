package com.example.user.runtrack;

import java.sql.Time;
import java.util.Date;

/**
 * Created by user on 16/12/2016.
 */
public class Run {
    private int id;
    private String title;
    private int distance;
    private int time;
    private int pace;
    private String route;
    private String type;

    //Full Run Constructor for DB
    public Run(int id, String title, int distance, int time, int pace, String route, String type){
        this.id = id;
        this.title = title;
        this.distance = distance;
        this.time = time;
        this.pace = pace;
        this.route = route;
        this.type = type;
    }

    //Full Run Constructor
    public Run(String title, int distance, int time, int pace, String route, String type){
        this.title = title;
        this.distance = distance;
        this.time = time;
        this.pace = pace;
        this.route = route;
        this.type = type;
    }

    //Simple Run Constructor
    public Run(String title, int distance){
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

    public int getDistance(){
        return this.distance;
    }

    public int getTime(){
        return this.time;
    }

    public int getPace(){
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
