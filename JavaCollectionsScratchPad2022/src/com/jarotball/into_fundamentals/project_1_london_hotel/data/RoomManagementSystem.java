package com.jarotball.into_fundamentals.project_1_london_hotel.data;

import java.util.*;
import java.util.stream.Collectors;

public class RoomManagementSystem {
    // 1. Declare a Collection to store Room Inventory
    private Collection<Room> inventory;

    // constructor
    public RoomManagementSystem(){
        // 2. Initialize Collection and assign it to the Room Inventory
        //this.inventory = new HashSet<>();
        this.inventory = new LinkedHashSet<>();
    }

    // getter and setter
    public Collection<Room> getInventory() {
        return inventory;
    }

    public void setInventory(Collection<Room> inventory) {
        this.inventory = inventory;
    }

    // Custom Method
    // custom_method_1: create a room and add this in the inventory
    public void createRoom(String name, String type, int capacity, double rate){
        inventory.add(new Room(name,type,capacity,rate));
    }

    // customer_method_2: add an array of rooms in the inventory
    public void createRoom(Room[] roomArray){
        inventory.addAll(Arrays.asList(roomArray));
    }

    // custom_method_3: remove a specified room from the inventory
    public void removeRoom(Room room){
        inventory.remove(room);
    }

    // custom_method_4: check if a room exists in the inventory
    public boolean hasRoom(Room room){
        return inventory.contains(room);
    }

    // custom_method_5: returns all room as an Array of Rooms in the **order** they were added
    /* There are two parts in this solution
    * Part01
    * ----------
    * "Ordered" as they were added; but in the Collection implementation I earlier used HashSet<> which doesn't maintain the order
    *   - To ensure we return the Rooms as Array in the Order Added, now replace the HashSet<> with LinkedHashSet<>
    * Part02
    * ----------
    * Collection.toArray()
    *
    * */
    public Room[] asArray(){
        var roomArray= inventory.toArray(new Room[0]); // .toArray(type_returned_by_the_method)
        return roomArray;
    }

    // custom_method_6: Return a new Collection of Rooms where Room#type matches the provided string.
    // The original Room Inventory collection MUST NOT BE MODIFIED




    // custom_method_7: Get potential revenue by room type
    public Map<String, Double> getPotentialRevenueByType(){
        var getRevByType = this.inventory
                .stream()
                .collect(Collectors.groupingBy(room -> room.getType().toLowerCase()))
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

    public OptionalDouble getAvgRoomRate(){
        var avgRoomRate = this.inventory
                .stream()
                .mapToDouble(Room::getRate)
                .average();
        return avgRoomRate;
    }

    //
    public Map<String,Long> getRoomCountByType() {
        var roomCountByType = this.inventory
                .stream()
                .collect(Collectors.groupingBy((room)-> room.getType().toLowerCase(), Collectors.counting()));
        return roomCountByType;
    }

    //
    public void getAvgRoomRateByType() {
        var avgRoomRateByType = this.inventory
                .stream()
                .collect(Collectors.groupingBy(room -> room.getType().toLowerCase()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        (entry)-> entry.getKey(),
                        (entry)-> entry.getValue()
                                .stream()
                                .mapToDouble(room -> room.getRate())
                                .average()
                                .stream()
                                .map(Math::round)
                                .findFirst()
                                .orElse(0)
                ));
        System.out.println(avgRoomRateByType);
    }



}
