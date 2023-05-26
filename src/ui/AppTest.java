package ui;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.*;
import logics.*;

public class AppTest {
    private static final double delta = 1e-5;
    @Test
    public void dateCorrectness(){
        String testStringOne = "2023-10-10";
        String testStringTwo = "2023-10-11";
        String testStringThree = "2021.15.10";
        String testStringFour = "RANDOMBULLSHIT";
        assertNotNull(App.checkDate(testStringOne));
        assertNotNull(App.checkDate(testStringTwo));
        assertNull(App.checkDate(testStringThree));
        assertNull(App.checkDate(testStringFour));
    }

    @Test
    public void testBreakTimeCounter(){
        boolean isVem = false;
        int age = 20;
        Logics l = new Logics(isVem, age);
        assertEquals(l.breakTime(8.0), 0.33333, delta);
        assertEquals(l.breakTime(10), 0.75, delta);
        assertEquals(l.breakTime(5), 0, delta);
        age = 16;
        l = new Logics(isVem, age);
        assertEquals(l.breakTime(8), 0.75, delta);
        assertEquals(l.breakTime(6), 0.5, delta);
        assertEquals(l.breakTime(4), 0, delta);
        isVem = true;
        l = new Logics(isVem, age);
        assertEquals(l.breakTime(8), 0.5, delta);
        assertEquals(l.breakTime(10), 1, delta);
    }

    @Test
    public void testCountingHours(){
        boolean isDoubleMoney = false;
        Logics l = new Logics(isDoubleMoney, 23);
        Clocking clocking = new Clocking("13:40", "22:00");
        Hours hours = l.countingHours(clocking, isDoubleMoney);

        assertEquals(hours.getBaseHours(), 8, delta);
        assertEquals(hours.getThirtyPercent(), 4, delta);
        assertEquals(hours.getFourtyPercent(), 0, delta);

        isDoubleMoney = true;
        l = new Logics(isDoubleMoney, 23);
        clocking = new Clocking("13:40", "22:00");
        hours = l.countingHours(clocking, isDoubleMoney);

        assertEquals(hours.getHundredPercent(), 7.8333333, delta);

        isDoubleMoney = false;
        l = new Logics(isDoubleMoney, 23);
        clocking = new Clocking("06:00", "17:45");
        hours = l.countingHours(clocking, isDoubleMoney);
        
        assertEquals(hours.getBaseHours(), 11, delta);
    }
}
