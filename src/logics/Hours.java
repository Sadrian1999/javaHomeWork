//********************************************************************************************
//*                                     HOUR CLASS                                           *
//********************************************************************************************

package logics;

public class Hours {
    private double baseHours;
    private double thirtyPercent;
    private double fourtyPercent;
    private double hundredPercent;

    /**
     * This class's purpose to separate the different bonuses, and help summing them
     * 
     * @param   basehours -> 0% bonus
     * @param   thirtyPercent -> 30% bonus
     * @param   fourtyPercent -> 40% bonus
     * @param   hundredPercent -> 100% bonus
     * 
     * These gets multiplied by the wage.
     */
    public Hours(){
        this.baseHours = 0;
        this.thirtyPercent = 0;
        this.fourtyPercent = 0;
        this.hundredPercent = 0;
    }
    public Hours(double baseHours, double thirtyPercent, double fourtyPercent, double hundredPercent){
        this.baseHours = baseHours;
        this.thirtyPercent = thirtyPercent;
        this.fourtyPercent = fourtyPercent;
        this.hundredPercent = hundredPercent;
    }

    public double getBaseHours() { return baseHours; }
    public double getThirtyPercent() { return thirtyPercent; }
    public double getFourtyPercent() { return fourtyPercent; }
    public double getHundredPercent() { return hundredPercent; }
    
    public void setBaseHours(double baseHours) {
        this.baseHours = baseHours;
    }
    public void setThirtyPercent(double thirtyPercent) {
        this.thirtyPercent = thirtyPercent;
    }
    public void setFourtyPercent(double fourtyPercent) {
        this.fourtyPercent = fourtyPercent;
    }
    public void setHundredPercent(double hundredPercent) {
        this.hundredPercent = hundredPercent;
    }
    
    public String toString() {
        return "Base:\t" + baseHours + "\n30%:\t" + thirtyPercent + "\n40%:\t" + fourtyPercent + "\n100%:\t" + hundredPercent;
    }
    /**
     * Adds the new hours to the already existing ones.
     * @param hoursToAdd the hours to add to the already existing ones.
     * @return a new Hour object
     */
    public Hours add(Hours hoursToAdd){
        double newBase = this.baseHours + hoursToAdd.baseHours;
        double newThirty = this.thirtyPercent + hoursToAdd.thirtyPercent;
        double newFourty = this.fourtyPercent + hoursToAdd.fourtyPercent;
        double newHundred = this.hundredPercent + hoursToAdd.hundredPercent;
        return new Hours(newBase, newThirty, newFourty, newHundred);
    }
}
