package com.example.springmicroserviceweb.repositories;

import com.example.springmicroserviceweb.domain.TourPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourPackageRepository extends JpaRepository<TourPackage, String> {
}
