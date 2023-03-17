package org.jarotball.collections.into_fundamentals.project_7_list;

import org.jarotball.collections.into_fundamentals.project_1_london_hotel.Room;

import java.util.Arrays;

public class ApplicationGuestService {
    public static void main(String[] args) {
        // Setup
        // Rooms
        Room R1 = new Room("R1","5star", 5,500);
        Room R2 = new Room("R2","4star", 5,400);
        Room R3 = new Room("R3","3star", 5,300);
        Room R4 = new Room("R4","2star", 5,200);
        Room R5 = new Room("R5","1star", 5,100);
        Room R6 = new Room("R6","5star", 5,500);

        // Guests
        Guest billy = new Guest("Billy","Bow", false);
        Guest cilly = new Guest("Cilly","Cow", true);
        Guest dilly = new Guest("Dilly","Dow", false);
        Guest eilly = new Guest("Eilly","Eow", true);
        Guest filly = new Guest("Filly","Fow", true);

        // Set the room preferences for guests
        billy.setPreferredRooms(Arrays.asList(R1,R2,R3));
        cilly.setPreferredRooms(Arrays.asList(R1,R4,R5));
        dilly.setPreferredRooms(Arrays.asList(R1,R5,R6));
        eilly.setPreferredRooms(Arrays.asList(R2,R3,R6));
        filly.setPreferredRooms(Arrays.asList(R2,R3,R5));


        // Simulation
        GuestService gs = new GuestService();

        // 1.1 Guests are in checkin
        gs.checkIn(billy);
        gs.checkIn(cilly);
        gs.checkIn(dilly);
        gs.checkIn(eilly);
        gs.checkIn(filly);

        // Print the guest
        gs.print();
        System.out.println("-------------");

        // 1.2 Filter Guests by their Top preferred room
        gs.filterGuestsByTopRoom(R1)
                .forEach(System.out::println);

        // 1.3 Swap the Guest Positions
        System.out.println("-------After Swap-----------");
        gs.swapPosition(billy,cilly);
        gs.print();


    }

}
