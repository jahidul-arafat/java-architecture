package com.example.springmicroserviceweb.repositories;

import com.example.springmicroserviceweb.domain.TourRating;
import com.example.springmicroserviceweb.domain.TourRatingPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
@RepositoryRestResource(exported = false) // we dont want this Repository to be publicly exposed through RESTFul API Call
public interface TourRatingRepository extends JpaRepository<TourRating, TourRatingPK> {
    // Lookup all tourRatings for a tour



}
