package org.datascience.datamanipulation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Challenge {
    public static void main(String[] args) {
        Employee[] empArr = {
                new Employee("Ailly",32, "developer", 20000f),
                new Employee("Billy",30, "developer", 25000f),
                new Employee("Cilly",40, "marketing", 20000f),
                new Employee("Dilly",35, "developer", 30000f),
                new Employee("Eilly",33, "marketing", 20000f),
                new Employee("Filly",19, "sales", 10000f),
                new Employee("Gilly",19, "sales", 15000f),
                new Employee("Hilly",19, "marketing", 10000f),
                new Employee("Iilly",59, "sales", 20000f),
                new Employee("Jilly",19, "developer", 50000f)

        };

        List<Employee> empList = Arrays.asList(empArr);

        BiFunction<Integer,String,Function<Employee, Boolean>> empAgeFuncFactory = (age,comparator)-> (emp)-> {
            if (comparator.equalsIgnoreCase("gt"))
                return emp.age>age;
            return emp.age<=age;
        };

        var ageOver30= empAgeFuncFactory.apply(30,"gt");
        var ageOver40= empAgeFuncFactory.apply(40,"gt");
        var ageEqualUnder20 = empAgeFuncFactory.apply(20,"lte");

        Comparator<Employee> salaryComparatorASC = Comparator.comparing(Employee::getSalary,(emp1,emp2)-> emp1.compareTo(emp2));
        Comparator<Employee> salaryComparatorDSC = Comparator.comparing(Employee::getSalary,(emp1,emp2)-> emp2.compareTo(emp1));

        // Task-1: get the names of all employees over 30 years of age sorted by their salary in ascending order
        empList
                .stream()
                .filter(employee -> ageOver30.apply(employee))
                .sorted(salaryComparatorASC)
                //.map(employee -> employee.name)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        //System.out.println("Emp Names Over age 30: "+ empNameOverAge30);

        // Task-2: get the names of all employees over 40 years of age
        var empNameOverAge40 = empList
                .stream()
                .filter(employee -> ageOver30.apply(employee))
                .map(employee -> employee.name)
                .collect(Collectors.toList());
        System.out.println("Emp Names Over age 40: "+ empNameOverAge40);

        // Task-3: get the names of all employees over 40 years of age
        var empNameEqualUnder20 = empList
                .stream()
                .filter(employee -> ageEqualUnder20.apply(employee))
                .map(employee -> employee.name)
                .collect(Collectors.toList());
        System.out.println("Emp Names Over age 40: "+ empNameEqualUnder20);

        // Task-4: Using more simplified way to group employee names by their age
        var empGroupedByAge= empList
                .stream()
                .collect(Collectors.groupingBy(employee -> employee.age))
                        .entrySet()
                        .stream()
                                .collect(Collectors.toMap(
                                        (entry)-> entry.getKey(),
                                        (entry)-> entry.getValue()
                                                .stream()
                                                .map(employee -> employee.getName())
                                                .collect(Collectors.toList())
                                ));
        System.out.println(empGroupedByAge);
        System.out.println();

    }


}
