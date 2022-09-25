package com.jarotball.streams_in_java.map_examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BasicMapOps {
    public static void main(String[] args) {
        // have an array of items
        Integer[] intArr = {1,2,3,4,5,6,7,8,9,10};

        // convert the array into list
        List<Integer> intList = Arrays.asList(intArr); // this intList will be mutated later. so lets have another intList
        List<Integer> intListOriginal = Arrays.asList(intArr);
        System.out.println("Original List: "+ intList);

        // Tradition Approach 01: Double the elements on list and store into another list
        List<Integer> doubledList = new ArrayList<>();
        for (int i = 0; i < intList.size() ; i++) {
            doubledList.add(intList.get(i)*2);
        }

        // print the doubledList
        System.out.println("After Doubled (traditional_approach_01): "+doubledList);

        // Traditional Approach 02: Double the elements in list and do in-place storing
        // The Worst Case Scenario
//        for (int i = 0; i < intList.size(); i++) {
//            intList.set(i, intList.get(i)*2); // in-place replacement // intList has been updated and original data lost
//        }
//        // print the intList which we just have in-place replacement
//        System.out.println("After Doubled (traditional_approach_02/worst_case): "+intList); // original data lost and overwritten

        // Best Approach: Using stream().map()
        // map() and filter() dont mutate the original list
        // map() and filter() returns a stream(),
        // which could be converted to list again using .collect(Collectors.toList())
        System.out.println();
        System.out.println("intListOriginal: "+ intListOriginal);

        // create the mapper function (optional)
        Function<Integer,Integer> timesTwo = (x)-> x*2;

        var itemsTwo = intListOriginal.stream()
                //.map((x)->x*2) // what if, instead using lambda, we use a function here
                .map(timesTwo)
                .collect(Collectors.toList());
        System.out.println("After Doubled (using stream.map): "+ itemsTwo);


    }
}
