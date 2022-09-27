package com.jarotball.firstclass_functions.custom_functional_programming_interfaces;
/**
 * Functional Interface cant have more than one method.
 * */
@FunctionalInterface
public interface NoArgFunction <R>{
    R apply();
}
