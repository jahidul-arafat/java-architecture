package org.jarotball.collections.into_fundamentals.project_5_collection_object_comparison;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Simulator {
    public static void main(String[] args) {
//        Car c1 = new Car("BMW", "2018", 1000);
//        Car c2 = new Car("BMW", "2018", 2000);
//        System.out.println(c1.equals(c2));
//        var c3= c1;
//        System.out.println(c3==c1);

        List<Car> carCollection = new ArrayList<>(List.of(
                new Car("Tesla", "S", 2000),
                new Car("Subaru", "Impreza", 3000),
                new Car("Honda", "Civic", 4000),
                new Car("Toyota", "Z", 5000),
                new Car("Toyota", "Z", 510000)
        ));

        for (int carCount=0; carCount<carCollection.size()-1;carCount++){
            System.out.println(carCollection.get(carCount).equals(carCollection.get(carCount+1)));
        }
    }
}
