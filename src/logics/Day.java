package logics;

import java.util.ArrayList;

public class Day {
    private ArrayList<Clocking> clockings = new ArrayList<Clocking>();
    private Hours hours = new Hours();
    private boolean isDoubleMoney;
    private boolean subtractBreak;

    public Day(Clocking clocking, boolean isDoubleMoney) {
        this.clockings.add(clocking);
        this.isDoubleMoney = isDoubleMoney;
        this.subtractBreak = subtractBreak;
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

    public void countHours(Logics l){
        for (Clocking clocking : clockings) {
            hours = hours.add(l.countingHours(clocking, isDoubleMoney));
        }
    }
    
    public String toString(){
        if (clockings.size() == 1) {
            return "In:\t" + clockings.get(0).getOriginalIn() + "\nOut:\t" + clockings.get(0).getOriginalOut()+ "\n" ;
        }
        else {
            return "1rst\nIn:\t" + clockings.get(0).getOriginalIn() + "\nOut:\t" + clockings.get(0).getOriginalOut() + "\n" +
            "\n2nd\nIn:\t" + clockings.get(1).getOriginalIn() + "\nOut:\t" + clockings.get(1).getOriginalOut();
        }
    }
    public static void main(String[] args) {
        Day day = new Day(new Clocking("13:40", "22:00"), false);
        System.out.println(day.getHours());

    }
    
}
