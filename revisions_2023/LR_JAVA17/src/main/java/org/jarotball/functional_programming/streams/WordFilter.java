package org.jarotball.functional_programming.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class WordFilter {
    public static void main(String[] args) {
        // An array of words
        String[] wordArr = {"hello", "functional", "programming", "is", "cool"};

        // Convert the Array into List
        List<String> wordList = Arrays.asList(wordArr);

        // Find all words longer than 5 characters
        Predicate<String> isLongerThan5 = (word)-> word.length()>5;
        Function<Integer, Function<String, Boolean>> wordLenFuncFactory = (length)->(word)-> word.length()>length;

        var moreThan5 = wordLenFuncFactory.apply(5);
        var moreThan3 = wordLenFuncFactory.apply(3);

        var wordsMoreThan3=wordList
                .stream()
                .filter(word-> moreThan5.apply(word))
                .collect(Collectors.toList());
        System.out.println(wordsMoreThan3);


    }
}
