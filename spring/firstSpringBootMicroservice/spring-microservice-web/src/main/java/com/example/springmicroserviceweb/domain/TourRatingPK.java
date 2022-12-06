package com.example.springmicroserviceweb.domain;

import java.io.Serializable;

/*
 * Note
 * ----
 * TourRating Class with store the toru ratings into a Database, which thereby require a PrimaryKey
 * The TourRating PK is a composed PK = tourId_customerId
 */

// This class contains embedded properties to a single database table
// i.e TourRatingPK will produce a composite PrimaryKey for Domain/Model <TourRating> which interacts with Persistent Database <TourRatingRepository>
public class TourRatingPK implements Serializable {
    private Tour tour;
    private Integer customerId;

}
