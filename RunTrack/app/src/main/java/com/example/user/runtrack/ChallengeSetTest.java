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
        public void challengeSetIsPopulated(){
            assertEquals(8, challengeSet.challengeSize());
        }

        @Test
        public void challengeSetHasParticularChallenge(){
            assertEquals("Suicide Runs", challengeSet.retrieveChallenge(0).getTitle());
            assertEquals("Johnston Terrace Hills", challengeSet.retrieveChallenge(1).getTitle());
        }

        @Test
        public void countChallengesByTypeTest(){
            assertEquals(2,challengeSet.countShortChallenges());
            assertEquals(2,challengeSet.countLongChallenges());
            assertEquals(2,challengeSet.countHillChallenges());
            assertEquals(2,challengeSet.countIntervalChallenges());
        }





}
