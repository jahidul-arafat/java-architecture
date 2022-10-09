package com.jarotball.into_map.project_2_booking_service.data;

import com.jarotball.into_fundamentals.project_1_london_hotel.data.Room;
import com.jarotball.into_list.project_1_london_hotel_guest_checkin_loyalty.data.Guest;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 1. Book a room for a guest
 * 2. Get the total revenue/income from the booked rooms
 *
 * */
public class BookingService {
    Map<Room, Guest> bookingMap;

    // Constructor
    public BookingService() {
        this.bookingMap = new HashMap<>();
    }

    // custom_method_1
    // Book a room for a guest; only if that room is empty
    // Return true is booking successful, else false
    public boolean book(Room room, Guest guest) {
        System.out.format("%n------ Booking a Room to Guest  ------%n");
        //.putIfAbsent() will return null if no guest is associated with the room,
        // else it will return the current value (guest) associated with the room
        // that's why we compared with == null; if successful, guest will get the room
        // else room is pre-occupied
        return this.bookingMap.putIfAbsent(room, guest) == null;

    }

    // custom_method_2
    // get the total revenue from all the booked rooms
    public double totalRevenueFromBooking() {
        System.out.format("%n------ Calculating Booked Room Total Revenue ------%n");
        var totalRevenue = this.bookingMap
                .keySet()
                .stream()
                .mapToDouble(Room::getRate)
                .sum();

        return totalRevenue;
    }

    // custom_method_4
    // switch room between guests
    // i.e. R2-> Cilly, R3->Dilly (before Switch)
    //      R2-> Dilly, R3->Cilly (After Switch)

    public void switchRooms(Guest guest1, Guest guest2){
        System.out.format("%n------ Switching Room ------%n");
        Function<Guest,Room> guestRoomFuncFactory =(guest)->{
            return this.bookingMap
                    .entrySet()
                    .stream()
                    .filter(entry -> entry.getValue().equals(guest))
                    .findFirst()
                    .map(roomGuestEntry -> roomGuestEntry.getKey())
                    .orElse(null);
        };

        var guest1Room = guestRoomFuncFactory.apply(guest1);
        System.out.println("Room1: "+ guest1Room.getName());

        var guest2Room = guestRoomFuncFactory.apply(guest2);
        System.out.println("Room2: "+ guest2Room.getName());

        this.bookingMap.put(guest1Room, this.bookingMap.remove(guest2Room)); // .remove(guest2Room) returns guest2 name
        //print();

        this.bookingMap.putIfAbsent(guest2Room,guest1); // now, hence the guest2Room is empty, assign that room to guest1
        //print();
    }

    // custom_method_
    public void print() {
        System.out.format("%n------ Printing the Map<Room, Guest> ------%n");
        var output = bookingMap.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        (entry) -> entry.getKey().getName(),
                        (entry) -> entry.getValue()
                                .getFirstName()
                ));
        for (String room : output.keySet()
        ) {
            System.out.format("Guest %s at Room %s%n", output.get(room), room);

        }
    }
}
