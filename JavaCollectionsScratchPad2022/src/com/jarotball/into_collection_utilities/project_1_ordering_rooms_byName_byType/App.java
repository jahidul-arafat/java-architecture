package com.jarotball.into_collection_utilities.project_1_ordering_rooms_byName_byType;

import com.jarotball.into_collection_utilities.project_1_ordering_rooms_byName_byType.data.RoomVer2;
import com.jarotball.into_fundamentals.project_1_london_hotel.data.Room;

import java.util.*;

public class App {
    public static void main(String[] args) {
        // 0. Setup - Create 7x rooms using class RoomVer2
        RoomVer2 baloy = new RoomVer2("Baloy", "Room", 3,124.00);
        RoomVer2 aaloy = new RoomVer2("Aaloy", "Room", 3,124.00);
        RoomVer2 daloy = new RoomVer2("Daloy", "Suite", 3,124.00);
        RoomVer2 caloy = new RoomVer2("Caloy", "Guest Room", 3,124.00);
        RoomVer2 faloy = new RoomVer2("Faloy", "Premiere Room", 3,124.00);
        RoomVer2 ealoy = new RoomVer2("Ealoy", "Room", 3,124.00);
        RoomVer2 baloyGuest = new RoomVer2("Baloy", "Guest Room", 3,124.00);

        List<RoomVer2> roomList = new ArrayList<>(List.of(baloy,aaloy,daloy,caloy,faloy,ealoy,baloyGuest));
        //Collections.sort(roomList, RoomVer2::compareTo);
        //Collections.sort(roomList, Comparator.naturalOrder());
        roomList.sort(RoomVer2::compareTo);

        roomList
                .stream()
                .forEach(room -> System.out.format("%-15s    %-15s  %-10f%n", room.getName(),room.getType(),room.getRate()));


    }
}
