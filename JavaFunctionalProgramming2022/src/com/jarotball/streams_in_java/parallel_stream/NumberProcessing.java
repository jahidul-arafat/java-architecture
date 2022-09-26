package com.jarotball.streams_in_java.parallel_stream;

import java.util.Arrays;
import java.util.List;

public class NumberProcessing {
    public static void main(String[] args) {
        Integer[] intArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11,12,13,14,15};
        List<Integer> intList = Arrays.asList(intArr);

        var sum = intList
                .parallelStream()
                .map((num) -> {
                    System.out.println(String.format("Doubling %s ...", num));
                    return num * 2;
                })
                .reduce(0, (acc, x) -> {
                    System.out.println("Summing up Numbers ....");
                    var output = acc + x;
                    System.out.println(String.format("acc %s, num: %s, output: %s", acc, x, output));
                    System.out.println();
                    return output;
                });

        System.out.println("Total (After Doubling -> Then SUM): "+sum);
    }
}
