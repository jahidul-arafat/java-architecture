package org.example.playground.collect_examples;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.example.playground.collect_examples.Playground.*;


public class Main {
    public static void main(String[] args) {
        // PersonSimulator method to simulate the Playground methods
        // a list of strings
        String[] wrdArr = {"abc","Hello", "world", "Jahidul", "Arafat", "world", "!",null};
        List<String> wrdList = Arrays.asList(wrdArr);
        System.out.println("The List of Strings is: " + wrdList);

        // define an empty list
        List<String> wrdListEmpty = List.of();

        // Problem_01: list all words having length >= 5 char
        var wrdListGt5CharLength= getWrdListGt5Length(wrdList);
        System.out.println("Using Collectors.toList(): " + wrdListGt5CharLength); // this list might

        // Problem_02: list all unique words having length >= 5 char
        var wrdListUniqueGt5CharLength= getUniqueWrdListGt5Length(wrdListEmpty);
        System.out.println("Using Collectors.toSet(): " + wrdListUniqueGt5CharLength); // this list might

        // Problem_o3: join all words by a delimiter
        String joinedWords = joinWords(wrdList,":-:");
        System.out.println("Using Collectors.joining(): " + joinedWords); // this list might

        // Problem_o4: group the list of words by their length
        Map<Integer,List<String>> wrdGroupedByLength= groupWordsByLength(wrdList);
        System.out.println("Using Collectors.groupingBy(): " + wrdGroupedByLength); // this list might

        // Problem_05: partition/group words by predicate isLengthGt5
        Map<Boolean, List<String>> wrdPartitionByLengthGt5 = partitionWordsByLength(wrdListGt5CharLength);
        System.out.println("Using Collectors.partitioningBy(): " + wrdPartitionByLengthGt5); // this
    }
}
