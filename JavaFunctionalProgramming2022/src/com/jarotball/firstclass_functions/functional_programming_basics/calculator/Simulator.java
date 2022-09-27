package com.jarotball.firstclass_functions.functional_programming_basics.calculator;

import java.util.Random;

public class Simulator {
    public static void main(String[] args) {
        //f(x,y)=x+y | Integer
        Calculator<Integer,Integer,Integer> addFunc01 =
                (x,y)-> x+y;
        System.out.println(addFunc01.calculate(10,20));

        // f(x,y)=x+y | Double
        Calculator<Double,Double,Double> addFunc02 =
                (x,y)->x+y;
        System.out.println(addFunc02.calculate(10d,20d));

        // f(x,y)=x*y+a_random_number__less_tan_50
        Calculator<Double,Double,Double> multiAddRandFunc = (x,y)->{
            return x*y+new Random().nextDouble(50d);
        };

        System.out.println(multiAddRandFunc.calculate(10d,20d));

    }


}
