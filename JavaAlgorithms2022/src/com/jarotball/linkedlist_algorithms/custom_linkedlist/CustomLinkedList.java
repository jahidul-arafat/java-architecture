/*
 * Copyright (c) 2022.
 * Jahidul Arafat
 * jahidul.arafat@oracle.com
 *
 * All rights reserved.
 */

package com.jarotball.linkedlist_algorithms.custom_linkedlist;

/**
 * CustomLinkedList is not part of Collection Interface
 * That's why we need to implement a print method
 */
public class CustomLinkedList {
    public Node head;

    /**
     * (should not be) 11->12->13->14->  (see extra "->" appears at tail)
     * (correct)       11->12->13->14    (no extra "->" at tail)
     * Strategy: check if the current.next is Null or not. Print an "->" only if the current.next is not Null.
     */
    public void displayContents() {
        Node current = head;        // start with the head node and keeps track what node next
        while (current != null) {    // Loop until there are no next node;
            // this can be done by checking if the current_node has a nextNode.
            // If so, iterate, else stop.
            // Hence, we stopped just before the Null Node, it will avoid NullPointerException
            String arrow = (current.next != null) ? "->" : "";
            System.out.print(current.data + arrow);
            current = current.next;
        }
        System.out.println();

    }


    /**
     * Delete BackHalf of LinkedList
     * While condition checks only the fast node, not the slow node; because node<slow> will always be behind node<fast>
     * backhalf = middle node + rest
     * <p>
     * Input:                       11->12->13->14->15
     * after deleting backhalf:     11->12  (see middlenode 13 and rest are deleted)
     * <p>
     * <p>
     * Input: 1->null     (here, head.NEXT=NULL)
     * <p>
     * <p>
     * in[ut: no_element  (here, head is NULL)
     *
     * Ref: https://www.geeksforgeeks.org/delete-nth-node-from-the-end-of-the-given-linked-list/
     */

    public void deleteBackHalf() {

        // one element or no element
        if (head == null || head.next == null) {
            return; // since only one element or no element in linkedlist, nothing to delete; just return;

        }

        Node slow = head;
        Node fast = head;
        Node prev = null; // node<prev> will reach just behind node<slow>

        // 11->12->13->14->15->NULL
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = null; // will delete middle +rest
        // this will raise an NullPointerException if LL has only one element or no element
        // to avoid so, exit the ops if only one element
    }

    // this algorithm failed to delete the first element

    /**
     * list =              [10 11 12 13 14] k=5 (means delete 5th element from last which is 10)
     * output (expected) = [11 12 13 14]
     * output (got)      = [10 11 12 13 14]
     */
    public void deleteKthNode(int k) {

        // base case
        // if list is empty, nothing to delete; just return
        // if k==0
        if (head == null || k == 0) {
            return;
        }

        Node first = head;
        Node second = head;

        // reach to the kth element using for loop
        for (int i = 0; i < k; i++) {
            if (second.next == null) {
                if (i == k - 1) {
                    head = head.next;
                }
                return;
            }
            second = second.next; // if you put this at the top of for loop error and expections will raise
        }

        // flag<fist> is still at head, we have to move this flag till the item to be removes
        while (second.next != null) {
            first = first.next;
            second = second.next;
        }


        //first.next =second.next; // with this algo, this will not work;
        first.next = first.next.next;


    }


}
