package com.jarotball.into_set.project_1_set_fundamentals;

import com.jarotball.into_fundamentals.project_1_london_hotel.data.Room;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        // 0. Create 3x rooms
        Room r1 = new Room("R1","5star",5,500);
        Room r2 = new Room("R2","4star",4,400);
        Room r3 = new Room("R3","3star",3,300);

        // 0.1 Create a duplication of room <r2>
        // r2 and r2duplication are logically same w.r.t value-comparison
        // check the equals() method overridden in class <Room>
        Room r2duplicate = new Room("R2","4star",4,400);

        // 1. Create a Collection and add all these rooms into the Collection;
        // Make sure there are no duplication, even not in terms of values
        // Rooms will be in the order of add

        Collection<Room> roomCollection = new LinkedHashSet<>(List.of(
                r1,r2,r2,r2duplicate,r3
        ));
        roomCollection.forEach(System.out::println);

        System.out.println();
        roomCollection.add(new Room("R4","2star",2,200));
        roomCollection.forEach(System.out::println);

        // 2. Create an immutable set using Set.of() and Set.copyOf(from_collection)
        // 2.1 using Set.of()
        Set<Room> otherRooms = Set.of(r1,r2); // this is an immutable set; cant add any elements later after initialization
        //otherRooms.add(r3); // this will raise an exception of UnsupportedOperation

        // 2.2 using Set.copyOf(from_collection)
        System.out.println(".....");
        Set<Room> moreRooms = Set.copyOf(roomCollection); // creates an immutable set
        moreRooms.add(new Room("R5","2star",2,200)); // cant add any element in immutable set
                                                                            // Raise unsupportedOpertationException



    }
}
