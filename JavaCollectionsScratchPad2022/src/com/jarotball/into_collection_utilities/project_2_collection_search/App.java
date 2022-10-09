package com.jarotball.into_collection_utilities.project_2_collection_search;

import com.jarotball.into_collection_utilities.project_1_ordering_rooms_byName_byType.data.RoomVer2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

        // Task-1. Sort the room by their RATE -> NAME -> Type
        roomList.sort(RoomVer2.RATE_NAME_TYPE_COMPARATOR);

        // Task-2: Find a room in the collection
        //2.1 Find a room in the collection and try with an existing room
        // there are two types of binary search; one using the natural sort, one with the custom comparator
        // here, we are not going for natural search, we will use the custom comparator
        var result = Collections.binarySearch(roomList,baloy,RoomVer2.RATE_NAME_TYPE_COMPARATOR);
        System.out.println("Result: "+ result); // You must sort the list before going for binary search; Binary search only works with sorted list

        // 2.2 What if a room doesn't exist
        RoomVer2 newRoom = new RoomVer2("Miami", "HotelRoom", 4, 123.44);
        var newHotelRoomPos=Collections.binarySearch(roomList,
                newRoom,
                RoomVer2.RATE_NAME_TYPE_COMPARATOR); // returns -3
        System.out.println(newHotelRoomPos);

        // 2.3 Insert this new room into the list
        roomList.add(Math.abs(++newHotelRoomPos),newRoom);

        // Task-3: get the min and max room based in the Comparator defined by RATE
        // 3.1 Min room
        System.out.println("Min: "+ Collections.min(roomList, RoomVer2.RATE_NAME_TYPE_COMPARATOR));
        System.out.println("Max: "+ Collections.max(roomList, RoomVer2.RATE_NAME_TYPE_COMPARATOR));



        // print the rooms
        roomList
                .stream()
                .forEach(room -> System.out.format("%-15s    %-15s  %-10f%n",
                        room.getName(),
                        room.getType(),
                        room.getRate()));


    }
}
