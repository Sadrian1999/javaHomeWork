package logics;

public class Logics {
    private User user;

    public Logics(User user) {
        this.user = user;
    }
    public double breakTime(double workedHours){

        if (user.isVem()) {
            if (workedHours > 9 + (double)1/3) { return 1;}
            if (workedHours <= 6) { return 0; }
            else { return 0.5; }
        }
        else if (user.getAge() >= 18) {
            if (workedHours > 6 && workedHours <= 9 + (double)1/3) { return (double)1 / 3; }
            if (workedHours > 9 + (double)1/3 && workedHours <= 12.75) { return 0.75; }
            else{ return 0; }
        }
        else {
            if (workedHours > 4.5 && workedHours <= 6) { return 0.5; }
            if (workedHours > 6 && workedHours <= 8.75) { return 0.75; }
            else { return 0; }
        }
    }
    public Hours countingHours(Clocking clocking, boolean isDoubleMoney){
        Hours hours = new Hours();
        double in = clocking.getIn();
        double out = clocking.getOut();
        double base = 0, thirty = 0, fourty = 0, hundred = 0;
        double workedHours;
        int doubleMoney = 1;

        if (in < out) {
            workedHours = out - in;

            if (isDoubleMoney) {
                doubleMoney = 2;
                hundred += workedHours - breakTime(workedHours);
            }

            if (in > 0 && in < 6 && out <= 18 && out > 6) {
                fourty += (6 - in) * doubleMoney;
            }
            else if (in > 6 && out <= 22 && out > 18) {
                thirty += (out - 18 ) * doubleMoney;
            }
            else if (in > 18 && out <= 24 && out > 22) {
                fourty += (24 - out) * doubleMoney;
                thirty += (22 - in - breakTime(workedHours)) * doubleMoney;
            }
            else if (in > 0 && in <= 6 && out < 22 && out >= 18) {
                fourty += (24 - out) * doubleMoney;
                thirty += (out - 18) * doubleMoney;
            }
            else if (in > 6  && in <= 18 && out <= 24 && out > 22){
                fourty += (out - 22) * doubleMoney;
                thirty += 4 * doubleMoney;
            }
            base = workedHours - breakTime(workedHours);
        }
        if (in > out) {
            workedHours = 24 - in + out;

            if (isDoubleMoney) {
                doubleMoney = 2;
                hundred += workedHours - breakTime(workedHours);
            }

            if (in >= 22 && out <= 6) {
                fourty += (workedHours - breakTime(workedHours)) * doubleMoney;
            }
            else if (in >= 18 && out <= 6 ) {
                fourty += (2 + out) * doubleMoney;
                thirty += (22 - in - breakTime(workedHours)) * doubleMoney;
            }
            else if (in >= 12 && out >= 0) {
                thirty += 4 * doubleMoney;
                fourty += (out + 2) * doubleMoney;
            }
            base = workedHours - breakTime(workedHours);
        }

        hours.setBaseHours(base);
        hours.setThirtyPercent(thirty);
        hours.setFourtyPercent(fourty);
        hours.setHundredPercent(hundred);
        return hours;
        
    }

    public static void main(String[] args) {
        User u = new User(23, 2260, 8, false, true, "Adrian", "Koordinator", "Full time");
        Logics l = new Logics(u);
        System.out.println(l.countingHours(new Clocking("12:00", "23:45"), false));
    }
}