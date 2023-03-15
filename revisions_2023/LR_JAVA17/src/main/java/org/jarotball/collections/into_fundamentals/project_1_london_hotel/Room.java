package org.jarotball.collections.into_fundamentals.project_1_london_hotel;

import java.util.Objects;

public class Room {
    private String name;
    private String type;
    private int capacity;
    private double rate;

    private boolean petFriendly;    // introduced later

    // Constructor - CompileTime Polymorphism not applied
    public Room(String name, String type, int capacity, double rate) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.rate = rate;
        this.petFriendly=false;
    }

    // Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public boolean isPetFriendly() {
        return petFriendly;
    }

    public void setPetFriendly(boolean petFriendly) {
        this.petFriendly = petFriendly;
    }

    // Print the Object
    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", capacity=" + capacity +
                ", rate=" + rate +
                '}';
    }

    // For object comparison
    // For value-based comparison
    // Default is: instance-based comparison
    // hashCode() automatically override with equals() method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        System.out.format("Comparing %s with %s%n",
                ((Room) o).name, this.name);

        if (capacity != room.capacity) return false;
        if (!Objects.equals(name, room.name)) return false;
        return Objects.equals(type, room.type);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + capacity;
        return result;
    }
}
