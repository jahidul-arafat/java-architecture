package com.jarotball.firstclass_functions.functional_programming_basics;

import java.util.function.Function;

public class FirstClassFuncOpsBasicMain {
    public static void main(String[] args) {
        // -------------if imperative programming---------------------------
        FirstClassFuncOpsBasic mm1 = new FirstClassFuncOpsBasic();
        System.out.println(mm1.triple(10)); // this will raise warning, as tripe(int x) is a static method accessed by object instances!!!


        // -------------if Declarative/Functional Programming---------------
        // Step-01: Function to create a reference from anotherClass::Method
        // Create a reference to the MyMath triple(int x) function using "::" -> refer to a function/method of an existing class
        // Function<T,R> interface T: argument R: apply(T,t)
        Function<Integer, Integer> myTriple = FirstClassFuncOpsBasic::triple;

        // Let's call the myTriple function
        System.out.println(myTriple.apply(5)); // R apply(T t) - Apply this function to the given argument
        System.out.println(myTriple.apply(10));

        //Function[] demoFuncArr={myTriple, myTriple};

        // Step-02: Function to create new Function using Lambda Expression / with Single Argument
        // 2.1 Creating a new Function using Function Interface and Lambda
        // f(x)=2x+1
        Function<Integer, Integer> newFunction = (x) -> {
            var result = x * 2 + 1;
            return result;
        };
        System.out.println(newFunction.apply(10));

        // 2.2 let's shorten the above lambda expression
        Function<Integer, Integer> updatedNewFunction = (x)-> x*2+1;
        System.out.println(updatedNewFunction.apply(10));

        // 2.3 Create another Function using Function interface and Lambda
        // f(x) = x.length;
        Function<String, Integer> getStringLength = (demoString)-> demoString.length();
        System.out.println(getStringLength.apply("Jahidul Arafat"));

        // 2.4 Write a lambda function to return the absolute value of an integer
        // abs(-x)=x;
        // abs(x)=x
        Function<Integer, Integer> absoluteValueFunc =(x)->{
            if (x<0) return -x;
            return x;
        };

        System.out.println(absoluteValueFunc.apply(-100));

        // Step-03: Function to create new Function using Lambda Expression / with Multiple Arguments
        // See BiFunction


    }

}
