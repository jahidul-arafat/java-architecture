package com.company.into_collections;

import com.company.models.Customer;

import java.util.LinkedList;

/**
 * Queue is First-In First-Out data structure
 */
public class QueueExample {

    public static void main(String[] args) {
        // create a queue
        // there are several classes in JAVA API that implements the QUEUE interface; LinkedList is one of them
        LinkedList<Customer> queue = new LinkedList<>();

        // add several customers into the queue
        queue.add(new Customer("Sally"));
        queue.add(new Customer("Billy"));
        queue.add(new Customer("Killy"));
        queue.add(new Customer("Filly"));

        // print the queue list
        System.out.println("Existing Customers: "+queue);

        serverTheCustomer(queue);

        // print the customer remains
        System.out.println("Customer Remains: "+queue);

    }

    private static void serverTheCustomer(LinkedList<Customer> queue) {
        // poll the first customer and serve him/her
        // use .poll() method, that pull the customer First-In and Delete it from the queue
        Customer c =  queue.poll();
        c.serve();
    }


}
