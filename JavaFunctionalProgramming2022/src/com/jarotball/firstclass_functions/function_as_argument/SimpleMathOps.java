package com.jarotball.firstclass_functions.function_as_argument;

import java.util.function.BiFunction;

public class SimpleMathOps {
    public static Integer addition(Integer x, Integer y){
        return x+y;
    }

    public static Integer subtraction(Integer x, Integer y){
        return x-y;
    }

    public static Integer combine2And3(BiFunction<Integer, Integer, Integer> combineFunc){
        return combineFunc.apply(2,3);
    }
}
