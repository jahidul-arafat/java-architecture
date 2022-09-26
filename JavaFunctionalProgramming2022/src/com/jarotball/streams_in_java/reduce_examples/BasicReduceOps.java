package com.jarotball.streams_in_java.reduce_examples;


import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class BasicReduceOps {
    public static void main(String[] args) {
        Integer[] intArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> intList = Arrays.asList(intArr);
        System.out.println("Initial List: " + intList);

        /**
         * @FunctionalInterface
         * public interface BinaryOperator<T>
         * extends BiFunction<T,T,T>
         *
         * T - the type of the operands and result of the operator
         *
         * */
        BinaryOperator<Integer> getSum = (acc, x) -> {
            Integer result = acc + x;
            System.out.println(String.format("Acc: %s, x: %s, result: %s", acc, x, result));
            return result;
        };
        var output = intList.stream()
                .reduce(0, getSum); // will return T
                                            // However, if .reduce(getSum), without the startingValue -> Then returns Optional<T>;
                                            // Why Optional<T>>?
                                            // Because in the case, the list is empty, it will return NULL; If the list not empty, then it will return Integer.
                                            // That's why type of T can't be explicitly get; thereby got Optional<T> as return.
        System.out.println("Reduced Sum is: " + output);

    }
}
