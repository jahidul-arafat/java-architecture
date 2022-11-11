package com.example.springprojectzero.web;

import com.example.springprojectzero.business.GuestService;
import com.example.springprojectzero.data.Guest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/guests") // request url
public class GuestController {
    // Instance Attributes
    // Controller gonna call the GuestService to assemble the data for the model
    private final GuestService guestService; // must be a bean

    // constructor // @Autowired if a single constructor
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    // custom_method_01
    // get all the guests data and put this list into the model
    // model gonna call the view which we gonna design in the resource/temptale section using Thymeleaf
    @RequestMapping(method = RequestMethod.GET) //verb
    public String getAllGuests(Model model){
        // get the data
        List<Guest> guestList = this.guestService.getHotelGuests();

        // add this data into the model
        model.addAttribute("guestDetails", guestList);

        // return the view name where we gonna render the data from the model
        return "guestdetails"; // response page
                                // Dont name your RequestURL the same name as your ResponsePage; this might ends up in circular referencing
    }
}
