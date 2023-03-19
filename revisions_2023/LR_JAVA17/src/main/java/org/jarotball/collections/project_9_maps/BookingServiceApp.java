package org.jarotball.collections.project_9_maps;

import org.jarotball.collections.project_1_london_hotel.Room;
import org.jarotball.collections.project_7_list.Guest;

public class BookingServiceApp {
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

        // Booking Service
        BookingService bs = new BookingService();
        System.out.println(bs.book(R1,ailly));
        System.out.println(bs.book(R1,billy));

        System.out.println(bs.book(R2,cilly));
        System.out.println(bs.book(R2,dilly));

        bs.print();
        System.out.println(bs.getTotalRevenueFromBooking());

        bs.switchRooms(ailly,cilly);
        bs.print();

    }
}
