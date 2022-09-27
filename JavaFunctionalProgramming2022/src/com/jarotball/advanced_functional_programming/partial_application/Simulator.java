package com.jarotball.advanced_functional_programming.partial_application;

import com.jarotball.firstclass_functions.custom_functional_programming_interfaces.TriFunction;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Simulator {
    public static void main(String[] args) {
        TriFunction<Integer, Integer, Integer, Integer> add = (x,y,z)->x+y+z;

        // Problem_01: Creating Partial Function: add5(6,7)
        // Step-1.1: Create the function factory
        // f(x,f(y,z))=f(x,y,z)=x+y+z
        Function<Integer, BiFunction<Integer,Integer,Integer>> addFuncFactory01 =
                (x)->(y,z)->add.apply(x,y,z);

        // 1.2 Get the partial function add5
        // add(5)(6,7)
        var add5 = addFuncFactory01.apply(5);
        var output= add5.apply(6,7);
        System.out.println(output);

        //Problem_02: Create Partial Function: add5,6(7)
        // Step 2.1: Create the function factory
        // f(x,y,f(z))=f(x,y,z)=x+y+z;
        BiFunction<Integer,Integer,Function<Integer,Integer>> addFuncFactory02 =
                (x,y)->(z)-> add.apply(x,y,z);

        // 2.1 Get the partial function add5And6(7)
        // add(5,6)(7)
        var add5And6 = addFuncFactory02.apply(5,6);
        System.out.println(add5And6.apply(7));

        // Problem_03
        // 3.1 Create the function factory
        // f(x,f(y,f(z)))=f(x,y,z)=z+y+z
        Function<Integer,Function<Integer,Function<Integer, Integer>>> addFuncFactory03 =
                (x)->(y)->(z)->add.apply(x,y,z);

        // 3.2 Create the Partial Function add5And6And7
        // add(10)(11)(12)
        var add10 = addFuncFactory03.apply(10);
        var add10And11 = add10.apply(11);
        var add10And11And12 = add10And11.apply(12);
        System.out.println(add10And11And12);




    }
}
