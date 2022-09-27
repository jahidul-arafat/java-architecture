package com.jarotball.firstclass_functions.functional_programming_basics.employee_lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Simulator {
    public static void main(String[] args) {
        // Create 7x Employees
        // The MD
        Employee jahid = new Employee("Jahidul","Arafat",15,0);

        // Rest
        Employee billy = new Employee("Billy","Adward",10,2);
        Employee silly = new Employee("Silly","Swart",1,4);
        Employee killy = new Employee("Killy","Adward",5,1);
        Employee filly = new Employee("Filly","Swart",6,4);
        Employee tilly = new Employee("Tilly","Adward",17,1);
        Employee milly = new Employee("Milly","Swart",3,1);
        Employee ailly = new Employee("Ailly","Adward",7,3);
        Employee dilly = new Employee("Dilly","Swart",11,4);


        // Set their manager
        billy.setManager(jahid);  // Head of Award, reports to MD<jahid>
        silly.setManager(jahid);  // Head of Swart, reports to MD<jahid>

        // Awards
        killy.setManager(billy);
        tilly.setManager(billy);
        ailly.setManager(billy);

        // Swarts
        filly.setManager(silly);
        milly.setManager(silly);
        dilly.setManager(silly);

        // Create an Emp List and add the employees into the list
        List<Employee> empList= new ArrayList<>();
        empList.add(jahid);
        empList.add(billy);
        empList.add(silly);
        empList.add(killy);
        empList.add(filly);
        empList.add(tilly);
        empList.add(milly);
        empList.add(ailly);
        empList.add(dilly);


        // Problem_01: Get the Full Name of all employees
        // [Jahidul Arafat, Billy Adward, Silly Swart, Killy Adward, Filly Swart, Tilly Adward, Milly Swart, Ailly Adward, Dilly Swart]
        Function<Employee,String> empFullNameMapper = (emp)-> emp.getFirstName() + " " + emp.getLastName();
        var empNameList = empList
                .stream()
                .map(empFullNameMapper)
                .collect(Collectors.toList());
        System.out.println(empNameList);

        // Problem_02: Get the last name of managers of all employees
        // [-1, Arafat, Arafat, Adward, Swart, Adward, Swart, Adward, Swart]
        Function<Employee, String> empManagerLastNameMapper =(emp)->{
            try{
                return emp.getManager().getLastName();
            } catch (Exception e){
                return "-1"; // -1 means No Manager; S/He is the MD
            }
        };
        var empManagerLastNameList= empList
                .stream()
                .map(empManagerLastNameMapper)
                .collect(Collectors.toList());
        System.out.println(empManagerLastNameList);

        // Problem_03: find employees has been employed more than five years
        // [Jahidul, Billy, Filly, Tilly, Ailly, Dilly]
        Predicate<Employee> moreThanFive = (emp)-> emp.getYearsOfService()>5;
        var empMoreThanFiveYears = empList
                .stream()
                .filter(moreThanFive)
                .map((emp)-> emp.getFirstName())
                .collect(Collectors.toList());
        System.out.println(empMoreThanFiveYears);

        // Problem_04: Categorize the employees by their manager name
        /**
         * {-1=[Jahidul Arafat],
         * Swart=[Filly Swart, Milly Swart, Dilly Swart],
         * Arafat=[Billy Adward, Silly Swart],
         * Adward=[Killy Adward, Tilly Adward, Ailly Adward]}
         * */
        var managerEmpMap = empList
                .stream()
                .collect(Collectors.groupingBy(empManagerLastNameMapper))
                        .entrySet()
                                .stream()
                .collect(Collectors.toMap(
                        (entry) -> entry.getKey(),
                        (entry) -> entry.getValue()
                                .stream()
                                .map(empFullNameMapper)
                                .collect(Collectors.toList())
                ));

        System.out.println(managerEmpMap);

        // Problem_05: Find Employees having more than 3 direct reports
        // [Silly Swart, Filly Swart, Dilly Swart]
        // Also find employees who dont report to anyone.
        // [Jahidul Arafat]
        Function<Integer,Function<Employee,Boolean>> empReportFuncFactory =
                (numOfDirectReports)-> (emp)-> emp.getNumberOfDirectReports()>numOfDirectReports;

        var moreThan3Reports = empReportFuncFactory.apply(3);
        var moreThan2Reports = empReportFuncFactory.apply(2);
        Predicate<Employee> havingNoReports = (emp)-> emp.getNumberOfDirectReports()==0;

        var empMoreThan3Reports = empList
                .stream()
                .filter((emp)-> moreThan3Reports.apply(emp))
                .map(empFullNameMapper)
                .collect(Collectors.toList());
        System.out.println(empMoreThan3Reports);

        var empHavingNoReports = empList
                .stream()
                .filter(havingNoReports)
                .map(empFullNameMapper)
                .collect(Collectors.toList());
        System.out.println(empHavingNoReports); //[Jahidul Arafat]



    }
}
