package com.jarotball.into_map.project_2_booking_service;

import com.jarotball.into_fundamentals.project_1_london_hotel.data.Room;
import com.jarotball.into_list.project_1_london_hotel_guest_checkin_loyalty.data.Guest;
import com.jarotball.into_map.project_2_booking_service.data.BookingService;

public class App {
    public static void main(String[] args) {
        // 0. Setup - Create Rooms and Guest
        Room R1 = new Room("R1","5star", 5, 500);
        Room R2 = new Room("R2","4star", 4, 400);
        Room R3 = new Room("R3","3star", 3, 300);
        Room R4 = new Room("R4","2star", 2, 200);
        Room R5 = new Room("R5","1star", 1, 100);
        Room R6 = new Room("R6","5star", 5, 500);
        Room R7 = new Room("R7","4star", 4, 400);

        Guest ailly = new Guest("Ailly", "Aow",false);
        Guest billy = new Guest("Billy", "Bow",true);
        Guest cilly = new Guest("Cilly", "Cow",false);
        Guest dilly = new Guest("Dilly", "Dow",true);
        Guest eilly = new Guest("Eilly", "Eow",false);
        Guest filly = new Guest("Filly", "Fow",true);
        Guest gilly = new Guest("Gilly", "Gow",false);

        // BookingService
        BookingService bs = new BookingService();
        System.out.println(bs.book(R1,ailly)); // true
        System.out.println(bs.book(R1, billy)); // false

        System.out.println(bs.book(R2, cilly)); // true
        System.out.println(bs.book(R3,dilly)); // true

        bs.print();

        System.out.println(bs.totalRevenueFromBooking());

        bs.switchRooms(ailly,dilly);
        bs.print();









    }
}
