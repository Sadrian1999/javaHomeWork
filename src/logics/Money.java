package logics;

public class Money{
    private double base;
    private double thirty;
    private double fourty;
    private double hundred;
    private double sick;
    private double paidOff;
    private double overTime;
    private double nett;
    private double gross;

    public Money(){
        base = 0;
        thirty = 0;
        fourty = 0;
        hundred = 0;
        sick = 0;
        paidOff = 0;
        overTime = 0;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getThirty() {
        return thirty;
    }

    public void setThirty(double thirty) {
        this.thirty = thirty;
    }

    public double getFourty() {
        return fourty;
    }

    public void setFourty(double fourty) {
        this.fourty = fourty;
    }

    public double getHundred() {
        return hundred;
    }

    public void setHundred(double hundred) {
        this.hundred = hundred;
    }

    public double getSick() {
        return sick;
    }

    public void setSick(double sick) {
        this.sick = sick;
    }

    public double getPaidOff() {
        return paidOff;
    }

    public void setPaidOff(double paidOff) {
        this.paidOff = paidOff;
    }

    public void calculate(User user) {
        double baseMoney = user.getWage() * base;
        double thirtyMoney = user.getWage() * thirty * 0.3;
        double fourtyMoney = user.getWage() * fourty * 0.4;
        double hundredMoney = user.getWage() * hundred;
        double sickMoney = user.getWage() * sick * 0.7;
        double paidOffMoney = user.getWage() * paidOff;
        double overTimeMoney = user.getWage() * overTime * 0.5;
        double tbMoney = gross * 0.115;
        double taxMoney;
        gross = baseMoney + thirtyMoney + fourtyMoney + hundredMoney + sickMoney + paidOffMoney + overTimeMoney + 200;
        
        if (user.getAge() < 25) {
            if (gross > 433600) {
                taxMoney = (gross - 433600) * 0.15;
            }
            else {
                taxMoney = 0;
            }
        } 
        else {
            taxMoney = gross * 0.15;
        }
        nett = gross - tbMoney - taxMoney;
        System.out.println(nett);
    }
    public static void main(String[] args) {
        Money m = new Money();
        User u = new User();
        u.setWage(2260);
        u.setAge(27);
        m.setBase(10);
        m.calculate(u);
    }
}

