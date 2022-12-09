package com.example.springmicroserviceweb.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.*;


/*
* Customer (having a Unique Customer Id) can Rate A tour they have visited in 1 to 5 star
* and also can make comments on that
*
* Note
* ----
* TourRating Class with store the toru ratings into a Database, which thereby require a PrimaryKey
* The TourRating PK is a composed PK = tourId_customerId
*
*
* Q. Is there a difference between using the @Id and @EmbeddedId annotations when referencing a compound key?
* Sol: The @EmbeddedId and @IdClass annotations are used to denote composite primary keys
 */

// REST Controller will not directly talk to the TalkRating as the Object is little complex
// REST Controller will talk to a DTO <RatingDto> to pass the talk to tourRating wither for POST, PUT, PATCH
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class TourRating {
    /*
    *
    * pk tourId_customerId
    * score 1-5
    * comment   string max 255characters
     */
    @EmbeddedId // as this is a Composite Primary key, we have to use @EmbeddedId annotation instead of @Id annotation
    private TourRatingPK pk;    //tour and customerId

    @Column(nullable = false)   // rating must be there // cant be nullable
    private Integer score;

    @Column(length = 255) // can be nullable // commentLength <=255 characters
    private String comment;

}
