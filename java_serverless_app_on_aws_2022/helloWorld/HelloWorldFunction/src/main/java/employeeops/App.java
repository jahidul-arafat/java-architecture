package employeeops;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import employeeops.data.Employee;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Problem Statement: Given an array of employee, we are expecting output as below format
 * {developer: dev_avg_salary_in_float, sales: sales_avg_salary_in_float}
 * */
public class App implements RequestHandler<Employee[], Map<String,Map>> {
    @Override
    public Map<String, Map> handleRequest(Employee[] empArray, Context context) {
        // business logic
        Map<String, Map> empReportMap = new HashMap<>();

        var empList = Arrays.asList(empArray);

        // total employee count by employee job title
        System.out.println("Calculating employee count by job title");
        var totalEmpCountByJobTitleMap= empList
                .stream()
                .collect(Collectors.groupingBy((emp)-> emp.getJobTitle(),
                        Collectors.counting()));

        empReportMap.put("empCount", totalEmpCountByJobTitleMap);

        // total salary by employee job title
        System.out.println("Calculating total salary by job title");
        var totalSalaryByJobTitleMap = empList
                .stream()
                .collect(Collectors.groupingBy((emp)-> emp.getJobTitle()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        (entry) -> entry.getKey(),
                        (entry)-> entry.getValue()
                                .stream()
                                .map((emp)->emp.getSalary())
                                .reduce(0f,(acc,empSalary)-> acc+empSalary)
                ));

        empReportMap.put("totalSalary",totalSalaryByJobTitleMap);

        // Average salary by employee job title
        System.out.println("Calculating average salary by job title");
        var avgSalaryByJobTitleMap = empList
                .stream()
                .collect(Collectors.groupingBy((emp)-> emp.getJobTitle()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        (entry) -> entry.getKey(),
                        (entry)-> entry.getValue()
                                .stream()
                                .map((emp)->emp.getSalary())
                                .reduce(0f,(acc,empSalary)-> acc+empSalary/entry.getValue().size())
                ));
        empReportMap.put("averageSalary", avgSalaryByJobTitleMap);
        return empReportMap;
    }
}
