package org.jarotball.functional_programming.func_factory;

import org.jarotball.functional_programming.custom_fp.TriFunction;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Application {
    public static void main(String[] args) {
        // Create a TriFunction named 'add'
        TriFunction<Integer, Integer, Integer, Integer> add = (x,y,z)-> x+y+z;

        // f(x,f(y,z))= x+y+z
        Function<Integer, BiFunction<Integer,Integer,Integer>> addFuncFactory =
                (num1)->(num2, num3)-> add.apply(num1,num2,num3);
        var add10=addFuncFactory.apply(10);
        System.out.println(add10.apply(20,30));

        var add100 = addFuncFactory.apply(100);
        System.out.println(add100.apply(200,300));

        // f(x,y,f(z))= x+y+z
        BiFunction<Integer,Integer,Function<Integer,Integer>> biAddFuncFactory =
                (n1,n2)->(n3)-> add.apply(n1,n2,n3);
        var add20_30= biAddFuncFactory.apply(20,30);
        System.out.println(add20_30.apply(10));

        var add200_300 = biAddFuncFactory.apply(200,300);
        System.out.println(add200_300.apply(100));

        //f(x,f(y, f(z))) = x+y+z
        Function<Integer,Function<Integer, Function<Integer,Integer>>> chainFuncFactory =
                (x)->(y)->(z)-> add.apply(x,y,z);
        var chain10= chainFuncFactory.apply(10);
        var chain10_20=chain10.apply(20);
        System.out.println(chain10_20.apply(30));

    }
}
