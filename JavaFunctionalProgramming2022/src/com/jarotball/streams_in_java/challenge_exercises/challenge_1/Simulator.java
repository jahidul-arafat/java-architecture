package com.jarotball.streams_in_java.challenge_exercises.challenge_1;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Problem-01: Return a list contains all the Person's name | No Condition
 *
 * Problem-02: Get a list of all the BLUE cars | condition: carColor==BLUE and
 *         // count how many of them
 *         // return on the makers of the blue car
 *
 * Problem-03: Find the SUM of all the employee's salary | Reduced to salarySUM
 * */

public class Simulator {
    public static void main(String[] args) {
        // Problem-01: Return a list contains all the Person's name | No Condition
        // 1.1 Create 5x Persons
        Person[] personArray = {
                new Person("Billy", 23),
                new Person("Silly", 43),
                new Person("Killy", 20),
                new Person("Tilly", 50),
                new Person("Filly", 14)
        };

        // 1.2 Convert the Array into List
        List<Person> personList = Arrays.asList(personArray);

        // 1.3 Define the map function which will return only the personName for the personObject
        Function<Person, String> personNameMapper = (person) -> person.getName();

        // 1.4 Get the list of all PersonName using the mapFunciton <personNameMapper>
        var personNameOnlyList = personList.stream()
                .map(personNameMapper)
                .collect(Collectors.toList());

        // 1.5 Print the list containing only the person names
        System.out.println(personNameOnlyList);


        // Problem-02: Get a list of all the BLUE cars | condition: carColor==BLUE and
        // count how many of them
        // return on the makers of the blue car

        //2.1 Create 5x Cars
        Car[] carArray = {
                new Car("Chevy", "red", 4500f),
                new Car("Ford", "blue", 4500f),
                new Car("Toyota", "grey", 4500f),
                new Car("Lamborghini", "blue", 4500f),
                new Car("Renault", "blue", 4500f),
        };

        // 2.2 Convert the carArray into carList
        List<Car> carList = Arrays.asList(carArray);

        // 2.3 Define the filter Predicate Function
        Predicate<Car> carFilterPredicate = (car) -> car.getColor() == "blue";

        // 2.4 Get the list of all BLUE colored cars
        var carOnlyBlueList = carList.stream()
                .filter(carFilterPredicate)
                .collect(Collectors.toList());
        System.out.println("Blue Cars: " + carOnlyBlueList);

        // 2.5 Get how many blue cars instead of the details of those cars
        var howManyBlueCars = carList.stream()
                .filter(carFilterPredicate)
                .collect(Collectors.counting());
        System.out.println("Number of BLUE cars: " + howManyBlueCars);

        // 2.6 Returns only the maker of those blue cars
        var carMakersOnlyListForBlue = carList.stream()
                .filter(carFilterPredicate)
                .map((car) -> car.getMake())
                .collect(Collectors.toList());
        System.out.println("Makes of BLUE cars: " + carMakersOnlyListForBlue);


        // Problem-03: Find the SUM of all the employee's salary | Reduced to salarySUM
        // 3.1 Create 6x Employees
        Employee[] empArray = {
                new Employee("Billy", 23, "Intern", 13000f),
                new Employee("Filly", 40, "Head", 43000f),
                new Employee("Tilly", 32, "GM", 33000f),
                new Employee("Killy", 44, "VP", 63000f),
                new Employee("Silly", 50, "EVP", 73000f),
                new Employee("Pilly", 29, "Software Engineer", 23000f),
        };

        // 3.2 Convert the empArry into empList
        List<Employee> empList = Arrays.asList(empArray);


        // 3.3 Define the REDUCE function to get the SUM of all employeeSalaries
        BinaryOperator<Float> getSalarySum = (acc, empSalary) -> {
            var output = acc + empSalary;
            System.out.println(String.format("Acc: %s, Emp Salary: %s, Total Salary: %s", acc, empSalary, output));
            return output;
        };

        // 3.4 Get the SUM of all employeeSalaries
        // Strategy:
        // (a) Get the salary of individual employee | Mapping employeeObject to employeeSalary
        // (b) Use BinaryOperator<T> to accumulate/Summation all employee salaries
        System.out.println("Summarizing all then Employee Salaries ...");
        var sumOfAllEmpSalary = empList.stream()
                .map((emp)-> emp.getSalary())
                .reduce(0f,getSalarySum);
        System.out.println("-------------------------------------------------------");
        System.out.println("Total Salary: "+ sumOfAllEmpSalary);


    }
}
