//********************************************************************************************
//*                                     CLOCKING CLASS                                       *
//********************************************************************************************

/**
 * The Clocking class represents the time you clocked in, clocked out and the time you spent
 * working.
 * @input: A string for in, and one for out
 * @example 14:00 - 22:00, where 14:00 is the in and 22:00 is the out
 * 
 * @function convertToDouble takes a string and converst it to a double
 * @example 18:30 -> 18,5
 * 
 */

package logics;

public class Clocking {
    private double in;
    private double out;
    private String originalIn;
    private String originalOut;

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
