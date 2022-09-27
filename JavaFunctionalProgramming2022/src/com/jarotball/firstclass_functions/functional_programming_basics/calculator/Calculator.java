package com.jarotball.firstclass_functions.functional_programming_basics.calculator;

@FunctionalInterface
public interface Calculator <T,V,R>{
    R calculate(T t, V v);

}
