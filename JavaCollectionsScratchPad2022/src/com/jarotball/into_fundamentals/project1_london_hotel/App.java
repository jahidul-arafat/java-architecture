package com.jarotball.into_fundamentals.project1_london_hotel;

import com.jarotball.into_fundamentals.project1_london_hotel.data.Room;

import java.util.*;
import java.util.stream.Collectors;


public class App {
    public static void main(String[] args) {
        greeting();

        // Create 6x Rooms
        Room[] roomArray = {
                new Room("Polly", "5Star", 5, 175d),
                new Room("Bolly", "3Star", 3, 130d),
                new Room("Tolly", "2Star", 2, 120d),
                new Room("Kolly", "1Star", 1, 100d),
                new Room("Solly", "5Star", 5, 175d),
                new Room("Iolly", "3Star", 3, 130d),
                new Room("Aolly", "4Star", 4, 140d),
                new Room("Folly", "2Star", 2, 100d)
        };

        List<Room> roomList = Arrays.asList(roomArray);


        // Calculate the total revenue from all these 6x rooms
        // Calculate the total revenue of all room categorize by types
        getPotentialRevenueUsingStreamLambda(roomList);
        System.out.println(getPotentialRevenueByType(roomList));

        // calculate average room rate
        System.out.println(getAvgRoomRate(roomList));

    }

    private static void getPotentialRevenueUsingStreamLambda(List<Room> roomList) {
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

    private static Map<String, Double> getPotentialRevenueByType(List<Room> roomList){
        var getRevByType = roomList
                .stream()
                .collect(Collectors.groupingBy(Room::getType))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        (entry) -> entry.getKey(),
                        (entry) -> entry.getValue()
                                .stream()
                                .mapToDouble(Room::getRate)
                                .sum()
                ));
        return getRevByType;
    }

    private static OptionalDouble getAvgRoomRate(List<Room> roomList){
        var avgRoomRate = roomList
                .stream()
                .mapToDouble(Room::getRate)
                .average();
        return avgRoomRate;
    }

    private static void greeting(){
        System.out.println("Welcome to London Hotel");
    }

}
