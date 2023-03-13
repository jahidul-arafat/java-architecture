package org.jarotball.basics;

public class Student {
    // Class Attributes
    static String identity="I AM A STUDENT";

    // Instance Attributes
    private String fName, lName;
    private int y2g;
    private double gpa;
    private String major;

    /**
     *
     * @param fName - first name
     * @param lName - last name
     * @param y2g   - year to graduation
     * @param gpa   - gpa
     * @param major - major i.e. Science, Commerce etc
     */
    public Student(String fName, String lName, int y2g, double gpa, String major) {
        this.fName = fName;
        this.lName = lName;
        this.y2g = y2g;
        this.gpa = gpa;
        this.major = major;
    }

    // custom methods
    public void incrementExpectedGraduationYear(){
        System.out.println(this.y2g+1);
    }


    // getter and setter
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getY2g() {
        return y2g;
    }

    public void setY2g(int y2g) {
        this.y2g = y2g;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    // Print the Object


    @Override
    public String toString() {
        return "Student{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", y2g=" + y2g +
                ", gpa=" + gpa +
                ", major='" + major + '\'' +
                '}';
    }
}
