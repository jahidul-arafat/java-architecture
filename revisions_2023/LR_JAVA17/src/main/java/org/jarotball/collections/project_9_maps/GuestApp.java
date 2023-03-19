package org.jarotball.collections.project_9_maps;

import org.jarotball.collections.project_1_london_hotel.Room;
import org.jarotball.collections.project_7_list.Guest;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GuestApp {

    public static void print(Map<Room,Guest> room2guest){
        var roomName2guestName=room2guest.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        (entry)-> entry.getKey().getName(),
                        (entry)-> entry.getValue().getFirstName()
                ));
        System.out.println(roomName2guestName);
    }
    public static void main(String[] args) {
        // Scenario: Assign Rooms to Guests and also can swap the Rooms
        // Create Rooms and Guests
        // Rooms
        Room R1 = new Room("R1","5Star",5,5000d);
        Room R2 = new Room("R2","3Star",3,3000d);

        // Guests
        Guest billy = new Guest("Billy","Bow",false);
        Guest killy = new Guest("Killy","Kow",true);

        // Assign Rooms to Guests
        Map<Room,Guest> room2guest = new LinkedHashMap<>();
        room2guest.put(R1,billy);
        room2guest.put(R2,killy);
        room2guest.forEach((room, guest) -> System.out.format("%s::%s%n",room.getName(),guest.getFirstName()));
        print(room2guest);

        // Swap
        room2guest.put(R2, room2guest.remove(R1));
        room2guest.putIfAbsent(R1,killy);
        print(room2guest);



    }
}
