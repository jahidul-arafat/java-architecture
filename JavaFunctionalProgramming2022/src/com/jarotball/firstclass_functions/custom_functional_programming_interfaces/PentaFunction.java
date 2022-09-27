package com.jarotball.firstclass_functions.custom_functional_programming_interfaces;

@FunctionalInterface
public interface PentaFunction <T,U,V,I,J,R>{
    R apply(T t, U u, V v, I i, J j);
}
