package com.jarotball.streams_in_java.challenge_exercises.challenge_2;

public class Employee {
    private final String name;
    private final Integer age;
    private final String jobTitle;
    private final Float salary;

    // Constructor
    public Employee(String name, Integer age, String jobTitle, Float salary) {
        this.name = name;
        this.age = age;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    // Setter - is not possible as the Instance attributes are defined to be final
    // Getter
    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public Float getSalary() {
        return salary;
    }

    // Print the Object

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", jobTitle='" + jobTitle + '\'' +
                ", salary=" + salary +
                '}';
    }
}
