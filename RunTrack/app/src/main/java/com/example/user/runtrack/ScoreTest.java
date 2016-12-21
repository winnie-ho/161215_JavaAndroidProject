package com.example.user.runtrack;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
/**
 * Created by user on 21/12/2016.
 */
public class ScoreTest {

        Score score;


        @Before
        public void before() {
            score = new Score();
        }

        @Test
        public void scoreStartsAtZeroTest(){
            assertEquals(0,score.getScore());
        }

        @Test
        public void scoreAddsTest(){
            score.addPoints(3);
            assertEquals(30, score.getScore());
        }

        @Test
        public void scoreSubtractsTest(){
            score.subtractPoints(3);
            assertEquals(-30, score.getScore());
        }
}
