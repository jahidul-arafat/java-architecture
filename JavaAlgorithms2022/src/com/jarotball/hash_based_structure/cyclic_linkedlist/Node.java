/*
 * Copyright (c) 2022.
 * Jahidul Arafat
 * jahidul.arafat@oracle.com
 *
 * All rights reserved.
 */

package com.jarotball.hash_based_structure.cyclic_linkedlist;

public class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next =null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
