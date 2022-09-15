/*
 * Copyright (c) 2022.
 * Jahidul Arafat
 * jahidul.arafat@oracle.com
 *
 * All rights reserved.
 */

package com.jarotball.array_algorithms.aggregate_filter;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.stream.Stream;

/**
 * Marge the even number of both arrays
 * You cant simply print an array in JAVA
 * You either iterate using ForEach or for loop or using
 * Arrays.stream() to get the individual contents in the array
 *
 * To understand what flattening a stream consists in, consider a structure like [ [1,2,3],[4,5,6],[7,8,9] ] which has "two levels".
 * Flattening this means transforming it in a "one level" structure : [ 1,2,3,4,5,6,7,8,9 ]
 * Stream.flatMap, as it can be guessed by its name, is the combination of a map and a flat operation. That means that you first apply a function to your elements, and then flatten it.
 * Stream.map only applies a function to the stream without flattening the stream.
 */
public class MergeArrays {
    public static void main(String[] args) {
        int[] demoArray1 = {-9, 3, 2, -8, 12, -16};
        int[] demoArray2 = {0, -3, -8, -35, 40, 20, 7};

        //var mergedArray = findEvenNums(demoArray1,demoArray2); // this will return the Array Object, not the contents of the array

        // A good approach to print arrays
        //Arrays.stream(mergedArray).forEach(System.out::println);

        // A Bad approach to print contents of array
//        for (int item:mergedArray
//             ) {
//            System.out.println(item);
//        }


        var mergedArrayOptimized = findEvenNumsOptimized(demoArray1,demoArray2);
        Arrays.stream(mergedArrayOptimized).forEach(System.out::println);

    }

    public static int[] findEvenNums(int[] demoArray1, int[] demoArray2) {
        // Take a List where you can add items later
        ArrayList<Integer> resultArrayList = new ArrayList<>(); // T -Type argument cant be primitive type. So <int> cant be used

        // loop through array1 and get the even numbers
        for (int num : demoArray1
        ) {
            if (num % 2 == 0) resultArrayList.add(num);
        }

        // loop through array2 and get the even numbers
        for (int num : demoArray2
        ) {
            if (num % 2 == 0) resultArrayList.add(num);

        }

        // you simply cant return the resultArrayList becoz its not an int[] expecting.
        // So convert the resultArrayList into array
        /**
         * using the JAVA Stream API
         * Create a stream and map each Integer value to int --> still its a stream of int, instead stream of Integers
         * Then turn it into array using .toArray()
         *
         * */
        return resultArrayList.stream().mapToInt(Integer::intValue).toArray();
    }

    // lets make the implementation simpler using Java Streams
    // Java Stream -- used for parallel aggregation operations
    public static int[] findEvenNumsOptimized(int[] demoArray1, int[] demoArray2) {
        System.out.println("Into JAVA Stream operations ...");
        // Create an Integer Predicate which takes a number and check if the number/2 has zero remainder
        IntPredicate isEvenPred = num -> num % 2 == 0;

        // Create a Stream of both arrays
        // then stream through each individual array and filter based on the predicate defined
        // finally convert to Array
        return Stream.of(demoArray1,demoArray2).
                flatMapToInt(Arrays::stream).filter(isEvenPred).toArray();
    }
}
