package com.jarotball.firstclass_functions.functional_programming_basics.default_interfaces;

import java.util.Random;
import java.util.function.BiFunction;

public class Calculator {
    public static void main(String[] args) {
        // f(x,y)=x+y | Integer
        BiFunction<Integer, Integer, Integer> addIntFunc =
                (x,y)-> x+y;
        System.out.println(addIntFunc.apply(10,20));

        // f(x,y) = x+y | Double
        BiFunction<Double,Double,Double> addDoubleFunc =
                (x,y)-> x+y;
        System.out.println(addDoubleFunc.apply(10d,20d));

        // f(x,y)=x*y+a_random_number__less_tan_50
        BiFunction<Double, Double,Double> multiAddRandFunc =
                (x,y)-> x*y+new Random().nextDouble(50);
        System.out.println(multiAddRandFunc.apply(10d,20d));


    }
}
