/*
 * Copyright (c) 2022.
 * Jahidul Arafat
 * jahidul.arafat@oracle.com
 *
 * All rights reserved.
 */

package com.jarotball.queue_stack.basic_stack_ops;

import java.util.Stack;

/**
 * Stack - LIFO - Last In First Out
 *       - FILO - First In Last Out
 *
 * Example: Runtime Stacks
 * - Keeps track of execution of program and processing of nested functions
 * Main         Builder             Util - IndexOutOfRangeException
 *              Main                Builder
 *                                  Main
 *
 * Unlike Queue which is an interface and implemented by LinkedList;
 * Stack is a Class itself, which implemented the following interfaces: Serializable, Cloneable, Iterable<E>, Collection<E>, List<E>, RandomAccess
 * */

public class StackOpsBasic {
    public static void main(String[] args) {
        System.out.println("Runtime Stack Trace Simulation\n--------------");
        Stack<String> demoStack = new Stack<>();

        // push few elements into stack - simulate the Runtime stack scenario
        System.out.println("START <MAIN>");
        demoStack.push("main");

        System.out.println("START <BUILDER>");
        demoStack.push("builder");

        System.out.println("START <UTIL>");
        demoStack.push("util");

        System.out.println("START <EXTERNAL-SERVICE>");
        demoStack.push("external-service");

        System.out.println(demoStack);

        while (!demoStack.isEmpty()){
            System.out.println("END <"+demoStack.pop()+">");
        }

        //demoStack.peek();


    }
}
