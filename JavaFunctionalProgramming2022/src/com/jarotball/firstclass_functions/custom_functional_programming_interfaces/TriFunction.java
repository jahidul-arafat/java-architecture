package com.jarotball.firstclass_functions.custom_functional_programming_interfaces;

@FunctionalInterface
public interface TriFunction <T, U, V, R>{
    R apply(T t, U u, V v);
}
