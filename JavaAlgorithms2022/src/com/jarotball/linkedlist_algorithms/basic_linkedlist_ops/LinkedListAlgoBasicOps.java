/*
 * Copyright (c) 2022.
 * Jahidul Arafat
 * jahidul.arafat@oracle.com
 *
 * All rights reserved.
 */

package com.jarotball.linkedlist_algorithms.basic_linkedlist_ops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListAlgoBasicOps {
    public static void main(String[] args) {
        /**
         * LinkedList<T>
         * T: Generic Type
         * */
        LinkedList<String> demoLL01 = new LinkedList<>();
        demoLL01.add("One");
        demoLL01.add("Two");
        demoLL01.add("Three");
        demoLL01.add("Four");
        demoLL01.add("Five");
        demoLL01.add("Six");

        System.out.println(demoLL01);

        // LinkedList operations
        // Check if a String is in the list
        System.out.println(demoLL01.contains("Two"));

        // get the LinkedList size
        System.out.println(demoLL01.size());

        // remove items from the list
        // LinkedList implements DataStructure: Deque, that's why you can access both head and tail of an item
        demoLL01.removeFirst(); // remove first item
        System.out.println(demoLL01);

        // printing items in linked-list
        // ordinary Option
        for (String item: demoLL01
             ) {
            System.out.println(item);

        }

        // Standard version
        demoLL01.forEach(x -> System.out.print(x+"->"));
        System.out.println();

        // general version
        System.out.println(demoLL01);


//        ArrayList<String> demoArrList = new ArrayList<>();
//        demoArrList.add("OOO");
//        System.out.println(demoArrList);
//
//        String[] demoArr = {"One", "Two"};
//        System.out.println(demoArr); // this will not print the array, instead will print the array object location
//        Arrays.stream(demoArr).forEach(System.out::print);

    }


}
