package logics;

public class Hours {
    private double baseHours;
    private double thirtyPercent;
    private double fourtyPercent;
    private double hundredPercent;

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
    
    public Hours add(Hours hoursToAdd){
        double newBase = this.baseHours + hoursToAdd.baseHours;
        double newThirty = this.thirtyPercent + hoursToAdd.thirtyPercent;
        double newFourty = this.fourtyPercent + hoursToAdd.fourtyPercent;
        double newHundred = this.hundredPercent + hoursToAdd.hundredPercent;
        return new Hours(newBase, newThirty, newFourty, newHundred);
    }
}
