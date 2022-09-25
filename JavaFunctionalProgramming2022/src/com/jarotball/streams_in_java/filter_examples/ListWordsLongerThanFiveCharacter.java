package com.jarotball.streams_in_java.filter_examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListWordsLongerThanFiveCharacter {
    public static void main(String[] args) {
        String[] wordsArr = {"hello", "functional", "programming", "is", "cool"};

        // Convert array into list
        List<String> wordsList = Arrays.asList(wordsArr);
        System.out.println("Original List: " + wordsList);

        // find all words in the list longer than 5 characters
        Predicate<String> isLongerThan5 = (word) -> word.length() > 5;

        // Using the concept: Function as an argument of another function
        //Function<Integer, Function<String, Boolean>> isLongerThanFuncFactory = (charLength)-> (word)-> word.length()>charLength;
        Function<Integer, Predicate<String>> isLongerThanFuncFactory = (minLength) -> (word) -> word.length() > minLength;

        var isLongerThan3 = isLongerThanFuncFactory.apply(3);
        var isLongerThan10 = isLongerThanFuncFactory.apply(10);


        // Design the filter with the Predicate Function
        var wordsGtThan3CharList = wordsList.stream()
                //.filter(isLongerThan5)
                //.filter(isLongerThanFuncFactory.apply(5)) // this will help us to filter at any character length
                .filter(isLongerThan3)
                .collect(Collectors.toList());
        System.out.println("Words >3 char: " + wordsGtThan3CharList);

        var wordsGtThan10CharList = wordsList.stream()
                .filter(isLongerThan10)
                .collect(Collectors.toList());
        System.out.println("Words >10 char: " +wordsGtThan10CharList);
    }
}
