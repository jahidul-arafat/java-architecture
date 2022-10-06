package com.jarotball.into_list.project_1_london_hotel_guest_checkin_loyalty.data;

import com.jarotball.into_fundamentals.project_1_london_hotel.data.Room;

import java.util.ArrayList;
import java.util.List;

public class Guest {
    private final String firstName; // once set, cant undo
    private final String lastName;  // once set, cant undo
    private boolean loyaltyProgramMember;   // can become a loyalty program member later; mutable
    private List<Room> preferredRooms = new ArrayList<>(100); // mutable, can change the preferred room list later

    // constructor
    public Guest(String firstName, String lastName, boolean loyaltyProgramMember) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.loyaltyProgramMember = loyaltyProgramMember;
    }

    // getter and setter
    //firstName and lastName defined to be final; only getter, no setter for these two
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

    // override toString - print the Guest object

    @Override
    public String toString() {
        return "Guest{" +
                "Name='" + firstName + " " +lastName + '\'' +
                ", loyaltyProgramMember=" + loyaltyProgramMember +
                ", preferredRooms=" + preferredRooms +
                '}';
    }
}
