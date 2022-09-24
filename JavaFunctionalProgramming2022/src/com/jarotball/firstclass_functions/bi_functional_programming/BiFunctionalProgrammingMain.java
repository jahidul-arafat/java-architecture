package com.jarotball.firstclass_functions.bi_functional_programming;

import java.util.function.BiFunction;

public class BiFunctionalProgrammingMain {
    public static void main(String[] args) {
        // Step-1: Create a function with two arguments
        // f(x,y)=x+y+1
        BiFunction<Integer, Integer, Integer> biFunc01 = (x, y) -> x + y + 1;
        System.out.println(biFunc01.apply(2,3));
    }
}
