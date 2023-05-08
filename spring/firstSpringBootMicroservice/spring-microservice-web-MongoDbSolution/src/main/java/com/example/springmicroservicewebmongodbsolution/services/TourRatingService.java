package com.example.springmicroservicewebmongodbsolution.services;

import com.example.springmicroservicewebmongodbsolution.domain.Tour;
import com.example.springmicroservicewebmongodbsolution.domain.TourRating;
import com.example.springmicroservicewebmongodbsolution.repositories.TourRatingRepository;
import com.example.springmicroservicewebmongodbsolution.repositories.TourRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TourRatingService {
    private final TourRatingRepository tourRatingRepository;
    private final TourRepository tourRepository;

    // Business Service-01: Given a TourID, create a tour Rating using the RatingDTO
    // For HTTP POST

    /**
     *
     * @param tourId
     * @param tourRating
     */
    /*
    A simple RatingDto passed in the payload in URL: http://localhost:8080/tours/{tourId}/ratings
    {
    "score":5,
    "comment": "Amazing tour",
    "customerId": 123
    }
     */
    // For POST /tours/{tourId}/ratings  with RatingDTO as the JSON/payload in the Body
    /*
    For this MongoDb Microservice, if you remove verifyTour() from
    TourRatingController.createTourRating() AND invoke the API to create a
    rating for a non-existent tour, then the API will return a 201 Created Response. --> TRUE
    --> So verifyTour must be there
     */
    public void createTourRating(String tourId, TourRating tourRating){
        // verify the tourId and return the tour
        Tour tour = verifyTour(tourId); // set a breakpoint here for debug to check if the RatingDTO is really being created and validated

        // then, save the rating into tourRatingRepository // persistent Database
        /*
        * Tour - TourRatingPk, Score, Comment
        * */
        tourRatingRepository.save(new TourRating(
                        tourId,
                        tourRating.getCustomerId(),
                        tourRating.getScore(),
                        tourRating.getComment()));
    }


    // Business Service-2: Get all the rating of a tour
    // For GET /tours/{tourId}/ratings
    // 2.1 using the Bag/DTO to get the ratings made
    public List<TourRating> getAllRatingsForTour(String tourId){
        verifyTour(tourId);
        return tourRatingRepository.findByTourId(tourId)
                .stream()
                .collect(Collectors.toList());

    }

    // 2.2 if Pageable // get all ratings made on a tour in pages
    // http://localhost:8080/tours/1/ratings/pages?size=2&page=1&sort=score,desc
    public Page<TourRating> getAllRatingsForTour(String tourId, Pageable pageable){
        verifyTour(tourId);
        Page<TourRating> tourRatingsPage = tourRatingRepository.findByTourId(tourId, pageable);
        return new PageImpl<>(
                tourRatingsPage
                        .get()
                        .collect(Collectors.toList())
                ,pageable
                ,tourRatingsPage.getTotalElements()
        );

    }

    // Business Service-3: Get the average rating of a tour
    // Rating OptionalDouble; it might having a tour with no rating for now
    // For GET /tours/{tourId}/ratings/average
    public Map<String,Double> getAverageRatingOfTour(String tourId){
        verifyTour(tourId);
        return Map.of("average",
                tourRatingRepository.findByTourId(tourId)
                        .stream()
                        .mapToInt(TourRating::getScore)
                        .average()
                        .orElseThrow(()-> new NoSuchElementException("Tour has no Ratings")));
    }

    // Business Service-4: Update Score and Comment of a Tour Rating
    // 4.1 Update with HTTP PUT Method - update if exists, else create
    // Semantics of PUT is >> All the attributes are updated

    public TourRating updateWithPut(String tourId, TourRating tourRating){
        // first, verify the tour rating given tourId and customerId
        TourRating rating= verifyTourRating(tourId,tourRating.getCustomerId());

        // Put semantics; update all irrespective to cases
        rating.setScore(tourRating.getScore());
        rating.setComment(tourRating.getComment());
        return tourRatingRepository.save(rating);    // save the TourRating in TourRatingRepository
    }

    // 4.2 Update with HTTP PATCH method - only for updating;
    // Semantics of PATCH is >> only the attributes whole value is modified is updated; not all
    // that's why Patch check first if any attribute need to be updated; if so, update; else not
    // Update with Bag/DTO
    public TourRating updateWithPatch(String tourId, TourRating tourRating){
        // first, verify the tour rating given tourId and customerId
        TourRating rating= verifyTourRating(tourId,tourRating.getCustomerId());

        // Patch Semantics; check if update really require
        if (tourRating.getScore()!=null)     // customer updated the Score
            rating.setScore(tourRating.getScore());
        if (tourRating.getComment()!=null)   // customer updated the comment
            rating.setComment(tourRating.getComment());
        return tourRatingRepository.save(rating);    // save the TourRating in TourRatingRepository
        // in the class RatingDto, there is a constructor RatingDto(TourRating)
    }

    // Business Service-5: Delete a Rating of a tour made by a customer
    // No Bag/DTO require; directly delete
    public void deleteRating(String tourId, String customerId){
        // first, verify if the tour rating given by tourId and customerId
        TourRating tourRating = verifyTourRating(tourId, customerId);
        tourRatingRepository.delete(tourRating);
    }

    // Business Service-6: Get the Rating (RatingDTO: Score and Comment) made by a customer (customerId) on a tour (tourId)
    public String getRatingByCustomer(String tourId, String customerId){
        // first verify the tour rating given the tourId and customerId
        TourRating tourRating = verifyTourRating(tourId, customerId);

        return tourRating.getScore() + " " + tourRating.getComment();
    }



    // ------- Helper Methods ----------------
    // Helper Method-01
    // from 01 // this method must be private and should not be exposed outside
    // Verify the tourID and return the tourObject
    // throws NoSuchElementException if no tour found // Http 404
    private Tour verifyTour(String tourId) throws NoSuchElementException{
        return tourRepository.findById(tourId)
                .orElseThrow(()-> new NoSuchElementException("Tour does not exists "+ tourId));
    }

    // Helper Method-02
    // Verify tourRating given tourId and customerId
    private TourRating verifyTourRating(String tourId, String customerId){
        return tourRatingRepository.findByTourIdAndCustomerId(tourId,customerId)
                .orElseThrow(()-> new NoSuchElementException(
                        String.format("Tour-Rating pair for request tourID: %s, for customerID: %s doesnt exist"
                                ,tourId
                                ,customerId)));

    }

}
