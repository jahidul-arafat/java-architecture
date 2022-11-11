package com.example.springprojectzero.web;

import com.example.springprojectzero.business.ReservationService;
import com.example.springprojectzero.business.RoomReservation;
import com.example.springprojectzero.util.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/*
- one class per url endpoint
- then write many methods in there as is necessary in order to handle all of the verbs that I need to respond to.
 */
@Controller
@RequestMapping("/reservations") // url
public class RoomReservationController {
    // Instance Attributes
    // Controller will go about and assemble data for the model using various bits of application codes
    // i.e. service,

    // this reservation controller will assemble data through the service "ReservationService"
    private final ReservationService reservationService;

    // constructor
    // Hence a single constructor, @Autowired annotation is not required
    public RoomReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // Custom method
    // Get the reservations made on a specific date
    // Upon receiving the request on a specific URL/verb, controller then build a model or Spring Framework might pass a model itself

    // dateString --> need to come from somewhere; that's why we put it under @RequestParam
    // Return the "TemplateName" for Thymeleaf templating engine

    // http://localhost:8080/reservations?date=2022-01-01
    @RequestMapping(method = RequestMethod.GET) // verb respond to // Requires a REST API to build, without this, when we go for rendering, it will render all Guest null, even if a booking made on the date as the date gonna be replaced with my current date
    public String getReservations(@RequestParam(value = "date", required = false) String dateString, Model model){
        Date date = DateUtils.createDateFromDateString(dateString); // if no date passed in, its today; else that day


        // return all the roomReservation irrespective to whether the room is reserved or not
        // if a room reservation is found on that day, then we have the room reservation entries update with the guest details and date of reservation
        // else guest details and dateOfReservation remain null
        // Note: roomReservation list is sorted by RoomName in alphabetic order
        List<RoomReservation> roomReservationList = this.reservationService.getRoomReservationForDate(date);

        // now take the model element; this model is live; Spring framework is handling this for us
        // we just put whatever data it requires; i.e. put the roomReservationList data into the live model
        model.addAttribute("roomReservations",roomReservationList);

        // now return a string "Template Name"
        // is actually the template name (without file extension) that we want to return
        // why no fileextension in the template name?
        // Bcoz Spring Boot Started Thymelead is configured in such a way that, that HTML tag at the end doesnt matter

        return "roomres"; // let's go to build the "roomres" template

    }
}
