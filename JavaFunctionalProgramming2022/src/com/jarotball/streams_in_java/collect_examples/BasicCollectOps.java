package com.jarotball.streams_in_java.collect_examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * collect(Collectors.toList()) - get ordered list of all words where length >= 5 char
 * collect(Collectors.toSet())  - get unordered set of all words where length >= 5 char; duplicate elements will be removed
 * collect(Collectors.joining("delimiter")) - get the combined string of all words joined by delimiter
 * collect(Collectors.groupingBy(func)) - get the list of all words grouped by their length. Use Function or BiFunction
 * collect(Collectors.partitioningBy(predicateFunc)) - get the list of all words grouped by either true or false based on predicate
 * i.e. the wordsLength > minLength where minLength=5
 */
public class BasicCollectOps {
    public static void main(String[] args) {
        String[] wordsArr = {"hello", "apple", "hello", "jahid", "functional", "programming", "is", "cool"};
        List<String> wordsList = Arrays.asList(wordsArr);

        // Problem_01: list all words having length>=5char
        Predicate<String> isLengthThan5 = (word) -> word.length() >= 5;

        // Problem_02: define the groupBy constraint would be used by Collectors.groupingBy()
        Function<String, Integer> groupByConstraint = (word) -> word.length();


        var wordsGt5CharLength = wordsList.stream()
                .filter(isLengthThan5)
                .collect(Collectors.toList());
        System.out.println("Using Collectors.toList(): " + wordsGt5CharLength); // this list might have repeated words

        // Problem_03: Get unique list of all words where wordLength >= 5 Char
        var uniqueWordsGt5CharLength = wordsList.stream()
                .filter(isLengthThan5)
                .collect(Collectors.toSet());
        System.out.println("Using Collectors.toSet(): " + uniqueWordsGt5CharLength); // unordered but unique list of words; no repeated words

        // Problem_04: join all the words in the list by delimiter ":-:"
        var joinedWordsByDelimiter = wordsList.stream()
                .collect(Collectors.joining(":-:"));
        System.out.println("Using Collectors.joining(delimiter): " + joinedWordsByDelimiter);

        // Problem_05: grouping the words by their length
        // Returns a Map <Integer, String>
        var wordLenMap = wordsList.stream()
                .collect(Collectors.groupingBy(groupByConstraint));

        System.out.println("Using Collectors.groupingBy(): " + wordLenMap);

        // Problem_06: partition the words by true and false based on Predicate wordLength>=5
        var wordLenMapPartition = wordsList.stream()
                .collect(Collectors.partitioningBy(isLengthThan5));
        System.out.println("Using Collectors.partitioningBy(): " + wordLenMapPartition);


    }
}
