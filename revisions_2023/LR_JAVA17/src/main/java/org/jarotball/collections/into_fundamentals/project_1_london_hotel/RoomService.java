package org.jarotball.collections.into_fundamentals.project_1_london_hotel;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class RoomService {
    private Collection<Room> inventory;

    public RoomService() {
        this.inventory = new LinkedHashSet<>();
    }

    public Collection<Room> getRoomCollection() {
        return inventory;
    }

    public void setRoomCollection(Collection<Room> roomCollection) {
        this.inventory = roomCollection;
    }

    // Custom Methods
    public void applyDiscount(final double discount) {

        //Reduces the rate of each room by the provided discount
        this.inventory.forEach(r -> r.setRate(r.getRate() * (1-discount)));
    }

    public Collection<Room> getRoomsByCapacity(int requiredCapacity){
        return this.inventory
                .stream()
                .filter(room -> room.getCapacity()>=requiredCapacity)
                .collect(Collectors.toList());
    }

    public Collection<Room> getRoomsByRateAndType(double rate, String type){
        return this.inventory
                .stream()
                .filter(room -> room.getRate()<rate && room.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

    public boolean hasRoom(Room room){
        return this.inventory.contains(room);
    }

    // Return the rooms as Array
    public Room[] asArray(){
        return this.inventory.toArray(new Room[0]);
    }

    // Get by Type
    public Collection<Room> getByType(String type){
        return this.inventory
                .stream()
                .filter(room -> room.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

    // Create Rooms into the RoomService
    public void createRoom(String name,String type, int capacity, double price){
        this.inventory.add(new Room(name,type,capacity,price));
    }

    // Create Room
    public void createRoom(Room[] rooms){
        this.inventory.addAll(Arrays.asList(rooms));
    }

    // remove a room from inventory
    public void removeRoom(Room room){
        this.inventory.remove(room);
    }
}
