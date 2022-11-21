package com.example.bootingweb.services;

import com.example.bootingweb.models.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private final List<Room> roomList;

    public RoomService(List<Room> roomList) {
        this.roomList = roomList;
    }

    public void setRoomDetails(){
        for (int i = 0; i < 10; i++) {
            this.roomList.add(new Room(i, "Room "+i, "R"+i,"Q"));
        }
    }

    public List<Room> getRoomDetails(){
        this.setRoomDetails();
        return this.roomList;
    }
}
