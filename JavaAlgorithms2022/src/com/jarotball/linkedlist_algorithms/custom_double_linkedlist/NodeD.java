/*
 * Copyright (c) 2022.
 * Jahidul Arafat
 * jahidul.arafat@oracle.com
 *
 * All rights reserved.
 */

package com.jarotball.linkedlist_algorithms.custom_double_linkedlist;

public class NodeD {
    private String data;
    private NodeD next;
    private NodeD prev;

    public NodeD(String data) {
        this.data = data;
        this.next=null;
        this.prev=null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public NodeD getNext() {
        return next;
    }

    public void setNext(NodeD next) {
        this.next = next;
    }

    public NodeD getPrev() {
        return prev;
    }

    public void setPrev(NodeD prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "NodeD{" +
                "data=" + data +
                '}';
    }
}
