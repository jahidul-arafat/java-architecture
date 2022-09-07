package com.company.models;

import java.util.List;

/**
 * @module Customer
 * @author  Jahidul Arafat
 * @see     List
 * @see java.util.LinkedList
 * @since 1.2
 * @param - hasBeenServed boolean, to check if the customer is served or not
 * @param - name the name of the customer, String
 * */
public class Customer {
    private boolean hasBeenServed;
    private String name;

    public Customer(String name) {
        hasBeenServed = false;
        this.name = name;
    }

    public void serve(){
        hasBeenServed = true;
        System.out.println(name + " has been served!!");
    }

    @Override
    public String toString() {
        return name;
    }
}
