package logics;

public class Clocking {
    private double in;
    private double out;

    public Clocking(String in, String out){
        this.in = convertToDouble(in);
        this.out = convertToDouble(out);
    }

    public double getIn() { return in; }
    public double getOut() { return out; }

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
