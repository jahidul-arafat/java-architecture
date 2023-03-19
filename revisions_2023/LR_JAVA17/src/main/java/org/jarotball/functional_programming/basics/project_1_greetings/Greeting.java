package org.jarotball.functional_programming.basics.project_1_greetings;

@FunctionalInterface
public interface Greeting<T,R> {
    public R sayHello(T t);
}
