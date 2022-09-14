/*
 * Copyright (c) 2022.
 * Jahidul Arafat
 * jahidul.arafat@oracle.com
 *
 * All rights reserved.
 */

package com.jarotball.string_algorithms.normalizing_string;

import com.jarotball.string_algorithms.developer_tools.DeveloperTools;

public class NormalizingString {
    public static void main(String[] args) {
        var demoString = "     Hello World, Buddy ...      ";
        //var demoString = DeveloperTools.getString("Enter a String: ");
        String normalizedDemoString = normalizeString(demoString);
        System.out.println(String.format("Before/<%s> \nAfter/<%s>",demoString,normalizedDemoString));

    }

    /**
     * Convert the input string into all lowercase and replace "," which none and remove all whitespaces at head and tail.
     * @param demoString Input string which needs to be normalized
     * */
    private static String normalizeString(String demoString) {
        return demoString.toLowerCase().trim().replace(",","");
    }
}
