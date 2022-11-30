package com.example.bootingweb.async;

import com.example.bootingweb.models.AsyncPayload;
import com.example.bootingweb.models.Room;
import com.example.bootingweb.services.RoomService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * This class is very interesting
 * Objective:
 * (a) By using the AsyncPayload which we will pass through the RabbitMQ UI, this class will read the Payload
 * Example Payload: {RoomID, ObjectType:ROOM}
 * if(ObjectType=="ROOM")-> it will log this message 'Room is available for cleaning' in the CONSOLE like CommandLineRunner
 * else -> again in the Console, this gonna print "Invalid Object Type"
 *
 * Thereby, this class require 2x types of objects:
 * (a) ObjectMapper
 * (b) RoomService -> which will return the result from the query {Select * from room where roomID==25}
 *      in the Class RoomService, write this business logic getRoomByID()::findById()
 */
@Component
public class RoomCleanerListener {
    // Class Attributes
    // define the slf4j logger which gonna log the message in CONSOLE
    private static final Logger LOG = LoggerFactory.getLogger(RoomCleanerListener.class);

    // Object Attributes
    // 2x   - ObjectMapper to find the objectType passed through the AsyncPayload
    //      - RoomID; this room for which we need the cleaning service
    private final ObjectMapper mapper;          // as the attributes are defined to be final, this require a mandatory initialization
    private final RoomService roomService;


    public RoomCleanerListener(ObjectMapper mapper, RoomService roomService) {
        this.mapper = mapper;
        this.roomService = roomService;
    }

    // Custom Method: Methiod that gonna receive the payload we will be passing through RabbitMQ UI using AsyncPayload class
    // Payload will be in JSON format
    // That's why the underlying method need to process this payload
    public void receiveMessage(String msg) {
        try{
            AsyncPayload payload= mapper.readValue(msg, AsyncPayload.class);

            // if objectType found in the payload ==ROOM; then print the Log in CONSOLE
            if ("ROOM".equals(payload.getModel())) {
                Room room =this.roomService.getRoomByID(payload.getId());
                LOG.info("Room {}:{} need to be cleaned", room.getRoomNumber(), room.getName());
            } else {
                LOG.warn("Unknown Model Type; Requires Mode Type <Room>");
            }
        } catch (JsonProcessingException e){
            e.printStackTrace();

        }

    }
}
