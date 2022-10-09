package com.jarotball.into_collection_utilities.project_1_ordering_rooms_byName_byType.data;

import java.util.Objects;
/**
 * public interface Comparable<T> {
 *     public int compareTo(T o);
 * }
 * */
public class RoomVer2 implements Comparable<RoomVer2> {
    public final String name;
    public final String type;
    public final int capacity;
    public double rate;
    public boolean isPetFriendly;

    // constructor
    public RoomVer2(String name, String type, int capacity, double rate) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.rate = rate;
    }

    // getter and setter

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

    public void setRate(double rate) {
        this.rate = rate;
    }

    public boolean isPetFriendly() {
        return isPetFriendly;
    }

    public void setPetFriendly(boolean petFriendly) {
        isPetFriendly = petFriendly;
    }

    // override equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomVer2 roomVer2 = (RoomVer2) o;

        if (capacity != roomVer2.capacity) return false;
        if (!Objects.equals(name, roomVer2.name)) return false;
        return Objects.equals(type, roomVer2.type);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + capacity;
        return result;
    }

    // override toString

    @Override
    public String toString() {
        return "RoomVer2{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", capacity=" + capacity +
                ", rate=" + rate +
                ", isPetFriendly=" + isPetFriendly +
                '}';
    }

    /**
     * @param o the object to be compared.
     * @return
     * this.CompareTo(that)
     * if this > that, return +n
     * if this < that, return -n
     * if this == that, return 0
     *
     * Comparing Strategy:
     * -------------------
     * (1) First, compare by roomName; if roomNames are not equal return, no need for second comparison
     * (2) if roomNames are equal, then compare by roomType
     */
    @Override
    public int compareTo(RoomVer2 o) {
        int resultByName = this.getName().compareTo(o.getName()); // return +n, -n, 0
        return resultByName!=0? resultByName: this.getType().compareTo(o.getType());
    }
}
