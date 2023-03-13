package org.jarotball.oop.challenge.employee;

public class simulator {
    public static void main(String[] args) {
        System.out.format("Organization: %s%n", Employee.ORGANIZATION);

        Employee employee1 = new Employee("Jahidul",35,900.50,Location.DHK);
        Employee employee2 = new Employee("Fariha",25,700.50,Location.CML);

        employee1.raiseSalary(120.44);

        System.out.println(employee1);
        System.out.println(employee2);

    }



}
