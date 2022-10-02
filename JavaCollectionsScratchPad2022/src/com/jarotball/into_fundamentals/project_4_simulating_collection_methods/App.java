package com.jarotball.into_fundamentals.project_4_simulating_collection_methods;

import com.jarotball.into_fundamentals.project_1_london_hotel.data.Room;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        // Step-01: Create a Collection object
        // 1.1 of Type: List - Duplicate value allowed here
        Collection<String> collection1 = new ArrayList<>();
        collection1.add("A");
        collection1.add("A"); // trying to add duplicate value
        collection1.add("B");
        collection1.add("C");

        // 1.1.1 print the collection
        System.out.println(collection1);

        // 1.1.2 count the number of elements in the collection
        var output = collection1
                .stream()
                .collect(Collectors.counting());

        System.out.println(output);
        System.out.println(collection1.size()); // a shorthand way to get the number of elements in the collection

        // 1.1.3 let's lowercase all the collection elements
        var lowerLetters = collection1
                .stream()
                .map(String::toLowerCase) // using method reference ::, instead traditional mapping
                .collect(Collectors.toList());

        System.out.println(lowerLetters);

        // 1.2 of Type: Set - Duplicate value not allowed in set
        Collection<String> collection2 = new HashSet<>();
        collection2.add("A");
        collection2.add("A");   // trying to add a duplicate value into set;
                                // this will not throw an error; but meantime will not add any duplicate element into the Collection

        System.out.println(collection2);

        // 1.3 Bulk insert into collection
        Collection<String> collection3 = new HashSet<>();
        collection3.addAll(List.of("a","b","c","d","e","a"));
        System.out.println(collection3);


        // Step-2: Remove some elements from collection
        // boolean remove(Object o)
        // 2.1 Remove a single item from collection
        collection3.remove("a"); // returns true
        System.out.println(collection3.remove("b")); // returns true
        System.out.println(collection3);

        // 2.2 Bulk remove from collection
        collection3.removeAll(List.of("a","b","c"));
        System.out.println(collection3);

        // 2.3 remove all items from collection
        collection3.clear();
        System.out.println(collection3);

        // 2.4 Retain some elements of the collection and delete rest
        // boolean retainAll()
        collection3.addAll(List.of("a","b","c","d","e","f"));
        //collection3.retainAll(List.of("a","d","f")); // means retain [a,d,f] and delete [b,c,e]
        System.out.println(collection3); // [a,d,f]

        // Step-3: Inspecting
        // 3.1 Check if a specific list of elements could be found in the collection
        System.out.println(collection3.contains("a"));
        System.out.println(collection3.containsAll(List.of("a","d","f")));

        // 3.2 Check if a collection isEmpty or not;
        // isEmpty(); returns boolean
        System.out.println(collection3.isEmpty()); // false

        // 3.3 Get the size of the collection
        System.out.println(collection3.size());

        // Step-4: Create a collection with different types of values
        // Note: this is a bad practice not to define the Collection Generic Type
        Collection diversedCollection = new ArrayList();
        diversedCollection.add("A");
        diversedCollection.add(10);
        diversedCollection.add(new Room("TollyRoom", "5star", 5,13000));
        System.out.println(diversedCollection);

        // 4.1 Get the class of the elements inside our collection
        diversedCollection
                .stream()
                .forEach(element-> System.out.println(element.getClass()));







    }
}
