package org.example.playground.filter_examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import static org.example.playground.filter_examples.Playground.*;

public class Main {
    public static void main(String[] args) {
        // an array of integers
        List<Integer> intList = Arrays.asList(1, 2, 3, 4,5,6,7,8,9,10);
        System.out.println(intList);

        List<Integer> evenList = intList.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even numbers: " + evenList);

        List<Integer> oddList = intList.stream()
                .filter(num -> num % 2 != 0)
                .collect(Collectors.toList());
        System.out.println("Odd numbers: " + oddList);

        List hateList = Arrays.asList(1,"a",2,4.5,'c');

        var xStr = hateList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining("->"));
        System.out.println(xStr);

        System.out.printf("The Type of hateList %s is %s%n", hateList,hateList.getClass().getSimpleName());

        // Arrays.asList()
        String[] array = {"apple", "banana", "cherry"};
        List<String> immuList1 = Arrays.asList("apple","banana","cherry"); // immutable list
        System.out.println(immuList1);

        List<String> mutList2 = new ArrayList<>(Arrays.asList("apple","banana","cherry")); // mutable list // Dynamic List
        mutList2.add(0,"oracle");
        List<String> mutList3 = new ArrayList<>(Arrays.asList("a","b","c"));
        mutList2.addAll(mutList3);
        System.out.println(mutList2);
        mutList3.remove(0);
        System.out.println(mutList3);

        List<String> immuList2 = List.of("apple","banana","cherry"); // immutable list
        //immuList2.add(0,"baiust"); // will trigger error as the list is immutable
        System.out.println(immuList2);

        // an array of strings
        String[] wrdArr = {"hello", "functional", "programming", "is", "cooc"};
        List<String> wrdList = Arrays.asList(wrdArr);
        System.out.println(wrdList);

        // predicate to find words greater than 5 letters
        Predicate<String> greaterThan5 = word -> word.length() > 5;

        var get5charWrd = wrdList.stream()
                .filter(greaterThan5)
                .collect(Collectors.toList());
        System.out.println(get5charWrd);

        // Function <T,R>, T-input, R-Return
        /*
        Input: Integer (minLength)
        Return: Predicate<String> (a predicate that takes a String as input)
         */
        Function<Integer,Predicate<String>> isLongerThanFuncFactory = (minLength) -> (word) -> {
            return word.length() > minLength;
        };
        var isLongerThan3= isLongerThanFuncFactory.apply(3);
        var get3charWrd = wrdList.stream()
                .filter(isLongerThan3)
                .collect(Collectors.toList());
        System.out.println(get3charWrd);

        var isLongerThan5 = isLongerThanFuncFactory.apply(5);
        var get5charWrdV2=getNCharLongWords(wrdList, isLongerThan5);
        System.out.println(get5charWrdV2);

        // function to check if a word is a palindrome
        Predicate<String> isPalindrome = word -> word.equals(new StringBuilder(word).reverse().toString());
        var getPalindromeWrd = wrdList.stream()
               .filter(isPalindrome)
               .collect(Collectors.toList());
        System.out.println(getPalindromeWrd);

        Predicate<String> isPalindrome2 = word -> {
            String reversed = new StringBuilder(word).reverse().toString();
            return word.equals(reversed);
        };

        // create a mutable non-thread safe string, reverse and concat "Test" to it
        var mutableString = new StringBuilder("Hello").reverse().toString();
        mutableString = mutableString.concat(" Test");
        System.out.println(mutableString);

        // convert the string to a list of words
        List<String> wordListFromString = new ArrayList<>(Arrays.asList(mutableString.split("\\s+")));
        wordListFromString.set(0,"Hello");
        System.out.println(wordListFromString);

        var strFromDynamicSB = dynamicStringBuilder();
        System.out.println(strFromDynamicSB);

        String demoString = new StringBuilder("Hello").toString();
        demoString.concat("ARAFAT"); // this will create a another String Object
        System.out.println(demoString); // will print "Hello"















    }
}
