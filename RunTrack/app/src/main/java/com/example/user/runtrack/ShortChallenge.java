package com.example.user.runtrack;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by user on 20/12/2016.
 */
public class ShortChallenge {
    private ArrayList<Challenge>shortChallenges;


    //Constructor
    public ShortChallenge(){
        this.shortChallenges = new ArrayList<Challenge>();
        populateShort();
    }

    //Raw Data
    Challenge cS1 = new Challenge(
            "Casual on the Canal",
            5,
            "5km along the canal to Meggetland and back via Colinton Road and Bruntsfield.",
            "casual_canal",
            "Short"
    );

    Challenge cS2 = new Challenge(
            "Tortoise",
            8,
            "8km around Edinburgh's New Town to draw out a tortoise",
            "tortoise",
            "Short"
    );

    Challenge cS3 = new Challenge(
            "On yer Bike",
            3,
            "3km mini bike run in Edinburgh's West End Crescents",
            "bike",
            "Short"
    );

    Challenge cS4 = new Challenge(
            "Horse sprints in the Colonies",
            3,
            "3.5km horsing up and down the colonies by the Water of Leith.",
            "horse",
            "Short"
    );

    Challenge cS5 = new Challenge(
            "Sausage Dog",
            3,
            "A quick sausage dog run in the city centre.",
            "sausage_dog",
            "Short"
    );


    //Getters
    public ArrayList getShortChallenges(){
        return this.shortChallenges;
    }


    //Methods
    public int shortChallengeSize(){
        return shortChallenges.size();
    }

    public Challenge retrieveShortChallenge(int index){
        return shortChallenges.get(index);
    }

    private void populateShort(){
        shortChallenges.add(cS1);
        shortChallenges.add(cS2);
        shortChallenges.add(cS3);
        shortChallenges.add(cS4);
        shortChallenges.add(cS5);
    }

    public Challenge getShortChallenge() {
        Random rand = new Random();

        Challenge randomShort = null;
        int randomIndex = rand.nextInt(shortChallengeSize());
        for (Challenge c:shortChallenges) {
            randomShort = shortChallenges.get(randomIndex);
            return randomShort;
        }
        return randomShort;
    }

}
