package org.example.playground.challenges.challenge_1;

public class Employee {
    // object attributes
    private final String name;
    private final Float salary;
    private final Integer age;
    private final String designation;

    // constructor
    public Employee(String name, Float salary, Integer age, String designation) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.designation = designation;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public Float getSalary() {
        return salary;
    }

    public Integer getAge() {
        return age;
    }

    public String getDesignation() {
        return designation;
    }

    // toString method
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", designation='" + designation + '\'' +
                '}';
    }
}
