package org.jarotball.collections.into_fundamentals.project_1_london_hotel;

import java.util.*;
import java.util.stream.Collectors;

public class RoomManagementSystem {
    // Instance Attributes
    private Collection<Room> inventory;

    // Constructor - No CompileTime Polymorphism

    public RoomManagementSystem() {
        this.inventory = new LinkedHashSet<>();
    }

    // Getter and Setter

    public Collection<Room> getInventory() {
        return inventory;
    }

    public void setInventory(Collection<Room> inventory) {
        this.inventory = inventory;
    }


    // Custom Methods
    // 1. Create a room and add this to inventory
    // RunTime Polymorphism
    public void createRoom(String name, String type, int capacity, double rate){
        this.inventory.add(new Room(name,type,capacity,rate));
    }

    // 2. Add an Array of rooms into the inventory
    public void createRoom(Room[] roomArray){
        this.inventory.addAll(Arrays.asList(roomArray));
    }

    // 3. Remove a specific room from the inventory
    public void removeRoom(Room room){
        this.inventory.remove(room);
    }

    // 4. Check if a Room exists in the inventory
    public boolean hasRoom(Room room){
        return this.inventory.contains(room);
    }

    // 5. Get RoomNames by type:: 5Star, 4Star, 3Star, 2Star, 1Star
    public List<String> getRoomsByType(String roomType){
        var roomsByType = this.inventory
                .stream()
                .collect(Collectors.groupingBy(room -> room.getType().toLowerCase()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        (entry)-> entry.getKey(),
                        (entry)-> entry.getValue()
                                .stream()
                                .map(room -> room.getName())
                                .collect(Collectors.toList())
                ));
        if (roomsByType.containsKey(roomType)){
            return roomsByType.get(roomType);
        }
        return null;
    }

    // 6. Get RoomNames by Capacity
    public  List<String> getRoomsByCapacity(int capacity){
        var roomsByCapacity= this.inventory
                .stream()
                .collect(Collectors.groupingBy(Room::getCapacity))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        (entry) -> entry.getKey(),
                        (entry) -> entry.getValue()
                                .stream()
                                .map(room -> room.getName())
                                .collect(Collectors.toList())
                ));
        if (roomsByCapacity.containsKey(capacity)){
            return roomsByCapacity.get(capacity);
        }
        return null;
    }

    // 7. Get Potential Revenue by room type
    public Map<String,Double> getPotentialRevenueByRoomType(){
        var getRevenueByType = this.inventory
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
        return getRevenueByType;

    }

    // 8. Get average Room Rate
    public OptionalDouble getAvgRoomRate(){
        var avgRoomRate = this.inventory
                .stream()
                .mapToDouble(Room::getRate)
                .average();
        return avgRoomRate;
    }

    // 9. Get Room count by Type
    public Map<String,Long> getRoomCountByType(){
        var roomCountByType= this.inventory
                .stream()
                .collect(Collectors.groupingBy(room -> room.getType().toLowerCase(), Collectors.counting()));
        return roomCountByType;
    }

    // 10. Get Avg room rate by Type
    public Map<String, Double> getAvgRoomRateByType(){
        var avgRoomRateByType = this.inventory
                .stream()
                .collect(Collectors.groupingBy(Room::getType))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        (entry) -> entry.getKey(),
                        (entry) -> entry.getValue()
                                .stream()
                                .mapToDouble(Room::getRate)
                                .average()
                                .stream().map(Math::round)
                                .findFirst()
                                .orElse(0)
                ));
        return avgRoomRateByType;
    }
}
