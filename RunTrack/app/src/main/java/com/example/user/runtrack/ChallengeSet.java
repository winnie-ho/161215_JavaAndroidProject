package com.example.user.runtrack;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by user on 20/12/2016.
 */
public class ChallengeSet {
    private ArrayList<Challenge>shortChallenges;
    private ArrayList<Challenge>longChallenges;
    private ArrayList<Challenge>intervalChallenges;
    private ArrayList<Challenge>hillChallenges;

    //Constructor
    public ChallengeSet(){
        this.shortChallenges = new ArrayList<Challenge>();
        this.longChallenges = new ArrayList<Challenge>();
        this.intervalChallenges = new ArrayList<Challenge>();
        this.hillChallenges = new ArrayList<Challenge>();
        populateMain();
    }

    //Raw Data
    Challenge cS1 = new Challenge("Casual on the Canal",5, "5km along the canal to Meggetland and back via Colinton Road and Bruntsfield.",
            "casual_canal","Short");

    Challenge cS2 = new Challenge("Park Run Cramond",5, "5km every Saturday 09:30 on Cramond Shore",
            "cramond_park_run", "Short");

    Challenge cS3 = new Challenge("Tortoise",8, "8km around Edinburgh's New Town to draw out a tortoise", "tortoise", "Short");

    Challenge cS4 = new Challenge("On yer Bike",3, "3km mini bike run in Edinburgh's West End Crescents", "bike", "Short");

    Challenge cS5 = new Challenge("Horse sprints in the Colonies", 3 , "3.5km horsing up and down the colonies by the Water of Leith.", "horse", "Short");

    Challenge cS6 = new Challenge("Sausage Dog",3, "A quick sausage dog run in the city centre.", "sausage_dog", "Short");

    Challenge cL1= new Challenge("Ice Cream Run",13, "13km run from Edinburgh City Centre to Lucas Ice Cream Shop." +
            " in Musselborough", "ice_cream_run", "Long" );

    Challenge cL2 = new Challenge("East Lothian Sea Trail", 21, "21.2km around East Lothian finishing at the Race Course.",
            "east_lothian", "Long");

    Challenge cL3 = new Challenge("Dragon Half Marathon",21, "21.2km to draw a fire breathing dragon around the city streets of Edinburgh. This is a toughy! Accept at your peril!", "dragon", "Long");

    Challenge cL4 = new Challenge("Gone Fishing",15, "15km run to draw this dude fishing in the West End of Edinburgh", "gone_fishing","Long");

    Challenge cL5 = new Challenge("Run a Rabbit",14, "14km around Edinburgh Southside on the bunny's trail.", "rabbit", "Long");

    Challenge cI1 = new Challenge("Suicide Runs",3, "400m Loop. 3 x (4 sides, Sprint 1, Recover 3," +
            " Sprint 2, Recover 2, Sprint 3, Recover 1, Sprint 4)","suicide_runs", "Intervals");

    Challenge cI2 = new Challenge("Mile Intervals",5,"3 x 1 mile intervals on the Meadows measured loop. 1 minute stationary recovery.",
            "meadows_mile_reps", "Intervals");

    Challenge cH1 = new Challenge("Johnston Terrace Hills",7, "Hill sprints from bottom phonebox to top phonebox. 10 x (Hill effort," +
            " recovery on descent.)","johnston_terrace", "Hills");

    Challenge cH2 = new Challenge("New Town Hills",10, "5 Hills of the New Town, Gloucester Lane, St Stephens Street," +
            " Dundas Street, India Street and Broughton Street. Effort on hill, rest on Queen Street and descent.",
            "new_town_hills", "Hills");


    //Getters
    public ArrayList getShortChallenges(){
        return this.shortChallenges;
    }

    public ArrayList getLongChallenges(){
        return this.longChallenges;
    }

    public ArrayList getIntervalChallenges(){
        return this.intervalChallenges;
    }

    public ArrayList getHillChallenges(){
        return this.hillChallenges;
    }


    //Methods
    public int shortChallengeSize(){
        return shortChallenges.size();
    }
    public int longChallengeSize(){
        return longChallenges.size();
    }
    public int intervalChallengeSize(){
        return intervalChallenges.size();
    }
    public int hillChallengeSize(){
        return hillChallenges.size();
    }

    public Challenge retrieveShortChallenge(int index){
        return shortChallenges.get(index);
    }

    public Challenge retrieveLongChallenge(int index){
        return longChallenges.get(index);
    }

    public Challenge retrieveIntervalChallenge(int index){
        return intervalChallenges.get(index);
    }

    public Challenge retrieveHillChallenge(int index){
        return hillChallenges.get(index);
    }


    private void populateMain(){
        shortChallenges.add(cS1);
        shortChallenges.add(cS2);
        shortChallenges.add(cS3);
        shortChallenges.add(cS4);
        shortChallenges.add(cS5);
        shortChallenges.add(cS6);
        longChallenges.add(cL1);
        longChallenges.add(cL2);
        longChallenges.add(cL3);
        longChallenges.add(cL4);
        longChallenges.add(cL5);
        intervalChallenges.add(cI1);
        intervalChallenges.add(cI2);
        hillChallenges.add(cH1);
        hillChallenges.add(cH2);
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
