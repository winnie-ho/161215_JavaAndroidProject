package com.example.user.runtrack;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by user on 20/12/2016.
 */
public class LongChallenge {

    private ArrayList<Challenge>longChallenges;

    //Constructor
    public LongChallenge(){
        this.longChallenges = new ArrayList<Challenge>();
        populateLong();
    }

    //Raw Data

    Challenge cL1 = new Challenge(
            "Dragon Half Marathon",
            21,
            "21.2km to draw a fire breathing dragon around the city streets of Edinburgh. This is a toughy! Accept at your peril!",
            "dragon",
            "Long");

    Challenge cL2 = new Challenge(
            "Gone Fishing",
            15,
            "15km run to draw this dude fishing in the West End of Edinburgh",
            "gone_fishing",
            "Long");

    Challenge cL3 = new Challenge("Run a Rabbit",
            14,
            "14km around Edinburgh Southside on the bunny's trail.",
            "rabbit",
            "Long");


    //Getters
    public ArrayList getLongChallenges(){
        return this.longChallenges;
    }

    //Methods
    public int longChallengeSize(){
        return longChallenges.size();
    }


    public Challenge retrieveLongChallenge(int index){
        return longChallenges.get(index);
    }



    private void populateLong(){
        longChallenges.add(cL1);
        longChallenges.add(cL2);
        longChallenges.add(cL3);
    }


    public Challenge getLongChallenge() {
        Random rand = new Random();

        Challenge randomLong = null;
        int randomIndex = rand.nextInt(longChallengeSize());
        for (Challenge c:longChallenges) {
            randomLong = longChallenges.get(randomIndex);
            return randomLong;
        }
        return randomLong;
    }
}
