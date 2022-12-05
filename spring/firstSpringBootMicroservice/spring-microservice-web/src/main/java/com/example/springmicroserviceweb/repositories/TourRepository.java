package com.example.springmicroserviceweb.repositories;

import com.example.springmicroserviceweb.domain.Difficulty;
import com.example.springmicroserviceweb.domain.Region;
import com.example.springmicroserviceweb.domain.Tour;
import com.example.springmicroserviceweb.domain.TourPackage;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface TourRepository extends JpaRepository<Tour, Integer> {
    // Invalid return type will raise RunTimeException
    // Spring Data JPA facilitates fast failure

    // Create some custom Query Method Signatures not available at default Jpa
    // Method Signature-1: Find all Tours in a TourPackage
    // user will enter the TourPackage code and return a List of all Tours in the Package
    List<Tour> findByTourPackageCode(String code);

    // Method Signature-2: Find all tours by their title
    Optional<Tour> findByTitle(String title); // return One or zero Tour; titles are unique

    // Method Signature-3: List all tours by Price
    List<Tour> findByPrice(Integer price);

    // Method Signature-4: List all Tours by their level of difficulty
    Collection<Tour> findByDifficulty(Difficulty difficulty);

    // Method Signature-5: List all Tours by their Regions
    List<Tour> findByRegion(Region region);

    // Find all tours in a tour package by the <TourPackageCode> and <TourRegion>
    // return a List
    List<Tour> findByTourPackageCodeAndRegion(String code, Region region);

    // Given a List of regions, find tours only within these Regions, not beyond those
    List<Tour> findByRegionIn(List<Region> regions);

    // Find all tours where TourPrice <MaxTourPrice
    List<Tour> findByPriceLessThan(Integer maxPrice);

    // Find all tours where TourPackageCode =code and searchString =TourBullets
    List<Tour> findByTourPackageCodeAndBulletsLike(String code, String searchString);

    // Find all Tours containing the search Keyword
    List<Tour> findByKeywordsContaining(String keyword);

    // Find all Tours
    // Filter By
    /*
    * TourPackageName
    * Difficulty
    * Region
    * PriceLessThan maxPrice
    * */

    List<Tour> findByTourPackageCodeAndDifficultyAndRegionAndPriceLessThan(
            String code, Difficulty difficulty, Region region, Integer maxPrice);

    // you can leverage complex JPQL queries inside Repository
//    @Query("SELECT tour from Tour tour where tour.tourPackage.code=?1 " +
//            "and tour.difficulty=?2 and tour.region=?3 and tour.price<=?4")
//    List<Tour> lookupTour(String code, Difficulty difficulty, Region region, Integer maxPrice);





}
