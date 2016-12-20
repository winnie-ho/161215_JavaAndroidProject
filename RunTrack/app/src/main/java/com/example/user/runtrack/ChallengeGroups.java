package com.example.user.runtrack;

import java.util.ArrayList;

/**
 * Created by user on 20/12/2016.
 */
public class ChallengeGroups {
    private ArrayList<Challenge>main;
    private ArrayList<Challenge>complete;
    private ArrayList<Challenge>failed;

    //Constructor
    public ChallengeGroups(){
        this.main = new ArrayList<Challenge>();
        this.complete = new ArrayList<Challenge>();
        this.failed = new ArrayList<Challenge>();
    }

    //Getters
    public ArrayList getChallengeMain(){
        return this.main;
    }

    public ArrayList getChallengeComplete(){
        return this.complete;
    }

    public ArrayList getChallengeFailed(){
        return this.failed;
    }

    //Methods
    //For Main Challenge ArrayList
    public void addMainChallenge(Challenge challenge){
        main.add(challenge);
    }

    public void removeMainChallenge(Challenge challenge){
        main.remove(challenge);
    }

    public int MainChallengeSize(){
        return main.size();
    }


    //For Completed Challenges ArrayList
    public void addCompleteChallenge(Challenge challenge){
        complete.add(challenge);
    }

    public void removeCompleteChallenge(Challenge challenge){
        complete.remove(challenge);
    }

    public int completeChallengeSize(){
        return complete.size();
    }


    //For Failed Challenges ArrayList
    public void addFailedChallenge(Challenge challenge){
        complete.add(challenge);
    }

    public void removeFailedChallenge(Challenge challenge){
        complete.remove(challenge);
    }

    public int failedChallengeSize(){
        return complete.size();
    }






}
