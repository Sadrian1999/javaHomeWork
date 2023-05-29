//********************************************************************************************
//*                                     ENGINE                                               *
//********************************************************************************************

package engine;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;

import logics.*;

public class Engine {
    
    private HashMap<LocalDate, Day> days = new HashMap<>();
    private Money money = new Money();
    private Logics logics = new Logics(money.getUser().isVem(), money.getUser().getAge());
    
    /**
     * This class is the centre of the software, gets the datas and passes it to the calculate unit.  
     */
    public Engine() {
    }

    public HashMap<LocalDate, Day> getDays() {
        return days;
    }
    /**
     * Checks if a day is added or not.
     * @param date the given date
     * @return true if added, otherwise false
     */
    public boolean isDayAdded(LocalDate date){
        if (days.containsKey(date)) {
            return true;
        }
        return false;
    }
    /**
     * Adds a day to the data structure. If a day is already in and it extends midnight, it gets split into two days.
     * Important for counting the double money.
     * @param day the given workday != date
     * @param date the starting date of the workday
     */
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
    /**
     *Counting the hours for the day.
     */
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
    
    public Money getMoney() {
        return money;
    }
    public void setPaidOff(int paidOff){
        money.setPaidOff(paidOff);
    }
    public void setSick(int sick){
        money.setSick(sick);
    }
    public double getThirty(){
        return money.getThirty();
    }
    public double getFourty(){
        return money.getFourty();
    }
    public double getHundred(){
        return money.getHundred();
    }
    public double getBase(){
        return money.getBase();
    }
    public double getPaidOff(){
        return money.getPaidOff();
    }
    public double getSick(){
        return money.getSick();
    }
    public double getBaseMoney() {
        return money.getBaseMoney();
    }
    public double getThirtyMoney() {
        return money.getThirtyMoney();
    }
    public double getFourtyMoney() {
        return money.getFourtyMoney();
    }
    public double getHundredMoney() {
        return money.getHundredMoney();
    }
    public double getSickMoney() {
        return money.getSickMoney();
    }
    public double getPaidOffMoney() {
        return money.getPaidOffMoney();
    }
}
