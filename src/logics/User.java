//********************************************************************************************
//*                                     USER CLASS                                           *
//********************************************************************************************

/**
 * This class represents a user, having the following parameters:
 * @param age               is the age of the employee
 * @param wage              is the amount of gross money per hour
 * @param jobTime           is the time an employee works a normal day, like 4 - 6 - 8 hours for 5 days a week
 * @param isVem             is needed if the employee is a Guest Experience Manager, because they have different breaktime then others      
 * @param isTaxFree         is need if an emloyee doesn't need to pay any taxes
 * @param name              is the name of the worker
 * @param position          is the position in the company, this program works with: Normal employee - Trainer - Coordinator - Guest Experience Manager
 * @param applicationType   is needed to find out whether someone is a student or a normal worker
 * 
 * 
 */
package logics;

import java.io.*;

public class User implements Serializable{
    private int age;
    private int wage;
    private int jobTime;
    private boolean isVem;
    private boolean isTaxFree;
    private String name;
    private String position;
    private String applicationType;
    private String profilePicturePath = "assets/default_profile.png";
    
    public String getProfilePicturePath() {
        return profilePicturePath;
    }

    public void setProfilePicturePath(String profilePicturePath) {
        this.profilePicturePath = profilePicturePath;
    }

    public User(){
        this.age = 23;
        this.wage = 1000;
        this.jobTime = 8;
        this.isVem = false;
        this.isTaxFree = true;
        this.name = "Adrián";
        this.position = "Koordinátor";
        this.applicationType = "Állandós";
        
    }
    
    public User(int age, int wage, int jobTime, boolean isVem, boolean isTaxFree, String name, String position, String applicationType) {
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

    @Override
    public String toString() {
        return "User [age=" + age + ", wage=" + wage + ", jobTime=" + jobTime + ", isVem=" + isVem + ", isTaxFree="
                + isTaxFree + ", name=" + name + ", position=" + position + ", applicationType=" + applicationType
                + "]";
    }

    public void write(){
        try {
            FileOutputStream f = new FileOutputStream("user.ser");
            ObjectOutputStream out = new ObjectOutputStream(f);
            out.writeObject(this);
            out.close();
        } catch (IOException exception) {
            System.err.println("Sikertelen írás");
        }
    }
    public static User read(){
        User redUser;
        try {
            FileInputStream f = new FileInputStream("user.ser");
            ObjectInputStream obj = new ObjectInputStream(f);
            redUser = (User)obj.readObject();
            obj.close();
            return redUser;
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}