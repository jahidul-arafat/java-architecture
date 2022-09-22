/*
 * Copyright (c) 2022.
 * Jahidul Arafat
 * jahidul.arafat@oracle.com
 *
 * All rights reserved.
 */

package com.jarotball.hash_based_structure.employee_project;

import java.util.*;

public class EmployeeMain {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Sally","CSE", 1234);
        Employee emp2 = new Employee("Killy","EEE", 4321);
        Employee emp3 = new Employee("Billy","CSE", 1000);
        Employee emp4 = new Employee("Dilly","CSE", 1000);

        // Create a HashMap with Key: empID and Value: EmployeeObject
        HashMap<Integer, Employee> employeesByIdHashMap = new HashMap<>();

        // add the employees by their ID into the HashMap
        employeesByIdHashMap.put(emp1.id, emp1);
        employeesByIdHashMap.put(emp2.id, emp2);
        employeesByIdHashMap.put(emp3.id, emp3);
        employeesByIdHashMap.put(emp4.id, emp4);

        // Enter an Employee ID and retrieve his/her name and department
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        int empID = 0;
        try {
            empID = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Expecting an Integer, Got String ... Existing");
            return;
        }

        // retrieve the employee by their ID and if the info is retrieved, print employeeName and employeeDepartment
        var retrievedEmployee = employeesByIdHashMap.get(empID);
        if (retrievedEmployee!=null){
            System.out.println(retrievedEmployee.name+" : "+ retrievedEmployee.department);
        } else {
            System.out.println("Cant Retrieve Employee info for: "+ empID);
        }

        // Get all the unique employee ID and
        var empIDSet= employeesByIdHashMap.keySet();

        // Enter a Unique set of product code using HashSet - HashSet is unordered and unique
        HashSet<String> productCodes_HS = new HashSet<>();
        productCodes_HS.add("XYZ01");
        productCodes_HS.add("XYZ02");
        productCodes_HS.add("XYZ03");

        // print all elements from HashSet
        System.out.println(productCodes_HS.contains("XYZ01"));
        for (var item:productCodes_HS
             ) {
            System.out.println(item);

        }
    }
}
