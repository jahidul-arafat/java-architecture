package org.example.playground.challenges.challenge_1;

public class Person {
    // object attributes
    private final String name;
    private final Integer age;

    // constructor
    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    // getters and setters

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    // toString method
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
