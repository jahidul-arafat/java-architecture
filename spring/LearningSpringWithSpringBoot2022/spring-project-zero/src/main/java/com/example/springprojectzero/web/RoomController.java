package com.example.springprojectzero.web;

import com.example.springprojectzero.business.RoomService;
import com.example.springprojectzero.data.Room;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;

    // constructor
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    // custom_methods_1
    @RequestMapping(method = RequestMethod.GET)
    public String getAllRooms(Model model){
        List<Room> roomList = this.roomService.getRoomDetails();
        model.addAttribute("roomDetails", roomList);
        return "roomdetails"; // the view
    }
}
