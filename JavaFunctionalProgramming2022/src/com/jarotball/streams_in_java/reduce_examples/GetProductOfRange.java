package com.jarotball.streams_in_java.reduce_examples;

import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Implementation of reduce method
// to get the product of all numbers
// in given range.
public class GetProductOfRange {
    public static void main(String[] args) {
        var intStream = IntStream.range(2,8); // {2,3,4,5,6,7} excluding 8
        // IntStream intStream=null;
        //intStream.forEach(System.out::println);

        IntBinaryOperator getProduct = (acc, x)->{
            var output = acc*x;
            System.out.println(String.format("Acc: %s, x: %s, output: %s", acc,x,output));
            return output;
        };
        var product = intStream
                .reduce(getProduct)
                .orElse(-1);
        System.out.println("The product is: "+ product);

    }
}
