package com.example.springprojectzero.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

// Java Bean
@Repository
public interface ReservationRepository extends CrudRepository<Reservation,Long> {
    String name = "Reservation Repository Interface (Bean) for Data<Reservation>"; // default public, static, final;
    Iterable<Reservation> findReservationByReservationDate(Date date); // sql.Date // this is a magic
    // this automatically execute the below SELECT statement on condition Date
    // Requires a SQL Format date, not UTILS format date as this gonna execute the SQL query

    // will be implemented later
    /*
    select * from reservation
    where res_date='2022-01-02';

    select * from reservation
    where res_date<'2022-11-02';
     */
}
