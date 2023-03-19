package org.jarotball.collections.project_6_RoomSet;

import org.jarotball.collections.project_1_london_hotel.Room;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        Room r1 = new Room("Piccadilly", "5Star", 5,500d);
        Room r2 = new Room("Oxford", "4Star", 4,400d);
        Room r3 = new Room("Victoria", "3Star", 3,300d);

        // Create a duplicate room of <r2>
        // r2 and r2duplicate are logically equivalent w.r.to value-comparison
        Room r2duplicate =new Room("Oxford", "4Star", 4,400d);
        System.out.println(r2.equals(r2duplicate));
        System.out.println(r2==r2duplicate);

        // Create a Collection
        Collection<Room> roomCollection = new LinkedHashSet<>(Arrays.asList(r1,r2,r3,r2duplicate));


        // Add another Room into the Collection
        Room r4 = new Room("Basundhara", "5Star", 3,300d);
        roomCollection.add(r4);

        // convert the room collection into Array
        Room[] roomArr = roomCollection.toArray(new Room[0]);
        System.out.println(roomArr[0]);
        System.out.println(roomArr[1]);
        System.out.println(roomArr[2]);

        // print the rooms
        roomCollection.stream()
                .map(room -> room.getName())
                .forEach(System.out::println);


        // Ensure Set immutability
        List<Room> roomList = List.of(r1,r2); // .of makes an immutable list
        System.out.println(roomList);
        //roomList.add(r3);   // trying to add an item into an immutable list raise an exception

        // Let's try to copy the Collection into a List and make sure the list is immutable
        List<Room> immutableRoomList = List.copyOf(roomCollection);

        // Create another room and lets try to add that room into the list
        Room r5 = new Room("Jamuna", "5Star", 3,300d);
        //immutableRoomList.add(r5);    // Will raise exception


        // Create a Set of Rooms and make sure the Set is immutable
        Set<Room> otherRooms = Set.of(r1,r2,r3); // in an immutable set, you cant add duplicate elements --> it will raise exception
        System.out.println(otherRooms);

        Set<Room> moreRooms = Set.copyOf(roomCollection);
        moreRooms.add(r5);
        System.out.println(moreRooms);






    }
}
