package com.jarotball.into_set.project_2_treeset;

import com.jarotball.into_fundamentals.project_1_london_hotel.data.Room;

import java.util.*;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        // 0. A List of Integers
        List<Integer> numList = Arrays.asList(500,1500,2500,1000,3000,2000);
        // Collections.sort(numList); // to sort a list
        System.out.println(numList);

        // 1. Create a binary tree set
        // interface NavigableSet extends SortedSet
        // class TreeSet implements NavigableSet
        NavigableSet<Integer> numTree = new TreeSet<>(numList); // ascending sort when storing
        System.out.println(numTree);

        // 1.1 Print the numbers in ascending order
        numTree.stream()
                .forEach(System.out::println);

        System.out.println();
        // 1.2 Print the numbers in descending order
        numTree.descendingSet()
                .stream()
                .forEach(System.out::println);

        // 1.3 Get all of the integers in the tree < x
        System.out.println();
        numTree.headSet(1750).forEach(System.out::println);

        // 1.4 get all_num_in_the_list > x
        System.out.println();
        System.out.println(numTree.tailSet(1750));

        // 1.5 get all_num within a given range
        System.out.println();
        System.out.println(numTree.subSet(1000,2750));

        // 1.6 Get a number just lower than 750
        System.out.println();
        System.out.println(numTree.lower(750));

        // 1.7 Get a number just higher than 750
        System.out.println();
        System.out.println(numTree.higher(750));


    }
}
