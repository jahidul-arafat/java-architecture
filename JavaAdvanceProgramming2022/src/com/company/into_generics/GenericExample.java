package com.company.into_generics;

import java.util.ArrayList;
import java.util.List;

public class GenericExample {
    public static void main(String[] args) {
        // write your code here
        // List with explicit Generic: T
        List<String> nameList = new ArrayList<>();
        nameList.add("Jahidul");
        nameList.add("Arafat");
        // nameList.add(8);     // Error-01
        displayItemDetails(nameList, "Into the Generic/String/List");

        // List without explicit Generic: T
        List nameList2 = new ArrayList();
        nameList2.add("A");
        nameList2.add(7);
        displayItemDetails(nameList2, "Into The non-Generic/List");

        // List with explicit Generic: T -- Integer
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            intList.add(i);
        }

        displayItemDetails(intList, "Into the Generic/Integer/List");

    }

    private static void displayItemDetails(List sampleList, String prompt) {
        System.out.println(prompt);
        for (var item : sampleList
        ) {
            System.out.println(item);

        }
        System.out.println();
    }
}
