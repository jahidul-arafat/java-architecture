package com.jarotball.advanced_functional_programming.composition.simple_math_composition;

import java.util.function.Function;

public class Simulator {
    public static void main(String[] args) {
        // Simulation-01
        /**
         * Given Two functions
         * f(x)=3x+2
         * g(x) = x+5
         * Calculate fOg = f(g(x))=f(x+5)=3(x+5)+2=3x+15+2=3x+17
         * Calculate gOf =g(f(x))=g(3x+2)=3x+2+5 = 3x+7
         * */

        Function<Integer, Integer> fX= (x)-> 3*x+2;
        Function<Integer, Integer> gX = (x)-> x+5;

        var fOg = fX.compose(gX);
        System.out.println(fOg.apply(10)); // 3x+17 = 47

        var gOf = gX.compose(fX);
        System.out.println(gOf.apply(10)); // 3x+7 = 37
    }
}
