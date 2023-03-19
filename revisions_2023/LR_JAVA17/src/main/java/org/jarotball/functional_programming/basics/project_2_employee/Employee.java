package org.jarotball.functional_programming.basics.project_2_employee;

public class Employee {
    private final String fName;
    private final String lName;
    private int yearOfService;
    private int numOfDirectReports;
    public Employee manager;

    // Constructor
    public Employee(String fName, String lName, int yearOfService, int numOfDirectReports) {
        this.fName = fName;
        this.lName = lName;
        this.yearOfService = yearOfService;
        this.numOfDirectReports = numOfDirectReports;
    }

    // Getter and Setter
    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public int getYearOfService() {
        return yearOfService;
    }

    public void setYearOfService(int yearOfService) {
        this.yearOfService = yearOfService;
    }

    public int getNumOfDirectReports() {
        return numOfDirectReports;
    }

    public void setNumOfDirectReports(int numOfDirectReports) {
        this.numOfDirectReports = numOfDirectReports;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public boolean hasManager(){
        return this.getManager()!=null;
    }

    // Print the Object
    @Override
    public String toString() {
        return "Employee{" +
                "Name='" + fName + " " + lName+ '\'' +
                ", yearOfService=" + yearOfService +
                ", numOfDirectReports=" + numOfDirectReports +
                ", manager=" + manager.getfName() +" " + manager.getlName()+
                '}';
    }
}
