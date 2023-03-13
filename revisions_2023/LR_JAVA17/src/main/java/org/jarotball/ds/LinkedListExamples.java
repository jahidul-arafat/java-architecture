package org.jarotball.ds;

import java.util.*;

public class LinkedListExamples {
    public static void main(String[] args) {
        // Create a simple Double LinkedList of shopping elements
        LinkedList<String> shoppingList = new LinkedList<>();
        shoppingList.add("apple");
        shoppingList.add("banana");
        shoppingList.add("pear");

        // printing the shoppingList items
        shoppingList.stream()
                .forEach(System.out::println);

        shoppingList.add(1,"mango");
        System.out.println(shoppingList);

        shoppingList.removeFirst();
        System.out.println(shoppingList);

        ArrayList<String> demoArrayList = new ArrayList<>();

        /* LinkedList is not synchronized by nature.
            - good for performance and memory
            - bad, as it's not Thread Safe. Multiple thread if accessing the list at the same time, might overwrite each other's changes
         */
        // Create a new List and convert the LinkedList into a synchronized list
        List<String> synchronizedShoppingList = Collections.synchronizedList(shoppingList);
        System.out.println(synchronizedShoppingList);
        synchronizedShoppingList.add(0,"bel");
        System.out.println(synchronizedShoppingList);

        synchronizedShoppingList.addAll(1,List.of("fruit1","fruit2"));
        System.out.println(synchronizedShoppingList);
        System.out.println(synchronizedShoppingList.get(2));






    }
}
