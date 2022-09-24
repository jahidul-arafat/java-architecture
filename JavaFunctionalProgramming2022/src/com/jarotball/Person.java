package com.jarotball;

import java.util.function.Function;

public class Person {
    private final String name;
    private final int age;
    private static String classVar="A";

    public Person(String name, int age){
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
