package com.jarotball.streams_in_java.filter_examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BasicFilterOps {
    /**
     * find all the even number from an array
     * find all the odd number from an array
     * .stream().filter() works on Predicate Function - One argument Boolean Function
     */
    public static void main(String[] args) {
        Integer[] intArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> intList = Arrays.asList(intArr);
        System.out.println("Initial Array: " + intList);

        // Applying filter - find all even numbers
        // Create filter function / Predicate Function
        // Predicate<T>   T - Input Type - Represents a predicate (boolean-valued function) of one argument
        Predicate<Integer> isEven = (x) -> x % 2 == 0;

        var evenNumList = intList.stream()
                .filter(isEven)
                .collect(Collectors.toList());

        System.out.println("Even Number List: " + evenNumList);

        // Applying filter - find all odd numbers
        Predicate<Integer> isOdd = (x) -> x % 2 != 0;
        var oddNumList = intList.stream()
                .filter(isOdd)
                .collect(Collectors.toList());
        System.out.println("Odd Number List: " + oddNumList);


    }
}
