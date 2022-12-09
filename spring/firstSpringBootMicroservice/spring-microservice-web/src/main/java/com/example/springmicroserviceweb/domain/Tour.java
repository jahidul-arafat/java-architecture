package com.example.springmicroserviceweb.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Tour {

    // Tour Main Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;     // this is auto-generated; we dont need to provide it

    @Column()
    private String title;

    @Column(length = 2000)
    private String description; // short description

    @Column( length = 4000)
    private String blurb;       // long description

    @Column
    private Integer price;

    @Column
    private String duration;

    @Column(length = 2000)
    private String bullets;

    @Column
    private String keywords;

    // Tour Entity-Relationship attributes
    // Entity-Relationship-Attribute-01
    // Tour Have a Many-to-One relationship with TourPackage
    // Multiple Tour can be in a Tour package
    @ManyToOne
    private TourPackage tourPackage; // tourPackageCode will come in the table as the in the Tour Table, tourPackageCode is marked to be the Foreign Key to map to TourPackage repository

    // Tour Enumerated Attributes
    // Enumerated Attribute-01: Tour belongs to which Region
    @Column
    @Enumerated
    private Region region;

    // Enumerated Attribute-02: Tour Difficulty level
    @Column
    @Enumerated
    private Difficulty difficulty;

    // Constructor
    // this is not an AllArgument Constructor
    // The main purpose of creating this constructor is to create a new Tour in the TourService
    public Tour(String title, String description, String blurb, Integer price, String duration,
                String bullets, String keywords, TourPackage tourPackage, Region region, Difficulty difficulty) {
        this.title = title;
        this.description = description;
        this.blurb = blurb;
        this.price = price;
        this.duration = duration;
        this.bullets = bullets;
        this.keywords = keywords;
        this.tourPackage = tourPackage;
        this.region = region;
        this.difficulty = difficulty;
    }



    // object equality check

}
