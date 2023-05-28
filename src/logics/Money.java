//********************************************************************************************
//*                                     MONEY CLASS                                          *
//********************************************************************************************

/**
 * This class calculates the salary of given parameters in the other logics classes, 
 * @param base      base hours from clocking
 * @param thirty    is the 30% bonus
 * @param fourty    is the 40% bonus
 * @param hundred   is the 100% bonus
 * @param sick      is the hours of being sick
 * @param paidOff   is the hours being on holiday
 * @param overTime  is the hours working more in a month then the montly frame
 * @param nett      is the nett salary
 * @param gross     is the gross salary
 * 
 * @function calculate takes the users data, and calculate their salary
 *              
 */

package logics;

import java.io.*;

public class Money implements Serializable{
    private User user = User.read();
    private double base;
    private double thirty;
    private double fourty;
    private double hundred;
    private double sick;
    private double paidOff;
    private double overTime;
    private double nett;
    private double gross;
    private double baseMoney;
    private double thirtyMoney;
    private double fourtyMoney;
    private double hundredMoney;
    private double sickMoney;
    private double paidOffMoney;
    private double overTimeMoney;
    private double tbMoney;
    
    public void setUser(User user) {
        this.user = user;
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
     
    public User getUser() {
        return user;
    }
    
    public double getOverTime() {
        return overTime;
    }
    
    public double getNett() {
        return nett;
    }
    
    public double getGross() {
        return gross;
    }
    
    public double getBaseMoney() {
        return baseMoney;
    }
    
    public double getThirtyMoney() {
        return thirtyMoney;
    }
    
    public double getFourtyMoney() {
        return fourtyMoney;
    }
    
    public double getHundredMoney() {
        return hundredMoney;
    }
    
    public double getSickMoney() {
        return sickMoney;
    }
    
    public double getPaidOffMoney() {
        return paidOffMoney;
    }
    
    public double getOverTimeMoney() {
        return overTimeMoney;
    }
    
    public double getTbMoney() {
        return tbMoney;
    }
    public void calculate() {
        double taxMoney;
        baseMoney = user.getWage() * base;
        thirtyMoney = user.getWage() * thirty * 0.3;
        fourtyMoney = user.getWage() * fourty * 0.4;
        hundredMoney = user.getWage() * hundred;
        sickMoney = user.getWage() * sick * 0.7;
        paidOffMoney = user.getWage() * paidOff;
        overTimeMoney = user.getWage() * overTime * 0.5;
        gross = baseMoney + thirtyMoney + fourtyMoney + hundredMoney + sickMoney + paidOffMoney + overTimeMoney + 200;
        tbMoney = gross * 0.185;
        
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
    }

    public void write(String fileName){
        try {
            FileOutputStream f = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(f);
            out.writeObject(this);
            out.close();
        } catch (IOException exception) {
            System.err.println("Sikertelen írás");
        }
    }
    public static Money read(String fileName){
        Money redMoney;
        try {
            FileInputStream f = new FileInputStream(fileName);
            ObjectInputStream obj = new ObjectInputStream(f);
            redMoney = (Money)obj.readObject();
            obj.close();
            return redMoney;
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

