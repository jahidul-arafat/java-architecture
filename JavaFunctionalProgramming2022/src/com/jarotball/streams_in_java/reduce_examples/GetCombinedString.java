package com.jarotball.streams_in_java.reduce_examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

// Implementation of reduce method
// to get the combined String

public class GetCombinedString {
    public static void main(String[] args) {
        String[] wordsArr = {"hello", "functional", "programming", "is", "cool"};
        List<String> wordsList = Arrays.asList(wordsArr);
        System.out.println("Initial Words List: " + wordsList);

        BinaryOperator<String> getCombinedString = (word1, word2) -> {
            var combinedWord = word1 + "_" + word2;
            System.out.println(String.format("Word1=%s, Word2=%s, CombinedWord=%s", word1, word2, combinedWord));
            return combinedWord;
        };
        var output = wordsList.stream()
                .reduce(getCombinedString);
        System.out.println("Final Combined Word: " + getCombinedString);
    }
}
