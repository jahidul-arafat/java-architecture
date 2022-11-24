package com.example.bootingweb.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @Column(name = "EMPLOYEE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String empID;

    @Column(name = "FIRST_NAME")
    private String empFirstName;

    @Column(name = "LAST_NAME")
    private String empLastName;

    @Column(name = "POSITION")
    @Enumerated(EnumType.STRING)
    private Position empPosition;


    // Hence data will be loading directly from embedded database or from any external database, constrcutor is not required
    // Define 2x constructors
    public Employee() {
        this.empID = UUID.randomUUID().toString();
    }

    public Employee(String empID, String empFirstName, String empLastName, Position empPosition) {
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

    public Position getEmpPosition() {
        return empPosition;
    }

    public void setEmpPosition(Position empPosition) {
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
