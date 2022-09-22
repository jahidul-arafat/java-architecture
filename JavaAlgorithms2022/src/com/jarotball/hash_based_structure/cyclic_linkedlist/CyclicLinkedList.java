/*
 * Copyright (c) 2022.
 * Jahidul Arafat
 * jahidul.arafat@oracle.com
 *
 * All rights reserved.
 */

package com.jarotball.hash_based_structure.cyclic_linkedlist;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Create an algorithm that detects a cycle within a linked list
 */

public class CyclicLinkedList {
    Node head;

    public boolean hasCycle() {
        if (head == null) return false;
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        Node currentNode = head;
        while (currentNode.next != null) {
            if (!freqMap.containsKey(currentNode.data)) {
                freqMap.put(currentNode.data, 1);
            } else {
                freqMap.put(currentNode.data, freqMap.get(currentNode.data) + 1);
                if (freqMap.get(currentNode.data) > 1) {
                    return true;
                }
            }
            currentNode = currentNode.next;

        }
        return false;
    }

    // if this is a cyclicLinkedList, then it will never break, an infinite loop will occur
    public void displayLinkedList() {
        HashSet<Integer> hashSet = new HashSet<>();
        if (head == null) return;
        Node currentNode = head;
        while (currentNode != null) {
            if (!hashSet.contains(currentNode.data)){
                hashSet.add(currentNode.data);
                var arrow=(currentNode.next!=null)?" -> ":" -> null";
                System.out.print(currentNode.data + arrow);
                currentNode = currentNode.next;
            } else {
                System.out.println(currentNode.data + ":: Loop Detected!!!");
                return; // to prevent infinite loop in the case the LinkedList having a loop
            }
        }
        System.out.println();

    }

}
