/*
 * Copyright (c) 2022.
 * Jahidul Arafat
 * jahidul.arafat@oracle.com
 *
 * All rights reserved.
 */

package com.jarotball.linkedlist_algorithms.custom_linkedlist;

import java.util.ArrayList;

public class CustomLinkedListMain {
    /**
     * Create a CustomLinkedList - it has an empty constructor
     *
     * */
    public static void main(String[] args) {
        // An arrayList of Type:Node, a collection of nodes
        ArrayList<Node> nodeCollections = new ArrayList<>();
        CustomLinkedList demoCustomLL = new CustomLinkedList();

        // populate and chaining Nodes
        populateLinkedList(0,nodeCollections, demoCustomLL);

        // create 4 nodes
//        Node firstNode = new Node(10);
//        Node secondNode = new Node(11);
//        Node thirdNode = new Node(12);
//        Node fourthNode = new Node(13);
//        Node fifthNode = new Node(14);

        // lets chaining the nodes
        //demoCustomLL.head = firstNode;
        //firstNode.next = secondNode;
        //secondNode.next = thirdNode;
        //thirdNode.next = fourthNode;
        //fourthNode.next = fifthNode;

        // printing the custom linkedlist
        //System.out.println(demoCustomLL); // will not print the list nodes // instead will print the object
                                          // Note. Our CustomLinedList class is not part of collection interface.
                                          // thats why we need to implement a print method for the customLinkedList

        // using the customLinkedList's newly created printMethod<displayContents>
        demoCustomLL.displayContents();

        // delete the backhalf of linkedlist
        // backhalf = modNode+restFollowing
        //demoCustomLL.deleteBackHalf();
        demoCustomLL.deleteKthNode(0);
        demoCustomLL.displayContents();

    }

    public static void populateLinkedList(int numOfItems, ArrayList<Node> nodeCollections,
                                          CustomLinkedList demoCustomLL){
        for (int i = 0; i < numOfItems; i++) {
            Node newNode = new Node(i+10);
            nodeCollections.add(newNode);
        }

        // chaining the nodes
        // set the head of linkedlist
        try {
            demoCustomLL.head= nodeCollections.get(0);  // will raise IndexOtOfBoundException if LL is empty
        } catch (IndexOutOfBoundsException e){
            System.out.println("LinkedList is Empty");
            return;
        }


        // next of th last node will be null
        for (int i = 0; i < nodeCollections.size()-1; i++) {
            nodeCollections.get(i).next = nodeCollections.get(i + 1);
        }
    }
}
