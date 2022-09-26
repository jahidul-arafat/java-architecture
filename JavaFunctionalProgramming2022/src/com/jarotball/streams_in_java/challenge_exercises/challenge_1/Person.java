package com.jarotball.streams_in_java.challenge_exercises.challenge_1;

public class Person {
    private final String name;
    private final Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    // setter - not possible as the Instance attributes are defined to be final - immutable
    // getter
    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    // Print the Object
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
