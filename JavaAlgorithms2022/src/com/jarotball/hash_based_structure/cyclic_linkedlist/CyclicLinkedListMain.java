/*
 * Copyright (c) 2022.
 * Jahidul Arafat
 * jahidul.arafat@oracle.com
 *
 * All rights reserved.
 */

package com.jarotball.hash_based_structure.cyclic_linkedlist;

public class CyclicLinkedListMain {
    public static void main(String[] args) {
        CyclicLinkedList noCyclicLinkedList = new CyclicLinkedList();

        // Create 4x nodes
        Node firstNode = new Node(5);
        Node secondNode = new Node(4);
        Node thirdNode = new Node(3);
        Node fourthNode = new Node(2);
        Node fifthNode = new Node(1);


        noCyclicLinkedList.head = firstNode;
        firstNode.next=secondNode;
        secondNode.next=thirdNode;
        thirdNode.next=fourthNode;
        fourthNode.next=fifthNode;
        //fifthNode.next=secondNode; // uncomment it to make the linkedlist cyclic

        noCyclicLinkedList.displayLinkedList();
        System.out.println("Has Cycle? "+noCyclicLinkedList.hasCycle());

    }
}
