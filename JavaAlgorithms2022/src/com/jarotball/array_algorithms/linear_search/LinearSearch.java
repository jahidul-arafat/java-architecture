/*
 * Copyright (c) 2022.
 * Jahidul Arafat
 * jahidul.arafat@oracle.com
 *
 * All rights reserved.
 */

package com.jarotball.array_algorithms.linear_search;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        int[] demoArray = {1, 2, 3, 4, 5, 6, 7};

        Scanner sc = new Scanner(System.in);
        System.out.println("Search Number: ");
        var numToBeSearched = sc.nextInt();

        // call the linearSearch::Basic method
        System.out.print(String.format("Searching <%s> :: ", numToBeSearched));
        System.out.println(linearSearch(demoArray, numToBeSearched));
        System.out.println();

        // call the linearSearch::Stream method
        linearSearchStream(demoArray, numToBeSearched).ifPresent(System.out::println);
    }

    /**
     * Method Variations
     * --------------------
     * (a) public static int linearSearch(int[] demoArray, int numToBeSearched) -> if return type is integer
     * (b) public static boolean linearSearch(int[] demoArray, int numToBeSearched) -> if return type is boolean
     * (c) public static Integer linearSearch(int[] demoArray, int numToBeSearched) -> if return either integer or null.
     * primitive type <int> cant be null. Thats why use return tupe Integer <an Object>
     * (d) public static Integer linearSearch(int[] demoArray, int numToBeSearched)
     * (e) public static Object linearSearch(int[] demoArray, int numToBeSearched) // if you know the returns an object, but unsure of what type.
     */
    public static Integer linearSearch(int[] demoArray, int numToBeSearched) {
        System.out.print("Into the LinearSearch::Basic");
        for (int item : demoArray
        ) {
            if (item == numToBeSearched) {
                return item;
            }
        }
        return null;
    }

    /**
     * Method Variation
     * ----------------
     * public static OptionalInt linearSearchStream(int[] demoArray, int numToBeSearched)
     * public static Object linearSearchStream(int[] demoArray, int numToBeSearched) // if unsure of whatType of Object
     * using Arrays.stream()
     * Return OptionalInt <Object>
     * using lambda in the filter
     *
     * Some JSHELL implementation
     * -----------------------------
     * jshell> myArray
     * myArray ==> int[7] { 1, 2, 3, 4, 5, 6, 7 }
     *
     * jshell> var myArrayStream = Arrays.stream(myArray)
     * myArrayStream ==> java.util.stream.IntPipeline$Head@161cd475
     *
     * jshell> myArrayStream.filter(x-> x==10).findFirst()
     * $32 ==> OptionalInt.empty
     *
     * jshell> var myArrayStream = Arrays.stream(myArray)
     * myArrayStream ==> java.util.stream.IntPipeline$Head@5f8ed237
     *
     * jshell> myArrayStream.filter(x-> x==5).findFirst()
     * $34 ==> OptionalInt[5]
     * */

    public static OptionalInt linearSearchStream(int[] demoArray, int numToBeSearched) {
        System.out.println("Into the LinearSearch::Stream");
        return Arrays.stream(demoArray).filter(currentItem -> currentItem == numToBeSearched).findFirst();
        //var output = Arrays.stream(demoArray).filter((int item)->{return item == numToBeSearched;}).findFirst();
        //return output;
    }
}
