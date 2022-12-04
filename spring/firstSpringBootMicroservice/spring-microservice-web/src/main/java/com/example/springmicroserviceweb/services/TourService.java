package com.example.springmicroserviceweb.services;

import com.example.springmicroserviceweb.domain.Difficulty;
import com.example.springmicroserviceweb.domain.Region;
import com.example.springmicroserviceweb.domain.Tour;
import com.example.springmicroserviceweb.domain.TourPackage;
import com.example.springmicroserviceweb.repositories.TourPackageRepository;
import com.example.springmicroserviceweb.repositories.TourRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
/*
* TourService
* ------------
* 1 - Create a new tour and add that tour into the tourPackage, createTour()
* 2 - Calculate the number of tours in the database
*
*
* */
@Service
@AllArgsConstructor
public class TourService {
    private final TourRepository tourRepository;
    private final TourPackageRepository tourPackageRepository;

    // Business Service -01
    // Create a new tour
    // first check if the tour to be created is already in the Database; if so, dont create; just return that tourObject
    // else create the tourObject and save it into the repository
    // Creating a Tour requires the following attributes

    /**
     *
     * @param title
     * @param description
     * @param blurb
     * @param price
     * @param duration
     * @param bullets
     * @param keywords
     * @param tourPackageName
     * @param difficulty
     * @param region
     * @return Tour Entity
     */
    public Tour createTour(String title, String description, String blurb, Integer price,
                           String duration, String bullets, String keywords, String tourPackageName,
                           Difficulty difficulty, Region region){
        // One this to note, a prerequisite of a Tour to be created is already having a TourPackage
        // A Tour cant live without a TourPackage

        // So, first check, whether the tourPackage of the 'tourPackageName' really exists
        // if so, return that tourPackage
        // else, a RunTime exception will arise
        TourPackage tourPackage = tourPackageRepository.findById(tourPackageName).orElseThrow(()->
                new RuntimeException("Tour package does not exist: "+tourPackageName));

        // Second phase, if the tourPackage already exists, that create the tour with the tourPackage
        // Tour having a 'Many-to-One' relationship with 'TourPackage'
        // Multiple Tours can be under a single TourPackage
        return tourRepository.save(
                new Tour(title,
                        description,
                        blurb,
                        price,
                        duration,
                        bullets,
                        keywords,
                        tourPackage,
                        region,
                        difficulty));
    }


    // Business Service -02
    // Count the total number of tours in the database
    // JpaRepository  query will return a 'long' instead 'int'
    // .count
    public long total(){
        return tourRepository.count();
    }





}
