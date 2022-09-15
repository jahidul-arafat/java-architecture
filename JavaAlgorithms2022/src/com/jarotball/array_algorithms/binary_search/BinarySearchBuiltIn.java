/*
 * Copyright (c) 2022.
 * Jahidul Arafat
 * jahidul.arafat@oracle.com
 *
 * All rights reserved.
 */

package com.jarotball.array_algorithms.binary_search;

import java.util.Arrays;

public class BinarySearchBuiltIn {
    public static void main(String[] args) {
        int[] demoArray={1,2,3,4,5,6};

        // Option-1: basic
        System.out.println(Arrays.binarySearch(demoArray,6)); // found // return index of array

        // Option-2: Slicing Array
        System.out.println(Arrays.binarySearch(demoArray,1,4,6)); // not found due to slicing of array ::[2,3,4,5]// returns the index of the array
                                                                    // positive index if found
                                                                    // negative index if not found


        // Option-3: Using ternary operator
        //var isFound=Arrays.binarySearch(demoArray,4)>0?true:false;
        //System.out.println(isFound);

    }


}
