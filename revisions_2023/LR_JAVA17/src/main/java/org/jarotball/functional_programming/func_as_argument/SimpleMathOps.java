package org.jarotball.functional_programming.func_as_argument;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiFunction;

public class SimpleMathOps {
    @Contract(pure = true)
    public static @NotNull Integer addition(int x, int y){
        return x+y;
    }

    @Contract(pure = true)
    public static @NotNull Integer substraction(int x, int y){
        return x-y;
    }

    public static int combineTwoNumbers(BiFunction<Integer,Integer,Integer> combineFunc){
        return combineFunc.apply(2,3);
    }
}
