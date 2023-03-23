package org.jarotball.functional_programming.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BasicFilterOps {
    public static void main(String[] args) {
        //Integer[] numArr = {1,2,3,4,5,6,7,8};
        Integer[] numArr = new Integer[100];
        IntStream.range(1,101)
                .forEach(i -> numArr[i-1]=i);
        List<Integer> numList = Arrays.asList(numArr);
        System.out.println(numList);

        // Generate Odd number series
        Predicate<Integer> oddFilter = (num)-> num%2!=0;
        Predicate<Integer> evenFilter = (num)-> num%2==0;
        Predicate<Integer> primeFilter = (num)-> {
            return num > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(num)).noneMatch(n -> num % n == 0);
        };
        var oddList = numList
                .stream().filter(num-> primeFilter.test(num))
                .collect(Collectors.toList());
        System.out.println(oddList);

        // Filter words by minLength



    }
}
