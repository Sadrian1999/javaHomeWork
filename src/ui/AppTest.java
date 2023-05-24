package ui;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.*;
import logics.*;

public class AppTest {
    private Clocking clocking;
    private LocalDate date;

    @Test
    public void clockingCorrectness(){
        clocking = new Clocking("14:00", "22:00");
    }
}
