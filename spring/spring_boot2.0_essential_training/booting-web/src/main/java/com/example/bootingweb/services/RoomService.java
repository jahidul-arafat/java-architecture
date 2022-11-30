package com.example.bootingweb.services;

import com.example.bootingweb.helpers.Helper;
import com.example.bootingweb.models.Room;
import com.example.bootingweb.repositoreis.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class RoomService {
    // Now we are directly loading data from H2-embedded database
    // so get rid of all the static definitions
//    private final List<Room> roomList = Arrays.asList(
//            new Room(0, "Room "+0, "R"+0,"Q"),
//            new Room(1, "Room "+1, "R"+1,"Q"),
//            new Room(2, "Room "+2, "R"+2,"Q"),
//            new Room(3, "Room "+3, "R"+3,"Q"),
//            new Room(4, "Room "+4, "R"+4,"Q"),
//            new Room(5, "Room "+5, "R"+5,"Q"),
//            new Room(6, "Room "+6, "R"+6,"Q"),
//            new Room(7, "Room "+7, "R"+7,"Q"),
//            new Room(8, "Room "+8, "R"+8,"Q"),
//            new Room(9, "Room "+9, "R"+9,"Q"),
//            new Room(10, "Room "+10, "R"+10,"Q")
//    );


//    public RoomService(List<Room> roomList) {
//        this.roomList = roomList;
//    }

//    public void setRoomDetails(){
//        for (int i = 0; i < 10; i++) {
//            this.roomList.add(new Room(i, "Room "+i, "R"+i,"Q"));
//        }
//    }

    private final RoomRepository roomRepository;

    // we will load data directly from the h2 embedded database
    // hence, RoomRepository has been defined final, it needs to be initialized
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getRoomDetails(){
        // query into the database to get all the rows from the Table<ROOM>; on ly accessible through the RepositoryInterface
        // Note; the repositoryInterface will return an iterable, not a list; we need a way to convert this iterable into list
        var roomIterables = this.roomRepository.findAll();

        // convert the iterable into a list
        List<Room> roomList = Helper.covertInterableIntoList(roomIterables);

        // sort the rooms by their name
        roomList.sort(Comparator.comparing(Room::getName));
        return roomList;
    }

    // find a room by id
    // like select * from room where roomId =id
    public Room getRoomByID(long id){
        return roomRepository.findById(id).get(); // return the RoomObject
    }

}
