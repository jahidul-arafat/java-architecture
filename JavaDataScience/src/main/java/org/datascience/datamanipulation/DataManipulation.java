package org.datascience.datamanipulation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DataManipulation {
    public static void main(String[] args) {
        // List of Integers
        Integer[] intArr = {1,2,3,4,5,6,7,8,9,10};
        List<Integer> intList = Arrays.asList(intArr);
        System.out.println(intList);

        // List of words
        String[] wordsArr = {"hello", "oracle", "your","data","science","team","is","a","masterpiece"};
        //String[] wordsArr = {"cool"};
        List<String> wordsList = Arrays.asList(wordsArr);
        System.out.println(wordsList);

        // List of Employees
        Employee[] empArr = {
                new Employee("Ailly",30, "developer", 20000f),
                new Employee("Billy",20, "developer", 25000f),
                new Employee("Cilly",40, "marketing", 20000f),
                new Employee("Dilly",25, "developer", 30000f),
                new Employee("Eilly",23, "marketing", 20000f),
                new Employee("Filly",19, "sales", 10000f),
                new Employee("Gilly",19, "sales", 15000f),
                new Employee("Hilly",19, "marketing", 10000f),
                new Employee("Iilly",19, "sales", 20000f),
                new Employee("Jilly",19, "developer", 50000f)
        };

        List<Employee> empList = Arrays.asList(empArr);
//        empList
//                .stream()
//                .forEach(System.out::println);


        // ops-1: double the integers in the list
        var doubleIntList = intList
                .stream()
                .map((n) -> (n)*2)
                .collect(Collectors.toList());
        //System.out.println(doubleIntList);

        // ops-2: find the odd numbers in the list
        var oddIntList = intList
                .stream()
                .filter((n)-> n%2!=0)
                .collect(Collectors.toList());
        //System.out.println(oddIntList);

        // ops-3: Convert the words in uppercase
        var upperWordList = wordsList
                .stream()
                .map((word)-> word.toUpperCase())
                .collect(Collectors.toList());
        //System.out.println(upperWordList);

        // ops-4: Capitalize first character of each word
        var capsFirstWordList=wordsList
                .stream()
                .map((word)-> word.substring(0,1).toUpperCase()+ word.substring(1))
                .collect(Collectors.toList());
        //System.out.println(capsFirstWordList);

        // ops-5: Capitalize any N random letter of each word
        BiFunction<String,Integer, String> randWordConvertFunc= (word,flagCount)->
        {
            if (flagCount>=word.length()) // abc //is
                return word.toUpperCase();

            // else -- hello
            Set<Integer> flagSet = new HashSet<>();
            var word2CharList = word.chars()
                    .mapToObj(c-> (char)c)
                    .collect(Collectors.toList());

            //get the flags, make sure 3 non-repeating flags
            while (flagSet.size()<flagCount){
                int flag=(int) (Math.random()*(word.length()));
                flagSet.add(flag);
            }
            System.out.println("FlagSet Size: "+flagSet.size()+ "Elements: "+flagSet);


            // else
            StringBuilder sb = new StringBuilder();
            for (Integer flag: flagSet) {
                word2CharList.set(flag, Character.toUpperCase(word.charAt(flag)));
            }
            for (int i=0;i<word.length();i++){
                sb.append(word2CharList.get(i));
            }

            return sb.toString();
        };


        var randCapsWordList =wordsList
                .stream()
                .map((word)->randWordConvertFunc.apply(word,3))
                .collect(Collectors.toList());
        System.out.println(randCapsWordList);

        // ops-6: Find words, when length >9
        wordsList
                .stream()
                .filter((word)-> word.length()>4)
                .collect(Collectors.toList())
                .forEach((word)-> System.out.print(word+">>"));
        System.out.println();

        // -------------------------------------
        // ops-7: Employee Operations
        Map<String,String> empMap = new HashMap<>();
        Map<String, Map<String,String>> reportMap = new HashMap<>();

        // 7.1 list only employee names
        var empNameList= empList
                .stream()
                .map(emp -> emp.name)
                .collect(Collectors.toList());
        System.out.println(empNameList);

        // 7.2 count, total, avg, min, max salary of all employees
        // a. # of employees
        var totalEmpCount = empList
                .stream()
                .collect(Collectors.counting());
        System.out.println("Total Employees: "+ totalEmpCount);
        empMap.put("count",String.valueOf(totalEmpCount));


        // b. total salary
        var totalSalaryOfAll = empList
                .stream()
                .mapToDouble(employee -> employee.salary)
                .sum();
        System.out.println(totalSalaryOfAll);
        empMap.put("total_salary", String.valueOf(totalSalaryOfAll));


        // c. average emp salary
        var avgEmpSalary=empList
                .stream()
                .mapToDouble(emp-> emp.salary)
                .average()
                .orElse(-1);
        System.out.println("Avg Employee Salary: "+ avgEmpSalary);
        empMap.put("avg_salary",String.valueOf(avgEmpSalary));

        // d. find min employee salary
        var minSalaryEmp= empList
                .stream()
                .min(Comparator.comparing(employee -> employee.salary))
                //.ifPresent(emp-> System.out.println("Min Emp Salary: "+emp.salary));
                .map(employee -> employee.salary);
        empMap.put("min_salary", String.valueOf(minSalaryEmp));

        // e. find max employee salary
        var maxSalaryEmp= empList
                .stream()
                .max(Comparator.comparing(employee -> employee.salary))
                //.ifPresent(employee -> System.out.println("Max Emp Salary: "+ employee.salary));
                .map(employee -> employee.salary);
        empMap.put("max_salary", String.valueOf(maxSalaryEmp));

        // f. first and last employee in the list
        var firstEmp = empList
                .stream()
                .findFirst()
                .map(employee -> employee.name)
                        .orElse(null);
        empMap.put("first_emp",firstEmp);

        var lastEmp = empList
                .stream()
                .reduce((e1,e2)-> e2)
                .map(employee -> employee.name)
                .orElse(null);
        empMap.put("last_emp", lastEmp);

        reportMap.put("Employee",empMap);

        // print the empMap as JSON
        final String empJson=new Gson().toJson(empMap);
        System.out.println(empJson);

        // -----------------------------------------------------------------------------------------------------
        Function<String, Function<Employee, Boolean>> empFuncFactoryByJobTitle =
                (jobTitle)-> (employee)-> employee.jobTitle.equalsIgnoreCase(jobTitle);

        var devsOnly = empFuncFactoryByJobTitle.apply("developer");
        var salesOnly = empFuncFactoryByJobTitle.apply("sales");

        Map<String,String> devMap = new HashMap<>();

        // a. get the total, avg, min and max salary of developers only
        var totalSalaryDev = empList
                .stream()
                .filter(employee -> devsOnly.apply(employee))
                .mapToDouble(employee -> employee.salary)
                .sum();
        devMap.put("total_salary",String.valueOf(totalSalaryDev));

        // avg salary
        var avgSalaryDev= empList
                .stream()
                .filter(employee -> devsOnly.apply(employee))
                .mapToDouble(employee -> employee.salary)
                .average();
        devMap.put("avg_salary",String.valueOf(avgSalaryDev));

        // min salary
        var minSalaryDev= empList
                .stream()
                .filter(employee -> devsOnly.apply(employee))
                .min(Comparator.comparing(dev -> dev.salary))
                //.ifPresent(dev -> System.out.println(dev.salary));
                        .map(employee -> employee.salary)
                                .orElse(-1f);
        devMap.put("min_salary", String.valueOf(minSalaryDev));

        // max salary
        var maxSalaryDev= empList
                .stream()
                .filter(employee -> devsOnly.apply(employee))
                .max(Comparator.comparing(dev -> dev.salary))
                //.ifPresent(dev -> System.out.println(dev.salary));
                .map(employee -> employee.salary)
                .orElse(-1f);
        devMap.put("max_salary", String.valueOf(maxSalaryDev));


        // number of developers
        var devCount = empList
                .stream()
                .filter(employee -> devsOnly.apply(employee))
                .collect(Collectors.counting());
        devMap.put("count", String.valueOf(devCount));

        // find first developer in the list
        var firstDev = empList
                .stream()
                .filter(employee -> devsOnly.apply(employee))
                .findAny()
                .map(employee -> employee.name)
                .orElse(null);
        devMap.put("first", firstDev);

        // find the last developer in the list
        var findLast = empList
                .stream()
                .filter(employee -> devsOnly.apply(employee))
                .reduce((first, last)-> last)
                .map(employee -> employee.name)
                .orElse(null);
        devMap.put("last", findLast);

        reportMap.put("Developer", devMap);

        System.out.println(reportMap);

        // --------- Collect GroupBy----------
        // sort employee by age
        Comparator<Employee> empAgeComparatorASC= Comparator.comparing(Employee::getAge,(emp1,emp2)->emp1.compareTo(emp2));
        Comparator<Employee> empAgeComparatorDSC= Comparator.comparing(Employee::getAge,(emp1,emp2)->emp2.compareTo(emp1));

        empList
                .stream()
                .sorted(empAgeComparatorASC)
                .forEach(System.out::println);

        System.out.println("---------");
        empList
                .stream()
                .sorted(empAgeComparatorDSC)
                .forEach(System.out::println);

        System.out.println("-------------");
        // sort employee by name length
        Comparator<Employee> empNameComparatorASC = Comparator.comparing(Employee::getName, (emp1,emp2)-> emp1.compareTo(emp2));
        Comparator<Employee> empNameComparatorDSC = Comparator.comparing(Employee::getName, (emp1,emp2)-> emp2.compareTo(emp1));

        empList
                .stream()
                .sorted(empNameComparatorASC)
                .forEach(System.out::println);

        System.out.println("-------------------------");

        empList
                .stream()
                .sorted(empNameComparatorDSC)
                .forEach(System.out::println);

        // sort employee by salary
        Comparator<Employee> empSalaryComparatorASC = Comparator.comparing(Employee::getSalary, (emp1,emp2)-> emp1.compareTo(emp2));
        Comparator<Employee> empSalaryComparatorDSC = Comparator.comparing(Employee::getSalary, (emp1,emp2)-> emp2.compareTo(emp1));

        empList
                .stream()
                .sorted(empSalaryComparatorASC)
                .forEach(System.out::println);

        System.out.println("----------------------------");

        empList
                .stream()
                .sorted(empSalaryComparatorDSC)
                .forEach(System.out::println);

        // Collection GroupBy
        // average salary by each category: developer, sales, marketing
        var empCatAvgSalary= empList
                .stream()
                .collect(Collectors.groupingBy(Employee::getJobTitle))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        (entry)-> entry.getKey(),
                        (entry)-> entry.getValue()
                                .stream()
                                .mapToDouble((emp)-> emp.salary)
                                .average()
                                .stream()
                                .map(Math::round)
                                .findFirst()
                                .orElse(0)

                ));
        System.out.println(empCatAvgSalary);


    }
}
