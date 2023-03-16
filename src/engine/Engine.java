package engine;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import logics.*;

public class Engine {
    private HashMap<LocalDate, Day> days = new HashMap<>();
    private Logics logics = new Logics(false, 23);
    private User user = new User();
    private Money money = new Money();

    public HashMap<LocalDate, Day> getDays() {
        return days;
    }
    
    private boolean isDayAdded(LocalDate date){
        if (days.containsKey(date)) {
            return true;
        }
        return false;
    }

    public void addDay(Day day, LocalDate date){
        double in = day.getClockings().get(0).getIn();
        double out = day.getClockings().get(0).getOut();
        String originalIn = day.getClockings().get(0).getOriginalIn();
        String originalOut = day.getClockings().get(0).getOriginalOut();
        if (in < out && !isDayAdded(date)) {
            days.put(date, day);
        }
        else if (in > out && !isDayAdded(date)) {
            LocalDate newDate = LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth() + 1);
            days.put(date, new Day(new Clocking(originalIn, "00:00"), false));
            days.put(newDate, new Day(new Clocking("00:00", originalOut), false));
        }
        else if (in < out && isDayAdded(date)) {
            days.get(date).addClockings(new Clocking(originalIn, originalOut));
        }
        else if (in > out && isDayAdded(date)) {
            LocalDate newDate = LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth() + 1);
            days.get(date).addClockings(new Clocking(originalIn, "00:00"));
            days.put(newDate, new Day(new Clocking("00:00", originalOut), false));
        }
    }

    public void countHoursForDay() {
        Iterator it = days.entrySet().iterator();
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry)it.next();
            ((Day) pair.getValue()).countHours(logics);
            money.setBase(money.getBase() + ((Day)pair.getValue()).getHours().getBaseHours());
            money.setThirty(money.getThirty() + ((Day)pair.getValue()).getHours().getThirtyPercent());
            money.setFourty(money.getFourty() + ((Day)pair.getValue()).getHours().getFourtyPercent());
            money.setHundred(money.getHundred() + ((Day)pair.getValue()).getHours().getHundredPercent());
            it.remove();
        }
    }
    public void printMoney() {
        System.out.println(money.getBase() + "\n" + money.getThirty() + "\n" + money.getFourty() + "\n" + money.getHundred());
    }
    
    public static void main(String[] args) {
        Engine e = new Engine();
        e.addDay(new Day(new Clocking("18:00", "22:00"), false), LocalDate.of(2023, 3, 16));
        e.countHoursForDay();
        e.printMoney();
    }
}
