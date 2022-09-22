/*
 * Copyright (c) 2022.
 * Jahidul Arafat
 * jahidul.arafat@oracle.com
 *
 * All rights reserved.
 */

package com.jarotball.queue_stack.matching_parentheses;

import java.util.Stack;

public class MatchingParentheses {
    public static void main(String[] args) {
        System.out.println(hasMatchingParenthesesUsingStack("((algorithm))"));
        System.out.println(hasMatchingParenthesesUsingStack("()(algorithm)"));
        System.out.println(hasMatchingParenthesesUsingStack("((algorithm()))"));
        System.out.println(hasMatchingParenthesesUsingStack("(algorithm)"));

        System.out.println();

        System.out.println(hasMatchingParenthesesUsingStack("(algorithm("));
        System.out.println(hasMatchingParenthesesUsingStack(")algorithm)"));
        System.out.println(hasMatchingParenthesesUsingStack("algorithm(("));
        System.out.println(hasMatchingParenthesesUsingStack("(algorithm"));


        //------
        System.out.println(hasMatchingParenthesesUsingInteger("((algorithm))"));
        System.out.println(hasMatchingParenthesesUsingInteger("()(algorithm)"));
        System.out.println(hasMatchingParenthesesUsingInteger("((algorithm()))"));
        System.out.println(hasMatchingParenthesesUsingInteger("(algorithm)"));

        System.out.println();

        System.out.println(hasMatchingParenthesesUsingInteger("(algorithm("));
        System.out.println(hasMatchingParenthesesUsingInteger(")algorithm)"));
        System.out.println(hasMatchingParenthesesUsingInteger("algorithm(("));
        System.out.println(hasMatchingParenthesesUsingInteger("(algorithm"));


    }

    // O(n)
    public static boolean hasMatchingParenthesesUsingStack(String givenString){
        Stack<Character> demoStack = new Stack<>();
        for (int i = 0; i < givenString.length(); i++) {
            char currentChar = givenString.charAt(i);
            if (currentChar=='('){
                demoStack.push(currentChar);
            } else if (currentChar==')'){
                if (!demoStack.isEmpty())
                {
                    demoStack.pop();
                } else {
                    return false;
                }
            }
        }
        return demoStack.isEmpty();
    }

    // O(1)
    // this solution is more efficient
    public static boolean hasMatchingParenthesesUsingInteger(String givenString){
        int matchingSymbolTracker=0;
        for (int i = 0; i < givenString.length(); i++) {
            char currentChar = givenString.charAt(i);
            if (currentChar=='('){
                matchingSymbolTracker++;
            } else if (currentChar==')'){
                if (matchingSymbolTracker>0)
                {
                    matchingSymbolTracker--;
                } else {
                    return false;
                }
            }
        }
        return matchingSymbolTracker==0;
    }
}
