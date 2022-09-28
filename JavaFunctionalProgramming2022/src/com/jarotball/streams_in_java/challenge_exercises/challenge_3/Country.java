package com.jarotball.streams_in_java.challenge_exercises.challenge_3;

public class Country {
    private final String name;

    public Country(String name) {
        this.name = name;
    }

    // Getter

    public String getName() {
        return name;
    }

    // Print the object

    @Override
    public String toString() {
        return  name;

    }
}
