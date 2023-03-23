package org.jarotball.functional_programming.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BasicMapOps {
    public static void main(String[] args) {
        // An array of intergers
        Integer[] numArr = {1,2,3,4,5,6,7,8};

        // Convert array into list
        Function<Integer,Function<Integer,Integer>> timesFactory = (times)-> (num)-> num*times;
        var timesTwo = timesFactory.apply(2);
        var timesThree = timesFactory.apply(3);

        List<Integer> numList = Arrays.asList(numArr);
        var doubledNumList = numList.stream()
                .map(num -> timesTwo.apply(num))
                .collect(Collectors.toList());
        System.out.println(doubledNumList);


    }
}
