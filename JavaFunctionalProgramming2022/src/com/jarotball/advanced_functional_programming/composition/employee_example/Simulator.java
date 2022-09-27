package com.jarotball.advanced_functional_programming.composition.employee_example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Simulator {
    public static void main(String[] args) {
        // Create 6x Employees
        Employee[] empArray = {
                new Employee("Billy",23,"developer", 33000f),
                new Employee("Silly",25,"developer", 30000f),
                new Employee("Killy",30,"sales", 43000f),
                new Employee("Pilly",33,"developer", 33000f),
                new Employee("Ailly",44,"sales", 13000f),
                new Employee("Tilly",34,"sales", 13000f),
                new Employee("Filly",23,"developer", 33000f)
        };

        // Convert the list into array
        List<Employee> empList = Arrays.asList(empArray);

        // Strategy_01: (USING STREAM/Without Any Function) - Reverse EmployeeName and then UpperCase
        var empNameRevUpperList = empList
                .stream()
                .map((emp)-> {
                    var empName=emp.getName();
                    StringBuilder sb = new StringBuilder();
                    sb.append(empName);
                    return sb.reverse().toString().toUpperCase(); // reverse it, then convert it into uppercase

                })
                .collect(Collectors.toList());

        System.out.println(empNameRevUpperList);

        // Strategy_02: (Using Stream/ Functional Composition)
        /**
         * f(x:Employee|Object) = employee_name
         * g(x:EmployeeName|String) = reverse+uppercase
         *
         * */

        Function<Employee, String> fX = (emp)-> emp.getName();
        Function<String, String> gX = (empName)-> {
            StringBuilder sb = new StringBuilder();
            sb.append(empName);
            return sb.reverse().toString().toUpperCase();
        };

        // Why gOf, why not fOg?
        /**
         * gOf=g(f(x)) we firstNeed the EmpName which f(x) will provide us; then on those name apply g(x)
         * if fOg=f(g(x)), will return error; because we are asking to reverse and uppercase when yet to get any empName from Employee Object.
         *
         * That's why gOf is used here.
         * */
        var gOf= gX.compose(fX);

        var result = empList
                .stream()
                .map((emp)-> gOf.apply(emp))
                .collect(Collectors.toList());
        System.out.println(result);


    }
}
