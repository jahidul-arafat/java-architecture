package com.company.into_generics;

import java.util.ArrayList;
import java.util.List;

public class GenericMethodsLosingTypeSafety {
    // Scenario: When Generic methods using <Object> can result in loosing type-safety
    // Step-01: Define 3x arrays
    static Character[] charArray = {'h', 'e', 'l', 'l', 'o'};
    static Integer[] intArray = {1, 2, 3, 4, 5};
    static Boolean[] boolArray = {true, false, true, false, true};

    // Step-02: Create a non-Generic Method to add the respective array into the list
    /*
    * This non-Generic method doesn't safeguard the TypeSafety
    * */
    public static List arrayToList(Object[] array, List<Object> list) {
        for (Object object : array
        ) {
            list.add(object);

        }
        return list;
    }

    public static void main(String[] args) {
        List<Character> charList = arrayToList(charArray, new ArrayList<>());
        List<Boolean> boolList = arrayToList(boolArray, new ArrayList<>());
        //List<Integer> intList = arrayToList(intArray, new ArrayList<>());
        List<String> intList = arrayToList(intArray, new ArrayList<>()); // type-safety is breaking here;
                                                                        // trying to mapping an integer list into a string list and
                                                                        // no compile time error:: ClassCastException. But there will be a runtime error

        System.out.println(intList.get(0));


    }


}
