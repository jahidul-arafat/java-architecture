/*
 * Copyright (c) 2022.
 * Jahidul Arafat
 * jahidul.arafat@oracle.com
 *
 * All rights reserved.
 */

package com.jarotball.tree_algorithms.binary_search;

public class BinarySearchTreeMain {
    /**
     * apply constraints:: leftNodeValue> rootNodeValue; rightNodeValue< rootNodeValue
     *                      5
     *                 2        7
     *              -1              8
     *                                  11
     *                              10
     *
     *
     * PreOder      (Root-L-R):      5,2,-1,7,8,11,10
     * PostOrder    (L-R-Root):      2,-1,7,8,11,10,5
     * InOrder      (L-Root-R):      2,-1,5,7,8,11,10
     *
     * Got:
     * PreOrder: 5(O_0) , 2(L_1) , -1(L_2) , 7(R_2) , 8(R_4) , 11(R_6) , 10(L_7) ,
     * PostOrder: 2(L_1) , -1(L_2) , 7(R_2) , 8(R_4) , 11(R_6) , 10(L_7) , 5(O_2) ,
     * InOrder: 2(L_1) , -1(L_2) , 5(O_1) , 7(R_2) , 8(R_4) , 11(R_6) , 10(L_7) ,
     *
     * apply constraints:: leftNodeValue< rootNodeValue; rightNodeValue> rootNodeValue
     *                         7
     *                    5         10
     *                1      6            18
     * */
    public static void main(String[] args) {

        // Create a root node
        Node rootNode = new Node(5);

        BinarySearchTree bst = new BinarySearchTree();
        bst.root = rootNode;

        // insert few values into the tree
        // apply constraints:: leftNodeValue> rootNodeValue; rightNodeValue< rootNodeValue
        bst.insert(2);
        bst.insert(7);
        bst.insert(8);
        bst.insert(11);
        //bst.insert(2);
        bst.insert(10);
        bst.insert(-1);



        // root, left, right
        System.out.print("PreOrder: ");
        bst.preOrderTraversal();

        System.out.println();
        // left, right, root
        System.out.print("PostOrder: ");
        bst.postOrderTraversal();

        System.out.println();
        // left, root, right
        System.out.print("InOrder: ");
        bst.inOrderTraversal();

        System.out.println();
        // Searching an item into the Tree
        var valueToBeSearched = 100;
        System.out.println(String.format("Found %s: %s",valueToBeSearched,bst.contains(valueToBeSearched)));

    }
}
