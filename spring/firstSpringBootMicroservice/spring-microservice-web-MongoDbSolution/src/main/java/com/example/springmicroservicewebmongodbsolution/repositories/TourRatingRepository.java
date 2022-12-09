package com.example.springmicroservicewebmongodbsolution.repositories;

import com.example.springmicroservicewebmongodbsolution.domain.TourRating;
import com.example.springmicroservicewebmongodbsolution.domain.TourRatingPK;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

//@Repository
@RepositoryRestResource(exported = false) // we dont want this Repository to be publicly exposed through RESTFul API Call
public interface TourRatingRepository extends JpaRepository<TourRating, TourRatingPK> {
    // list all tourRatings for a tour // by the touId (primary key of Tour Entity in persistent view)
    // Return type: List
    List<TourRating> findByPkTourId(Integer tourId);

    // Find the tourRating (Score and Comment) made by a specific customer to a tour
    //PkTourIdAndPkCustomerId
    // Return type is Optional
    Optional<TourRating> findByPkTourIdAndPkCustomerId(Integer tourId, Integer customerId);


    // Find all tourRatings made for a Tour by different customers
    // Make sure, the return is Pageable
    Page<TourRating> findByPkTourId(Integer tourId, Pageable pageable);





}
