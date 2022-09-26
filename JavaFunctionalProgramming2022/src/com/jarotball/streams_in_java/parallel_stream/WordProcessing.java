package com.jarotball.streams_in_java.parallel_stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordProcessing {
    public static void main(String[] args) {
        String[] wordsArr = {"hello", "apple", "jahid", "functional", "programming", "is", "fun"};
        List<String> wordsList = Arrays.asList(wordsArr);

        var processedWordList = wordsList
                .parallelStream()
                .map((word)-> {
                    System.out.println(String.format("UpperCasing word <%s> ....",word));
                    return word.toUpperCase();
                })
                .map((upperWord)-> {
                    System.out.println(String.format("Adding ! to word <%s>", upperWord));
                    return upperWord+"!";
                })
                .collect(Collectors.toList());
        System.out.println(processedWordList);
    }
}
