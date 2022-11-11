package com.example.springprojectzero.data;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RESERVATION_ID")
    private Long id;

    @Column(name = "ROOM_ID")
    private Long roomID;

    @Column(name = "GUEST_ID")
    private Long guestID;

    @Column(name = "RES_DATE")
    private Date reservationDate;

    // getter and setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoomID() {
        return roomID;
    }

    public void setRoomID(Long roomID) {
        this.roomID = roomID;
    }

    public Long getGuestID() {
        return guestID;
    }

    public void setGuestID(Long guestID) {
        this.guestID = guestID;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }


    // toString


    @Override
    public String toString() {
        DateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm a z");
        format.setTimeZone(TimeZone.getTimeZone("Asia/Dhaka"));
        return "Reservation{" +
                "id=" + id +
                ", roomID=" + roomID +
                ", guestID=" + guestID +
                ", reservationDate=" + format.format(reservationDate) +
                '}';
    }
}
