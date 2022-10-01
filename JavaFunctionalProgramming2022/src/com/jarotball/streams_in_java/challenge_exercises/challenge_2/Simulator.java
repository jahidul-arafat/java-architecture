package com.jarotball.streams_in_java.challenge_exercises.challenge_2;

import com.jarotball.firstclass_functions.custom_functional_programming_interfaces.NoArgFunction;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Problem_1: Get the average salary of developers compared to the average salary of all the other jobTitles
 * Strategy 01:Get the SUM of all developer Salary
 * (a) Filter all the developers from the employee list
 * (b) Map each developerObject only to the developerSalary
 * (c) Reduce the developerSalary to SUM
 *
 * Strategy 02: Get how many are developers in the existing employeeList.
 * (a) Filter all the developers from the employee list
 * (b) Using Collectors.counting() to get the count_of_developers
 *
 * Strategy 03: Get the Average salary of developer
 * (a) avg_developer_salary= total_salary_of_all_developers / total_number_of_developers
 *
 *
 * */
public class Simulator {
    public static void main(String[] args) {
        // 1.1 Create 6x employees
        Employee[] empArray = {
                new Employee("Billy",23, "developer", 23000f), // empObject1
                new Employee("Silly",21, "sales", 13000f),     // empObject2
                new Employee("Killy",30, "developer", 33000f), // empObject3
                new Employee("Filly",44, "sales", 11000f),     // empObject4
                new Employee("Ailly",37, "developer", 33000f), // empObject5
                new Employee("Cilly",32, "sales", 13000f),     // empObject6
                new Employee("Dilly",30, "sales", 13000f),     // empObject7
                new Employee("Pilly",55, "sales", 43000f)      // empObject8
        };


        // 1.2 Convert the empArray into empList
        List<Employee> empList = Arrays.asList(empArray);

        // 1.3 returns function based on JobTitle
        Function<String, Function<Employee, Boolean>> empFuncFactoryByJobTitle =
                (jobTitle)-> (emp)-> emp.getJobTitle().equalsIgnoreCase(jobTitle);

        var developersOnly = empFuncFactoryByJobTitle.apply("developer");
        var salesOnly = empFuncFactoryByJobTitle.apply("sales");

        // ------- Developer -------------
        // 1.4 Get summation of all developer salaries
        var totalSalaryDeveloper = empList
                .stream()
                //.filter((emp)-> emp.getJobTitle()=="developer")
                .filter((emp)-> developersOnly.apply(emp)) // get the developers from all employee list
                .map((developer)-> developer.getSalary())       // get the individual developer salary from the developerObject
                .reduce(0f,(acc,devSalary)-> acc+devSalary);
        System.out.println("Total Salary (of_all_developers): "+ totalSalaryDeveloper);

        // 1.5 get How many developers are in the employeeList
        var totalDevelopers = empList
                .stream()
                .filter((emp)-> developersOnly.apply(emp))
                .collect(Collectors.counting());
        System.out.println("Total Developers: "+ totalDevelopers);

        // 1.6 Ave Developer Salary
        var avgSalaryDeveloper = totalSalaryDeveloper/totalDevelopers;
        System.out.println("Avg Salary (developer): "+ avgSalaryDeveloper);

        System.out.println();

        // -----------------Sales---------------
        // 1.7 Get summation of all sales salaries
        var totalSalarySales = empList
                .stream()
                //.filter((emp)-> emp.getJobTitle()=="developer")
                .filter((emp)-> salesOnly.apply(emp)) // get the developers from all employee list
                .map((sales)-> sales.getSalary())       // get the individual developer salary from the developerObject
                .reduce(0f,(acc,salesSalary)-> acc+salesSalary);
        System.out.println("Total Salary (of_all_sales): "+ totalSalarySales);

        // 1.8 Total Sales Personnel in the Employee list
        var totalSalesPersonnel = empList
                .stream()
                .filter((emp)-> salesOnly.apply(emp))
                .collect(Collectors.counting());
        System.out.println("Total Sales Personnel: "+ totalSalesPersonnel);

        // 1.9 Avg salary of sales personnel
        var avgSalarySalesPersonnel = totalSalarySales/totalSalesPersonnel;
        System.out.println("Avg Salary (Sales): "+ avgSalarySalesPersonnel);

        // Recommendation
        /**
         * (1) Duplication of Steps found in 1.5 and 1.7
         * (2) Duplication of Steps found in 1.6 and 1.8
         * Q1. Is there any way to get rid of these duplication steps to make the program more readable and organized.  --> YES
         *
         * */
        // A Better Solution Approach
        /**
         * Strategies
         * 1. get the list of all employee, convert it into stream and later groupingBy the employeeJobTitle
         * outcome_Map: {developer/jobTitle: {empObject1, empObject3, empObject5}, sales/jobTitle: {empObject2, empObject4, empObject6, empObject7, empObject8}}
         *
         * 2. Get the list of all the key and value entry of these Map using .entrySet(),
         *                          -> convert it into stream
         *                          -> get into the values (empObjects) {a list of empObjects} of each Key/JobTitle
         *                              --> convert this list{empObjects} of specific Key/JobTitle into stream
         *                              --> map each empObject to empSalary | at this point we have this
         *                              {developer:{23000,33000,33000}, sales: {13000,11000,13000,13000,43000}}
         *                              -> reduce the salaries of each category to total_salary and then get avg= total_salary_per_category / total_developers
         * Output Format:  Map<String, Float>
         * Expected Output: {developer=29666.666, sales=18600.0}
         *
         * */

        var jobTitleByAvgSalaryMap = empList
                .stream()
                .collect(Collectors.groupingBy((emp)-> emp.getJobTitle()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        (entry)-> entry.getKey(),
                        (entry)-> entry.getValue()
                                .stream()
                                .map((emp)-> emp.getSalary())
                                .reduce(0f,(acc, empSalary)-> acc+empSalary / entry.getValue().size())
                ));
        System.out.println(jobTitleByAvgSalaryMap);

        // using iterators
//        var itr = jobEmpMap.entrySet().iterator();
//        while (itr.hasNext()){
//            var entry = itr.next();
//            System.out.println(String.format("Key= %s, Value = %s",entry.getKey(),entry.getValue()));
//        }







    }
}
