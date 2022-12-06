package com.example.springmicroserviceweb.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

/*
* Lombok are used
* Thereby no need for the followings
* - NoArgument Constructor
* - All Argument Constructor
* - ToString method
* - Getter
* - Setter
* - Object Equality and Hashing
* */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode

public class TourPackage {

    @Id
    private String code; // this is not auto-generated; we have to provide it either in the POST method or in the PUT method

    @Column
    private String name;




}
