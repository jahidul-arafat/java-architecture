package com.jarotball.firstclass_functions.higher_order_function;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Simulator {
    public static void main(String[] args) {
        // Simple Division Operation
        // f(x)-> f(y)-> x/y
//        Function<Float, Function<Float,Float>> divisionFuncFactory = (x)->(y)->{
//            if (y==0f) {
//                System.out.println("Division By ZERO");
//                return 0f;
//            }
//            return x/y;
//        };
//
//        System.out.println(divisionFuncFactory.apply(4f).apply(2f)); // 4/2
//        System.out.println(divisionFuncFactory.apply(4f).apply(0f)); // 4/0
//        System.out.println(divisionFuncFactory.apply(2f).apply(4f)); // 2/4


        // Base Division Function
        // Create a division function - not safe
        BiFunction<Float,Float,Float> divide = (x,y)-> x/y; // this divide operation is not safe; Exception if y=0

        // A Not So Good Improvement
        // Improving Division Function - safeguard inside the function
        // But it's not a good idea to let our division program to check the Exception:DividedByZERO
        // Instead division function should only be concentrating doing division, nothing else, not even checking DivisionByZero Exception
        BiFunction<Float,Float,Float> divideImpSafeguardInside = (x,y)->{
            if (y==0f) {
                System.out.println("Error: Division By ZERO");
                return 0f;
            }
            return x/y;
        };


        // A good solution - using the concept of Higher Order Function
        /**
         * Here, secondArgIsntZeroCheck function is HIGHER ORDER FUNCTION
         * It takes function<division> as argument, returns another function--> which check if ZeroDivisionError occurs
         * Here func--> divide function
         * f1-> func -> divide
         * f2->
         * */
        Function<BiFunction<Float,Float,Float>, BiFunction<Float,Float,Float>> secondArgIsntZeroCheck = (func)->(x,y)->{
            if (y==0f){
                System.out.println("Error: Division By Zero");
                return 0f;
            }
            return func.apply(x,y); // calling the divide function

        };



        // Simulation
        System.out.print("Simulating Normal Division Operation ... ");
        System.out.println(divide.apply(4f,2f));

        System.out.print("Simulating Division with Insider Safeguard Operation ... ");
        System.out.println(divideImpSafeguardInside.apply(4f,0f));

        System.out.print("Simulating Division with Higher Order Function ... ");
        System.out.println(secondArgIsntZeroCheck.apply(divide).apply(4f,0f));

    }
}
