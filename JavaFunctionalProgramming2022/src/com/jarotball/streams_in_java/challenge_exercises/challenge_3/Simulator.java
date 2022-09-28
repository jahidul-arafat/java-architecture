package com.jarotball.streams_in_java.challenge_exercises.challenge_3;

import java.util.*;
import java.util.stream.Collectors;

public class Simulator {
    public static void main(String[] args) {
        // Create 6x Country
        Country[] countryArray = {
                new Country("Bangladesh"),
                new Country("Australia"),
                new Country("Newzeland"),
                new Country("India"),
                new Country("Croatia"),
                new Country("Indonasia"),
                new Country("Iran")
        };

        // Convert the array into list
        List<Country> countryList = Arrays.asList(countryArray);
        System.out.println(countryList);

        /**
         * Problem_01: Get the list of all Countries CAPITALIZED, Sorted except the countries starting with "I"
         * */

        // 1. A Non-Functional Approach
        // 1.1 Get the list of all countries
        List<String> countryNameList =new ArrayList<>();
        for (Country country:countryList
             ) {
            countryNameList.add(country.getName());
        }

        // 1.2 Sort them in ascending order; Collections.sort() cant be applied on a list of Object, instead on a list of String, int etc
        Collections.sort(countryNameList);
        System.out.println(countryNameList);

        // 1.3 Iterate through each countryName, then CAPITALIZE and then filter those starting with "I"
        List<String> output = new ArrayList<>();
        for (String countryName: countryNameList
             ) {
            if (!countryName.startsWith("I")){
                output.add(countryName.toUpperCase());
            }
        }

        System.out.println(output);

        // 2. A functional Approach
        var sortedFilteredCountryList = countryList
                .stream()
                .filter((country)-> !country.getName().startsWith("I"))
                .map((country)-> country.getName().toUpperCase()) // returns a list of countryName
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedFilteredCountryList);

    }
}
