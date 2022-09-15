/*
 * Copyright (c) 2022.
 * Jahidul Arafat
 * jahidul.arafat@oracle.com
 *
 * All rights reserved.
 */

package com.jarotball.array_algorithms.basic_array_ops;

import java.util.Arrays;

/**
 * Rotate the contents of an array to the left by one space
 * Input  {1,2,3,4,5,6}
 * Output {2,3,4,5,6,1}
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] demoArray = {1, 2, 3, 4, 5, 6};
        var numOfRotation = 2;

        // print the original array
        System.out.print("Original Array: ");
        Arrays.stream(demoArray).forEach(System.out::print);
        System.out.println();

        // if you try the left rotation algo, then right rotation algo, output should become the original array
        // rotate left
        rotateArrayLeftInPlace(demoArray, numOfRotation);

        // rotate right
        rotateArrayRightInPlace(demoArray, numOfRotation);


    }

    /**
     * In-place rotation
     * A new array should not be created
     */
    private static void rotateArrayLeftInPlace(int[] demoArray, int numOfRotation) {
        var counter = 0;
        while (counter < numOfRotation) {
            var temp = demoArray[0];
            for (int i = 0; i < demoArray.length - 1; i++) {
                // 1 2 3 4 5 6
                // 2 3 4 5 6 6  -> 1:: arr[0] is missed
                // strategy: save the arr[0] item into temp
                demoArray[i] = demoArray[i + 1];
            }
            demoArray[demoArray.length - 1] = temp;
            System.out.print(String.format("After Rotation(L)_%s: ", counter));
            Arrays.stream(demoArray).forEach(System.out::print);
            System.out.println();
            counter += 1;

        }
    }

    /**
     * In-place right rotation
     * input  1 2 3 4 5 6
     *        1 1 2 3 4 5  --> you have to tmp 6
     * output 6 1 2 3 4 5
     */
    private static void rotateArrayRightInPlace(int[] demoArray, int numOfRotation) {
        var counter = 0;
        while (counter < numOfRotation) {
            var temp = demoArray[demoArray.length - 1];
            for (int i = demoArray.length - 1; i >= 1; i--) {
                demoArray[i] = demoArray[i - 1];
            }
            demoArray[0] = temp;

            System.out.print(String.format("After Rotation(R)_%s: ", counter));
            Arrays.stream(demoArray).forEach(System.out::print);
            System.out.println();
            counter++;
        }


    }


}
