package com.example.user.runtrack;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
/**
 * Created by user on 20/12/2016.
 */
public class ChallengeSetTest {

        ChallengeSet challengeSet;


        @Before
        public void before() {
            challengeSet = new ChallengeSet();
        }

        @Test
        public void challengeSetsArePopulated(){
            assertEquals(2, challengeSet.shortChallengeSize());
            assertEquals(2, challengeSet.longChallengeSize());
            assertEquals(2, challengeSet.intervalChallengeSize());
            assertEquals(2, challengeSet.hillChallengeSize());
        }

        @Test
        public void challengeSetHasParticularChallenge(){
            assertEquals("Suicide Runs", challengeSet.retrieveIntervalChallenge(0).getTitle());
            assertEquals("Johnston Terrace Hills", challengeSet.retrieveHillChallenge(0).getTitle());
        }

}
