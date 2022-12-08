package com.example.springmicroserviceweb.dto;

/*
* In Spring Framework, DTO us an object that carries data between the processes
* When you are working with a remote interface, each call is expensive.
* As a result, you need to reduce the number of calls.
* The solution is to create a DTO that holds all the data for that call
* Score 0-5
* Comment Max 255 characters
* CustomerId not nullable, customer must having a unique ID to rate the Tour or making a comment
*
*
 */
// Customer is going to make a call to rate a particular Tour and also make a comment on it
// This call require the application create a DTO to carry the following data between processes :
// {scoreOnTheTour, commentOnTheTour, customerIDWhoIsRatingTheTour}
// This DTO info will be stored in a Persistent DB Entity called <TourRating> on which we later have made several calls for different business logics


import com.example.springmicroserviceweb.domain.TourRating;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// DTO is like a shopping Cart carrying the items to be purchased into the Counter for checkout
// This Rating DTO require 3x constructors
/*
* Constructor-1: will all Object attributes     // replace it by Lombok
* Constructor-2: Having no argument at all      // replace it by Lombok
* Constructor-3: Fill the RatingDTO bag from the attributes of a fully instantiated TourRating object
 */

// Dependency Required: spring-boot-starter-validation

// Rating a Particular Tour; means in the RESTFul URL http://localhost:8080/api/{tourId}/ratings ;
// see the {tourId} is already there
// this DTO will be passed in the Request Body
/*
{
    "score":5,
    "comment": "Amazing tour",
    "customerId": 123
}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RatingDto {

    @Min(0)
    @Max(5)
    private Integer score;

    @Size(max = 255)
    private String comment;

    @NotNull
    private Integer customerId;

    // no tourId is required; as tourId will already be in the RESTful URL on which you are making a Rating

    // Constructor-3: Fill the RatingDTO bag from the attributes of a fully instantiated TourRating object
    // why this constructor used? to get all the rating made for a tour in the TourRatingService and TourRatingRestController
    public RatingDto(TourRating tourRating) {
        this(tourRating.getScore(), tourRating.getComment(), tourRating.getPk().getCustomerId());
    }
}
