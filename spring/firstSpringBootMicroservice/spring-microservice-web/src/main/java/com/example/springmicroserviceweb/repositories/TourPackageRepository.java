package com.example.springmicroserviceweb.repositories;

import com.example.springmicroserviceweb.domain.TourPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TourPackageRepository extends JpaRepository<TourPackage, String> {
    Optional<TourPackage> findByName(String pkgName);
    // in the TourService, when creating a new tour, tour has a dependency of tourPackage (must be already exists)
    // in the create a new tour section in TourService, we not gonna enter the tourPackage code, instead tourPackageName
    // by default, JpaRepository doesnt has anything for the query call with the tourPackageName ior nothing like findByName()
    // instead it has findById() which is not applicable in our case
    // so, the solution is, define an abstract method named findByName(String pkgName) which may either query return somethign or nothing.
    /// thats why the return type is defined as Optional
}
