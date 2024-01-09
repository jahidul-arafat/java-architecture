/*
By Jahidul Arafat, Solution Architect (AppDev and DevOps)

 */
package org.example.playground.reduce_examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

/*
Java Reduce operation default time complexity is O(n),
until stream is parallelized -> means dividing the reduction operation among multiple threads;
potentially improving performance
 */
public class Main {
    public static void main(String[] args) {
        Integer[] intArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> intList = Arrays.asList(intArr); // immutable List

        Integer result = intList.stream()
                .reduce(0, Integer::sum);
        System.out.println(result);

        String[] wrdArr = {"hello", "functional", "world", "is", "cool"};
        List<String> wrdList = Arrays.asList(wrdArr); // immutable List
        List<String> wrdListEmpty = new ArrayList<>(); // empty List
        System.out.println(wrdList);

        // reduce the words by "_"
        // Approach-01
        // Expected output: "_hello_functional_world_is_cool" // starts with a leading _
        // In this case, the initial value is an empty string "".
        // The lambda expression (a, b) -> a + "_" + b is used to concatenate each element of the stream with an underscore in between.
        String result2 = wrdList.stream()
                .reduce("", (a, b) -> a + "_" + b);
        System.out.println(result2);

        // Approach-02
        /*
        @FunctionalInterface
        public interface BinaryOperator<T> extends BiFunction<T,T,T>
         */
        BinaryOperator<String> getReducedStr = (a, b) -> a + "_" + b; // BinaryOperator<T> is a functional interface
        // it represents operation between two operands of same type
        // is BinaryOperator<T> interface extends BiFunction<T,T,T>? --> YES
        // Yes, for BinaryOperator<T>, T is the type of the operands and type of returned value
        // Expected output: "hello_functional_world_is_cool" // avoid leading "_"
        BiFunction<String, String, String> getReducedStr2 = (a, b) -> a + "_" + b;

        // calcuate the start time of the reduction operation
        long startTime = System.currentTimeMillis();

        String result3 = wrdList.stream()// these stream is Sequantial Stream causing O(n) worst case time complexity
                .reduce(getReducedStr)
                .orElse(""); // if the wrdList is empty, return empty String
        long endTime = System.currentTimeMillis();
        System.out.printf("Takes: %sms%n",endTime - startTime);
        System.out.println(result3);

        // using functional interface, get longest word
        BinaryOperator<String> getLongestWord = (a, b) -> a.length() > b.length() ? a : b;
        String longestWord2 = wrdList.stream()
                .reduce(getLongestWord)
                .orElse(""); // if the wrdList is empty, return empty String
        System.out.println(longestWord2);

        // create an integer list using int stream
        var intStream = IntStream.range(1,5); // excluding 5
        // using functional interface, get the product of all the numbers in the list
        // IntBinaryOperator is a functional interface
        IntBinaryOperator getProduct = (a, b) -> a * b;
        Integer product = intStream
               .reduce(getProduct)
               .orElse(0);
        System.out.println(product);


        // Example
        var intStream2 = IntStream.range(1,9999); // excluding 5
        long startTime2 = System.currentTimeMillis();

        var result4 = intStream2.reduce(Integer::sum).orElse(0);

        long endTime2 = System.currentTimeMillis();
        System.out.printf("Takes: %sms%n",endTime2 - startTime2);
        System.out.println(result4);

        var result5 = intList.parallelStream()
                .reduce(0,Integer::sum); // using -10 as identity value might return unexpected output i.e. -45
        // vary on in which order Threads in parallel processing is handling the reduction operation
        // thats why make sure the parallelStream always having a neutral identity value i.e. 0 instead of -10
        System.out.println(result5);

        Function<Integer,Double> doubleFactory = (item)-> 2*item.doubleValue(); // item->item*2.0;
        var result6 = intList.stream()
                .map(doubleFactory)
                .reduce(0.0, Double::sum);
        System.out.println(result6);



    }
}
