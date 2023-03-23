package org.jarotball.functional_programming.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectOps {
    public static void main(String[] args) {
        String[] wordsArr = {"hello", "apple", "hello", "jahid", "functional", "programming", "is", "cool"};
        List<String> wordsList = Arrays.asList(wordsArr);

        var formattedStr = wordsList
                .stream()
                .collect(Collectors.joining("_"));
        System.out.println(formattedStr);

        var formattedStr1 = wordsList
                .stream()
                .reduce((w1,w2)->w1+"_"+w2)
                        .stream().findFirst()
                        .orElse("-1");
        System.out.println(formattedStr1);

        // groupBy the words length; make sure all words are unique
        var wordsByLength = wordsList
                .stream()
                .collect(Collectors.groupingBy(word-> word.length()))
                        .entrySet()
                                .stream()
                                        .collect(Collectors.toMap(
                                                (entry)-> entry.getKey(),
                                                (entry)-> entry.getValue()
                                                        .stream().collect(Collectors.toSet())
                                        ));
        System.out.println(wordsByLength);

        // List all words grouped by True and False
        Predicate<String> isLengthMoreThan5 = (word)-> word.length()>5;
        Function<String,Boolean> isLengthMoreThan5Func = (word)-> word.length()>5;
        var wordsByGroup = wordsList
                .stream()
                .collect(Collectors.groupingBy(isLengthMoreThan5Func));
        System.out.println(wordsByGroup);

        var wordsByPartition = wordsList
                .stream()
                .collect(Collectors.partitioningBy(isLengthMoreThan5));
        System.out.println(wordsByPartition);


    }
}
