/*
 * Copyright (c) 2022.
 * Jahidul Arafat
 * jahidul.arafat@oracle.com
 *
 * All rights reserved.
 */

package com.jarotball.string_algorithms.developer_tools;

import java.util.Scanner;

public class DeveloperTools {
    static Scanner sc = new Scanner(System.in);
    public static String getString(String prompt) {
        // check whether every character is uppercase

        System.out.print(prompt);
        var demoString = sc.nextLine();
        return demoString;
    }

    public static String normalizeString(String inputString){
        return inputString.toLowerCase().trim().replace(",","");

    }
}
