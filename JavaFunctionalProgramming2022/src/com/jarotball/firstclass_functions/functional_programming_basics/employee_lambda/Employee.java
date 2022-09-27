package com.jarotball.firstclass_functions.functional_programming_basics.employee_lambda;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final Integer yearsOfService;
    public Employee manager;
    private final Integer numberOfDirectReports;

    // Constructor
    public Employee(String firstName, String lastName, Integer yearsOfService,
                    Integer numberOfDirectReports) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearsOfService = yearsOfService;
        this.numberOfDirectReports = numberOfDirectReports;
    }

    // Setter - is not possible as the Instance variables are defined final
    // Getter


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getYearsOfService() {
        return yearsOfService;
    }

    public Employee getManager() {
        return manager;
    }

    public Integer getNumberOfDirectReports() {
        return numberOfDirectReports;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }
    // Print the Object

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", yearsOfService=" + yearsOfService +
                ", manager=" + manager.getFirstName()+ " " + manager.getLastName() +
                ", numberOfDirectReports=" + numberOfDirectReports +
                '}';
    }
}
