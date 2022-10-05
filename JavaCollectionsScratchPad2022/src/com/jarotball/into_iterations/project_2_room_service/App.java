package com.jarotball.into_iterations.project_2_room_service;

import com.jarotball.into_fundamentals.project_1_london_hotel.data.Room;
import com.jarotball.into_iterations.project_2_room_service.data.RoomService;

import java.rmi.server.RemoteRef;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // 0. Create 6x Rooms

        Collection<Room> roomCollection = new LinkedHashSet<>(List.of(
            new Room("R1","5star", 5, 500),
            new Room("R2","4star", 4, 400),
            new Room("R3","3star", 3, 300),
            new Room("R4","2star", 2, 200),
            new Room("R5","1star", 1, 100),
            new Room("R6","5star", 5, 499)
        ));

        // 1. Apply discount rate to rooms
        RoomService rs = new RoomService(roomCollection);
        rs.applyDiscount(12.5d); // 10% discount
        rs.getInventory().forEach(room -> System.out.println(room.getName()+"->"+room.getRate()));

        System.out.println();
        // 2. get all the rooms with >= 'n' rooms
        rs.getRoomsByCapacity(3)
                .forEach(System.out::println);

        System.out.println();

        // 3. Get the list of all rooms with rate<500 USD and type=5star
        rs.getRoomByRateAndType(500,"5star").forEach(System.out::println);

        // 4. Check if a room exists in the list
        System.out.println();
        System.out.println(rs.hasRoom(new Room("R6", "5star",5,500)));

        // 5. Get all the 3star rooms
        System.out.println();
        rs.getByType("5STAR").forEach(System.out::println);

    }
}
