package org.example.playground.challenges.challenge_1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CarSimulator {
    public static void main(String[] args) {
        // create an array of 5 car objects
        Car[] carsArray = {
                new Car("Chevy", "red", 4500.0),
                new Car("Ford", "blue", 4500.0),
                new Car("Toyota", "grey", 4500.0),
                new Car("Lamborghini", "blue", 4500.0),
                new Car("Renault", "blue", 4500.0),
                new Car("Renault", "valvet", 9000.0)

        };

        List<Car> carList = Arrays.asList(carsArray);
        // get the list of unique car makers
        Function<Car, String> carMakerGrapperFunction = car -> car.getMake();
        Set<String> carMakerList = carList.stream()
                //.map(carMakerGrapperFunction)
                .map(Car::getMake)// using method reference, instead of Function; however could be done in both ways
                .collect(Collectors.toSet());
        System.out.printf("List of unique car makers: %s%n",carMakerList);

        // get the list of all blue colored cars
        Predicate<Car> carColorPredicate = car -> car.getColor().equalsIgnoreCase("blue");
        List<Car> blueColoredCarList = carList.stream()
                //.map(carColorGrapperFunction)
                //.map(Car::getColor)// using method reference, instead of Function; however could be done in both ways
                .filter(carColorPredicate)
                .toList();
        System.out.printf("List of all blue colored cars: %s%n",blueColoredCarList);

        // count the number of blue colored cars
        var blueColoredCarCount = carList.stream()
                .map(Car::getColor)
                .filter(color -> color.equalsIgnoreCase("blue"))
                .count();
        System.out.println("Blue colored cars count: " + blueColoredCarCount);

        // get the list of makers of all blue colored cars
        List<String> blueColoredCarMakerList = carList.stream()
                .filter(car -> car.getColor().equalsIgnoreCase("blue"))
                .map(Car::getMake)
                .toList();
        System.out.println("Blue colored cars maker list: " + blueColoredCarMakerList);

        // get the average price of all car
        Double averagePrice = carList.stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0.0);
        System.out.println("Average price of all cars: " + averagePrice);

        // get the highest price of all cars and return the Car object with the highest price
        Car highestPriceCar = carList.stream()
                .max(Comparator.comparing(Car::getPrice))
                .orElse(null);
        System.out.println("Highest price of all cars: " + highestPriceCar);

        // get the lowest price of all cars and return the Car object with the lowest price
        Car lowestPriceCar = carList.stream()
                .min(Comparator.comparing(Car::getPrice))
                .orElse(null);
        System.out.println("Lowest price of all cars: " + lowestPriceCar);
    }
}
