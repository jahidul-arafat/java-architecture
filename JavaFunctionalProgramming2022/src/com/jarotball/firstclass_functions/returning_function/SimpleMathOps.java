package com.jarotball.firstclass_functions.returning_function;

import java.util.function.Function;

/**
 * Create 3x different functions that multiply the given integer.
 * Problem: Seems redundant as these functions are almost similar with slight differences
 * Question: How to resolve these redundancies?
 *
 *
 * */
public class SimpleMathOps {

    // Some redundant functions doing almost the same things
    public static Integer timesTwo(Integer x){
        return x*2;
    }
    public static Integer timesThree(Integer x){
        return x*3;
    }
    public static Integer timesFour(Integer x){
        return x*4;
    }

    // Resolving the redundancies with a simple method
    // delete the above methods: timesTwo(), timesThree() and timesFour()
    public static Function<Integer,Integer> createMultiplier(Integer term){
        return (Integer x)-> x*term;
    }


}
