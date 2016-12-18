package com.example.user.runtrack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by user on 18/12/2016.
 */
public class Message {
    private ArrayList<String> messages;

    public Message(){
        messages = new ArrayList<String>();
        populateMessages();
    }

    public void populateMessages(){
        messages.add("YOU'RE DOING GREAT!");
        messages.add("KEEP IT GOING!");
        messages.add("POWER ON!");
        messages.add("GET OFF YOUR BUTT!");
        messages.add("SO MANY MILES TO RUN SO LITTLE TIME!");
        messages.add("THOSE TRAINERS AIN'T GONNA RUN THEMSELVES!");
        messages.add("IT'S MEANT TO HURT!");
        messages.add("YOUR COMPETITORS AIN'T RESTING!");
        messages.add("THAT'S NOT AN EXCUSE!");
    }

    public int messagesSize(){
        return messages.size();
    }

    public String getMessage() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(messagesSize());
        String randomMsg = messages.get(randomIndex);
        return randomMsg;
    }
}
