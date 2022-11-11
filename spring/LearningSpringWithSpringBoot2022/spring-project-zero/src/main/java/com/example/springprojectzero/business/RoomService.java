package com.example.springprojectzero.business;

import com.example.springprojectzero.data.Room;
import com.example.springprojectzero.data.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    // constructor
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getRoomDetails(){
        var roomIterables = this.roomRepository.findAll();
        List<Room> roomList = new ArrayList<>();
        roomIterables.forEach(roomList::add);

        roomList.sort(Comparator.comparing(Room::getName));
        return roomList;
    }

    // custom_method
    // add a new room
    public void addRoom(Room room){
        if (room==null){
            throw new RuntimeException("Room cant be null");
        }
        this.roomRepository.save(room); // Execute the SQL INSERT INTO operation
    }

    // custom_method
    // find room by their name
    public List<Room> findRoomByName(String roomName){
        List<Room> roomList = getRoomDetails();
        return roomList
                .stream()
                .filter(room -> room.getName().equalsIgnoreCase(roomName))
                .collect(Collectors.toList());
    }

    // custom_method
    // filter rooms by their bedInfo
    // find the rooms having similar bedInfo
    public List<Room> findRoomByBedInfo(String bedInfo){
        List<Room> roomList = getRoomDetails();
        return roomList
                .stream()
                .filter(room -> room.getBedInfo().equalsIgnoreCase(bedInfo))
                .collect(Collectors.toList());
    }
}
