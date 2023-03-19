package org.jarotball.collections.project_10_collections;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class RoomV2 implements Comparable<RoomV2> {
    // Class Attributes
    // Single Comparators
    public static Comparator<RoomV2> RATE_COMPARATOR = Comparator.comparing(RoomV2::getRate);
    public static Comparator<RoomV2> NAME_COMPARATOR = Comparator.comparing(RoomV2::getName);
    public static Comparator<RoomV2> TYPE_COMPARATOR = Comparator.comparing(RoomV2::getType);
    public static Comparator<RoomV2> CAPACITY_COMPARATOR = Comparator.comparing(RoomV2::getCapacity);


    // Chaining Comparators
    public static Comparator<RoomV2> RATE_NAME_COMPARATOR = Comparator.comparing(RoomV2::getRate)
            .thenComparing(RoomV2::getName);
    public static Comparator<RoomV2> RATE_NAME_TYPE_COMPARATOR = Comparator.comparing(RoomV2::getRate)
            .thenComparing(RoomV2::getName)
            .thenComparing(RoomV2::getType);

    public static Comparator<RoomV2> CAP_RATE_NAME_TYPE_COMPARATOR = Comparator.comparing(RoomV2::getRate)
            .thenComparing(RoomV2::getName)
            .thenComparing(RoomV2::getType)
            .thenComparing(RoomV2::getCapacity);

    // Instance Attributes
    private String name;
    private String type;
    private int capacity;
    private double rate;
    private boolean isPetFriendly;

    // Constructor
    public RoomV2(String name, String type, int capacity, double rate) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.rate = rate;
        this.isPetFriendly=false;
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
        return isPetFriendly;
    }

    public void setPetFriendly(boolean petFriendly) {
        isPetFriendly = petFriendly;
    }


    // Custom Methods
    // A Room's equality will be checked against {name, type, capacity}, not anything else
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomV2 roomV2 = (RoomV2) o;

        if (capacity != roomV2.capacity) return false;
        if (!Objects.equals(name, roomV2.name)) return false;
        return Objects.equals(type, roomV2.type);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + capacity;
        return result;
    }

    @Override
    public String toString() {
        return "RoomV2{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", capacity=" + capacity +
                ", rate=" + rate +
                ", isPetFriendly=" + isPetFriendly +
                '}';
    }

    @Override
    public int compareTo(@NotNull RoomV2 o) {
        // Custom Sorting
        // Sort the Rooms (a) By their Names (b) Then by their type
        // this <--> that comparison
        // here "RoomV2 o" --> is "that"
        int byName= this.getName().compareTo(o.getName()); //return +n,-n,0
        return byName==0? byName: this.getType().compareTo(o.getType());
    }
}
