/*
 * Copyright (c) 2022.
 * Jahidul Arafat
 * jahidul.arafat@oracle.com
 *
 * All rights reserved.
 */

package com.jarotball.string_algorithms.algodriven_strings;

/**
 * Reverse the string
 * Strings are immutable. They cant be changed once they are created.
 * So, in the string reverse process we might endup creating many unnecessary temporal strings.
 * To avoid these unnecessary string creation, use <StringBuilder>.
 * StringBuilder objects works differently than strings in memory.
 * When a StringBuilder object is modified it doesn't create a new StringBuilder. Instead it dynamically extends memory
 * accomodate the modified string.
 *
 * Difference between null and isEmpty
 * isEmpty - An empty string is a string instance of zero length; example "" is an empty string - its a character sequence of zero characters
 * null - a null string has no value at all
 *
 * StringBuilder has a default reverse() method.
 * */
public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseAStringCustom(null)); // null string
        System.out.println(reverseAStringCustom(""));   // empty string
        System.out.println(reverseAStringCustom("Jahidul Arafat"));

        System.out.println(reverseAStringWithSBDefault(null)); // null string // it will raise NullPointerException
        System.out.println(reverseAStringWithSBDefault(""));   // empty string
        System.out.println(reverseAStringWithSBDefault("Jahidul Arafat"));

    }

    public static String reverseAStringCustom(String demoString){
        if (demoString == null || demoString.isEmpty()) return demoString; // this will handle the NullPointerException

        StringBuilder sb = new StringBuilder();

        for (int i = demoString.length()-1; i >=0 ; i--) {
            sb.append(demoString.charAt(i));
        }
        return sb.toString();

    }

    public static String reverseAStringWithSBDefault(String demoString){
        if (demoString == null || demoString.isEmpty()) return demoString; // this will handle the NullPointerException
        StringBuilder sb = new StringBuilder(demoString);
        return sb.reverse().toString();

    }
}
