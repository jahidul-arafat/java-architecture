package com.company.into_collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {
        // Define a linkedlist of Generic Type: String
        LinkedList<String> myList = new LinkedList();

        // Add several elements into the LinkedList;
        // use .add(String) and .add(index, String) methods
        myList.add("A");
        myList.add("B");
        myList.add(1,"C");
        System.out.println(myList);

        // add some element at first and at last
        myList.addFirst("FirstA");
        myList.addLast("LastB");
        System.out.println(myList);

        // Remove some elements from LinkedIn
        myList.remove("C");
        System.out.println(myList);

        // Remove the first and last element
        myList.removeFirst();
        myList.removeLast();
        System.out.println(myList);



        // Define a Simple List of type String
        List<String> myList2 = new ArrayList<>();
        myList2.add("A");
        myList2.add("B");
        myList2.add(1,"C");
        System.out.println(myList2);


    }
}
