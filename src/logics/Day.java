//********************************************************************************************
//*                                     DAY CLASS                                            *
//********************************************************************************************

package logics;

import java.util.ArrayList;

public class Day {
    private ArrayList<Clocking> clockings = new ArrayList<Clocking>();
    private Hours hours = new Hours();
    private boolean isDoubleMoney;

    /**
     * This class represents an actual day.
     * A day can consists of maximum 2 blockings, if the employee worked night shifts one after another.
     * Like this it can happen that they have working hours after midnight to like 6 am, and they clock
     * in again at 10 pm.
     *
     * @param clocking a clocking for the day
     * @param isDoubleMoney whether if its a double money day or not.
     * The main purpose of this class is to separate the working hours into different sections,
     * since there are bonuses depending on what time you are working troughout the day.
     * 
     * @example Clocking 12:00 - 22:00  (Age > 18, basic employee)
     *          I.   -> adding to clockings
     *          II.  -> passing to the logics module
     *                  to get the hours
     *          II.  -> hours store for this clocking:
     *                  base:   9.25
     *                  30%:    4
     *                  40%:    0
     *                  100%:   0
     *          This information will be used to calculate the salary.
     */
    public Day(Clocking clocking, boolean isDoubleMoney) {
        this.clockings.add(clocking);
        this.isDoubleMoney = isDoubleMoney;
    }

    public void addClockings(Clocking clocking) {
        this.clockings.add(clocking);
    }
    
    public void setDoubleMoney(boolean isDoubleMoney) {
        this.isDoubleMoney = isDoubleMoney;
    }

    public void setHours(Hours hours) {
        this.hours = hours;
    }

    public boolean isDoubleMoney() {
        return isDoubleMoney;
    }

    public ArrayList<Clocking> getClockings() {
        return clockings;
    }
    
    public Hours getHours() {
        return hours;
    }
    /**
     * Counts the hours from clocking.
     * @param l is the logics unit
     */
    public void countHours(Logics l){
        for (Clocking clocking : clockings) {
            hours = hours.add(l.countingHours(clocking, isDoubleMoney));
        }
    }
    
    public String toString(){
        if (clockings.size() == 1) {
            return "In:\t" + clockings.get(0).getOriginalIn() + "\nOut:\t" + clockings.get(0).getOriginalOut()+ "\n" ;
        }
        return "1rst\nIn:\t" + clockings.get(0).getOriginalIn() + "\nOut:\t" + clockings.get(0).getOriginalOut() + "\n" +
                "\n2nd\nIn:\t" + clockings.get(1).getOriginalIn() + "\nOut:\t" + clockings.get(1).getOriginalOut();
    } 
}
