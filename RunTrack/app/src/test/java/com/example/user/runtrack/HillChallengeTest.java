package com.example.user.runtrack;
import org.junit.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by winnieho on 06/03/2017.
 */

public class HillChallengeTest {
    HillChallenge hillChallenge1;
    HillChallenge hillChallenge2;

    @Before
    public void before(){
        hillChallenge1 = new HillChallenge();
    }

    @Test public void hillChallengesHave2ChallengesTest(){
        ArrayList hillchallenges = hillChallenge1.getHillChallenges();
        assertEquals(2, hillchallenges.size());
    }

    @Test public void hillChallengesSizeTest(){
        assertEquals(2,hillChallenge1.hillChallengeSize());
    }


}
