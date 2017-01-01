package com.example.user.runtrack;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by user on 20/12/2016.
 */
public class IntervalChallenge {

    private ArrayList<Challenge>intervalChallenges;

    //Constructor
    public IntervalChallenge(){
        this.intervalChallenges = new ArrayList<Challenge>();
        populateInterval();
    }

    //Raw Data

    Challenge cI1 = new Challenge(
            "Suicide Runs",
            3,
            "400m Loop. 3 x (4 sides, Sprint 1, Recover 3, Sprint 2, Recover 2, Sprint 3, Recover 1, Sprint 4)",
            "suicide_runs",
            "Intervals"
    );

    Challenge cI2 = new Challenge(
            "Mile Intervals",
            5,
            "3 x 1 mile intervals on the Meadows measured loop. 1 minute stationary recovery.",
            "meadows_mile_reps",
            "Intervals"
    );



    //Getters
    public ArrayList getIntervalChallenges(){
        return this.intervalChallenges;
    }



    //Methods
    public int intervalChallengeSize(){
        return intervalChallenges.size();
    }



    public Challenge retrieveIntervalChallenge(int index){
        return intervalChallenges.get(index);
    }



    private void populateInterval(){
        intervalChallenges.add(cI1);
        intervalChallenges.add(cI2);
    }



    public Challenge getIntervalChallenge() {
        Random rand = new Random();

        Challenge randomInterval = null;
        int randomIndex = rand.nextInt(intervalChallengeSize());
        for (Challenge c:intervalChallenges) {
            randomInterval = intervalChallenges.get(randomIndex);
            return randomInterval;
        }
        return randomInterval;
    }

}
