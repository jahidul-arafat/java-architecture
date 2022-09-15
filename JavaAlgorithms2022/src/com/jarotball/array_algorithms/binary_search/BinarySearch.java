/*
 * Copyright (c) 2022.
 * Jahidul Arafat
 * jahidul.arafat@oracle.com
 *
 * All rights reserved.
 */

package com.jarotball.array_algorithms.binary_search;


import java.util.Arrays;
import java.util.Scanner;

/**
 * Binary Search - O(log(n)) - Only on Sorted Array
 */

public class BinarySearch {

    public static void main(String[] args) {
        //user input
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter item to be searched: ");
        var itemToBeSearched = sc.nextInt();

        // source array
        int[] demoArray = {0, 0, 1, 3, 12, 34, 7, 5, 2, 10};
        Arrays.sort(demoArray);

        // Binary Search
        System.out.println(binarySearch(demoArray, itemToBeSearched));


    }

    /**
     * Binary Sort -- Array sorted in Ascending Order
     */
    public static boolean binarySearch(int[] demoArray, int itemToBeSearched) {
        var min = 0;
        var max = demoArray.length - 1;
        while (min <= max) {
            var mid = (min + max) / 2;
            if (itemToBeSearched == demoArray[mid]) {
                return true;
            } else if (itemToBeSearched < demoArray[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;

    }


}
