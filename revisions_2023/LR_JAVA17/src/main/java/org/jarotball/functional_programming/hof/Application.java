package org.jarotball.functional_programming.hof;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Application {
    public static <divFuncFactory> void main(String[] args) {
        // Simple Division Operations
        BiFunction<Double,Double,Double> division = (x,y)-> x/y;
        BiFunction<Double,Double,Double> multiplication = (x,y)-> x*y;

        System.out.println(division.apply(4d,2d));
        System.out.println(division.apply(10d,4d));

        // Checking if y=0
        BiFunction<Double,Double,Double> divByZeroImpiInside = (x,y)-> {
            if (y==0d){
                System.out.println("Division by ZERO ....");
                return 0d;
            }
            return x/y;
        };
        System.out.println(divByZeroImpiInside.apply(3d,4d));
        System.out.println(divByZeroImpiInside.apply(10d,0d));

        // But division function should only concentrate on division, not on Error Checking
        // Sol: Implement Higher Order Function
        Function<BiFunction<Double,Double,Double>, BiFunction<Double,Double,Double>> divHofZeroChecking = (func)-> (x,y)->{
            if (y==0d){
                System.out.println("Division by Zero ...");
                return 0d;
            }
            return func.apply(x,y);
        };

        System.out.println(divHofZeroChecking.apply(division).apply(10d,4d));
        System.out.println(divHofZeroChecking.apply(multiplication).apply(10d,4d));

        // Division Func Factory
        Function<Double,Function<Double,Double>> divFuncFactory= (by)-> (item)-> item/by;
        var by2= divFuncFactory.apply(2d);
        System.out.println(by2.apply(10d));

        // HoF - Sanity Checker
        BiFunction<Double,Double, Boolean> sanityCheck = (x,y)-> y!=0;
        System.out.println(sanityCheck.apply(10d,0d));
        System.out.println(sanityCheck.apply(10d,3d));

        Function<BiFunction<Double,Double,Boolean>,BiFunction<Double,Double,Double>> testFunc =
                (sFunc)->(x,y)->{
                    return sFunc.apply(x,y)?x/y:0d;
                };
        System.out.println(testFunc.apply(sanityCheck).apply(10d,2d));
        System.out.println(testFunc.apply(sanityCheck).apply(10d,0d));






    }
}
