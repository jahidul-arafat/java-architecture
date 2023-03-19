package org.jarotball.functional_programming.func_as_argument;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Application {
    public static void main(String[] args) {
        // Pass function as argument
        var x=SimpleMathOps.combineTwoNumbers(SimpleMathOps::addition);
        System.out.println(x);

        var y=SimpleMathOps.combineTwoNumbers(SimpleMathOps::substraction);
        System.out.println(y);

        BiFunction<Integer,Integer,Integer> multiFunc = (n1,n2)-> n1*n2;
        var z = SimpleMathOps.combineTwoNumbers(multiFunc);
        System.out.println(z);

        Function<Integer,Function<Integer,Integer>> timesFuncFactory =(times)->(num)-> num*times;
        var times2 = timesFuncFactory.apply(2);
        var times3 = timesFuncFactory.apply(3);
        System.out.println(times2.apply(10));
        System.out.println(times3.apply(10));
    }
}
