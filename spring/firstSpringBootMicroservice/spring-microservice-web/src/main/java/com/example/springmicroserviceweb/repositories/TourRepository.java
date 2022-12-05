package com.example.springmicroserviceweb.repositories;

import com.example.springmicroserviceweb.domain.Tour;
import com.example.springmicroserviceweb.domain.TourPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TourRepository extends JpaRepository<Tour, Integer> {
}
