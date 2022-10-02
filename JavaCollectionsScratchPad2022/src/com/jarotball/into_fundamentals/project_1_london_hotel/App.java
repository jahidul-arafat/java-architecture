package com.jarotball.into_fundamentals.project_1_london_hotel;

import com.jarotball.into_fundamentals.project_1_london_hotel.data.Room;
import com.jarotball.into_fundamentals.project_1_london_hotel.data.RoomManagementSystem;

import java.util.*;
import java.util.stream.Collectors;


public class App {
    public static void main(String[] args) {

        greeting();

        // Create 6x Rooms; initiate the setup
        Collection<Room> roomList = setUp();

        // Room Inventory Management System
        /*
         * Feature
         * - Add a new room into the Management System
         * - Get the list of all rooms of London Hotel
         *
         * */

        roomManagementSystem(roomList);

        // Calculate the total revenue from all these rooms
        // Calculate the total revenue of all room categorize by types
        getPotentialRevenueUsingStreamLambda(roomList);






    }




    private static void roomManagementSystem(Collection<Room> roomList) {
        RoomManagementSystem rms = new RoomManagementSystem(); // create a new RoomManagementSystem instance
        rms.setInventory(roomList); // adding the existing room into the list

        // now using the rms, create some new rooms and add those to Collection
        rms.createRoom("R1","2star",1,100d);
        rms.createRoom("R2","3star",2,200d);
        rms.createRoom("R3","3star",3,300d);
        rms.createRoom("R4","2star",1,400d);
        rms.createRoom("R5","1star",2,500d);
        rms.createRoom("R6","5star",3,600d);
        rms.createRoom("R7","1star",1,700d);

        // create an array of rooms
        Room[] roomArray = {
                new Room("R8","2star",1,100d),
                new Room("R9","3star",2,200d),
                new Room("R10","2star",3,300d),
                new Room("R11","2star",2,400d),
                new Room("R12","3star",3,500d),
                new Room("R13","2star",4,600d),
                new Room("R14","4star",1,700d),
                new Room("R15","5star",2,800d),
                new Room("R16","2star",3,900d),

        };

        //

        System.out.println("Adding the roomArray into the room inventory");
        rms.createRoom(roomArray);

        // print all the rooms in the inventory
        //printRooms(rms);

        // remove a room from the RMS
        // this remove will not work properly as it's still using the instance-based comparison, instead value-based comparison
        // override the equals() method to use value-based comparison
        //System.out.println();
        System.out.println("Deleting a room from Management System");
        rms.removeRoom(new Room("R16","2star",3,900d));
        //printRooms(rms);

        // check if a room exists in the inventory list
        System.out.println(rms.hasRoom(new Room("R16","2star",3,900d)));
        System.out.println(rms.hasRoom(new Room("R14","4star",1,700d)));

        // get the list of all rooms in the same order as they were added
        var roomArrayOrdered = rms.asArray();
        //Arrays.stream(roomArrayOrdered).map(room -> room.getName()).forEach(System.out::println);


        // get potential revenue by type
        System.out.println(rms.getPotentialRevenueByType());

        // get avg room rate by type
        System.out.println(rms.getAvgRoomRate());

        // get total room count by type
        System.out.println(rms.getRoomCountByType());

        // calculate average room rate
        // calculate average room rate by category; make sure the values are rounded
        /*
         * Note
         * ------
         * Stream findFirst() returns an Optional (a container object which may or may not contain a non-null value) describing the
         * first element of this stream, or an empty Optional if the stream is empty.
         * If the stream has no encounter order, then any element may be returned.
         * */

        rms.getAvgRoomRateByType();


    }

    private static void printRooms(RoomManagementSystem rms) {
        System.out.println("Printing all the rooms in the array ...");
        rms.getInventory()
                .stream()
                .map(room -> room.getName()+"::"+room.getType())
                .forEach(System.out::println);
    }

    private static Collection<Room> setUp() {
        Collection<Room> roomList = new ArrayList<Room>(Set.of(
                new Room("Polly", "5Star", 5, 175d),
                new Room("Bolly", "3Star", 3, 130d),
                new Room("Tolly", "2Star", 2, 120d),
                new Room("Kolly", "1Star", 1, 100d),
                new Room("Solly", "5Star", 5, 175d),
                new Room("Iolly", "3Star", 3, 130d),
                new Room("Aolly", "4Star", 4, 140d),
                new Room("Folly", "2Star", 2, 100d)
        ));
        return roomList;
    }

    private static void getPotentialRevenueUsingStreamLambda(Collection<Room> roomList) {
        var totalRevenue= roomList
                .stream()
                .map(room -> room.getRate())
                .reduce(0d,(acc,roomRate)-> acc+roomRate);

        var totalRevenueAlt1 = roomList
                .stream()
                        .mapToDouble(Room::getRate)
                                .sum();

        var totalRevenueAlt2 = roomList
                .stream()
                        .mapToDouble((room)-> room.getRate())
                                .sum();

        System.out.println(totalRevenue);
        System.out.println(totalRevenueAlt1);
        System.out.println(totalRevenueAlt2);
    }



    private static void greeting(){
        System.out.println("Welcome to London Hotel");
    }


}
