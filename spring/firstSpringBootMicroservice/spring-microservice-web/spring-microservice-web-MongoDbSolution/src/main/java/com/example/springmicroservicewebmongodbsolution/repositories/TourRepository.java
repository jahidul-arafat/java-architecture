package com.example.springmicroservicewebmongodbsolution.repositories;

import com.example.springmicroservicewebmongodbsolution.domain.Difficulty;
import com.example.springmicroservicewebmongodbsolution.domain.Region;
import com.example.springmicroservicewebmongodbsolution.domain.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/*
 * Modify the Default behavior of Paging and Sorting
 * Default Paging - page 0
 * Default Size=20
 * Default Sort = des
 */

// Danger that Spring Data REST expose
/*
 *
 * As we have seen earlier, the Spring Data Rest enables us not only lookup  the entities, but also allow us to
 * Create (HTTP POST), Update (PUT/PATCH) and delete(DELETE) them
 * But I dont think we should allow this in public to modify our database in this way
 *
 * Solution
 * --------
 * Use @RepositoryRestResource(exported=false) at Class Level
 * Use @RestResource(exported=false) at the method level
 */

// Default endpoint of the repository: http://localhost:9090/tours
// No need to rename the default endpoint
//
@Repository //- this will expose CRUD operations to public which we dont want; thats why we override some methods and make them false to make it publicly unavailable
public interface TourRepository extends JpaRepository<Tour, Integer> {
    // Invalid return type will raise RunTimeException
    // Spring Data JPA facilitates fast failure

    // Create some custom Query Method Signatures not available at default Jpa
    // Method Signature-1: Find all Tours in a TourPackage
    // user will enter the TourPackage code and return a List of all Tours in the Package
    // http://localhost:9090/tours/search/findByTourPackageCode?code=CC&size=2&sort=title,asc

    Page<Tour> findByTourPackageCode(@Param("code") String code, Pageable pageable);
    // @Param("code") for the previous version of Spring Data Rest; but the new Version doesnt require this @Param annotation

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



    // now override the default Create, Update and Delete methods of JpaRepository
    // And make them publicly unavailable by using @RestResource(exported=false)


    @Override
    @RestResource(exported = false)
    <S extends Tour> List<S> saveAll(Iterable<S> entities);

    @Override
    @RestResource(exported = false)
    <S extends Tour> S save(S entity);

    @Override
    @RestResource(exported = false)
    void deleteById(Integer integer);

    @Override
    @RestResource(exported = false)
    void delete(Tour entity);

    @Override
    @RestResource(exported = false)
    void deleteAllById(Iterable<? extends Integer> integers);

    @Override
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends Tour> entities);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
