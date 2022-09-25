package com.jarotball.firstclass_functions.returning_function;

import com.jarotball.firstclass_functions.custom_functional_programming_interfaces.NoArgFunction;

import java.util.function.Function;

public class Simulator {
    public static void main(String[] args) {

        // Simulation_01: NoArgument Function
        // Scenario: NoArgFunction ->Returns anotherNoArgFunction -> which finally returns a String
//        NoArgFunction<NoArgFunction<String>> functionFactory= ()->{
//            return ()->"Hello world";
//        };

        // shorthand version of lambda expression for Simulation_01
        NoArgFunction<NoArgFunction<String>> functionFactory = () -> () -> "Hello world";
        NoArgFunction<String> greeterFunc = functionFactory.apply(); // it returns another NoArgument function, called greeterFunction
        //System.out.println(functionFactory.apply().apply());
        System.out.println(greeterFunc.apply());                    // finally, return the string "Hello World"

        // Simulation_02: Single Argument Function
        // interface Function<T, R>: T- inputArgumentType, R- returnType
        // Function takes a String Argument, returns another Function which also takes another string argument and eventually returns the final string
        Function<String, Function<String, String>> stringFunctionFactory = (x) -> (y) -> x.toUpperCase() + " " + y.toUpperCase();
        var helloFunc = stringFunctionFactory.apply("Hello");
        System.out.println(helloFunc.apply("World!!"));
        //System.out.println(stringFunctionFactory.apply("Hello").apply("World!"));

        // Simulation_03: related to SimpleMathOps Class
        Function<Integer, Integer> timesTwo = SimpleMathOps.createMultiplier(2); // this returns a function
        Function<Integer, Integer> timesThree = SimpleMathOps.createMultiplier(3); // this returns a function
        Function<Integer, Integer> timesFour = SimpleMathOps.createMultiplier(4); // this returns a function

        System.out.println(timesTwo.apply(10));
        System.out.println(timesThree.apply(10));
        System.out.println(timesFour.apply(10));

        // Simulation_03: Single line alternative
        Function<Integer, Function<Integer, Integer>> multiplicationFactory = (x) -> (term) -> x * term;
        System.out.println(multiplicationFactory.apply(10).apply(2)); // f(x)-> f(term)-> x*term; // 10*2
        System.out.println(multiplicationFactory.apply(10).apply(3)); // f(x)-> f(term)-> x*term; // 10*3
        System.out.println(multiplicationFactory.apply(10).apply(4)); // f(x)-> f(term)-> x*term; // 10*4

        // Simulation_04: CLOSURE
        NoArgFunction<NoArgFunction<String>> greeterFunctionFactory = ()->{
            String name = "Jahid";
            return ()-> "Hello, "+ name ;
        };

        NoArgFunction<String> greeterFunc02 = greeterFunctionFactory.apply();
        System.out.println(greeterFunc02.apply());


    }
}
