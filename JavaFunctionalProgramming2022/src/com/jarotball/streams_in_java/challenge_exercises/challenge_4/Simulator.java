package com.jarotball.streams_in_java.challenge_exercises.challenge_4;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Simulator {
    public static void main(String[] args) {
        // Create planet
        Planet[] planetArray = {
                new Planet("Mercury",5.43, false,0),
                new Planet("Venus",5.24, false,0),
                new Planet("Earth",5.52, false,1),
                new Planet("Mars",3.940, false,2),
                new Planet("Jupiter",1.33, true,80),
                new Planet("Saturn",0.70, true,83),
                new Planet("Uranus",1.30, true,27),
                new Planet("Neptune",1.76, true,14),
        };

        // Convert the array into list
        List<Planet> planetList = Arrays.asList(planetArray);

        // Problem_1: Find all planets starting with 'M'
        Function<Planet, String> getPlanetName = (planet)-> planet.getName();
        var planetsStartingM= planetList
                .stream()
                .filter((planet)-> planet.getName().startsWith("M"))
                .map(getPlanetName)
                .collect(Collectors.toList());
        System.out.println(planetsStartingM);

        // Problem_2: Find all planets have rings
        var planetHavingRing = planetList
                .stream()
                .filter((planet)-> planet.isHasRings()==true)
                .map(getPlanetName)
                .collect(Collectors.toList());
        System.out.println(planetHavingRing);

        // Problem_3: Find all planets with density >5
        var planetsDensityGT5 = planetList
                .stream()
                .filter(planet -> planet.getDensity()>5d)
                .map(getPlanetName)
                .collect(Collectors.toList());
        System.out.println(planetsDensityGT5);

        // Problem_4: Final all planets having more than 3 moons
        var planetsMoonGT3 = planetList
                .stream()
                .filter(planet -> planet.getNumOfMoons()>3)
                .map(getPlanetName)
                .collect(Collectors.toList());
        System.out.println(planetsMoonGT3);

    }
}
