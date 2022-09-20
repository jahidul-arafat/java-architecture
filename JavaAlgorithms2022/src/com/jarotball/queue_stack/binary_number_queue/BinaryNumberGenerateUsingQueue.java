/*
 * Copyright (c) 2022.
 * Jahidul Arafat
 * jahidul.arafat@oracle.com
 *
 * All rights reserved.
 */

package com.jarotball.queue_stack.binary_number_queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Generate binary Number till a given number N
 * i.e. if Given Number = 2
 * Generated Binary Numbers would be:
 * 1    -> 1
 * 10   -> 2
 *
 * i.e. if Given Number = 9
 * Generated Binary Numbers would be:
 * 1    --> 1
 * 10   --> 2
 * 11   --> 3
 * 100  --> 4
 * 101  --> 5
 * 110  --> 6
 * 111  --> 7
 * 1000 -> 8
 * 1001 -> 9
 *
 *
 *
 * */

public class BinaryNumberGenerateUsingQueue {
    public static void main(String[] args) {
        printBinary(9);

    }

    public static void printBinary(int n){
        if (n<=0) return;

        Queue<Integer> tempQueue = new LinkedList<>();
        Queue<Integer> finalQueue = new LinkedList<>();

        // keep an initialized value "1" into the tempQueue
        tempQueue.add(1);

        // iterate till the given "N" to generate all the Binary
        for (int i = 0; i <n ; i++) {
            int currentItem = tempQueue.remove();
            finalQueue.add(currentItem);

            tempQueue.add(currentItem*10);
            tempQueue.add(currentItem*10+1);

            System.out.println("Final Queue Status: "+ finalQueue);
            System.out.println("Temp  Queue Status: "+ tempQueue);
            System.out.println("-------");

        }

        System.out.println("Binary Numbers upto (including) 9: "+ finalQueue);

    }

}
