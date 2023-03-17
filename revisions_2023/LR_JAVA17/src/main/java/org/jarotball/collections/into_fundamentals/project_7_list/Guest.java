package org.jarotball.collections.into_fundamentals.project_7_list;

import org.jarotball.collections.into_fundamentals.project_1_london_hotel.Room;

import java.util.ArrayList;
import java.util.List;

public class Guest {
    private final String firstName;
    private final String lastName;
    private boolean loyaltyProgramMember;
    List<Room> preferredRooms = new ArrayList<>();  // Guests room preferences

    // Constructor

    public Guest(String firstName, String lastName, boolean loyaltyProgramMember) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.loyaltyProgramMember = loyaltyProgramMember;
    }

    // Getter and Setter

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isLoyaltyProgramMember() {
        return loyaltyProgramMember;
    }

    public void setLoyaltyProgramMember(boolean loyaltyProgramMember) {
        this.loyaltyProgramMember = loyaltyProgramMember;
    }

    public List<Room> getPreferredRooms() {
        return preferredRooms;
    }

    public void setPreferredRooms(List<Room> preferredRooms) {
        this.preferredRooms = preferredRooms;
    }

    // Print the Guest Object

    @Override
    public String toString() {
        return "Guest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", loyaltyProgramMember=" + loyaltyProgramMember +
                ", preferredRooms=" + preferredRooms +
                '}';
    }
}
