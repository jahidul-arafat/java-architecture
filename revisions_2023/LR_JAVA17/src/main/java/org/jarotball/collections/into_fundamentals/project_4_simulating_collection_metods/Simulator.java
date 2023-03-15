package org.jarotball.collections.into_fundamentals.project_4_simulating_collection_metods;

import org.jarotball.collections.into_fundamentals.project_1_london_hotel.Room;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Simulator {
    public static void main(String[] args) {
        // Step-01: Create a Collection object and add some value - Duplicate values are allowed
        Collection<String> collection1 = new ArrayList<>();
        collection1.add("A");
        collection1.add("A");
        collection1.add("B");
        collection1.add("C");

        // 1.1 Print the collection
        System.out.println(collection1);

        // 1.2 Count
        System.out.println(collection1.size());

        // 1.3 Convert to lowercase
        var lowerLetters= collection1.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        System.out.println(lowerLetters);

        // Step-02: Create another Collection object, Duplicate values not allowed
        Collection<String> collection2 = new HashSet<>();
        collection2.add("A");
        collection2.add("A");
        collection2.add("B");
        collection2.add("C");

        System.out.println(collection2);

        // Step-03: Bulk insert into the Collection- Duplicate Values not allowed
        Collection<String> collection3 = new HashSet<>();
        collection3.addAll(List.of("a","b","c","d","e","a"));
        System.out.println(collection3);

        collection3.clear();
        System.out.println(collection3);

        // Diversed Collection
        Collection diversedCollection = new ArrayList(List.of(
                "a",
                10,
                new Room("Bob", "5Star",4,176d)
        ));

        diversedCollection.stream()
                .forEach(element-> System.out.println(element.getClass()));




    }



}
