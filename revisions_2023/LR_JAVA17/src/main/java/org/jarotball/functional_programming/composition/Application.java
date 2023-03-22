package org.jarotball.functional_programming.composition;

import org.jarotball.functional_programming.basics.project_2_employee.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // Advanced Functional Programming
        // Composition
        // f(x)= 3x+2
        // g(x) = x+5
        // Calculate f0g and g0f

//        Function<Integer,Integer> fX = (x)-> 3*x+2;
//        Function<Integer,Integer> gX = (x)-> x+5;
//
//        var f0g= fX.compose(gX);
//        var g0f = gX.compose(fX);
//
//        System.out.println(f0g.apply(10));
//        System.out.println(g0f.apply(10));

        // Create 6x Employees
        Employee[] empArray={
                new Employee("Ailly", "Aow", 15,3),
                new Employee("Billy", "Bow", 5,2),
                new Employee("Cilly", "Cow", 3,0),
                new Employee("Dilly", "Dow", 3,1),
                new Employee("Eilly", "Eow", 10,2),
                new Employee("Filly", "Fow", 9,1),
                new Employee("Gilly", "Gow", 7,1),
        };

        List<Employee> empList = Arrays.asList(empArray);


        // 1. (a) Reverse EmpName and then (b) Convert to Upper case
        Function<Employee, String> fX = employee -> employee.getfName();

        Function<String,String> gX=(name)->
        {
            StringBuilder sb = new StringBuilder();
            var eName=sb.append(name);
            return eName.reverse().toString().toUpperCase();
        };

        var empNameRevUpperList=empList
                .stream()
                .map(employee -> {
                    var eName=fX.apply(employee);
                    return gX.apply(eName);
                })
                .collect(Collectors.toList());
        System.out.println(empNameRevUpperList);

        // Using Composition
        // f(x) -> get emp name
        // g(x) -> revers and uppercase
        // here we will require, g0f-> g(f(x))-> reverseUpperCase(empName)

        var g0f= gX.compose(fX);
        var nameList=empList
                .stream()
                .map(employee -> g0f.apply(employee))
                .collect(Collectors.toList());
        System.out.println(nameList);
    }
}
