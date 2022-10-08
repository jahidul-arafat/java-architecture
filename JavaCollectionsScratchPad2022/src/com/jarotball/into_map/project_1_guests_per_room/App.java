package com.jarotball.into_map.project_1_guests_per_room;

import com.jarotball.into_fundamentals.project_1_london_hotel.data.Room;
import com.jarotball.into_list.project_1_london_hotel_guest_checkin_loyalty.data.Guest;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        // 0. Setup - Create New Rooms and few Guests
        Room R1 = new Room("R1","5star", 5,500);
        Room R2 = new Room("R2", "4star", 4,400);

        Guest billy = new Guest("Billy", "Bow", false);
        Guest killy = new Guest("Killy", "Kow", true);

        // 1. Assign rooms to Guest
        Map<Room, Guest> assignments = new HashMap<>();
        assignments.put(R1, billy);
        assignments.put(R2, killy);
        System.out.format("%n------- Before Switch -------%n");
        print(assignments);


        // now lets switch the room , billy-> R2, killy-> R1
        //assignments.put(R2, billy); // R2-> billy, R1--> billy
        System.out.format("%n------- At Switch (In-Progress) -------%n");
        assignments.put(R2, assignments.remove(R1)); // (R2, billy) // R2-> billy, R1-> null
        assignments.putIfAbsent(R1, killy); // R1-> killy

        System.out.format("%n------- After Switch -------%n");
        print(assignments);

        // Check if equals() and hashCode() methods overridden in class <Room>
        System.out.format("%n------- Validating if equals() and hashCode() overridden! -------%n");
        System.out.format("R1-> %s%n",assignments.get(R1).getFirstName());
        System.out.format("R2-> %s%n",assignments.get(new Room("R2", "4star", 4,400))
                .getFirstName()); // to validate if equals() and hashCode() is overridden



    }

    public static void print(Map<Room, Guest> assignments){
        var output = assignments.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        (entry)-> entry.getKey().getName(),
                        (entry)-> entry.getValue()
                                .getFirstName()
                ));
        for (String room: output.keySet()
             ) {
            System.out.format("Guest %s at Room %s%n", output.get(room), room);

        }
        //System.out.println(output);


    }
}
