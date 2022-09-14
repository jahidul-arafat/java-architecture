/*
 * Copyright (c) 2022.
 * Jahidul Arafat
 * jahidul.arafat@oracle.com
 *
 * All rights reserved.
 */

package com.jarotball.string_algorithms.string_paring;

import com.jarotball.string_algorithms.developer_tools.DeveloperTools;

public class StringParsing {
    public static void main(String[] args) {
        var demoString = DeveloperTools.getString("Enter Your String: ");
        var normalizedDemoString = DeveloperTools.normalizeString(demoString);

        var subString = DeveloperTools.getString("Enter Your SubString: ");
        var normalizedSubString = DeveloperTools.normalizeString(subString);

        // check if substring exists
        checkSubstringExists(normalizedDemoString, normalizedSubString);

        // parsing characters of a string
        parseCharacterFromString(normalizedDemoString);

    }

    private static void checkSubstringExists(String normalizedDemoString, String normalizedSubString) {
        System.out.println(String.format("SubString <%s> in SuperString <%s> is %s",
                normalizedSubString, normalizedDemoString, normalizedDemoString.contains(normalizedSubString)));
    }

    private static void parseCharacterFromString(String normalizedDemoString) {
        // option-1: forEach
        System.out.println("Parsing Contents from String");
        System.out.println("Option-01: forEach");
        for (var c: normalizedDemoString.toCharArray()
             ) {
            System.out.print(c);
        }

        // option-2: for loop
        System.out.println();
        System.out.println("Option-02: For Loop");
        for (int i = 0; i < normalizedDemoString.length(); i++) {
            System.out.print(normalizedDemoString.charAt(i));

        }
    }

}
