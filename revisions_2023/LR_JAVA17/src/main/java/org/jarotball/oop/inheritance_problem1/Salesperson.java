package org.jarotball.oop.inheritance_problem1;

public class Salesperson extends Employee{
    // Instance Attributes
    private double commissionPercentage;

    // constructor
    public Salesperson(String name, double salary, int age, double commissionPercentage) {
        super(name,salary,age);
        this.commissionPercentage = commissionPercentage;
    }

    // custom methods
    public void raiseCommission(){
        if (this.commissionPercentage<0.30){
            this.commissionPercentage*=1.2;
        }
    }


    // Print the object
    @Override
    public String toString() {
        return "Salesperson{" +
                super.toString()+ " " +
                "commissionPercentage=" + commissionPercentage +
                '}';
    }
}
