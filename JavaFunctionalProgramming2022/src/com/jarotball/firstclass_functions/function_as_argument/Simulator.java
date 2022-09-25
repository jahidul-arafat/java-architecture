package com.jarotball.firstclass_functions.function_as_argument;

import java.util.function.BiFunction;

public class Simulator {
    public static void main(String[] args) {
        //BiFunction<Integer, Integer, Integer> combineFunc = SimpleMathOps::addition;
        // Referencing functions from another Class
        System.out.println(SimpleMathOps.combine2And3(SimpleMathOps::addition));
        System.out.println(SimpleMathOps.combine2And3(SimpleMathOps::subtraction));

        // Let's create some lambda instead referencing functions from another class
        System.out.println(SimpleMathOps.combine2And3((x,y)->x*y));



    }
}
