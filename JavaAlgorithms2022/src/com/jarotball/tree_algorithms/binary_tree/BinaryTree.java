/*
 * Copyright (c) 2022.
 * Jahidul Arafat
 * jahidul.arafat@oracle.com
 *
 * All rights reserved.
 */

package com.jarotball.tree_algorithms.binary_tree;

import com.jarotball.tree_algorithms.binary_tree.Node;

public class BinaryTree {
    Node root;
    boolean flag = false; // indicates if the flag is found or not

    // Searching an item into the Binary Tree; this is not BST
    public void contains(int valueToBeSearched){
        contains(this.root,valueToBeSearched);
        if (flag) System.out.println("FOUND");
        else System.out.println("Not FOUND");
    }

    private void contains(Node root, int valueToBeSearched){
        System.out.println(String.format("Searching %s, Got %s",valueToBeSearched, root.data));

        if (root==null) return;

        // base case - every recursion will reach here
        if (root.data == valueToBeSearched) {
            flag = true;
            return;
        }
        if (flag!=true && root.left!=null){
            System.out.println("Switched to LEFT ...");
            contains(root.left, valueToBeSearched);
        }

        // if search unsuccessful in LEFT
        if(flag!=true && root.right!=null){
            System.out.println("Switched to RIGHT");
            contains(root.right, valueToBeSearched);
        }




    }


    // Traversal: preOrder:: root, left, right
    // helper function
    public void preOrderTraversal(){
        preOrderTraversal(this.root, "O", 0);
    }

    // main implementation
    private void preOrderTraversal(Node root, String FLAG, int flagCounter){
        if (root!=null){
            //System.out.print(String.format("%s(%s_%s) , ",root.data, FLAG, flagCounter));
            System.out.print(root.data+ " , ");
            preOrderTraversal(root.left, "L", flagCounter+=1);
            preOrderTraversal(root.right, "R", flagCounter+=1);
        }
        //System.out.println("Back to: "+root+"__"+flagCounter); // uncomment it to check the footprint of the traversal

    }


    // Traversal: postOrder: left, right, root
    // helper function
    public void postOrderTraversal(){
        postOrderTraversal(this.root, "O", 0);
    }

    // main implementation
    private void postOrderTraversal(Node root, String FLAG, int flagCounter){
        if (root!=null){
            preOrderTraversal(root.left, "L", flagCounter+=1);
            preOrderTraversal(root.right, "R", flagCounter+=1);
            //System.out.print(String.format("%s(%s_%s) , ",root.data, FLAG, flagCounter));
            System.out.print(root.data+ " , ");
        }
        //System.out.println("Back to: "+root+"__"+flagCounter); // uncomment it to check the footprint of the traversal
    }


    // Traversal: inOrder: left, root, right
    // helper function
    public void inOrderTraversal(){
        inOrderTraversal(this.root, "O", 0);
    }

    // main implementation
    private void inOrderTraversal(Node root, String FLAG, int flagCounter){
        if (root!=null){
            preOrderTraversal(root.left, "L", flagCounter+=1);
            //System.out.print(String.format("%s(%s_%s) , ",root.data, FLAG, flagCounter));
            System.out.print(root.data+ " , ");
            preOrderTraversal(root.right, "R", flagCounter+=1);
        }
        //System.out.println("Back to: "+root+"__"+flagCounter); // uncomment it to check the footprint of the traversal
    }
}
