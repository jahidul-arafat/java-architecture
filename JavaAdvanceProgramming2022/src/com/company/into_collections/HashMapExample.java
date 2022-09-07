package com.company.into_collections;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Hashmap doesn't guarantee the Order
 * Solution: LinkedHashMap
 * @see LinkedHashMapExample
 * */
public class HashMapExample {
    public static void main(String[] args) {
        HashMap<String, Integer> phoneBook = new HashMap<>();

        // Add a number of user <user_name,phone_number> into th HashMap:: phonezBook
        phoneBook.put("Sally",12345);
        phoneBook.put("Billy",23456);
        phoneBook.put("Killy",34567);
        phoneBook.put("Filly",45678);

        // Hashmap allows duplicate keys
        // Update the phone_number of user<Sally>; earlier phone_number of <Sally> will be overwritten.
        phoneBook.put("Sally",19876);

        // Hashmap also allows to have null as key
        addASpace();
        phoneBook.put(null,00000);

        // print the HashMap:: phoneBook
        addASpace();
        System.out.println(phoneBook);

        // Print the phonebook details
        addASpace();
        printPhoneBookDetails(phoneBook);

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

    private static void printPhoneBookDetails(HashMap<String, Integer> phoneBook) {
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

    private static void removeAUser(HashMap<String, Integer> phoneBook){
        Scanner sc = new Scanner(System.in);
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

    public static void removeAllEntriesFromPhoneBook(HashMap<String,Integer> phoneBook) {
        System.out.println("Clearing the Phone Book ...");
        phoneBook.clear();
    }


}
