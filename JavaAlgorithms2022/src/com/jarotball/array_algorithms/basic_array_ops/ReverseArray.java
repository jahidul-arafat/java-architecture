/*
 * Copyright (c) 2022.
 * Jahidul Arafat
 * jahidul.arafat@oracle.com
 *
 * All rights reserved.
 */

package com.jarotball.array_algorithms.basic_array_ops;

import java.util.ArrayList;
import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] demoArray = {1,2,3,4,5,6,7};
        //reversingArrayOptimized(demoArray);
        reversingArrayInPlace(demoArray);
    }

    /**
     * This method is optimized but it requires creating an ArrayList
     * If the solution is looking for revesing array without creating any extra Array, then there are other way to solve this.
     * */
    private static void reversingArrayOptimized(int[] demoArray) {
        ArrayList<Integer> reverseArrayList = new ArrayList<>();
        for (int i = demoArray.length-1; i >= 0; i--) {
            reverseArrayList.add(demoArray[i]);
        }

        var reverseArray = reverseArrayList.stream().mapToInt(Integer::intValue).toArray();
        Arrays.stream(reverseArray).forEach(System.out::println);
    }

    /**
     * Get the middle fixed and swap the both sides.
     * 1 2 3 4 5
     * mid=a[2]
     * a[0]=1 --> tmp0 it -> replace it with a[4]=a[5-1-0]=5
     * a[1]=2
     * a[2]=3 <<Fixed>>
     * a[3]=4
     * a[4]=5 <--- tmp0 --> 1
     * */
    private static void reversingArrayInPlace(int[] demoArray){
        for (int i = 0; i < demoArray.length/2; i++) {
            var tmp = demoArray[i];
            demoArray[i]=demoArray[demoArray.length-1-i];
            demoArray[demoArray.length-1-i]=tmp;
        }
        Arrays.stream(demoArray).forEach(System.out::println);


    }
}
