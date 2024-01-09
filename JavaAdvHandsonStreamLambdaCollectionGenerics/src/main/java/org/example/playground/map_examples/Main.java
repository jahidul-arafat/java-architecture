package org.example.playground.map_examples;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // define a list of integers from 1 to 10
        Integer[] intArr = {1,1,2,1,3,2,4,5,6,7,8,9,10};
        List<Integer> intList = new ArrayList<>(Arrays.asList(intArr));

        // Define a BiFunction Function which takes two arguments and returns a value multiple by N
        BiFunction<Integer, Integer,Integer> mulN = (i,n)->i*n;
        Function<Integer,Double> times2 = (i)->i*2.0;

        var doubledValue = intList.stream()
                .map(item->mulN.apply(item,2))
                .collect(Collectors.toList());
        System.out.println(doubledValue);

        var doubledValue2 = intList.stream()
                .map(value-> 2*value.doubleValue())
                        .reduce(0.0, Double::sum);
        System.out.println(doubledValue2);

        // use stream API to get the summation of all values in the intList
        var sum = intList.stream()
                       .reduce(0, Integer::sum);
        System.out.println(sum);

        var doubleList = intList.stream()
                .map(Integer::doubleValue)
                .toList();
        System.out.println(doubleList);

        var intList2 = doubleList.stream()
                .map(Double::intValue)
                .collect(Collectors.toList());
        System.out.println(intList2);

        String[] intStrArr={"1.2","2","3","4","5","6","7","8","9","10","1.2"};
        List<String> intStrList = new ArrayList<>(Arrays.asList(intStrArr));
        var intStrListInt = intStrList.stream()
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        System.out.println(intStrListInt);

        var sumDouble = intStrListInt.stream()//Double::doubleValue is a method reference to Double class; referring the method "doubleValue"
                        .reduce(0.0, Double::sum);
        System.out.println(sumDouble);

        // By Jahidul Arafat, Solution Architect (AppDev and DevOps)
        // Clean Code Writer
        Function<Integer,Function<Integer,Integer>> timesFactory = (item)->times->item*times;
        var timesFactory2 = timesFactory.apply(2);
        var timesFactory3 = timesFactory.apply(3);

        var intListTimes3 = intList.stream()
                .map(timesFactory3::apply)
                .collect(Collectors.toList());
        System.out.println(intListTimes3);

        // count the occurrence of each number in the intList where return type is Map<Integer,Integer>
        Map<Integer,Long> countMap = intList.stream()
               .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(countMap);

        Map<Double,Long> countIntStrMap = intStrList.stream()
                .map(Double::parseDouble)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        /*
        Collectors.groupingBy(Function.identity(), Collectors.counting())
        - means, group the elements by their identity (here, identity is the number itself),
        - and count the number of times each element appears in the stream.
         */
        System.out.println(countIntStrMap);
        System.out.println(countIntStrMap.get(2.0));

        // take user input from the user using scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        var userInput = scanner.nextDouble();
        System.out.println(countIntStrMap.get(userInput));



    }
}
