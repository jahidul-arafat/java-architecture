/*
 * Copyright (c) 2022.
 * Jahidul Arafat
 * jahidul.arafat@oracle.com
 *
 * All rights reserved.
 */

package com.jarotball.tree_algorithms.binary_tree;

import com.jarotball.tree_algorithms.binary_tree.Node;

public class BinaryTreeMain {
    /**
     *                      5
     *          2                       4
     *      9       10              7
     *
     *
     * InOrder      (L-Root-R): 9 2 10 5 7 4
     * PreOrder     (Root-L-R): 5 2 9 10 4 7
     * PostOrder    (L-R-Root): 9 10 2 7 4 5
     * */
    public static void main(String[] args) {
        //
        BinaryTree bt = new BinaryTree();

        // leaf nodes
        Node n9 = new Node(9);
        Node n10 = new Node(10);
        Node n7 = new Node(7);

        // intermediate nodes
        Node n2 = new Node(2,n9,n10); // Node(data, left, right)
        Node n4 = new Node(4, n7, null); // Node(data, left, right)
        Node n5 = new Node(5, n2,n4);

        // Set the root node
        bt.root=n5;

        // traverse the tree to display its contents
        // root, left, right
        System.out.print("PreOrder: ");
        bt.preOrderTraversal();

        System.out.println();
        // left, right, root
        System.out.print("PostOrder: ");
        bt.postOrderTraversal();

        System.out.println();
        // left, root, right
        System.out.print("InOrder: ");
        bt.inOrderTraversal();

        System.out.println();
        // Search an item in the tree
        bt.contains(20);


    }



}
