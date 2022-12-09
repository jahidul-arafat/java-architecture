package com.example.springmicroservicewebmongodbsolution.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;

/*
 * Note
 * ----
 * TourRating Class with store the toru ratings into a Database, which thereby require a PrimaryKey
 * The TourRating PK is a composed PK = tourId_customerId
 */

// This class contains embedded properties to a single database table
// i.e TourRatingPK will produce a composite PrimaryKey for Domain/Model <TourRating> which interacts with Persistent Database <TourRatingRepository>

// TourRatingPK class will be embedded by Entity <TourRating>
// Thereby TourRatingPK will not have a separate table in the Database

@Embeddable // means this Class having no separate entity in the Database and can be embedded by any other Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class TourRatingPK implements Serializable{
    @ManyToOne              // Means, multiple Tour Ratings could be there for a single tour;
    private Tour tour; // why entire tour is sending in the RequestBody of TourRating?

    @Column(insertable = false, updatable = false, nullable = false)    // means, it must have a value, but you cant insert a value neither could modify it
    private Integer customerId; // For simplicity purpose, we are not going to maintain a separate customer Repository.

}
