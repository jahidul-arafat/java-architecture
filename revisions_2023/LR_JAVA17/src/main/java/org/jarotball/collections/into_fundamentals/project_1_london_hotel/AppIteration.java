package org.jarotball.collections.into_fundamentals.project_1_london_hotel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class AppIteration {
    public static void main(String[] args) {
        Room r1 = new Room("R1","5star", 5, 500);
        Room r2 = new Room("R2","4star", 4, 400);
        Room r3 = new Room("R3","3star", 3, 300);
        Room r4 = new Room("R4","2star", 2, 200);
        Room r5 = new Room("R5","3star", 2, 200);

        r1.setPetFriendly(true);
        r2.setPetFriendly(true);

        Collection<Room> roomCollection = new ArrayList<>(Arrays.asList(r1,r2,r3,r4,r5));
        roomCollection.stream()
                .forEach(System.out::println);

        // Using Java Stream API
        // 1. Get all not pet friendly rooms
        roomCollection.stream()
                .filter(room -> !room.isPetFriendly())
                .map(Room::getName)
                .forEach(System.out::println);

        // 2. Get list of all pen friendly rooms
        roomCollection.stream()
                .filter(room -> room.isPetFriendly())
                .map(Room::getName)
                .forEach(System.out::println);

        // 3. Get the Total Revenue of all PetFriendly Rooms
        var totalRevFromPetFndlyRooms = roomCollection
                .stream()
                .filter(room -> !room.isPetFriendly())
                .mapToDouble(Room::getRate)
                .sum();
        System.out.println(totalRevFromPetFndlyRooms);

        // 4. Get Total Revenue by PetFndly type
        var getTotalRevByType= roomCollection
                .stream()
                .collect(Collectors.groupingBy(Room::isPetFriendly))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        (entry)-> entry.getKey(),
                        (entry) -> entry.getValue()
                                .stream()
                                .mapToDouble(Room::getRate)
                                .sum()
                ));
        System.out.println(getTotalRevByType);

        // 5. Get the list of all PetFriendly and Not-pet friendly rooms
        var roomsByPetFndly = roomCollection
                .stream()
                .collect(Collectors.groupingBy(Room::isPetFriendly))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        (entry)-> entry.getKey(),
                        (entry)-> entry.getValue()
                                .stream()
                                .map(Room::getName)
                                .collect(Collectors.toList())
                ));
        System.out.println(roomsByPetFndly);


        // 6. Get the list of all Room object by PetFndly and Not-pPetFndly
        var roomObjectsByPetFndly = roomCollection
                .stream()
                .collect(Collectors.groupingBy(Room::isPetFriendly));
        System.out.println(roomObjectsByPetFndly);

        // 7. Apply 50% discount to each rooms
        roomCollection
                .stream()
                .forEach(room -> room.setRate(room.getRate()*0.50));
        roomCollection.stream()
                .forEach(System.out::println);

        System.out.println();
        // 8. Return a new Collection of rooms that meet or exceed the given capacity
        // List all rooms where capacity>=3
        roomCollection.stream()
                .filter(room -> room.getCapacity()>=3)
                .forEach(System.out::println);

        // 9. List all rooms by type
        var roomsByType=roomCollection.stream()
                .collect(Collectors.groupingBy(room -> room.getType().toLowerCase()))
                        .entrySet()
                                .stream()
                                        .collect(Collectors.toMap(
                                                (entry)-> entry.getKey(),
                                                (entry)-> entry.getValue()
                                                        .stream()
                                                        .map(Room::getName)
                                                        .collect(Collectors.toList())
                                        ));

        System.out.println(roomsByType);

        // 10. Filter the rooms by type
        String roomType="3Star";
        var filteredRoomsByType= roomCollection
                .stream()
                .filter(room -> room.getType().equalsIgnoreCase(roomType))
                .map(room -> room.getName())
                .collect(Collectors.toList());
        System.out.println(filteredRoomsByType);


    }
}
