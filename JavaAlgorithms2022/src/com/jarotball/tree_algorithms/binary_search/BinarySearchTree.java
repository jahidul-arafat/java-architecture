/*
 * Copyright (c) 2022.
 * Jahidul Arafat
 * jahidul.arafat@oracle.com
 *
 * All rights reserved.
 */

package com.jarotball.tree_algorithms.binary_search;

public class BinarySearchTree {
    Node root;

    // helper function
    public void insert(int value){
        insert(this.root,value);
    }

    // This method is only accessible to the Class <BinarySearchTree>
    // Thereby to access this Method, we have designed another insert method with public access modifier, called a helper function
    // this helper function is accessible to class instances
    private Node insert(Node root, int value){
        // check if the root is null; if so, then the inout value will become the root
        // if the root is not null // apply constraints:: leftNodeValue< rootNodeValue; rightNodeValue> rootNodeValue
        // If value == rootNodeValue, dont insert anything, just return the root

        // base case - to stop recursive iteration
        // why this base case is important?
        // without this base case, the program will never terminate; results in <StackOverFlowError>
        if (root==null) root=new Node(value);
        else if(value< root.data) root.left = insert(root.left, value); // seems like recursive;
                                                                        // initially I tried with root.left = new Node(value);
                                                                        // But what if that rootNode already has a left Child?
                                                                        // That's why instead of using root.left = new Node(value), try root.left = insert(root.left, value)
                                                                        // this will traverse the node chain and only insert a value if it has a leftNode null
        else if(value> root.data) root.right=insert(root.right,value);

        return root;

    }

    // Search an element into BST
    public boolean contains(int value){
        return contains(this.root,value);
    }

    private boolean contains(Node root, int valueToBeSearched){
        System.out.println(String.format("Searching %s, Got %s",valueToBeSearched,root));
        if (root == null) return false;

        if(valueToBeSearched<root.data){
            // search left side - using recursion
            System.out.println("Switched to LEFT");
            return contains(root.left,valueToBeSearched);
        } else if(valueToBeSearched> root.data){
            System.out.println("Switched to RIGHT");
            // search right side - using recursion
            return contains(root.right, valueToBeSearched);
        }

        // base case
        return true; // means valueToBeSearched isEqual to ROOT; Recursion will reach here
    }



    // helper function
    // root, left,right
    public void preOrderTraversal(){
        preOrderTraversal(this.root,"O",0);
    }

    private void preOrderTraversal(Node root, String Flag, int depth){
        if (root!=null){
            System.out.print(String.format("%s(%s_%s) , ",root.data,Flag, depth));
            preOrderTraversal(root.left,"L", depth+=1);
            preOrderTraversal(root.right,"R", depth+=1);

        }

    }
    // helper function
    // left,right, root
    public void postOrderTraversal(){
        postOrderTraversal(this.root,"O",0);
    }

    private void postOrderTraversal(Node root, String Flag, int depth){
        if (root!=null){
            preOrderTraversal(root.left,"L", depth+=1);
            preOrderTraversal(root.right,"R", depth+=1);
            System.out.print(String.format("%s(%s_%s) , ",root.data,Flag, depth));

        }

    }

    // helper function
    // left,root, right
    public void inOrderTraversal(){
        inOrderTraversal(this.root,"O",0);
    }
    private void inOrderTraversal(Node root, String Flag, int depth){
        if (root!=null){
            preOrderTraversal(root.left,"L", depth+=1);
            System.out.print(String.format("%s(%s_%s) , ",root.data,Flag, depth));
            preOrderTraversal(root.right,"R", depth+=1);


        }

    }

}
