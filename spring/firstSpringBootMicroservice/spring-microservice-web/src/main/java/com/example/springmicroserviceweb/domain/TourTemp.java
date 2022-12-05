package com.example.springmicroserviceweb.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TourTemp {
    // Creating a new Object Type: TourTemp, which reassemble the Domain/Model: Tour
    // This TourTemp will read the JSON input file where customer provides us all the tour information and attributes
    // We will read that file and create a new Tour
    private String packageType, title, description, blurb, price, length,
            bullets, keywords, difficulty, region;

    // Class Method
    // Why you are returning TourTemp object type instead directly returning Tour
    // Because, there tour packageType read as String from the JSON file, Tour required packageType to be TourPackage, not String
    // Even tour service when creating a tour require the packageType to be in String format
    // it then check if that package is already available, else it creates a new tourPackage object with that String packageType
    // and then finally trigger the createTour
    public static List<TourTemp> loadToursFromJson(String fileToImport) throws IOException {
        return new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
                .readValue(new FileInputStream(fileToImport), new TypeReference<List<TourTemp>>() {});
    }

    // Getter - Formatting the Price, Difficulty and Region
    public Integer getPrice() {
        return Integer.parseInt(price);
    }

    public Difficulty getDifficulty() {
        return Difficulty.valueOf(difficulty);
    }

    public Region getRegion() {
        return Region.findByLabel(region);
    }
}
