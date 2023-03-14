package org.jarotball.oop.challenge.phonecontacts;

import org.jetbrains.annotations.NotNull;

public class Contact {
    private String name, address;

    // Compile Time polymorphism - Different ways to take input into the Contract() constructor
    // Constructors
    // Constructor-01 - Base Constructor
    public Contact(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Print the object
    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
