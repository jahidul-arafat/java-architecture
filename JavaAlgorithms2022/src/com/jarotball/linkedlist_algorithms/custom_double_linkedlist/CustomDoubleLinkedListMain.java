/*
 * Copyright (c) 2022.
 * Jahidul Arafat
 * jahidul.arafat@oracle.com
 *
 * All rights reserved.
 */

package com.jarotball.linkedlist_algorithms.custom_double_linkedlist;

public class CustomDoubleLinkedListMain {
    public static void main(String[] args) {
        // create an CustomDoubleLinkedList
        CustomDoubleLinkedList demoDLL = new CustomDoubleLinkedList();

        //populate the linkedlist
        NodeD firstNode = new NodeD("A");
        NodeD secondNode = new NodeD("B");
        NodeD thirdNode = new NodeD("C");
        NodeD fourthNode = new NodeD("D");
        NodeD fifthNode = new NodeD("E");

        // set the head of the linkedlist to firstNode
        demoDLL.setHead(firstNode);

        // chaining the linkedlist
        firstNode.setNext(secondNode);
        secondNode.setPrev(firstNode); secondNode.setNext(thirdNode);
        thirdNode.setPrev(secondNode); thirdNode.setNext(fourthNode);
        fourthNode.setPrev(thirdNode); fourthNode.setNext(fifthNode);
        fifthNode.setPrev(fourthNode);

        // print the linkedlist
        System.out.println(demoDLL);

        // Add an item at the front of the list
        //demoDLL.push("F");
        //System.out.println(demoDLL);

        // insert a new Node after a given node
        //demoDLL.insertAfter(thirdNode,"E");
        //System.out.println(demoDLL);

        // append a new Node at the end
        //demoDLL.append("G");
        //System.out.println(demoDLL);

        // insert a new Node efore a given node
        //demoDLL.insertBefore(thirdNode,"k");
        //System.out.println(demoDLL);

        // insert at a specific position
        //demoDLL.insertAtPos(8,"K");
        //System.out.println(demoDLL);

        // Delete a node
        demoDLL.deleteNode(firstNode);  // delete first node
        demoDLL.deleteNode(fifthNode);  // delete last node
        demoDLL.deleteNode(thirdNode);  // delete third node or any node not the first/last node
        demoDLL.deleteNode(new NodeD("J")); // delete a node not in the linkedlist
        System.out.println(demoDLL);

    }
}
