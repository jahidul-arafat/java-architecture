package com.jarotball.streams_in_java.challenge_exercises.challenge_4;

public class Planet {
    private final String name;
    private final double density;
    private final boolean hasRings;
    private final int numOfMoons;

    // Constructor
    public Planet(String name, double density, boolean hasRings, int numOfMoons) {
        this.name = name;
        this.density = density;
        this.hasRings = hasRings;
        this.numOfMoons = numOfMoons;
    }

    // Getter

    public String getName() {
        return name;
    }

    public double getDensity() {
        return density;
    }

    public boolean isHasRings() {
        return hasRings;
    }

    public int getNumOfMoons() {
        return numOfMoons;
    }

    // Print the Object
    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", density=" + density +
                ", hasRings=" + hasRings +
                ", numOfMoons=" + numOfMoons +
                '}';
    }
}
