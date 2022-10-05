package com.jarotball.into_iterations.project_2_room_service.data;

import com.jarotball.into_fundamentals.project_1_london_hotel.data.Room;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RoomService {

    private Collection<Room> inventory;

    // Constructor
    public RoomService(Collection<Room> inventory) {
        this.inventory = inventory;
    }


    // Getter and setter
    public Collection<Room> getInventory() {
        return inventory;
    }

    public void setInventory(Collection<Room> inventory) {
        this.inventory = inventory;
    }

    // Custom methods
    // 1. Reduce the rate of each room by the provided discount
    public void applyDiscount(double discount){
        this.inventory
                .forEach(room -> room.setRate(room.getRate()*(1-(discount/100))));
    }

    // 2. Returns a new collection of rooms that meet or exceed the provided capacity
    public Collection<Room> getRoomsByCapacity(int requiredCapacity){
        return this.inventory
                .stream()
                .filter(room -> room.getCapacity()>=requiredCapacity)
                .collect(Collectors.toList());
    }

    // 3. Returns a new collection of rooms with a rate below the provided rate and that match the provided type
    public Collection<Room> getRoomByRateAndType(double rate, String type){
        var output = this.inventory
                .stream()
                .filter(room -> room.getRate()<rate && room.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
        return output;
    }

    // 4. Check is a room exists in the RoomService system
    public boolean hasRoom(Room room){
        return this.inventory.contains(room);
    }

    // 5. Get list of all rooms by type i.e. 3star, 4starn etc

    public Collection<Room> getByType(String type){
        var output = this.inventory
                .stream()
                .filter(room -> room.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
        return output;
    }

}
