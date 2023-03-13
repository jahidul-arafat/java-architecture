package org.jarotball.oop.inheritance_problem1;

public class Analyst extends Employee{
    // Instance Attributes

    // constructor
    public Analyst(String name, double salary, int age) {
        super(name,salary,age);
    }

    // Custom Methods
    public double getAnnualBonus(){
        return super.salary *0.05;
    }

    // Print the object

    @Override
    public String toString() {
        return "Analyst{" +
                super.toString()+ " " +
                '}';
    }
}
