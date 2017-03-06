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
        run3 = new Run("Arthurs Seat", 23, 2, 2016, 21, 1, 23, 12, "Long", "Hard work");
    }

    @Test public void getRunTitleTest(){
        assertEquals("Out and Back",run1.getRunTitle());
    }

    @Test public void getRunDistanceTest(){
        assertEquals(5, run2.getDistance(),0);
    }

    @Test public void getRunInfo(){
        assertEquals(23, run3.getDay());
        assertEquals(2, run3.getMonth());
        assertEquals(2016, run3.getYear());
        assertEquals("Long", run3.getType());
        assertEquals("Hard work", run3.getComment());
        assertEquals(1, 0,run3.getHours());
        assertEquals(23, 0,run3.getMinutes());
        assertEquals(12, 0,run3.getSeconds());
    }

    @Test public void getTimeTest(){
        assertEquals("1:23:12", run3.getTime());
    }

    @Test public void getTypeTest(){
        assertEquals("Long", run3.getType());
    }

    @Test public void getCommentTest(){
        assertEquals("Hard work", run3.getComment());
    }
}
