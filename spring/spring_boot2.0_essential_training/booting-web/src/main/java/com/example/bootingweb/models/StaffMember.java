package com.example.bootingweb.models;

public class StaffMember {
    private String empID;
    private String empFirstName;
    private String empLastName;
    private String empPosition;

    // Define 2x constructors
    // No Argument constructor

    public StaffMember() {
    }

    // All argument constructor
    public StaffMember(String empID, String empFirstName, String empLastName, String empPosition) {
        this.empID = empID;
        this.empFirstName = empFirstName;
        this.empLastName = empLastName;
        this.empPosition = empPosition;
    }

    // getter and setter

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getEmpFirstName() {
        return empFirstName;
    }

    public void setEmpFirstName(String empFirstName) {
        this.empFirstName = empFirstName;
    }

    public String getEmpLastName() {
        return empLastName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    public String getEmpPosition() {
        return empPosition;
    }

    public void setEmpPosition(String empPosition) {
        this.empPosition = empPosition;
    }

    // toString

    @Override
    public String toString() {
        return "StaffMember{" +
                "empID='" + empID + '\'' +
                ", empFirstName='" + empFirstName + '\'' +
                ", empLastName='" + empLastName + '\'' +
                ", empPosition='" + empPosition + '\'' +
                '}';
    }
}
