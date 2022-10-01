package com.jarotball.into_fundamentals.project1_london_hotel.data;

public class Room {
    private final String name;
    private final String type;
    private final int capacity;
    private final double rate;

    // constructor
    public Room(String name, String type, int capacity, double rate) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.rate = rate;
    }

    // Getter

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getRate() {
        return rate;
    }

    // print the object

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", capacity=" + capacity +
                ", rate=" + rate +
                '}';
    }
}
