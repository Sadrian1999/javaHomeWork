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

    public String getStringTime(String time){
        return time;
    }
    private double convertToDouble(String clocking){
        String[] time = clocking.split(":");
        int hour = Integer.parseInt(time[0]);
        double min = (double)Integer.parseInt(time[1]) / 60;
        return hour + min;
    }
    
    public String toString(){
        return this.in + "\n" + this.out;
    }

}
