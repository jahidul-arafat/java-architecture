package com.jarotball.into_iterations.project_1_iteration_fundamentals;

import com.jarotball.into_fundamentals.project_1_london_hotel.data.Room;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        // Step-01: Create a Collection of rooms
        // Use LinkedHashSet for ordered room list (in the seq as they were added)
//        Collection<Room> roomCollection = new LinkedHashSet<>(List.of(
//                new Room("R1","5star", 5, 500),
//                new Room("R2","4star", 4, 500),
//                new Room("R3","3star", 3, 500),
//                new Room("R4","2star", 2, 500),
//                new Room("R5","1star", 1, 500),
//                new Room("R6","5star", 5, 500)
//
//        ));

        Room r1 = new Room("R1","5star", 5, 500);
        Room r2 = new Room("R2","4star", 4, 400);
        Room r3 = new Room("R3","3star", 3, 300);
        Room r4 = new Room("R4","2star", 2, 200);

        // By default, for all rooms, petFriendly=false
        r1.setPetFriendly(true);
        r3.setPetFriendly(true);

        Collection<Room> roomCollection = new ArrayList<>(Arrays.asList(r1,r2,r3,r4));


        // Step-2: Iteration
        // 2.1: Using Iterator, before JAVA 5
        Iterator<Room> iterator = roomCollection.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().getName());
        }

        // 2.2: using forEach from JAVA5
        // Modify collections with iteration
        // remove the rooms from the Collection which are petFriendly
        // But this will raise a concurrentModificationException - means you cant read and remove/add/modify elements of the Collection at the same time
        /*
        * Exception in thread "main" java.lang.UnsupportedOperationException: remove
            at java.base/java.util.Iterator.remove(Iterator.java:102)
            at java.base/java.util.AbstractCollection.remove(AbstractCollection.java:283)
            at com.jarotball.into_iterations.project_1_iteration_fundamentals.App.main(App.java:47)
        * */

//        Collection<Room> collectionOfPetFriendlyRooms = new ArrayList<>();
//        for (Room room:roomCollection
//             ) {
//            if (room.isPetFriendly()){
//                //System.out.println("Removing Room: "+room.getName());
//                //roomCollection.remove(room); //  concurrent Modification Exception
//                                             // But what if we still want to remove the elements from the collection upon matching condition?
//                                             // Solution: Create another Collection
//
//                collectionOfPetFriendlyRooms.add(room);
//            }
//        }
//
//        // list of all petFriendlyRooms
//        System.out.println(collectionOfPetFriendlyRooms);
//
//        // remove all the petFriendly rooms at-once from the main collection <roomCollection>
//        roomCollection.removeAll(collectionOfPetFriendlyRooms); // Still raising exception
//
//        // Now, we only have rooms which are not petFriendly
//        System.out.println("Collection of nonPetFriendly Rooms: "+ roomCollection);


        // 2.2.1 Is there a way to avoid this concurrent modification exception without using the additional collection
        // as the strategy we adopted for the forEach solution?
        // Answer: Yes; use Iterator instead forEach;
        // Iterator will let you do safeDelete without concurrentModificationException
        // Is there any better solution approach? --> Yes, using JAVA Stream API.

//        Iterator<Room> iterator1 = roomCollection.iterator();
//        while (iterator1.hasNext()){
//            Room currentRoom = iterator1.next();
//            if (currentRoom.isPetFriendly()){
//                //roomCollection.remove(currentRoom); // cant do this operation; will throw concurrentModificationException
//                iterator1.remove();                   // use this to modify roomCollection to avoid concurrentModificationException
//
//            }
//        }
//
//        System.out.println(roomCollection);



        // 2.3 Using JAVA Stream API
        // Filter rooms which are petFriendly; means list only the non-pet-frindly rooms
        Predicate<Room> getRoomsNotPetFriendly = room -> {
            System.out.format("Testing %s with result %b%n", room.getName(), room.isPetFriendly());
            return !room.isPetFriendly();
        };

        roomCollection.stream()
                .filter(getRoomsNotPetFriendly)
                .map(room -> room.getName()+""+room.isPetFriendly())
                .forEach(System.out::println);

        // get the list of all pet friendly rooms
        var petFriendlyRooms = roomCollection
                .stream()
                .filter(Room::isPetFriendly)
                .collect(Collectors.toList());

        // get the total revenue from all the petFriendly Rooms
        var totalRevenuePetFrndly = roomCollection
                .stream()
                .filter(Room::isPetFriendly)
                .mapToDouble(Room::getRate)
                .sum();
        System.out.println(totalRevenuePetFrndly);

        // get the total revenue from all the non-petFriendly rooms
        var totalRevenueNonPetFndly = roomCollection
                .stream()
                .filter(room -> !room.isPetFriendly())
                .mapToDouble(Room::getRate)
                .sum();

        System.out.println(totalRevenueNonPetFndly);

        // Above redundant coding; resolve using groupingBy
        // Expected Output: {false=600.0, true=800.0}
        var totalRevByTypePetFndly = roomCollection
                .stream()
                .collect(Collectors.groupingBy(Room::isPetFriendly))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        (entry)-> entry.getKey(),
                        (entry)-> entry.getValue()
                                .stream()
                                .mapToDouble(Room::getRate)
                                .sum()
                ));
        System.out.println(totalRevByTypePetFndly);

        // Get the list of all petFriendly and nonPetFriendly Rooms
        // Expected Output: {NotPetFndly=[R2, R4], petFndly=[R1, R3]}
        Function<Room, String>petFndlyFunction = (room)-> {
            var petFndlyStatus="";
            if (room.isPetFriendly()) petFndlyStatus="petFndly";
            else petFndlyStatus="NotPetFndly";
            return petFndlyStatus;
        };

        var roomsByTypePetFndly = roomCollection
                .stream()
                .collect(Collectors.groupingBy(petFndlyFunction))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        (entry)-> entry.getKey(),
                        (entry)-> entry.getValue()
                                .stream()
                                .map(Room::getName)
                                .collect(Collectors.toList())
                ));
        System.out.println(roomsByTypePetFndly);










        // -------------------------DRAFT---------------------------

        // Create another Collection
//        Collection<Room> roomCollection1 = new ArrayList<>(Arrays.asList(
//                new Room("R7", "4star", 4,400)
//        ));

        // Step-02: Iteration of elements of the Collection
        // 2.1 using Iterator, before Java 5
        /*
        * interface Collection extends Iterable
        * interface Iterable
        * */
        // 2.1.1 Create 2x iterator: iterator and iterator1 and check their behavior
        // a. creating first iterator;
//        Iterator<Room> iterator = roomCollection.iterator();
//        System.out.println(iterator.next()); // R1
//        System.out.println(iterator.next()); // R2
//        System.out.println(iterator.next()); // R3

        // b. creating second iterator
//        Iterator<Room> iterator1 = roomCollection.iterator();
//        System.out.println(iterator1.next()); // R1
    }
}
