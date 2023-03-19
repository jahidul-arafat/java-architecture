package org.jarotball.functional_programming.basics.project_1_greetings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class App {
    public static void main(String[] args) {
        // Using Functional Interface "Greeting"
        // Function interface by deault dont have .apply() method
        Greeting<String,String> gFunc = (name)-> {
            return String.format("Hello %s%n",name);
        };

        var output=gFunc.sayHello("Jahidul Arafat");
        System.out.println(output);

        // Normal Function
        // Normal Function by default having .apply() method
        Function<String,String> greetFunction = (name)->{
            return String.format("Welcome to: %s%n",name);
        };
        System.out.println(greetFunction.apply("USA"));

        //
        //BiFunction<Double,Double,Double> multiplicationFunc = (num,multiplier)->num*multiplier;
        BiFunction<Double,Double,Double> multiFunc= MathOps::multiplication;
        System.out.println(multiFunc.apply(20d,3d));

        BiFunction<Double,Double,Double> divFunc = MathOps::division;
        System.out.println(divFunc.apply(10d,2d));

        //f(x)=2x+1
        Function<Integer,Integer> fx = (num)-> num*2+1;
        System.out.println(fx.apply(10));

        // f(x)= x.length
        Function<String,Integer> getStringLength = (opt)-> opt.length();
        System.out.println(getStringLength.apply("Jahidul Arafat"));

        // Calculator
        Calculator<Integer,Integer,Integer> addFunc01= (n1,n2)-> n1+n2;
        System.out.println(addFunc01.calculate(10,20));




    }
}
