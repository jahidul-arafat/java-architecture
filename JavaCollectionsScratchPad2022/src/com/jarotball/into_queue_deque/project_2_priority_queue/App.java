package com.jarotball.into_queue_deque.project_2_priority_queue;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Arrays.compare;
import static java.util.Arrays.sort;

public class App {
    public static void main(String[] args) {
        // Dont print the PriorityQueue? Why
        // Because, PriorityQueue inherits its toString method, which doesnt know about sort orders.
        // Thus try to poll the elements from the queue; you will get the correct order
        // 45 30 20 15 10 5 -5 []
        Queue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);
        pq.offer(10);
        pq.offer(15);
        pq.offer(20);
        pq.offer(30);
        pq.offer(5);
        pq.offer(-5);
        pq.offer(45);

        // Correct way to get whether items are sorted in PriorityList
        Integer i;
        while ((i = pq.poll())!= null){
            System.out.println(i+" ");
        }
        // pq.stream().forEach(System.out::println); // not a correct way to get the list of items in the PriorityQueue

        // System.out.println(pq);  // not a correct way to get the list of items in the PriorityQueue
    }

}
