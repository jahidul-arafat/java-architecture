package com.jarotball.firstclass_functions.function_as_data.loading_from_server;

/**
 * This Person Data is in Server
 * Now based on the Environment / PROD or /DEV, we have to decide whether to load the real data or dummy data.
 * Production Data should not be used for testing.
 * For testing, use of dummy data is encouraged.
 *
 * */
public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
