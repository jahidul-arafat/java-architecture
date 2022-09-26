package com.jarotball.streams_in_java.reduce_examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

// Implementation of reduce method
// to get the longest String
public class GetLongestString {
    public static void main(String[] args) {
        String[] wordsArr = {"hello", "functional", "programming", "is", "cool"};
        List<String> wordsList = Arrays.asList(wordsArr);
        System.out.println("Initial Words List: "+wordsList);

        // BinaryOperator<T>
        // to get the longest word
        // it will check two words from the list and returns the longest word
        BinaryOperator<String> getLongestString =(word1, word2)-> {
            var longestWord= (word1.length()>word2.length())? word1: word2;
            System.out.println(String.format("Word1=%s , Word2=%s, LongestWord=%s",word1,word2,longestWord));
            return longestWord;
        };

        var longestString = wordsList.stream()
                .reduce(getLongestString);
        System.out.println("Longest Word in the List: "+ longestString);

    }
}
