package com.example.springmicroservicewebmongodbsolution.services;

import com.example.springmicroservicewebmongodbsolution.domain.Tour;
import com.example.springmicroservicewebmongodbsolution.domain.TourRating;
import com.example.springmicroservicewebmongodbsolution.domain.TourRatingPK;
import com.example.springmicroservicewebmongodbsolution.dto.RatingDto;
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
     * @param tourId tour Identifier, Primary Key
     * @param ratingDto is the RequestBody we gonna pass a Payload in RESTFul API CALL HTTP POST
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
    public void createTourRating(int tourId, RatingDto ratingDto){
        // verify the tourId and return the tour
        Tour tour = verifyTour(tourId); // set a breakpoint here for debug to check if the RatingDTO is really being created and validated

        // then, save the rating into tourRatingRepository // persistent Database
        /*
        * Tour - TourRatingPk, Score, Comment
        * */
        tourRatingRepository.save(new TourRating(
                new TourRatingPK(tour, ratingDto.getCustomerId()),
                ratingDto.getScore(),
                ratingDto.getComment()));
    }


    // Business Service-2: Get all the rating of a tour
    // For GET /tours/{tourId}/ratings
    // 2.1 using the Bag/DTO to get the ratings made
    public List<RatingDto> getAllRatingsForTour(int tourId){
        verifyTour(tourId);
        return tourRatingRepository.findByPkTourId(tourId)
                .stream()
                //.map(tourRating -> new RatingDto(tourRating))
                .map(RatingDto::new)
                .collect(Collectors.toList());

    }

    // 2.2 if Pageable // get all ratings made on a tour in pages
    // http://localhost:8080/tours/1/ratings/pages?size=2&page=1&sort=score,desc
    public Page<RatingDto> getAllRatingsForTour(int tourId, Pageable pageable){
        verifyTour(tourId);
        Page<TourRating> tourRatingsPage = tourRatingRepository.findByPkTourId(tourId, pageable);
        return new PageImpl<>(
                tourRatingsPage
                        .get()
                        .map(tourRating -> new RatingDto(tourRating))
                        .collect(Collectors.toList())
                ,pageable
                ,tourRatingsPage.getTotalElements()
        );

    }

    // Business Service-3: Get the average rating of a tour
    // Rating OptionalDouble; it might having a tour with no rating for now
    // For GET /tours/{tourId}/ratings/average
    public Map<String,Double> getAverageRatingOfTour(int tourId){
        verifyTour(tourId);
        return Map.of("average",
                tourRatingRepository.findByPkTourId(tourId)
                        .stream()
                        .mapToInt(TourRating::getScore)
                        .average()
                        .orElseThrow(()-> new NoSuchElementException("Tour has no Ratings")));
    }

    // Business Service-4: Update Score and Comment of a Tour Rating
    // 4.1 Update with HTTP PUT Method - update if exists, else create
    // Semantics of PUT is >> All the attributes are updated
    // Update with bag/DTO
    public RatingDto updateWithPut(int tourId, RatingDto ratingDto){
        // first, verify the tour rating given tourId and customerId
        TourRating tourRating= verifyTourRating(tourId,ratingDto.getCustomerId());

        // Put semantics; update all irrespective to cases
        tourRating.setScore(ratingDto.getScore());
        tourRating.setComment(ratingDto.getComment());
        return new RatingDto(tourRatingRepository.save(tourRating));    // save the TourRating in TourRatingRepository
    }

    // 4.2 Update with HTTP PATCH method - only for updating;
    // Semantics of PATCH is >> only the attributes whole value is modified is updated; not all
    // that's why Patch check first if any attribute need to be updated; if so, update; else not
    // Update with Bag/DTO
    public RatingDto updateWithPatch(int tourId, RatingDto ratingDto){
        // first, verify the tour rating given tourId and customerId
        TourRating tourRating= verifyTourRating(tourId,ratingDto.getCustomerId());

        // Patch Semantics; check if update really require
        if (ratingDto.getScore()!=null)     // customer updated the Score
            tourRating.setScore(ratingDto.getScore());
        if (ratingDto.getComment()!=null)   // customer updated the comment
            tourRating.setComment(ratingDto.getComment());
        return new RatingDto(tourRatingRepository.save(tourRating));    // save the TourRating in TourRatingRepository
        // in the class RatingDto, there is a constructor RatingDto(TourRating)
    }

    // Business Service-5: Delete a Rating of a tour made by a customer
    // No Bag/DTO require; directly delete
    public void deleteRating(int tourId, int customerId){
        // first, verify if the tour rating given by tourId and customerId
        TourRating tourRating = verifyTourRating(tourId, customerId);
        tourRatingRepository.delete(tourRating);
    }

    // Business Service-6: Get the Rating (RatingDTO: Score and Comment) made by a customer (customerId) on a tour (tourId)
    public String getRatingByCustomer(int tourId, int customerId){
        // first verify the tour rating given the tourId and customerId
        TourRating tourRating = verifyTourRating(tourId, customerId);

        return tourRating.getScore() + " " + tourRating.getComment();
    }



    // ------- Helper Methods ----------------
    // Helper Method-01
    // from 01 // this method must be private and should not be exposed outside
    // Verify the tourID and return the tourObject
    // throws NoSuchElementException if no tour found // Http 404
    private Tour verifyTour(int tourId) throws NoSuchElementException{
        return tourRepository.findById(tourId)
                .orElseThrow(()-> new NoSuchElementException("Tour does not exists "+ tourId));
    }

    // Helper Method-02
    // Verify tourRating given tourId and customerId
    private TourRating verifyTourRating(int tourId, int customerId){
        return tourRatingRepository.findByPkTourIdAndPkCustomerId(tourId,customerId)
                .orElseThrow(()-> new NoSuchElementException(
                        String.format("Tour-Rating pair for request tourID: %s, for customerID: %s doesnt exist"
                                ,tourId
                                ,customerId)));

    }

}
