package com.example.springprojectzero.business;

import com.example.springprojectzero.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

// @Service annotation is used with classes that provides some business functionalities
// Spring context will autodetect these classes when annotation-based configuration and classpath scanning is used.
@Service
public class ReservationService {

    // Interfaces to be used by the service, where abstracts are defined
    // 3x interfaces each for <Room>, <Guest> and <Reservation>
    // An API in the Reservation Interface to get the list of reservation based on date searched by
    // Keyword <final> is used to make the Object Singleton during the dependencyInjection lifecycle
    // Field Injection is not recommended, that's why you should not use @Autowired on fields

    //@Autowired //Field Injection is not recommended
    private final RoomRepository roomRepository; // Bean // Field

    //@Autowired //Field Injection is not recommended
    private final GuestRepository guestRepository;    // Bean    // Field

    //@Autowired //Field Injection is not recommended
    private final ReservationRepository reservationRepository;    //Bean // Field

    // Constructor play the important part in dependencyInjection
    // Absence of constructor would make the dependencyInjection failed and return the following kinds of errors
    // Error: java.lang.NullPointerException: Cannot invoke "com.example.springprojectzero.data.RoomRepository.findAll()" because "this.roomRepository" is null

    @Autowired
    public ReservationService(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    // Dummy constructor to test @Autowired
    // if this constructor not here, then @Autowired would not require
    // @Service will automatically map to the default constructor for autowiring
    public ReservationService(RoomRepository roomRepository, GuestRepository guestRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = null;
    }

    // custom methods
    // add all rooms in the roomReservation list
    // once the rooms are added in the reservation list, their guest and reservation date will remain null, only having the room details
    // for each room in the database which we access through the RoomRepository at persistent layer, we will create an RoomReservation object
    // Then we put these roomReservation objects into a Map, where roomId becomes the key of that respective room object

    // RoomReservationMap: {1=RoomReservation{roomId=1, guestId=0, roomName='Piccadilly', roomNumber='P1', guestFirstName='null', guestLastName='null', date=null},
    public Map<Long, RoomReservation> mapAllRoomsIntoRoomReservation(){
        Map<Long, RoomReservation> roomReservationMap = new HashMap<>();
        // get all the rooms from the RoomRepository which extends the CrudRepository for the DB operations
        // returns Iterable<Room> instead List<Room>
        var rooms = this.roomRepository.findAll();   // execute the sql stmt; select * from room;

        // for each room in the roomList, create a dummy reservation
        // strategy is: we will try to reserve every rooms for a dummy simulation
        // Function that takes a room as input and returns an RoomReservation object with that room which is registered
        // in a Map called with that roomID, so that in future we can find whether that room is reserved or not
        // register each room to be reserved
        rooms
                .forEach(room -> {
                    RoomReservation roomReservation = new RoomReservation();
                    roomReservation.setRoomId(room.getId());
                    roomReservation.setRoomNumber(room.getRoomNumber());
                    roomReservation.setRoomName(room.getName());
                    roomReservationMap.put(room.getId(), roomReservation);
                });

        return roomReservationMap; // RoomReservationMap: {1=RoomReservation{roomId=1, guestId=0, roomName='Piccadilly', roomNumber='P1', guestFirstName='null', guestLastName='null', date=null},
    }


    // Here with the roomReservation map, we will first get the roomReservation DB entries on a specific date
    // If any reservation found on that date, then we will update the respective RoomReservation object with the reservation's guest details and date
    public List<RoomReservation> getRoomReservationForDate(Date date){ // utils.Data
        var roomReservationMap = mapAllRoomsIntoRoomReservation();
        System.out.println("RoomReservationMap: "+ roomReservationMap); // RoomReservationMap: {1=RoomReservation{roomId=1, guestId=0, roomName='Piccadilly', roomNumber='P1', guestFirstName='null', guestLastName='null', date=null},

        // Simulation: All rooms will be reserved on today's date
        //java.sql.Date dateToReserveARoom = new java.sql.Date(date.getTime()); // lets reserve a room at today's date
        //Iterable<Reservation> reservations = this.reservationRepository.findAll();
        Iterable<Reservation> reservations = this.reservationRepository.findReservationByReservationDate(new java.sql.Date(date.getTime()));
        System.out.printf("Reservations found on %s is %s%n",date, reservations);   // Reservation{id=1, roomID=8, guestID=200, reservationDate=01/01/2022 12:00 AM BDT}
        /*
        RoomReservation{roomId=7, guestId=0, roomName='Cambridge', roomNumber='C1', guestFirstName='null', guestLastName='null', date=null}
        RoomReservation{roomId=8, guestId=200, roomName='Cambridge', roomNumber='C2', guestFirstName='Judith', guestLastName='Young', date=2022-01-01 00:00:00.0}
         */

        // update the Room reservation based on the Reservations available in the database
        // initially at database, there are only one reservation found
        // update the roomReservation list on the information found on the reservation, rest will remain same
        reservations
                .forEach(reservation -> {
                    // find that specific room which is reserved
                    var roomReserved = roomReservationMap.get(reservation.getRoomID());
                    roomReserved.setDate(reservation.getReservationDate());

                    // find the Guest with the guestId found in the reservation
                    Guest guest = this.guestRepository.findById(reservation.getGuestID()).get();

                    // update the RoomReservation object with the respective guest details
                    roomReserved.setGuestFirstName(guest.getFirstName());
                    roomReserved.setGuestLastName(guest.getLastName());
                    roomReserved.setGuestId(guest.getId());
                });

        // get the updated roomReservation list
        var roomReservationList = roomReservationMap
                .values()
                        .stream()
                                .collect(Collectors.toList());


        // sort the room reservations in Ascending order of the RoomName
        roomReservationList.sort(Comparator.comparing(RoomReservation::getRoomName));

        return roomReservationList;

    }



}
