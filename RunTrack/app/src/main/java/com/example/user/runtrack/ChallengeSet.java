package com.example.user.runtrack;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

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
            " recover on descent)","@drawable/suicide_runs", "Hills");

    Challenge challenge3 = new Challenge("New Town Hills", "5 Hills of the New Town, Gloucester Lane, St Stephens Street," +
            " Dundas Street, India Street and Broughton Street. Effort on hill, rest on Queen Street and descent","@drawable/nth", "Hills");

    Challenge challenge4 = new Challenge("Arthurs Seat Loop", "A loop of Arthurs Seat", "@drawable/arthurs_seat","Short");

    Challenge challenge5= new Challenge("Ice Cream Run", "13km run from Edinburgh City Centre to Lucas Ice Cream Shop in Musselborough", "@drawable/ice_cream_run", "Long" );

    Challenge challenge6 = new Challenge("East Lothian Sea Trail", "21.2km around East Lothian finishing at the Race Course", "@drawable/east_lothian", "Long");

    Challenge challenge7 = new Challenge("Park Run Cramond", "5km every Saturday 09:30 on Cramond Shore", "@drawable/cramond_park_run", "Short");

    Challenge challenge8 = new Challenge("400m Intervals","8 x 400m Intervals on the Meadows. 1 minute recovery", "@drawable/400m_intervals", "Intervals");


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

    public int challengeSize(){
        return challengeSet.size();
    }

    public Challenge retrieveChallenge(int index){
        Challenge retrievedChallenge = challengeSet.get(index);
        return retrievedChallenge;
    }

    public int countShortChallenges(){
        int shortCount = 0;
        for (Challenge c : challengeSet){
            if(c.getType() == "Short"){
                shortCount++;
            }
        }
        return shortCount;
    }

    public int countLongChallenges(){
        int longCount = 0;
        for (Challenge c : challengeSet){
            if(c.getType() == "Long"){
                longCount++;
            }
        }
        return longCount;
    }

    public int countIntervalChallenges(){
        int intervalCount = 0;
        for (Challenge c : challengeSet){
            if(c.getType() == "Intervals"){
                intervalCount++;
            }
        }
        return intervalCount;
    }

    public int countHillChallenges(){
        int hillCount = 0;
        for (Challenge c : challengeSet){
            if(c.getType() == "Hills"){
                hillCount++;
            }
        }
        return hillCount;
    }

    private void populateMain(){
        challengeSet.add(challenge1);
        challengeSet.add(challenge2);
        challengeSet.add(challenge3);
        challengeSet.add(challenge4);
        challengeSet.add(challenge5);
        challengeSet.add(challenge6);
        challengeSet.add(challenge7);
        challengeSet.add(challenge8);
    }

    public Challenge getShortChallenge() {
        Random rand = new Random();
        ArrayList<Challenge> shortChallenges = new ArrayList<Challenge>();

        Challenge randomShort = null;
        int randomIndex = rand.nextInt(countShortChallenges());
        for (Challenge c:challengeSet) {
            if (c.getType() == "Short"){
                shortChallenges.add(c);

                randomShort = shortChallenges.get(randomIndex);
                return randomShort;
            }
        }
        return randomShort;
    }

    public Challenge getLongChallenge() {
        Random rand = new Random();
        ArrayList<Challenge> longChallenges = new ArrayList<Challenge>();

        Challenge randomLong = null;
        int randomIndex = rand.nextInt(countLongChallenges());
        for (Challenge c : challengeSet) {
            if (c.getType() == "Long") {
                longChallenges.add(c);

                randomLong = longChallenges.get(randomIndex);
                return randomLong;
            }
        }
        return randomLong;
    }

    public Challenge getIntervalChallenge() {
        Random rand = new Random();
        ArrayList<Challenge> intervalChallenges = new ArrayList<Challenge>();



        Challenge randomInterval = null;
        int randomIndex = rand.nextInt(countIntervalChallenges());
        for (Challenge c : challengeSet) {
            if (c.getType() == "Intervals") {
                intervalChallenges.add(c);

                randomInterval = intervalChallenges.get(randomIndex);
                return randomInterval;

            }
        }
        return randomInterval;

    }

    public Challenge getHillChallenge() {
        Random rand = new Random();
        ArrayList<Challenge> hillChallenges = new ArrayList<Challenge>();

        Challenge randomHill = null;
        int randomIndex = rand.nextInt(countHillChallenges());
        for (Challenge c : challengeSet) {
            if (c.getType() == "Hill") {
                hillChallenges.add(c);

                randomHill = hillChallenges.get(randomIndex);
                return randomHill;
            }
        }
        return randomHill;
    }
}
