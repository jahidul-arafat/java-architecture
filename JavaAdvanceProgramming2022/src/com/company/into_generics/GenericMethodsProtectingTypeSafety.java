package com.company.into_generics;

import java.util.ArrayList;
import java.util.List;

public class GenericMethodsProtectingTypeSafety {
    // Scenario: When Generic methods using <Object> can result in loosing type-safety
    // Step-01: Define 3x arrays
    static Character[] charArray = {'h', 'e', 'l', 'l', 'o'};
    static Integer[] intArray = {1, 2, 3, 4, 5};
    static Boolean[] boolArray = {true, false, true, false, true};

    // Step-02: Create a non-Generic Method to add the respective array into the list
    /*
    * This Generic method safeguard the TypeSafety
    * public static <newTypeVar:T|only_have_local_scope:: in the method signature + inside this particular method>
    * public static <T> List arrayToList(T[] array, List<T> list) - This <T> ensures type-safety
    * */
    public static <T> List arrayToList(T[] array, List<T> list) {
        for (T object : array
        ) {
            list.add(object);
        }
        return list;
    }

    public static void main(String[] args) {
        List<Character> charList = arrayToList(charArray, new ArrayList<>());
        List<Boolean> boolList = arrayToList(boolArray, new ArrayList<>());

        List<Integer> intList = arrayToList(intArray, new ArrayList<>());
        //List<String> intList = arrayToList(intArray, new ArrayList<>());  // use of Generic Type <T> ensures typesafety
                                                                             // Will throw compile time error
        System.out.println(intList.get(3));


    }


}
