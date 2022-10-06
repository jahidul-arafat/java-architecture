package com.jarotball.into_list.project_2_london_hotel_guest_service;

import com.jarotball.into_fundamentals.project_1_london_hotel.data.Room;
import com.jarotball.into_list.project_1_london_hotel_guest_checkin_loyalty.data.Guest;
import com.jarotball.into_list.project_2_london_hotel_guest_service.data.GuestService;

import java.util.List;

public class App {
    public static void main(String[] args) {
        // 0. Setup - Create 5x guests, 6x rooms and set the guests preferred rooms
        // Create 6x Rooms
        Room R1 = new Room("R1","5star", 5,500);
        Room R2 = new Room("R2","4star", 5,400);
        Room R3 = new Room("R3","3star", 5,300);
        Room R4 = new Room("R4","2star", 5,200);
        Room R5 = new Room("R5","1star", 5,100);
        Room R6 = new Room("R6","5star", 5,500);

        // Create 5x Guests
        Guest billy = new Guest("Billy","Bow", false);
        Guest cilly = new Guest("Cilly","Cow", true);
        Guest dilly = new Guest("Dilly","Dow", false);
        Guest eilly = new Guest("Eilly","Eow", true);
        Guest filly = new Guest("Filly","Fow", true);

        // set the room preferences by the guest
        billy.setPreferredRooms(List.of(R1,R2,R3));
        cilly.setPreferredRooms(List.of(R1,R4,R5));
        dilly.setPreferredRooms(List.of(R1,R5,R6));
        eilly.setPreferredRooms(List.of(R2,R3,R6));
        filly.setPreferredRooms(List.of(R2,R3,R5));


        // 1. Guest Service Simulation
        GuestService gs = new GuestService();

        // 1.1 Guests are checkin
        gs.checkIn(billy);
        gs.checkIn(cilly);
        gs.checkIn(dilly);
        gs.checkIn(eilly);
        gs.checkIn(filly);

        gs.print(); // 0: Cilly
                    // 1: Eilly
                    // 2: Filly
                    // 3: Billy
                    // 4: Dilly

        // 1.2 Guests filter By their FavoriteRoom
        // Room-R1, Guests: [Cilly, Billy, Dilly]
        System.out.println();
        gs.filterByFavoriteRoom(gs.getCheckinList(), R1)
                .stream()
                .map(guest -> guest.getFirstName())
                .forEach(System.out::println);

        // 1.3 Swap Guest Position
        // Since Billy came first for checkin, but because of non_loyalty_member, he become 4th to checkin
        // But Billy has some urgency and requested cilly <a_loyalty_member> to swap with his position to checkin first
        // After Swaping:
        /*
        *   0: Billy
            1: Eilly
            2: Filly
            3: Cilly
            4: Dilly
        *
        * */
        System.out.println();
        gs.swapPosition(billy,cilly);
        gs.print();
    }

}
