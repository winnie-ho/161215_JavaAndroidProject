package com.example.user.runtrack;

/**
 * Created by user on 21/12/2016.
 */
public class Score {
    private int points;

    public Score(){
        this.points = 0;
    }

    //Getter


    public int getScore(){
        return this.points;
    }


    //Methods
    public int addPoints(int distance){
        return this.points += (distance*10);
    }

    public int subtractPoints(int distance){
        return this.points -= (distance * 10);
    }
}
