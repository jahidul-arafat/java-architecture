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

public class FilterArrays {
    public static void main(String[] args) {
        int[] demoArray = {-9,3,2,-8,12,-16};

        // using Arrays.stream().filter(predicate)
        filterArrayEvenOptimized(demoArray);

        // using ArrayList, then ArrayList.stream().mapToIn
        filterArrayEven(demoArray);
    }

    private static void filterArrayEven(int[] demoArray) {
        ArrayList<Integer> evenDemoArrayList = new ArrayList<>();
        for (int num: demoArray
             ) {
            if (num%2==0){
                evenDemoArrayList.add(num);
            }
        }

        var evenDemoArray = evenDemoArrayList.stream().mapToInt(Integer::intValue).toArray();
        Arrays.stream(evenDemoArray).forEach(System.out::println);
    }

    private static void filterArrayEvenOptimized(int[] demoArray) {
        IntPredicate isEvenNum = num-> num%2==0;
        var evenDemoArray = Arrays.stream(demoArray).filter(isEvenNum).toArray();
        Arrays.stream(evenDemoArray).forEach(System.out::println);
    }
}
