package com.example.user.runtrack;

/**
 * Created by user on 20/12/2016.
 */
public class Challenge {
    private int id;
    private String title;
    private String description;
    private String image;
    private String type;
    private Boolean status;

    //Constructor
    public Challenge(String title, String description, String image, String type, Boolean status){
        this.title = title;
        this.description = description;
        this.image = image;
        this.type = type;
        this.status = status;
    }

    //Getters
    public String getTitle(){
        return this.title;
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

    public Boolean getStatus(){
        return this.status;
    }
}
