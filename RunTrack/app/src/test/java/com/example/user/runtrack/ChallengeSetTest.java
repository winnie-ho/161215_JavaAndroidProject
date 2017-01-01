package com.example.user.runtrack;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * Created by user on 20/12/2016.
 */
public class ChallengeSetTest {

        ShortChallenge shortChallenge;
        LongChallenge longChallenge;
        IntervalChallenge intervalChallenge;
        HillChallenge hillChallenge;


        @Before
        public void before() {
            shortChallenge = new ShortChallenge();
            longChallenge = new LongChallenge();
            intervalChallenge = new IntervalChallenge();
            hillChallenge = new HillChallenge();
        }

        @Test
        public void challengeSetsArePopulated(){
            assertEquals(5, shortChallenge.shortChallengeSize());
            assertEquals(3, longChallenge.longChallengeSize());
            assertEquals(2, intervalChallenge.intervalChallengeSize());
            assertEquals(2, hillChallenge.hillChallengeSize());
        }

        @Test
        public void challengeSetHasParticularChallenge(){
            assertEquals("Suicide Runs", intervalChallenge.retrieveIntervalChallenge(0).getTitle());
            assertEquals("Johnston Terrace Hills", hillChallenge.retrieveHillChallenge(0).getTitle());
        }

}
