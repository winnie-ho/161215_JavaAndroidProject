package com.example.user.runtrack;
import org.junit.*;
import static org.junit.Assert.*;
/**
 * Created by user on 16/12/2016.
 */
public class RunTest {
    Run run1;
    Run run2;
    Run run3;

    @Before
    public void before(){
        run1 = new Run("Out and Back", 12);
        run2 = new Run("Cramond Park Run", 5);
        run3 = new Run("Arthurs Seat", 22, 03, 2016, 13, 61, 5, "Queens Drive", "Long");
    }


    @Test public void getRunTitleTest(){
        assertEquals("Out and Back",run1.getRunTitle());
    }

    @Test public void getRunDistanceTest(){
        assertEquals(5,run2.getDistance(),0);
    }


}
