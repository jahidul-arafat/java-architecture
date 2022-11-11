package com.example.springprojectzero.util;

import com.example.springprojectzero.business.GuestService;
import com.example.springprojectzero.business.ReservationService;
import com.example.springprojectzero.business.RoomService;
import com.example.springprojectzero.data.*;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.SortedMap;

/**
 * Make sure your database is all setup by the time we run this code to print all the elements from Database and print each of these
 * That's why, we created a new class called AppStartupEvent which implements the interface ApplicationListener of type ApplicationReadyEvent
 * Annotate it with @Component, so that Spring will peak it up
 *
 *
 * Iterable Vs List
 * Iterators can be returned and manipulated before the stored data is fully available,
 * whereas a list, or an array for that matter, must be fully populated before it can safely be returned
 */

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    // Instance attributes
    // We will not interact data directly, instead we will interact with repository interface that leverages
    // Proxies to build the actual CRUD operation

    private final RoomRepository roomRepository; // RoomRepository interface extends CrudRepository interface
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;
    private final ReservationService reservationService;

    private final GuestService guestService;
    private final RoomService roomService;

    // Constructor
    public AppStartupEvent(RoomRepository roomRepository, GuestRepository guestRepository,
                           ReservationRepository reservationRepository,
                           ReservationService reservationService,
                           GuestService guestService, RoomService roomService) {
        this.roomRepository = roomRepository;
        this.guestRepository= guestRepository;
        this.reservationRepository = reservationRepository;
        this.reservationService= reservationService;
        this.guestService = guestService;
        this.roomService = roomService;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        // Room Operations
        // Find the number of rooms are there
        var totalRooms = this.roomRepository.count();
        System.out.println("Total Rooms in the Embedded Database: "+ totalRooms);
        Iterable<Room> rooms = this.roomRepository.findAll(); // returns an iterable // WHY NOT LIST?
        rooms.forEach(System.out::println);
        System.out.println("");

        // Guest Operations
        // Find total guest in the database
        var totalGuests = this.guestRepository.count();
        System.out.println("Total Guests found in DB: "+ totalGuests);

        // print the guest details
        var guests = this.guestRepository.findAll();
        guests.forEach(System.out::println);

        System.out.println();
        // Reservation Details
        var totalReservations = this.reservationRepository.count();
        System.out.println("Total Reservations: "+ totalReservations);

        // print the reservation Details
        var reservations = this.reservationRepository.findAll();
        reservations.forEach(System.out::println);

        // RoomReservation Service
        System.out.println("Calling the RoomReservation Service");
        var roomReservations = this.reservationService.getRoomReservationForDate(DateUtils.createDateFromDateString("2022-1-1")); // utils.Date
        roomReservations.forEach(System.out::println);

        // GuestService
        // add a new guest into the existing guest list
        System.out.println("Adding a new guest into the System ......");
        Guest newGuest = new Guest();
        newGuest.setFirstName("Jahidul");
        newGuest.setLastName("Arafat");
        newGuest.setEmail("jahidul.arafat@oracle.com");
        newGuest.setAddress("191/abc Basundhara R/A");
        newGuest.setCountry("Bangladesh");
        newGuest.setPhoneNumber("+880-1759605859");
        System.out.println("New Guest: "+ newGuest);

        this.guestService.addGuest(newGuest);

        // Calling the GuestDetails Service
        System.out.println();
        System.out.println("Calling the GuestDetails Service");
        var guestDetails = this.guestService.getHotelGuests();
        guestDetails.forEach(System.out::println);

        // get the guest of a specific country
        System.out.println("Filtering guests by a given country ...");
        var guestsByCountry = this.guestService.filterByCountry("China");
        guestsByCountry.forEach(System.out::println);

        // get the guest bearing the similar family name
        System.out.println();
        System.out.println("Filtering guests by their family name ...");
        var guestsByFamilyName = this.guestService.filterByLastName("Tucker");
        guestsByFamilyName.forEach(System.out::println);

        // get the guest bearing similar family name and from the same country
        System.out.println();
        System.out.println("Filtering guests by bearing same family name and country ...");
        var guestsByFamilyAndCountry = this.guestService.filterByFamilyNameAndCountry("Tucker","United States");
        guestsByFamilyAndCountry.forEach(System.out::println);

        // Calling the Room Service
        System.out.println();
        System.out.println("Calling the Room Service");
        var roomDetails = this.roomService.getRoomDetails();
        roomDetails.forEach(System.out::println);





    }
}
