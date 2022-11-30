package com.example.employeeclr;

import java.util.UUID;


public class Employee {

    private String empID;


    private String empFirstName;


    private String empLastName;

    private String empPosition;


    // Hence data will be loading directly from embedded database or from any external database, constrcutor is not required
    // Define 2x constructors
    public Employee() {
        this.empID = UUID.randomUUID().toString();
    }

    public Employee(String empID, String empFirstName, String empLastName, String empPosition) {
        this.empID = empID;
        this.empFirstName = empFirstName;
        this.empLastName = empLastName;
        this.empPosition = empPosition;
    }

    // getter and setter

    // Getter and Setter
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
        return "Employee{" +
                "empID='" + empID + '\'' +
                ", empFirstName='" + empFirstName + '\'' +
                ", empLastName='" + empLastName + '\'' +
                ", empPosition='" + empPosition + '\'' +
                '}';
    }
}
