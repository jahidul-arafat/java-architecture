package com.jarotball.into_fundamentals.project_5_collection_object_comparison;

import com.jarotball.into_fundamentals.project_5_collection_object_comparison.data.Car;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class App {
    public static void main(String[] args) {
//        Car c1 = new Car("BMW", "JA", 1000);
//        Car c2 = new Car("BMW", "JA", 2000);
//        System.out.println(c1==c2); // false because two car are in two different memory location
//
//        var c3 =c1;
//        System.out.println(c1==c3); // true; because both c1 and c3 pointing then same memory location for this car object
//
//        System.out.println(c1.equals(c2)); // false // default equal() basically using == (instance comparison), instead value-based comparison.
//                                           // if we want equals() to use value-based authentication, we have to override it
//                                           // after equals() overriding, true; comparing only the values of <make,model>, not <mileage>


        // create a List of Cars
        List<Car> carCollection = new ArrayList<>(List.of(
                new Car("Tesla", "S", 2000),
                new Car("Subaru", "Impreza", 3000),
                new Car("Honda", "Civic", 4000),
                new Car("Toyota", "Z", 5000),
                new Car("Toyota", "Z", 510000)

        ));


        for (int carCounter = 0; carCounter < carCollection.size()-1; carCounter++) {
            System.out.println(carCollection.get(carCounter).equals(carCollection.get(carCounter+1)));
        }

    }



}
