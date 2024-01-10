package org.example.playground.challenges.challenge_1;

public class Car {
    // object attributes
    private final String make;
    private final String color;
    private final Double price;

    // constructor
    public Car(String make, String color, Double price) {
        this.make = make;
        this.color = color;
        this.price = price;
    }

    // getters and setters
    // Setter not possible as the Object attributed defined final


    public String getMake() {
        return make;
    }

    public String getColor() {
        return color;
    }

    public Double getPrice() {
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
