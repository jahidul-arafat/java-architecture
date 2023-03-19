package org.jarotball.collections.project_6_RoomSet;

import java.util.*;

public class ApplicationTreeSet {
    public static void main(String[] args) {

        // Create a List of integers
        Integer[] numArray = {500,1500,1500,2500,1000,3000,2000};
        //List<Integer> numList = Arrays.asList(500,1500,1500,2500,1000,3000,2000);

        // Create a binary tree set
        NavigableSet<Integer> numTree = new TreeSet<>(Arrays.asList(numArray));
        numTree.add(10000);
        System.out.println(numTree);

        // Print the numbers in ascending order
        numTree.stream()
                .forEach(System.out::println);

        System.out.println();

        // Print the numbers in descending order
        numTree.descendingSet()
                .stream()
                .forEach(System.out::println);

        System.out.println();

        // Get All integers <x
        numTree.headSet(2500)
                .stream()
                .forEach(System.out::println);

        System.out.println("----------------");

        // Get all integers within the range >=1000 to <3000
        numTree.subSet(1000,3000)
                        .stream()
                                .forEach(System.out::println);

        System.out.println("--------");

        // Get all integers >= x
        numTree.tailSet(2500)
                        .stream()
                                .forEach(System.out::println);

        System.out.println("Lower");

        System.out.println(numTree.lower(2500)); // get the immediate lower of 2500

        // Get the immediate higher of 2500
        System.out.println(numTree.higher(2500));

    }
}
