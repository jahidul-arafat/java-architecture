package org.jarotball.collections.project_10_collections;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // 0. Setup - Create 7x rooms using class RoomVer2
        RoomV2 baloy = new RoomV2("Baloy", "Koom", 13,124.00);
        RoomV2 aaloy = new RoomV2("Aaloy", "Aoom", 5,124.00);
        RoomV2 daloy = new RoomV2("Daloy", "Suite", 1,14.00);
        RoomV2 caloy = new RoomV2("Caloy", "Guest Room", 1,24.00);
        RoomV2 faloy = new RoomV2("Faloy", "Premiere Room", 2,550.00);
        RoomV2 ealoy = new RoomV2("Ealoy", "Goom", 3,124.00);
        RoomV2 baloyGuest = new RoomV2("Baloy", "Koom", 3,124.00);
        RoomV2 faloyGuest = new RoomV2("FaloyG", "Premiere Room", 2,550.00);

        // Create a colelction of Rooms
        List<RoomV2> roomCollection = new ArrayList<>(
                Arrays.asList(baloy,aaloy,daloy,caloy,faloy,ealoy,baloyGuest,faloyGuest));

        // 1. Sort rooms in RATE-->NAME-->TYPE
        //roomCollection.sort(RoomV2.RATE_COMPARATOR);
        Collections.sort(roomCollection, RoomV2.RATE_COMPARATOR);
        print(roomCollection);

        // Find the first Room in the Collection
        var firstRoom= roomCollection.stream().findFirst().orElse(null);
        System.out.println(firstRoom.getName());

        // Successful Binary Search
        // Given a Room, find whether the room exists in the Collection
        // Yes, we will provide a CUSTOM_COMPARATOR here, but make sure the List is already sorted with the same COMPARATOR we gonna use here
        var roomIndex = Collections.binarySearch(roomCollection,ealoy,RoomV2.RATE_COMPARATOR);
        System.out.println(roomIndex);
        System.out.println(roomCollection.get(roomIndex));

        // Unsuccessful Binary Search
        RoomV2 newRoom = new RoomV2("Miami", "HotelRoom", 4, 123.44);
        var newRoomIndex = Collections.binarySearch(roomCollection,newRoom,RoomV2.RATE_COMPARATOR);
        System.out.println(newRoomIndex);
        roomCollection.add(Math.abs(++newRoomIndex), newRoom);
        print(roomCollection);
        System.out.println("\n------------------\n");

//        roomCollection.sort(RoomV2.RATE_NAME_COMPARATOR);
//        print(roomCollection);

        // Get the Min and Max element in the Collection
        System.out.println(Collections.min(roomCollection,RoomV2.RATE_COMPARATOR));
        System.out.println(Collections.max(roomCollection,RoomV2.RATE_COMPARATOR));

        // Iterator
        Iterator<RoomV2> iter = roomCollection.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next().getName());
        }









    }

    public static void print(List<RoomV2> roomList) {
        roomList.stream()
                .forEach(room -> System.out.format("%-15s  %-15s  %-15s  %-10f%n",
                        room.getName(),
                        room.getType(),
                        room.getCapacity(),
                        room.getRate()
                ));

    }
}
