package com.example.user.runtrack;

/**
 * Created by user on 20/12/2016.
 */
public class Challenge {
    String title;
    int distance;
    String description;
    String image;
    String type;

    //Constructor
    public Challenge(String title,int distance, String description, String image, String type){
        this.title = title;
        this.distance = distance;
        this.description = description;
        this.image = image;
        this.type = type;
    }

    //Getters
    public String getTitle(){
        return this.title;
    }

    public int getDistance(){
        return this.distance;
    }

    public String getDescription(){
        return this.description;
    }

    public String getImage(){
        return this.image;
    }

    public String getType(){
        return this.type;
    }

}
