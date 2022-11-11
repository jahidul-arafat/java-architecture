package com.example.springprojectzero.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// This is a Java Bean
@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {
    // interface attributes are Class Attributes
    String name= "Guest Repository Interface for Data<Guest>"; // default is public, static, final
}
