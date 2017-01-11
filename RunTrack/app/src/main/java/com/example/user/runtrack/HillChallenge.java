package com.example.user.runtrack;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by user on 20/12/2016.
 */
public class HillChallenge {

    private ArrayList<Challenge>hillChallenges;

    //Constructor
    public HillChallenge(){
        this.hillChallenges = new ArrayList<Challenge>();
        populateHill();
    }

    //Raw Data

    Challenge cH1 = new Challenge(
            "Johnston Terrace Hills",
            7,
            "Hill sprints from bottom phonebox to top phonebox. 10 x (Hill effort, recovery on descent.)",
            "johnston_terrace",
            "Hills"
    );

    Challenge cH2 = new Challenge(
            "New Town Hills",
            10,
            "5 Hills of the New Town, Gloucester Lane, St Stephens Street, Dundas Street, India Street and Broughton Street. Effort on hill, rest on Queen Street and descent.",
            "new_town_hills",
            "Hills");




    //Getters
    public ArrayList getHillChallenges(){
        return this.hillChallenges;
    }


    //Methods
    public int hillChallengeSize(){
        return hillChallenges.size();
    }


    public Challenge retrieveHillChallenge(int index){
        return hillChallenges.get(index);
    }


    private void populateHill(){
        hillChallenges.add(cH1);
        hillChallenges.add(cH2);
    }


    public Challenge getHillChallenge() {
        Random rand = new Random();

        Challenge randomHill = null;
        int randomIndex = rand.nextInt(hillChallengeSize());
        for (Challenge c:hillChallenges) {
            randomHill = hillChallenges.get(randomIndex);
            return randomHill;
        }
        return randomHill;
    }
}
