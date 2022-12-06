package com.example.springmicroserviceweb.repositories;

import com.example.springmicroserviceweb.domain.TourPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


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

//@Repository   - this will expose CRUD operations to public which we dont want
// default endpoint http://localhost:9090/tourPackages
// rename the endpoint to http://localhost:9090/packages
@Repository
@RepositoryRestResource(collectionResourceRel = "packages", path = "packages")
public interface TourPackageRepository extends JpaRepository<TourPackage, String> {

    // Non-default method; created by me // not available in JPA

    /**
     *
     * @param pkgName name of the package
     * @return Optional of TourPackage
     */
    Optional<TourPackage> findByName(@Param("name") String pkgName); // http://localhost:9090/tourPackages/search
    // in the TourService, when creating a new tour, tour has a dependency of tourPackage (must be already exists)
    // in the create a new tour section in TourService, we not gonna enter the tourPackage code, instead tourPackageName
    // by default, JpaRepository doesnt has anything for the query call with the tourPackageName ior nothing like findByName()
    // instead it has findById() which is not applicable in our case
    // so, the solution is, define an abstract method named findByName(String pkgName) which may either query return somethign or nothing.
    /// thats why the return type is defined as Optional


    // now override the default Create, Update and Delete methods of JpaRepository
    // And make them publicly unavailable by using @RestResource(exported=false)

    @Override
    @RestResource(exported = false)
    <S extends TourPackage> List<S> saveAll(Iterable<S> entities);

    @Override
    @RestResource(exported = false)
    <S extends TourPackage> S save(S entity);

    @Override
    @RestResource(exported = false)
    void deleteById(String s);

    @Override
    @RestResource(exported = false)
    void delete(TourPackage entity);

    @Override
    @RestResource(exported = false)
    void deleteAllById(Iterable<? extends String> strings);

    @Override
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends TourPackage> entities);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
