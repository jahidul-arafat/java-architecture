package org.jarotball.collections.project_9_maps;

import org.jarotball.collections.project_1_london_hotel.Room;
import org.jarotball.collections.project_7_list.Guest;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BookingService {
    // Book Rooms for Guests
    private Map<Room, Guest> room2guest;

    // Constructor
    public BookingService() {
        this.room2guest = new HashMap<>();
    }

    public Map<Room, Guest> getRoom2guest() {
        return room2guest;
    }

    public void setRoom2guest(Map<Room, Guest> room2guest) {
        this.room2guest = room2guest;
    }
    // Custom Methods
    // Book a Room for a Guest -only if the room is empty
    public boolean book(Room room, Guest guest){
        return this.room2guest.putIfAbsent(room,guest)==null;
        //return this.room2guest.get(room).getFirstName().toLowerCase() == guest.getFirstName().toLowerCase();
    }

    // Get the total revenue of all booked rooms
    public double getTotalRevenueFromBooking(){
        return this.room2guest
                .keySet()
                .stream()
                .mapToDouble(Room::getRate)
                .sum();
    }

    // Switch Rooms between Guests
    public void switchRooms(Guest g1, Guest g2){
        // Define a Function which Takes Guest as Input and returns its associated Room
        Function<Guest,Room> guestRoomFunction = guest -> {
            return this.room2guest
                    .entrySet()
                    .stream()
                    .filter(entry -> entry.getValue().equals(guest))
                    .findFirst()
                    .map(entry -> entry.getKey())
                    .orElse(null);
        };


        // Find the Guest1's Room
        var guest1Room = guestRoomFunction.apply(g1);

        // Find the Guest2's Room
        var guest2Room = guestRoomFunction.apply(g2);

        // Assign the Guest1 to Guest2's Room
        // Assign the Guest2 to Guest1's Room
        this.room2guest.put(guest2Room,room2guest.remove(guest1Room));
        this.room2guest.putIfAbsent(guest1Room,g2);
    }


    public void print(){
        var roomName2guestName=this.room2guest
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        (entry)-> entry.getKey().getName(),
                        (entry)-> entry.getValue().getFirstName()
                ));
        System.out.println(roomName2guestName);

    }
}
