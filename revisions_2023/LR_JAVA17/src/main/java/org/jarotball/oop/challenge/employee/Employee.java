package org.jarotball.oop.challenge.employee;

public class Employee {

    // Class Attributes - static attributes
    public static final String ORGANIZATION="IQVIA";

    // Instance Attributes - non-static attributes
    private String name;
    private int age;
    private double salary;
    private Location location;

    // constructor

    /**
     *
     * @param name
     * @param age
     * @param salary
     * @param location
     */
    public Employee(String name, int age, double salary, Location location) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.location = location;
    }

    // Method01/Behavior01 - raiseSalary

    /**
     *
     * @param raiseAmount
     */
    public void raiseSalary(double raiseAmount){
        this.salary+=raiseAmount;
    }

    // getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    // Print the object
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", location='" + location + '\'' +
                '}';
    }
}
