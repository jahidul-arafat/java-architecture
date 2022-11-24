package com.example.bootingweb.controllers;

import com.example.bootingweb.models.Room;
import com.example.bootingweb.services.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.List;

// Adding dynamic Data to a webpage in a Spring Boot application
@Controller
@RequestMapping("/room")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    // Controller method going to take a model element; Model model
    @GetMapping("/details")
    public String getAllRooms(Model model){
        List<Room> roomDetails = this.roomService.getRoomDetails();
        //roomDetails.sort(Comparator.comparing(Room::getRoomNumber));

        // add the attribute into the model with the attributeName that we have passed in the Thymeleaf template
        model.addAttribute("roomDetails",roomDetails);

        // Return the thymeleaf template which gonna populate these info
        return "rooms"; // name of the view: rooms.html
    }
}
