package org.example.playground.filter_examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // an array of integers
        List<Integer> intList = Arrays.asList(1, 2, 3, 4,5,6,7,8,9,10);
        System.out.println(intList);

        List<Integer> evenList = intList.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even numbers: " + evenList);

        List<Integer> oddList = intList.stream()
                .filter(num -> num % 2 != 0)
                .collect(Collectors.toList());
        System.out.println("Odd numbers: " + oddList);

        List hateList = Arrays.asList(1,"a",2,4.5,'c');

        var xStr = hateList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining("->"));
        System.out.println(xStr);

        System.out.printf("The Type of hateList %s is %s%n", hateList,hateList.getClass().getSimpleName());

        // Arrays.asList()
        String[] array = {"apple", "banana", "cherry"};
        List<String> immuList1 = Arrays.asList("apple","banana","cherry"); // immutable list
        System.out.println(immuList1);

        List<String> mutList2 = new ArrayList<>(Arrays.asList("apple","banana","cherry")); // mutable list // Dynamic List
        mutList2.add(0,"oracle");
        List<String> mutList3 = new ArrayList<>(Arrays.asList("a","b","c"));
        mutList2.addAll(mutList3);
        System.out.println(mutList2);
        mutList3.remove(0);
        System.out.println(mutList3);

        List<String> immuList2 = List.of("apple","banana","cherry"); // immutable list
        //immuList2.add(0,"baiust"); // will trigger error as the list is immutable
        System.out.println(immuList2);








    }
}
