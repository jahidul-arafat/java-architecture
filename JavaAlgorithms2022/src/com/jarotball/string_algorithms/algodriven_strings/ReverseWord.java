/*
 * Copyright (c) 2022.
 * Jahidul Arafat
 * jahidul.arafat@oracle.com
 *
 * All rights reserved.
 */

package com.jarotball.string_algorithms.algodriven_strings;

/**
 * Reverse each word in a sentence
 * Input: String
 * Output: new string with each word reversed
 * Assumption: no punctuation in the string; each word seperated by spaces.
 * Cashing should remain the same. If a letter is given uppercase, it should remain uppercase.
 * */
public class ReverseWord {
    public static void main(String[] args) {
        System.out.println(reverseEachWordOption1("        Hello World, Buddy       "));
        System.out.println(reverseEachWordOption1("Hello!"));
        System.out.println(reverseEachWordOption1(null));
        System.out.println(reverseEachWordOption1(""));


        System.out.println(reverseEachWordOption2("        Hello World, Buddy       "));
        System.out.println(reverseEachWordOption2("Hello!"));
        System.out.println(reverseEachWordOption2(null));
        System.out.println(reverseEachWordOption2(""));
    }

    /**
     * using ForEach to iterate over the words and reversing each individually
     * can't explicitly identify the last word in the list using forEach and thus adding extra SPACE with each word
     * Expectation: each reversed(word) has a SPACE in between except the last word.
     * */
    public static String reverseEachWordOption1(String demoString){
        // Check if the demoString is null or Empty. If so, just return to avoid the NullPointerException
        if (demoString == null || demoString.isEmpty()) return demoString;
        // Normalize the string to remove leading and tailing whitespaces and ","
        var normalizedDemoString = demoString.trim().replace(",","");

        // Create a
        var reversedWordListSB = new StringBuilder();
        var wordList=normalizedDemoString.split(" ");

        for (String item:wordList
             ) {
            var reversedWord = new StringBuilder(item).reverse();
            reversedWordListSB.append(reversedWord);
            reversedWordListSB.append(">>"); // this will add the spaces even in the last word, which is kinda unnecessary
                            // make sure, spaces are back to all reversed words except the last word
        }

        return reversedWordListSB.toString();
    }

    /**
     * using for loop
     * easy to identify the last word in the list
     * No extra SPACE after the last word
     * */
    public static String reverseEachWordOption2(String demoString){
        // Check if the demoString is null or Empty. If so, just return to avoid the NullPointerException
        if (demoString == null || demoString.isEmpty()) return demoString;
        // Normalize the string to remove leading and tailing whitespaces and ","
        var normalizedDemoString = demoString.trim().replace(",","");

        // Create a
        var reversedWordListSB = new StringBuilder();
        var wordList=normalizedDemoString.split(" ");

        for (int wordIndex = 0; wordIndex < wordList.length; wordIndex++) {
            var reversedWord = new StringBuilder(wordList[wordIndex]).reverse();
            reversedWordListSB.append(reversedWord);
            if (wordIndex!=wordList.length-1)
                reversedWordListSB.append(">>");
        }
        return reversedWordListSB.toString();
    }
}
