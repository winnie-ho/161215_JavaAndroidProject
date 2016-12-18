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
        messages.add("You're doing great!");
        messages.add("Keep it going!");
        messages.add("Power on!");
        messages.add("Get off your butt!");
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
