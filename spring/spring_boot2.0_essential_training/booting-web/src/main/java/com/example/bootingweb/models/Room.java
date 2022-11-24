package com.example.bootingweb.models;

import javax.persistence.*;

@Entity // Room is an Entity object after defined with @Entity annotation
@Table(name = "ROOM")
public class Room {
    @Id     // Primary key
    @Column(name = "ROOM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // never use GenerationType.AUTO
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ROOM_NUMBER")
    private String roomNumber;

    @Column(name = "BED_INFO")
    private String bedInfo;

    // Constructor doesn't require as the data will be loaded directly from embedded database into Spring Boot framework
    // Create two constructors
    // No Argument constructor - Default, even if you dont define it, its there
//    public Room() {
//    }
//
//    // All argument constructor
//    public Room(long id, String name, String roomNumber, String bedInfo) {
//        this.id = id;
//        this.name = name;
//        this.roomNumber = roomNumber;
//        this.bedInfo = bedInfo;
//    }

    // Getter and Setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBedInfo() {
        return bedInfo;
    }

    public void setBedInfo(String bedInfo) {
        this.bedInfo = bedInfo;
    }

    //toString

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", bedInfo='" + bedInfo + '\'' +
                '}';
    }
}
