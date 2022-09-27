package com.jarotball.firstclass_functions.functional_programming_basics.greeting_alternative;

@FunctionalInterface
public interface Greeting<T,R> {
    R sayHello(T t);

}
