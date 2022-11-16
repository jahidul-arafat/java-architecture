package com.example.springprojectzero.web;

import com.example.springprojectzero.business.RoomService;
import com.example.springprojectzero.data.Room;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
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
    public String getAllRooms(@RequestParam(value = "roomName", required = false) String roomName,
                              @RequestParam(value = "bedInfo", required = false) String bedInfo, Model model){
        List<Room> roomList;
        if (roomName!=null)
            roomList= this.roomService.findRoomByName(roomName);
        else if (bedInfo!=null)
            roomList= this.roomService.findRoomByBedInfo(bedInfo);
        else roomList = this.roomService.getRoomDetails();

        model.addAttribute("roomDetails", roomList);
        return "roomdetails"; // the view
    }
}
