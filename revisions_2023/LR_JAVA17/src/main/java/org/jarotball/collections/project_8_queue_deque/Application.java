package org.jarotball.collections.project_8_queue_deque;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.*;

public class Application {
    public static <E> void printPriorityQueue(@NotNull Queue<E> priorityQueue){
        E item;
        while ((item=priorityQueue.poll())!=null){
            System.out.println(item);
        }
    }

    public static @NotNull String msgGenerator(String msg){
        return msg+ "@"+LocalDateTime.now();
    }

    public static<E> void printDeque(@NotNull Deque<E> deque){
        E item;
        int counter=0;
        while ((item=deque.poll())!=null){
            System.out.format("%s: %s %s%n",
                    counter,
                    item,
                    counter==0?"(Top)":""
                    );
            counter+=1;
        }
    }
    public static void main(String[] args) {
        // Stack - LIFO
        Deque<String> stack = new ArrayDeque<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.addAll(List.of("I","J","K","L"));
        stack.push("D");
        stack.addFirst("First");
        stack.addLast("Last");
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.poll()); // poll throws no exception if no elements exists in the list
        System.out.println(stack);
        System.out.println(stack.pop()); // pop throws exception if no elements exists in the list
        System.out.println(stack);
        System.out.println("n------------------------------\n");


        // Queue - FIFO
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("A");   // offer() and add() works similar. offer() -> throws no exception if the capacity limit reached
        queue.add("B");         // add() throws error if capacity limit raises
        queue.offer("C");
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println("n------------------------------\n");

        // LinkedList as Queue
        Queue<String> linkedlist = new LinkedList<>();
        linkedlist.offer("A");
        linkedlist.offer("B");
        linkedlist.offer("C");
        System.out.println(linkedlist);
        System.out.println(linkedlist.peek());
        linkedlist.addAll(Arrays.asList("I","J","K"));
        System.out.println(linkedlist);
        System.out.println(linkedlist.poll());
        System.out.println(linkedlist);

        System.out.println("n------------------------------\n");

        // PriorityQueue Implementation
        // Way-01: To create a Descending Order PriorityQueue
        // Queue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        // Way-02: To create a Descending Order PriorityQueue
        Queue<Integer> priorityQueue = new PriorityQueue<>((a,b)-> b-a);

        priorityQueue.add(10);
        priorityQueue.add(20);
        priorityQueue.add(15);
        priorityQueue.add(5);
        priorityQueue.add(-5);
        priorityQueue.add(45);
        printPriorityQueue(priorityQueue);
        System.out.println("n------------------------------\n");



        // Deque Concept
        // Implement a Mobile Phone Message System
        // Last message will always show at First and Read First
        // LIFO
        Deque<String> msgStack = new ArrayDeque<>();
        msgStack.push(msgGenerator("msg1"));
        msgStack.push(msgGenerator("msg2"));
        msgStack.push(msgGenerator("msg3"));
        msgStack.push(msgGenerator("msg4"));

        printDeque(msgStack);







    }

}
