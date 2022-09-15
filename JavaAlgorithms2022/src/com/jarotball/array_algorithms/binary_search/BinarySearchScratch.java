/*
 * Copyright (c) 2022.
 * Jahidul Arafat
 * jahidul.arafat@oracle.com
 *
 * All rights reserved.
 */

package com.jarotball.array_algorithms.binary_search;


import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Binary Search - O(log(n)) - Only on Sorted Array
 */

public class BinarySearchScratch {

    public static void main(String[] args) {
        //user input
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter item to be searched: ");
        var itemToBeSearched = sc.nextInt();

        // source array
        //int[] demoArray = {0, 0, 1,3, 12, 34, 7, 5, 2, 10};
        //Arrays.sort(demoArray1,Collections.reverseOrder());   // Collections.reverseOrder() cant be applied on primitive datatype,
                                                                // instead could be applied on Objects

        Integer[] demoArray={0,0,1,3,12,34,7,5,2,10}; // instead of int[] primitive datatype, I used Object Integer datatype
                                                        // Arrays.sort(array,Collections.reverseOrder()) can only be applied to Object, instead primitive data type
        Arrays.sort(demoArray, Collections.reverseOrder());

        //Arrays.sort(demoArray); // sort the array using Arrays.sort()

        // calling binarySearch
//        if (isSortedAscending(demoArray)) {
//            System.out.println(binarySearchASC(demoArray, itemToBeSearched));
//        }

        if (isSortedDescending(demoArray)){
            System.out.println(binarySearchDSC(demoArray,itemToBeSearched));
        }
    }

    /**
     * Binary Sort -- Array sorted in Ascending Order
     * */
    public static boolean binarySearchASC(Integer[] demoArray, int itemToBeSearched) {
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

    /**
     * Binary Search -- Array sorted in Descending Order
     * */
    public static boolean binarySearchDSC(Integer[] demoArray, int itemToBeSearched) {
        var max = 0;
        var min = demoArray.length - 1;
        while (max <= min) {
            var mid = (max + min) / 2;
            if (itemToBeSearched == demoArray[mid]) {
                return true;
            } else if (itemToBeSearched < demoArray[mid]) {
                max = mid + 1;
            } else {
                min = mid - 1;
            }
        }
        return false;

    }

    public static boolean isSortedAscending(Integer[] demoArray) {
        if (demoArray == null || demoArray.length <= 1) {
            return true;
        }

        // condition i<demoArray.length will result in IndexOutOfBound Exception
        // due to a[i] > a[i+1]
        for (int i = 0; i < demoArray.length-1; i++) {
            System.out.println(String.format("Comparing <%s -- %s>",demoArray[i], demoArray[i+1]));
            if (demoArray[i] > demoArray[i + 1]) {
                System.out.println("Array not sorted");
                return false; // not sorted ascending
            }
        }
        System.out.println("Green::Light::Array::Sorted::Ascending");
        return true;

    }

    public static boolean isSortedDescending(Integer[] demoArray) {
        if (demoArray == null || demoArray.length <= 1) {
            return true;
        }
        for (int i = 0; i < demoArray.length-1; i++) {
            System.out.println(String.format("Comparing <%s -- %s>",demoArray[i], demoArray[i+1]));
            if (demoArray[i] < demoArray[i + 1]) {
                return false; // not sorted descending
            }
        }
        return true;

    }


}
