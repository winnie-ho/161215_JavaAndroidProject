package com.example.user.runtrack;

import java.util.ArrayList;

/**
 * Created by user on 20/12/2016.
 */
public class ChallengeSet {
    private ArrayList<Challenge>challengeSet;


    //Constructor
    public ChallengeSet(){
        this.challengeSet = new ArrayList<Challenge>();
        populateMain();
    }


    //Raw Data
    Challenge challenge1 = new Challenge("Suicide Runs", "400m Loop. 3 x (4 sides, Sprint 1, Recover 3," +
            " Sprint 2, Recover 2, Sprint 3, Recover 1, Sprint 4)","@drawable/suicide_runs", "Intervals");

    Challenge challenge2 = new Challenge("Johnston Terrace Hills", "Phonebox to Phonebox. 10 x (Hill effort," +
            " recover on descent)","@drawable/suicide_runs", "Intervals");


    //Getters
    public ArrayList getChallengeSet(){
        return this.challengeSet;
    }


    //Methods
    public void addChallenge(Challenge challenge){
        challengeSet.add(challenge);
    }

    public void removeChallenge(Challenge challenge){
        challengeSet.remove(challenge);
    }

    public int ChallengeSize(){
        return challengeSet.size();
    }

    public Challenge retrieveChallenge(int index){
        Challenge retrievedChallenge = challengeSet.get(index);
        return retrievedChallenge;
    }

    private void populateMain(){
        challengeSet.add(challenge1);
        challengeSet.add(challenge2);
    }
}
