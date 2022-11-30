package com.example.bootingweb.models;

public class AsyncPayload {
    /*
    * Require 2x attributes
    * (a) Room ID; which which we will check for the room availabnle for cleaning service
    * (b) The Type of the Object we gonna pass in the AsyncPayload from the RabbitMQ AMQP UI
    * */
    private long id; // roomID
    private String model; // Object Type i.e. ROOM

    // getter and setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
