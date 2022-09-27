package com.jarotball.firstclass_functions.functional_programming_basics.greeting;

@FunctionalInterface
public interface Greeting {
    void sayHello();
    //void anotherMethod(); // Functional Interface cant have more than one method
}
