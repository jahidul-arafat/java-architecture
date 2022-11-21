package com.example.bootingweb.restcontrollers;

import com.example.bootingweb.models.Room;
import com.example.bootingweb.services.RoomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RoomRestController {
    private final RoomService roomService;

    // Constructor
    public RoomRestController(RoomService roomService) {
        this.roomService = roomService;
    }

    // rest_api localhost:8080/api/rooms
    @GetMapping("/rooms")
    public List<Room> getAllRooms(){
        List<Room> roomList = this.roomService.getRoomDetails();
        roomList.sort(Comparator.comparing(Room::getRoomNumber));
        return roomList;
    }
}
