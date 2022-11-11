package com.example.springprojectzero.business;

import com.example.springprojectzero.data.Guest;
import com.example.springprojectzero.data.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class GuestService {
    private final GuestRepository guestRepository;

    // constructor


    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    // custom method_1
    // get the details of all guest
    public List<Guest> getHotelGuests(){
        var guestsIterable = this.guestRepository.findAll();
        List<Guest> guestList = new ArrayList<>();
        guestsIterable.forEach(guestList::add);

        // sort the guests by their last name
        guestList.sort(Comparator.comparing(Guest::getLastName));

        // return the guest list
        return guestList;

    }

    public void addGuest(Guest guest){
        if (null == guest){
            throw new RuntimeException("Guest cant be null"); // map to HTTP 500 Internal Server Error server error response code indicates that the server encountered an unexpected condition that prevented it from fulfilling the request.
            // its better to map it to a specific response code for the produciton system
            // since its a demo, throwing runtime exception is OK here
        }
        this.guestRepository.save(guest); // this will execute the SQL INSERT Operation

    }

    // custom_method
    // find all guests from a specific country
    public List<Guest> filterByCountry(String country){
        List<Guest> guestList = getHotelGuests();

        return guestList
                .stream()
                .filter(guest-> guest.getCountry().equalsIgnoreCase(country))
                .collect(Collectors.toList());
    }

    // custom_method
    // find all guests filter by their last name or family name
    public List<Guest> filterByLastName(String lastName){
        List<Guest> guestList= getHotelGuests();

        return guestList
                .stream()
                .filter(guest -> guest.getLastName().equalsIgnoreCase(lastName))
                .collect(Collectors.toList());
    }

    // custom_method
    // Filter all guest having the same family name and from the same country
    public List<Guest> filterByFamilyNameAndCountry(String familyName, String country){
        List<Guest> guestList = getHotelGuests();
        return guestList
                .stream()
                .filter(guest -> {
                    return guest.getCountry().equalsIgnoreCase(country) && guest.getLastName().equalsIgnoreCase(familyName);
                })
                .collect(Collectors.toList());
    }
}
