package org.jarotball.oop.inheritance_problem1;

public class Employee extends Person{

    // Instance Attributes
    protected double salary;

    // Constructor
    public Employee(String name, double salary, int age) {
        super(name,age);
        this.salary = salary;

    }

    // Custom Method
    public void raiseSalary(){
        this.salary*=1.2;
    }

    // Getter and Setter
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    // Print the object
    @Override
    public String toString() {
        return "{" +
                super.toString()+ " " +
                "salary=" + salary +
                '}';
    }
}
