package com.jarotball.into_fundamentals.project_1_london_hotel.data;

import java.util.Objects;

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

    // override the equals() method to use value-based comparison instead instance-based comparison
    // hashCode() method will override automatically with equals() method

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;
//        System.out.format("Comparing %s %s %s with %s %s %s %n",
//                ((Room) o).name,
//                ((Room) o).type,
//                ((Room) o).capacity,
//                room.name,
//                room.type,
//                room.capacity
//                );

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
