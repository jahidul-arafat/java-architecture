/*
 * Copyright (c) 2022.
 * Jahidul Arafat
 * jahidul.arafat@oracle.com
 *
 * All rights reserved.
 */

package com.jarotball.string_algorithms.string_paring;

import com.jarotball.string_algorithms.developer_tools.DeveloperTools;

import java.util.ArrayList;

/**
 * Check if a certain character exists at even index
 */
public class CustomStringParsing {
    public static void main(String[] args) {

        // Input String
        // Worst case scenario: No input string
        var demoString = DeveloperTools.getString("Enter String: ");
        var normalizedDemoString = DeveloperTools.normalizeString(demoString);

        // Character to be searched
        // Worst case scenario: No Character - this might raise exception due to charAt(0) statement
        // solution: try..catch
        char charToBeSearched = 0;
        try {
            charToBeSearched = DeveloperTools.getString("Enter a Character: ").charAt(0);
        } catch (Exception e) {
            System.out.println("Null Character, stopping execution of rest of codes....");
            return; // if you not return here, then rest of the code will be executed, which is the basic theme to use try..catch
            // try...cache makes sure not to interrupt the code flow
        }

        // Check if character found in the input string
        var isCharAtEvenIndex = isAtEvenIndex(normalizedDemoString, charToBeSearched);
        System.out.println(String.format("Character<%s> in String<%s> at even index: <%s>",
                charToBeSearched, normalizedDemoString, isCharAtEvenIndex));

        // list all the even index where the character is found
        chatAtEvenIndexList(normalizedDemoString, charToBeSearched);
    }

    private static void chatAtEvenIndexList(String normalizedDemoString, char charToBeSearched) {
        ArrayList<Integer> charEvenIndexes = new ArrayList<>();
        for (int i = 0; i < normalizedDemoString.length(); i += 2) {
            if (normalizedDemoString.charAt(i) == charToBeSearched) {
                charEvenIndexes.add(i);
            }
        }
        System.out.println(charEvenIndexes);
    }

    private static boolean isAtEvenIndex(String normalizedDemoString, char charToBeSearched) {
        // for (int i = 0; i < normalizedDemoString.length()/2+1; i+=2) // this condition statement length(String)/2+1 is not gonna work
        // i.e. String is <jahidul arafat joni> and you are searching for character<i>
        // id len(string)/2+1 is used, then it reports char<i> is not found, because iteration stops before index(18), where char<i> is at index<18>
        for (int i = 0; i < normalizedDemoString.length(); i += 2) {
            var foundCharacter = normalizedDemoString.charAt(i);
            System.out.println(String.format("Searching index<%s> -- foundCharacter<%s> -- targetCharacter<%s>",
                    i, foundCharacter, charToBeSearched));
            if (normalizedDemoString.charAt(i) == charToBeSearched) {
                System.out.println("Found at Position: " + i);
                return true;
            }
        }
        return false;
    }
}
