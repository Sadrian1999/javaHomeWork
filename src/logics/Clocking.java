//********************************************************************************************
//*                                     CLOCKING CLASS                                       *
//********************************************************************************************


package logics;

public class Clocking {
    private double in;
    private double out;
    private String originalIn;
    private String originalOut;

    /**
     * The Clocking class represents the time you clocked in, clocked out and the time you spent
     * working.
     * @param in string for clock in
     * @param out string for clock out
     * @example 14:00 - 22:00, where 14:00 is the in and 22:00 is the out
     * 
     */
    public Clocking(String in, String out){
        originalIn = in;
        originalOut = out;
        this.in = convertToDouble(in);
        this.out = convertToDouble(out);
    }

    public double getIn() { return in; }
    public double getOut() { return out; }
    
    public String getOriginalIn() {
        return originalIn;
    }

    public String getOriginalOut() {
        return originalOut;
    }
    /**
     * Takes a date string and convert to a double
     * @example 18:30 -> 18,5
     * @param clocking is the date string
     * @return the double value
     */
    public static double convertToDouble(String clocking){
        String[] time = clocking.split(":");
        int hour = Integer.parseInt(time[0]);
        double min = (double)Integer.parseInt(time[1]) / 60;
        return hour + min;
    }
    
    public String toString(){
        return this.in + "\n" + this.out;
    }

}
