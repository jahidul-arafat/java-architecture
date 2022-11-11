package com.example.springprojectzero.data;

import javax.persistence.*;

@Entity
@Table(name = "ROOM")
public class Room {
    // Instance Attributes
    @Id                                                     // primary_key
    @GeneratedValue(strategy = GenerationType.IDENTITY)         // value auto_increment
    @Column(name = "ROOM_ID")                               // map to the Table Column
    private long id;                                        // out attributeName which mapped to the above table_column
    @Column(name = "NAME")
    private String name;
    @Column(name = "ROOM_NUMBER")
    private String roomNumber;
    @Column(name = "BED_INFO")
    private String bedInfo;



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


    // Print the Object

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", bedInfo=" + bedInfo +
                '}';
    }
}
