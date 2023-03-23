package org.jarotball.functional_programming.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;

public class ReduceExamples {
    public static void main(String[] args) {
        Integer[] numArr = {1,2,3,4,5,6,7,8,9,10};
        List<Integer> numList = Arrays.asList(numArr);

        // Way-01
        var sumOfOdds = numList.stream()
                .filter(n-> n%2!=0)
                .reduce(0, Integer::sum);
        System.out.println(sumOfOdds);

        // Way-02
        var sumOfEven = numList.stream()
                .filter(n-> n%2==0)
                .mapToInt(Integer::valueOf)
                .sum();
        System.out.println(sumOfEven);

        // Way-03
        var sumOfOddCustom = numList
                .stream()
                .filter(n-> n%2!=0)
                .reduce(0,(a,b)-> a+b+10);
        System.out.println(sumOfOddCustom);

        // Given a string, sum all the integers in it
        String string = "Item1 10 Item2 25 Item3 30 Item4 45";
        var wordList = Arrays.stream(string.split(" ")).collect(Collectors.toList());
        System.out.println(wordList);

        var sumOfInt = wordList.stream()
                .filter(w -> w.matches("\\d+"))
                .mapToInt(Integer::valueOf)
                .sum();
        System.out.println(sumOfInt);

        // Given an array of words. Try to combine those with _
        var combinedWordAsString = wordList
                .stream()
                .reduce((w1,w2)-> w1+"_"+w2)
                        .stream().findFirst()
                        .orElse("Null");
        System.out.println(combinedWordAsString);

        // Get the longest string in the list
        BinaryOperator<String> wordComparator = (w1, w2)-> w1.length()>w2.length()?w1:w2;
        var longestWord = wordList
                .stream()
                .reduce(wordComparator)
                        .stream().findFirst().orElse("");
        System.out.println(longestWord);

        // Now get the product of a range
        // i.e. Given {1,2,3,4}--> return 1*2*3*4
        BinaryOperator<Integer> getProduct = (acc,x)->
                acc*x;

        var product = numList
                .stream()
                .reduce(1,getProduct);
        System.out.println(product);


    }
}
