package com.jarotball.into_collection_utilities.project_1_ordering_rooms_byName_byType;

import com.jarotball.into_collection_utilities.project_1_ordering_rooms_byName_byType.data.RoomVer2;
import com.jarotball.into_fundamentals.project_1_london_hotel.data.Room;

import java.util.*;

public class App {
    public static void main(String[] args) {
        // 0. Setup - Create 7x rooms using class RoomVer2
        RoomVer2 baloy = new RoomVer2("Baloy", "Room", 3,124.00);
        RoomVer2 aaloy = new RoomVer2("Aaloy", "Aoom", 5,124.00);
        RoomVer2 daloy = new RoomVer2("Daloy", "Suite", 1,14.00);
        RoomVer2 caloy = new RoomVer2("Caloy", "Guest Room", 1,24.00);
        RoomVer2 faloy = new RoomVer2("Faloy", "Premiere Room", 2,550.00);
        RoomVer2 ealoy = new RoomVer2("Ealoy", "Goom", 3,124.00);
        RoomVer2 baloyGuest = new RoomVer2("Baloy", "Koom", 3,124.00);
        RoomVer2 faloyGuest = new RoomVer2("FaloyG", "Premiere Room", 2,550.00);

        List<RoomVer2> roomList = new ArrayList<>(List.of(baloy,aaloy,daloy,caloy,faloy,ealoy,baloyGuest, faloyGuest));

        // Task-1: Sort the room in their natural order; i.e. Alphabetic order of their name and type
        //Collections.sort(roomList, RoomVer2::compareTo);
        //Collections.sort(roomList, Comparator.naturalOrder());
        //roomList.sort(RoomVer2::compareTo);

        // Task-2: Instead natural alphabetic order, sort the rooms by their daily rate
        //roomList.sort(RoomVer2.RATE_COMPARATOR);
        roomList.sort(RoomVer2.RATE_COMPARATOR.reversed());

        // Task-2.1 What if two rooms having the same rate; then sort them by their name
        //roomList.sort(RoomVer2.RATE_NAME_COMPARATOR);

        // Task-2.2: What if two rooms having the same rate and name; sort by type
        //roomList.sort(RoomVer2.RATE_NAME_TYPE_COMPARATOR);

        // Task-3: Sort the rooms by their Capacity in descending order
        //roomList.sort(RoomVer2.CAPACITY_COMPARATOR);

        // 3.1 What if two room having the same capacity and name; sort by type
        //roomList.sort(RoomVer2.CAP_NAME_TYPE_COMPARATOR);

        roomList
                .stream()
                .forEach(room -> System.out.format("%-15s    %-15s      %-15s   %-10f%n",
                        room.getName(),
                        room.getType(),
                        room.getCapacity(),
                        room.getRate()));
    }
}
