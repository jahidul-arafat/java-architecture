package org.jarotball.functional_programming.basics.project_2_employee;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Application {
    protected static void print(List<Employee> empList, Function func){
        empList
                .stream()
                .map(employee -> employee.getfName() + ">> Manager->"+ func)
                .forEach(System.out::println);
    }
    public static void main(String[] args) {
        // Create a Manager
        Employee md = new Employee("Jahidul","Arafat",15,0);

        // Create 7x Employees
        Employee billy = new Employee("Billy","Adward",10,2);
        Employee silly = new Employee("Silly","Swart",1,4);
        Employee killy = new Employee("Killy","Adward",5,1);
        Employee filly = new Employee("Filly","Swart",6,4);
        Employee tilly = new Employee("Tilly","Adward",17,1);
        Employee milly = new Employee("Milly","Swart",3,1);
        Employee ailly = new Employee("Ailly","Adward",7,3);
        Employee dilly = new Employee("Dilly","Swart",11,4);

        // Set their managers
        md.setManager(md);
        // Set their manager
        billy.setManager(md);  // Head of Award, reports to MD<jahid>
        silly.setManager(md);  // Head of Swart, reports to MD<jahid>

        // Awards
        killy.setManager(billy);
        tilly.setManager(billy);
        ailly.setManager(billy);

        // Swarts
        filly.setManager(silly);
        milly.setManager(silly);
        //dilly.setManager(md);

        // Create an Employee List
        List<Employee> empList = new ArrayList<>();
        empList.add(md);
        empList.add(billy);
        empList.add(silly);
        empList.add(killy);
        empList.add(filly);
        empList.add(tilly);
        empList.add(milly);
        empList.add(ailly);
        empList.add(dilly);



        Function<Employee,String> empManagerLastNameMapperFunc = (emp)->{
            return emp.hasManager()==true?
                    ((emp.getManager().getlName()!=null)?emp.getManager().getlName():"-1"):"No Manager";
        };

        print(empList, empManagerLastNameMapperFunc);

        // Get the Full Name of all employees
        var empFullNameList=empList
                .stream()
                .map(employee -> employee.getfName()+" " + employee.getlName())
                .collect(Collectors.toList());
        System.out.println(empFullNameList);



        // Get the Last Name of Manager of all employees
        var empManagerLastNameList=empList
                .stream()
                .filter(employee -> employee.hasManager())
                .map(employee -> employee.getManager().getlName()!=null?employee.getManager().getlName():"-1")
                .collect(Collectors.toSet());
        System.out.println(empManagerLastNameList);

        // Find employees who has more than 5 years of experiences
        var empMoreThan5YearsExp=empList
                .stream()
                .filter(employee -> employee.getYearOfService()>=5)
                .map(employee -> employee.getfName()+">> Manager-->"+(employee.hasManager()?employee.getManager().getfName():"-1"))
                .collect(Collectors.toList());
        System.out.println(empMoreThan5YearsExp);

        // Group employees by their Manager name
        var empGroupByManager=empList
                .stream()
                .collect(Collectors.groupingBy(empManagerLastNameMapperFunc))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        (entry)-> entry.getKey(),
                        (entry)-> entry.getValue()
                                .stream()
                                .map(employee -> employee.getfName())
                                .collect(Collectors.toList())
                ));
        System.out.println(empGroupByManager);


        // Find employees who reports more than 'n' managers
        Function<Integer,Function<Employee,Boolean>> empReportFuncFactory=
                (numOfDirectReports)
                        ->(emp)-> emp.getNumOfDirectReports()>numOfDirectReports;
        var moreThan3Reports = empReportFuncFactory.apply(3);
        var moreThan5Reports = empReportFuncFactory.apply(5);
        var empMoreThan3Reports = empList
                .stream()
                .filter(employee -> moreThan3Reports.apply(employee))
                .map(employee -> employee.getfName())
                .collect(Collectors.toList());
        System.out.println(empMoreThan3Reports);

        // Find Employees having no report
        var empHavingNoReport = empList
                .stream()
                .filter(emp-> emp.hasManager()!=true)
                .map(employee -> employee.getfName())
                .collect(Collectors.toList());
        System.out.println(empHavingNoReport);

    }




}
