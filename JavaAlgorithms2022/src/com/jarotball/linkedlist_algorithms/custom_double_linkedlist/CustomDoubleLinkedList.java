/*
 * Copyright (c) 2022.
 * Jahidul Arafat
 * jahidul.arafat@oracle.com
 *
 * All rights reserved.
 */

package com.jarotball.linkedlist_algorithms.custom_double_linkedlist;

/**
 * Ref: https://www.geeksforgeeks.org/doubly-linked-list/
 */

public class CustomDoubleLinkedList {
    private NodeD head;

    public NodeD getHead() {
        return head;
    }

    public void setHead(NodeD head) {
        this.head = head;
    }

    // push: Adding a node at the front of the list
    public void push(String new_data) {
        NodeD newNode = new NodeD(new_data);
        newNode.setNext(head);
        //head.setPrev(newNode); // this could raise execption if linkedlist is empty; then head will be null
        if (head != null) head.setPrev(newNode);

        // update the Head to be the new_node
        head = newNode;
    }

    // insertAfter - Insert a node after a given node
    // A->B->C->D
    // insertAfter(C, E) : Insert newNode E after Node(C)
    public void insertAfter(NodeD prevNode, String new_data) {
        // Create a new node
        NodeD newNode = new NodeD(new_data);

        //operations
        newNode.setNext(prevNode.getNext());
        prevNode.setNext(newNode);
        newNode.setPrev(prevNode);

        // Check if the next of newNode is NULL? This may raise NullPointerException if not handled carefully
        if (newNode.getNext() != null) {
            newNode.getNext().setPrev(newNode);
        }
    }

    // append: at the end

    /**
     * Existing List:           A->B->C->D
     * Append(E)
     * After Appending:         A->B->C->D->E
     * D.next=E;
     * E.prev=D;
     * <p>
     * Exception handling:
     * (a) Check if the list is already null; Then nodeE becomes the solo node and will become HEAD
     */
    public void append(String new_data) {
        /**
         * NodeD(new_data) constructor will automatically set the prev and next to null.
         * No manual labor require to specifically mention those to be null in the code beneath
         * */
        NodeD newNode = new NodeD(new_data);

        // find the last node in the list
        /**
         * Crate a newFlag "last" and initialize it with the head node
         * Traverse the "last" node until reaching the NULL
         * if the last.next==NULL, stop iteration
         * */
        NodeD last = head;

        /**
         * checking if the List is empty; Means head would be null; if so, just return from the method
         * if so, then the newNode will be inserted as the solo node and eventually becomes HEAD
         * */
        if (head == null) {
            head = newNode;
            return;
        }

        // this code section might raise NullPointerException, if the HEAD where I placed the flag<LAST> is empty.
        // Means the list is already EMPTY
        while (last.getNext() != null) {
            last = last.getNext();
        }
        last.setNext(newNode);
        newNode.setPrev(last);

    }

    /**
     * insertBefore - Insert a node before the given node
     * Current List:           A->B->C->D
     * insert(C,E):
     * After Inserting:        A->B->E->C->D
     * <p>
     * Strategy:
     * E.prev=B(C.Prev)
     * E.next=C
     * B.next (C.prev.next)=E ?? Exception::NullPointerException - what if there is no other node then C in the list
     * C.prev=E
     */

    public void insertBefore(NodeD nextNode, String new_data) {
        NodeD newNode = new NodeD(new_data);

        // check if the list is empty; if so just put the newNode into it and make it the new HEAD and return
        if (nextNode == null) {
            head = newNode;
            return;
        }

        newNode.setNext(nextNode);
        newNode.setPrev(nextNode.getPrev());
        if (nextNode.getPrev() != null) {
            nextNode.getPrev().setNext(newNode); // condition checking to avoid null pointer exception
        }
        nextNode.setPrev(newNode);


    }

    /**
     * insertAtPos - insert a node at any given position
     */

    public void insertAtPos(int pos, String new_data) {
        // Create the newNode
        NodeD newNode = new NodeD(new_data);

        // if list is already empty, then just place the newNode and make it HEAD and return
        if (head == null) {
            head = newNode;
            return;
        }

        if (pos < 1) return;

        if (pos == 1) { // means, there is at least 1 item in the list
            newNode.setNext(head);
            if (head != null) head.setPrev(newNode);
            head = newNode;
            return;
        }

        /**
         * List:                A(pos1)->B(pos2)->C(pos3)->D(pos4)
         * insert 'k' at position '5'; but there is no position 5; is this is the case, then we will just append the 5 at the list
         * Strategy is: if any mentioned position is not in the list and pos>length --> then simply append
         * */
        int length = getLength(head); // get the length of the linkedlist
        // NullPointerException if HEAD is NULL
        if (pos > length) {
            NodeD lastNode = head;
            // traverse to get the last node
            while (lastNode.getNext() != null) {
                lastNode = lastNode.getNext();
            }

            // now simply append the newNode at the end
            lastNode.setNext(newNode);
            newNode.setPrev(lastNode);
            return;

        }

        // Find the node at the position mentioned and then insert newNode before to it
        // like insertBefore() characteristics
        NodeD currentNode = head;
        while (pos > 1) {
            currentNode = currentNode.getNext();
            pos--;
        }
        if (currentNode == null) return; //to avoid NullPointerException

        newNode.setNext(currentNode);
        newNode.setPrev(currentNode.getPrev()); // probable NullPointerException if insetPos> linkedList.length+1
        if (currentNode.getPrev() != null) { // condition order is important to avoid NullPointerException
            currentNode.getPrev().setNext(newNode); // probable NullPointerException
        }
        currentNode.setPrev(newNode);           // probable NullPointerException
    }

    /**
     * Nodes:       A->B->C->D->NULL
     * delete A        B->C->D->NULL
     * delete D     A->B->C->Null
     * delete B     A->C->D->Null
     */
    public void deleteNode(NodeD delNode) {
        // isListEmpty
        if (head == null) return;

        // check if the delNode is really in the linkedlist; if not simply say "item not found in list"
        if (delNode.getNext() == null && delNode.getPrev() == null) {
            System.out.println(String.format("Item <%s> not found in LinkedList", delNode.getData()));
            return;
        }

        //is the nodeToBeDeleted the Head Node
        if (delNode == head) {
            head = head.getNext();
            return;
        }

        // last node
        if (delNode.getNext() == null) {
            delNode.getPrev().setNext(delNode.getNext());
            return;
        }

        // any node except last and first node
        delNode.getPrev().setNext(delNode.getNext());
        delNode.getNext().setPrev(delNode.getPrev());


    }

    public void deleteNodeAtGivenPos(int pos) {
        // check if the list is empty and pos <=0
        if (head == null || pos < 1) return;

        // pos related constraints
        //if (pos==0) return;
        if (pos == 1) {
            head = head.getNext();
            return;
        }

        // check if pos is > length(linkedlist)
        int length = getLength(head);
        if (pos > length) return;

        // traverse to the node which needs to be deleted
        NodeD currentNode = head;
        while (pos > 1) {
            currentNode = currentNode.getNext();
            pos--;
        }
        if (currentNode.getPrev() != null) currentNode.getPrev().setNext(currentNode.getNext());
        if (currentNode.getNext() != null) currentNode.getNext().setPrev(currentNode.getPrev());


    }

    public int getLength(NodeD head) {
        int length = 0;
        while (head.getNext() != null) {
            head = head.getNext();
            length += 1;
        }
        return length;
    }

    // https://www.geeksforgeeks.org/reverse-a-doubly-linked-list/
    public void reverse(){
        NodeD temp = null;
        NodeD currentNode=head;

        while (currentNode!=null){
            System.out.println("CurrentNode: "+currentNode);
            temp = currentNode.getPrev();
            System.out.println("tmp: "+temp);

            currentNode.setPrev(currentNode.getNext());
            System.out.println(currentNode.getPrev());

            currentNode.setNext(temp);
            System.out.println(currentNode.getNext());

            currentNode=currentNode.getPrev();
            System.out.println("Current Node: "+currentNode);


            if (temp!=null){
                head=temp.getPrev();
            }
            System.out.println("Head: "+head);
            System.out.println("----------");

        }
    }


    @Override
    public String toString() {
        String output = "";
        NodeD current = head;
        while (current != null) {
            String arrow = (current.getNext() == null) ? "" : "->";
            output += current.getData() + arrow;
            current = current.getNext();
        }
        return output;
    }
}
