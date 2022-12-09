package com.example.springmicroservicewebmongodbsolution.repositories;

import com.example.springmicroservicewebmongodbsolution.domain.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

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

// Default endpoint of the repository: http://localhost:9090/tours/search
// No need to rename the default endpoint
//
@Repository //- this will expose CRUD operations to public which we dont want; thats why we override some methods and make them false to make it publicly unavailable
public interface TourRepository extends CrudRepository<Tour, String> {
    // Invalid return type will raise RunTimeException
    // Spring Data JPA facilitates fast failure

    // Create some custom Query Method Signatures not available at default Jpa
    // Method Signature-1: Find all Tours in a TourPackage
    // user will enter the TourPackage code and return a List of all Tours in the Package
    // http://localhost:9090/tours/search/findByTourPackageCode?code=CC&size=2&sort=title,asc

    // Spring Data Rest-01
    Page<Tour> findByTourPackageCode(@Param("code") String code, Pageable pageable);
    // @Param("code") for the previous version of Spring Data Rest; but the new Version doesnt require this @Param annotation

    // Spring Data Rest-02
    // Only return the Summary (id, title, tourPackageCode, tourPackageName) not details
    // you can leverage complex JPQL queries inside Repository
    @Query(value = "{'tourPackageCode': ?0}",
        fields = "{'id': 1, 'title': 1, 'tourPackageCode': 1, 'tourPackageName': 1}"
    )
    Page<Tour> findSummaryByTourPackageCode(@Param("code") String code, Pageable pageable);



    // now override the default Create, Update and Delete methods of JpaRepository
    // And make them publicly unavailable by using @RestResource(exported=false)


    @Override
    @RestResource(exported = false)
    <S extends Tour> S save(S entity);

    @Override
    @RestResource(exported = false)
    <S extends Tour> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    @RestResource(exported = false)
    void deleteById(String s);

    @Override
    @RestResource(exported = false)
    void delete(Tour entity);

    @Override
    @RestResource(exported = false)
    void deleteAllById(Iterable<? extends String> strings);

    @Override
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends Tour> entities);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
