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
    Challenge cS2 = new Challenge("Park Run Cramond", "5km every Saturday 09:30 on Cramond Shore",
            "cramond_park_run", "Short");

    Challenge cS1 = new Challenge("Arthurs Seat Loop", "A loop of Arthurs Seat",
            "arthurs_seat","Short");

    Challenge cL1= new Challenge("Ice Cream Run", "13km run from Edinburgh City Centre to Lucas Ice Cream Shop" +
            " in Musselborough", "ice_cream_run", "Long" );

    Challenge cL2 = new Challenge("East Lothian Sea Trail", "21.2km around East Lothian finishing at the Race Course",
            "east_lothian", "Long");

    Challenge cI1 = new Challenge("Suicide Runs", "400m Loop. 3 x (4 sides, Sprint 1, Recover 3," +
            " Sprint 2, Recover 2, Sprint 3, Recover 1, Sprint 4)","suicide_runs", "Intervals");

    Challenge cI2 = new Challenge("400m Intervals","8 x 400m Intervals on the Meadows. 1 minute recovery",
            "400m_intervals", "Intervals");


    Challenge cH1 = new Challenge("Johnston Terrace Hills", "Phonebox to Phonebox. 10 x (Hill effort," +
            " recover on descent)","suicide_runs", "Hills");

    Challenge cH2 = new Challenge("New Town Hills", "5 Hills of the New Town, Gloucester Lane, St Stephens Street," +
            " Dundas Street, India Street and Broughton Street. Effort on hill, rest on Queen Street and descent",
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
        longChallenges.add(cL1);
        longChallenges.add(cL2);
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
