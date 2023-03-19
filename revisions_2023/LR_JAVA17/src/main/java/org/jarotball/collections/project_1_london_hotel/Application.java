package org.jarotball.collections.project_1_london_hotel;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Application {
    protected static double getPotentialRevenue(@NotNull Collection<Room> roomCollection){
        return roomCollection.stream()
                .mapToDouble(room -> room.getRate())
                .sum();
    }

    protected  static void printRooms(@NotNull Collection<Room> roomCollection){
        roomCollection.stream()
                .map(room -> room.getName()+"::"+room.getType())
                .forEach(System.out::println);
    }

    private static void roomManagementSystem(Collection<Room> roomCollection){
        System.out.println("Initializing Room Management System ...");
        RoomManagementSystem rms = new RoomManagementSystem();

        // Adding rooms into Room  Management System
        rms.setInventory(roomCollection);

        // Use RMS to create some new Room
        rms.createRoom("R1","2star",1,100d);
        rms.createRoom("R2","3star",2,200d);
        rms.createRoom("R3","3star",3,300d);
        rms.createRoom("R4","2star",1,400d);
        rms.createRoom("R5","1star",2,500d);
        rms.createRoom("R6","5star",3,600d);
        rms.createRoom("R7","1star",1,700d);


        // Create an Array of Rooms and add those to RMS
        Room[] roomArray ={
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

        rms.createRoom(roomArray);

        printRooms(rms.getInventory());

        System.out.println("\nGetting rooms by type\n");
        System.out.println(rms.getAvgRoomRateByType());

        System.out.println("\nGetting potential revenue by type\n");
        System.out.println(rms.getPotentialRevenueByRoomType());

        System.out.println("\nGetting total room count by type\n");
        System.out.println(rms.getRoomCountByType());

        System.out.println("\nGetting rooms by type\n");
        System.out.println(rms.getRoomsByType("5star"));

    }
    public static void main(String[] args) {
        Collection<Room> roomCollection = new ArrayList<Room>(Set.of(
                new Room("Polly", "5Star", 5, 175d),
                new Room("Bolly", "3Star", 3, 130d),
                new Room("Tolly", "2Star", 2, 120d),
                new Room("Kolly", "1Star", 1, 100d),
                new Room("Solly", "5Star", 5, 175d),
                new Room("Iolly", "3Star", 3, 130d),
                new Room("Aolly", "4Star", 4, 140d),
                new Room("Folly", "2Star", 2, 100d)
        ));

        roomManagementSystem(roomCollection);



        // Array Copy
//        Room[] rooms = new Room[3];
//        Room[] moreRooms = new Room[4];
//        System.arraycopy(rooms,0,moreRooms,0,rooms.length);



//        double total = getPotentialRevenue(roomCollection);
//        System.out.println("Total Revenue: "+total);
//
//        // Print the room details
//        printRooms(roomCollection);


    }
}
