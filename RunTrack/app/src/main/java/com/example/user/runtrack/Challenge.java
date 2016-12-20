package com.example.user.runtrack;

/**
 * Created by user on 20/12/2016.
 */
public class Challenge {
    private String title;
    private String description;
    private String image;
    private String type;


    //Constructor
    public Challenge(String title, String description, String image, String type){
        this.title = title;
        this.description = description;
        this.image = image;
        this.type = type;
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


}
