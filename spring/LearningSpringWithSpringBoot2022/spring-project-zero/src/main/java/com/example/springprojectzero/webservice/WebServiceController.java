package com.example.springprojectzero.webservice;

import com.example.springprojectzero.business.GuestService;
import com.example.springprojectzero.business.ReservationService;
import com.example.springprojectzero.business.RoomReservation;
import com.example.springprojectzero.business.RoomService;
import com.example.springprojectzero.data.Guest;
import com.example.springprojectzero.data.Room;
import com.example.springprojectzero.util.DateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/*
Design a RESTful WebServiceController which will return JSON payload on different endpoints
- /api/reservations -> JSON payload of all the RoomReservations made
    - /api/reservations?date=2022-01-01 -> JSON payload of all the RoomReservations made on a specific date
- /api/guests -> JSON payload of all the Guests in our system
- /api/rooms  -> JSON payload of all the Rooms in our system
 */
@RestController
@RequestMapping("/api")
public class WebServiceController {
    private final ReservationService reservationService;
    private final GuestService guestService;
    private final RoomService roomService;

    // constructor // @Autowired
    public WebServiceController(ReservationService reservationService, GuestService guestService, RoomService roomService) {
        this.reservationService = reservationService;
        this.guestService = guestService;
        this.roomService = roomService;
    }

    // custom_method_1: Get all the roomReservations made
    // similar to earlier webController we made:: RoomReservationController
    // /api/reservations
    // @GetMapping would not work here
    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
    public List<RoomReservation> getReservations(@RequestParam(value = "date", required = false) String dateString){
        Date date = DateUtils.createDateFromDateString(dateString);
        return this.reservationService.getRoomReservationForDate(date);
    }

    // custom_method_2: Get all the Guest details in our system
    // similar to earlier webController we made: GuestController
    // /api/guests

    //@RequestMapping(path = "guests", method = RequestMethod.GET)
    // Get all guests
    // filter the guests by their country
    // filter the guest by their family name
    // filter guests bu both their family name and country
    @RequestMapping(path = "guests", method = RequestMethod.GET)
    public List<Guest> getAllGuests(@RequestParam(value = "country", required = false) String country,
                                    @RequestParam(value = "family", required = false) String familyName){
        if (country!=null && familyName!=null)
            return this.guestService.filterByFamilyNameAndCountry(familyName,country);
        if (country!=null)
            return this.guestService.filterByCountry(country);
        if (familyName!=null)
            return this.guestService.filterByLastName(familyName);
        return this.guestService.getHotelGuests();
    }

    // custom_method_2.1: Add a Guest into the existing GuestList
    //@RequestMapping(path = "guests", method = RequestMethod.POST)
    // Make sure, anything you create an element, you result return HTTP response status 200/successful
    @PostMapping("/guests")
    @ResponseStatus(HttpStatus.CREATED) // http response status upon successful creation of a new guest object
    public void addAGuest(@RequestBody Guest newGuest){
        // to be implemented
        // lets first try whether the service is working fine
        this.guestService.addGuest(newGuest);
    }

    // custom_method_3: Find guests filter by their country
    // is the URL remains same i.e. "/guests", then its throwing an error
    // error: to {GET [/api/guests]}: There is already 'webServiceController' bean method
//    @GetMapping("/guests")
//    public List<Guest> getGuestsByCountry(@RequestParam(value = "country", required = true) String country){
//        return this.guestService.filterByCountry(country);
//    }

    // custom_method_3: Get all the Room details in our system
    // similar to earlier webController we made: RoomController
    // /api/rooms

    //@RequestMapping(path = "rooms",method = RequestMethod.GET)
    // get all the rooms
    // filter rooms by their name
    // filter rooms by their BedInfo
    @GetMapping("/rooms")
    public List<Room> getAllRooms(@RequestParam(value = "roomName", required = false) String roomName,
                                  @RequestParam(value = "bedInfo", required = false) String bedInfo){
        if (roomName!=null)
            return this.roomService.findRoomByName(roomName);
        if (bedInfo!=null)
            return this.roomService.findRoomByBedInfo(bedInfo);
        return this.roomService.getRoomDetails();
    }

    // add a new room REST API
    // Change the GenerationType.AUTO to GenerationType.IDENTITY in data/Rooms.java as we are using H2 Spring Embedded Database; else an error will be thrown
    @PostMapping("/rooms")
    @ResponseStatus(HttpStatus.CREATED)
    public void addARoom(@RequestBody Room room){
        this.roomService.addRoom(room);
    }





}
