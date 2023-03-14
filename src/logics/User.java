package logics;

public class User {
    private int age;
    private int wage;
    private int jobTime;
    private boolean isVem;
    private boolean isTaxFree;
    private String name;
    private String position;
    private String applicationType;
    
    public User(int age, int wage, int jobTime, boolean isVem, boolean isTaxFree, String name, String position,
            String applicationType) {
        this.age = age;
        this.wage = wage;
        this.jobTime = jobTime;
        this.isVem = isVem;
        this.isTaxFree = isTaxFree;
        this.name = name;
        this.position = position;
        this.applicationType = applicationType;
    }
    
    public int getAge() {
        return age;
    }
    public int getWage() {
        return wage;
    }
    public int getJobTime() {
        return jobTime;
    }
    public boolean isVem() {
        return isVem;
    }
    public boolean isTaxFree() {
        return isTaxFree;
    }
    public String getName() {
        return name;
    }
    public String getPosition() {
        return position;
    }
    public String getApplicationType() {
        return applicationType;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setWage(int wage) {
        this.wage = wage;
    }
    public void setJobTime(int jobTime) {
        this.jobTime = jobTime;
    }
    public void setVem(boolean isVem) {
        this.isVem = isVem;
    }
    public void setTaxFree(boolean isTaxFree) {
        this.isTaxFree = isTaxFree;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }
}
