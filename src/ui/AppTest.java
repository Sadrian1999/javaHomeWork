package ui;

import static org.junit.Assert.*;

import java.time.LocalDate;
import org.junit.*;

import engine.Engine;
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

    @Test
    public void testCalculateMoney() {
        Money money = new Money();
        money.setUser(new User(23, 2390, 8, false, true, "Adrian", "Koordinátor", "Állandós"));
        money.setBase(8);
        money.setThirty(0);
        money.setFourty(0);
        money.setHundred(0);
        money.setSick(0);
        money.setPaidOff(0);
        money.calculate();
        assertEquals(money.getNett(), 15745.8, delta);
        assertEquals(money.getTbMoney(), 3574.2, delta);
    }

    @Test
    public void testConvertToDouble() {
        double result = Clocking.convertToDouble("14:20");
        assertEquals(result, 14.33333333333, delta);

        result = Clocking.convertToDouble("6:30");
        assertEquals(result, 6.5, delta);

        result = Clocking.convertToDouble("22:45");
        assertEquals(result, 22.75, delta);
    }

    @Test
    public void testAddingHours() {
        Hours hours = new Hours(8, 0, 0, 0);
        assertEquals(hours.add(new Hours(8, 0, 0, 0)).getBaseHours(), 16, delta);
        assertEquals(hours.add(new Hours(4, 4, 0, 0)).getThirtyPercent(), 4, delta);
    }

    @Test
    public void checkUserWrite() {
        User user = new User(23, 2390, 8, false, true, "Adrian", "Koordinátor", "Állandós");
        user.write();
        User newUser = User.read();
        assertEquals(newUser.getAge(), user.getAge());
        assertEquals(newUser.getName(), user.getName());
        assertNotEquals(newUser.getApplicationType(), "Diák");
    }

    @Test
    public void testMoneyWrite() {
        Money money = new Money();
        money.write("test.ser");
        Money newMoney = Money.read("test.ser");
        assertEquals(money.getBase(), newMoney.getBase(), delta);
        assertNotNull(newMoney);
    }

    @Test
    public void testEngineDayAdded() {
        Engine engine = new Engine();
        engine.addDay(new Day(new Clocking("14:00", "22:00"), false),LocalDate.of(2023, 10, 20));
        engine.addDay(new Day(new Clocking("14:00", "22:00"), false),LocalDate.of(2023, 11, 20));
        assertEquals(engine.isDayAdded(LocalDate.of(2023, 10, 20)), true);
        assertEquals(engine.isDayAdded(LocalDate.of(2023, 11, 20)), true);
        assertEquals(engine.isDayAdded(LocalDate.of(2023, 12, 20)), false);
        assertNotEquals(engine.isDayAdded(LocalDate.of(2023, 10, 22)), true);
    }

    @Test
    public void testUserParsing(){
        String age = "18";
        String wage = "2390";
        String job = "8";
        boolean parseSuccesful = App.checkUserParsing(age, wage, job);
        assertTrue(parseSuccesful);
    }
}
