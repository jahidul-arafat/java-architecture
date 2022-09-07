package com.company.into_collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * new LinkedHashMap<>(initialCapacity,loadFactor,accessOrder);
 * @param_1 initialCapacity - is the initial capacity of the LinkedHashMap; i.e. 4; but your map could grow beyond;
 * @param_2 loadFactor - if initialCapacity=4 and loadFactor=0.75f, then after adding 3 items into the Map, my map will automatically grow in size to acquire memory
 * @param_3 accessOrder - insertionOrder or mostFrequentlyAccessedItemOrder / false --> default value
 *
 * You want to create a list that is capable of returning the last element that was accessed. What is the correct declaration statement to accomplish this?
 * @solution LinkedHashMap<String, Integer> logbook = new LinkedHashMap(4, 0.75f, true);
 * */

public class LinkedHashMapExample {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> phoneBook = new LinkedHashMap<>();
        //LinkedHashMap<String, Integer> phoneBook = new LinkedHashMap<>(4,.75f,false); // false -> insertionOrder
        //LinkedHashMap<String, Integer> phoneBook = new LinkedHashMap<>(5,.75f,true);  // true  -> MostFrequentAccessOrder

        // Add a number of user <user_name,phone_number> into th HashMap:: phoneBook
        phoneBook.put("Sally",12345);
        phoneBook.put("Billy",23456);
        phoneBook.put("Killy",34567);
        phoneBook.put("Filly",45678);

        // Hashmap allows duplicate keys
        // Update the phone_number of user<Sally>; earlier phone_number of <Sally> will be overwritten.
        phoneBook.put("Sally",19876);

        // print Sally's number;
        // Purpose: to test whether my MostFrequentAccessOrder is working or not
        addASpace();
        System.out.println("Sally's phone number: "+phoneBook.get("Sally"));

        // Hashmap also allows to have null as key
        addASpace();
        phoneBook.put(null,00000);

        // print the HashMap:: phoneBook
        addASpace();
        System.out.println(phoneBook);

        // Print the phonebook details
        addASpace();
        printPhoneBookDetails(phoneBook);

        // Print the phonebook details - Alternative
        addASpace();
        printPhoneBookDetailsAlternative(phoneBook);

        // remove a user from phone book
        addASpace();
        removeAUser(phoneBook);

        // PhoneBook:: After method call
        addASpace();
        System.out.println(phoneBook);

        // PhoneBook: clearing all entries from phone book
        addASpace();
        removeAllEntriesFromPhoneBook(phoneBook);

        // Phone Book after Clearing
        addASpace();
        System.out.println(phoneBook);
    }

    private static void printPhoneBookDetails(LinkedHashMap<String, Integer> phoneBook) {
        // List all the keys of the hashMap
        for (String key: phoneBook.keySet()
        ) {
            if (phoneBook.containsKey(key) && key != null){
                System.out.println(key+" --> "+ phoneBook.get(key));
            } else {
                System.out.println("Invalid/Null Key: "+key);
            }

        }
    }

    private static void printPhoneBookDetailsAlternative(LinkedHashMap<String, Integer> phoneBook) {
        for (Map.Entry<String,Integer> entry:phoneBook.entrySet()
             ) {
            String key = entry.getKey();
            if (key!=null){
                System.out.println(entry.getKey()+" :--> "+entry.getValue());
            } else{
                System.out.println("Invalid/Null Key: "+key);
            }

        }

    }

    private static void removeAUser(LinkedHashMap<String, Integer> phoneBook){
        var sc = new Scanner(System.in);
        System.out.print("Enter user name to be removed: ");
        String userName = sc.nextLine();
        if (phoneBook.containsKey(userName)){
            phoneBook.remove(userName);
        } else{
            System.out.println(String.format("User <%s> doesnt exist",userName));
        }
    }

    private static void addASpace() {
        System.out.println();
    }

    public static void removeAllEntriesFromPhoneBook(LinkedHashMap<String,Integer> phoneBook) {
        System.out.println("Clearing the Phone Book ...");
        phoneBook.clear();
    }
}
