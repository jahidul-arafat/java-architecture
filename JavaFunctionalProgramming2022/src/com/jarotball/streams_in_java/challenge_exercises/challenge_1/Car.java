package com.jarotball.streams_in_java.challenge_exercises.challenge_1;

public class Car {
    private final String make;
    private final String color;
    private final Float price;

    // constructor
    public Car(String make, String color, Float price) {
        this.make = make;
        this.color = color;
        this.price = price;
    }

    // setter - not possible as the Instance attributes are defined to be final - immutable
    // getter
    public String getMake() {
        return make;
    }

    public String getColor() {
        return color;
    }

    public Float getPrice() {
        return price;
    }

    // Print the Object
    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
