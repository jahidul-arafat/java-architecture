/*
 * Copyright (c) 2022.
 * Jahidul Arafat
 * jahidul.arafat@oracle.com
 *
 * All rights reserved.
 */

package com.jarotball.queue_stack.basic_queue_ops;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Queue -FIFO- is an interface, methods in the interface are not implemented
 * LinkedList is a class implemented all the interfaces i.e. Queue, Collection, Deque etc.
 */
public class QueueBasicOps {
    public static void main(String[] args) {
        Queue<Integer> demoQueue = new LinkedList<>();

        // add elements into queue
        demoQueue.add(10);
        demoQueue.add(20);
        demoQueue.add(30);
        demoQueue.add(40);
        demoQueue.add(50);

        // print all the elements from Queue
        System.out.println(demoQueue);

        // remove the first element from then Queue
        var removedItem = demoQueue.remove();
        System.out.println(removedItem + "<-- removed");

        // peak the head of the queue but dont remove
        System.out.println(demoQueue.peek() + "<-- peeked");


        // remove all elements from the queue
        // verify your earlier peeked element is still in the list
        while (!demoQueue.isEmpty()) {
            System.out.println(demoQueue.remove() + "<-- removed");
        }
    }
}
