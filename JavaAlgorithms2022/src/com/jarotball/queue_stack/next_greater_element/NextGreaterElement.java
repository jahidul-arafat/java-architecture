/*
 * Copyright (c) 2022.
 * Jahidul Arafat
 * jahidul.arafat@oracle.com
 *
 * All rights reserved.
 */

package com.jarotball.queue_stack.next_greater_element;

import java.util.Stack;

/**
 * Find the next greater element
 * Given Stack: [16,7,2,15]
 * Output:
 * 16->-1
 * 7->15
 * 2->15
 * 15->-1
 *
 * */

public class NextGreaterElement {
    public static void main(String[] args) {
        //int[] demoArray={16,7,2,15};
        int[] demoArray={16,17,18,19};
        findNextGreaterElement(demoArray);

    }

    public static void findNextGreaterElement(int[] demoArr){
        if (demoArr.length == 0) return;

        Stack<Integer> demoStack = new Stack<>();
        demoStack.push(demoArr[0]); //16
        System.out.println("Initial Stack Status: "+demoStack);

        for (int i = 1; i < demoArr.length; i++) {
            System.out.println();
            var next = demoArr[i]; //7 //2 //15
            System.out.println("Validating "+ next);

            //if (next< demoStack.peek()) demoStack.push(next);
            while (next > demoStack.peek()) { //15>2 //15>7
                var popped = demoStack.pop();
                System.out.println("Popped: "+popped);
                System.out.println(popped + "-->" + next); //2 --> 15 // 7-->15
                if (demoStack.isEmpty()) break; // If you dont break here, it will raise an EmptyStack exception
            }

            System.out.println("Pushing into Stack: "+ next);
            demoStack.push(next); //[16,7] //[16,7,2]

            System.out.println("Current Stack Status: "+demoStack);
            System.out.println();
        }

        // now print the leftover element in the stack with next element -1
        while (!demoStack.isEmpty()){
            System.out.println(demoStack.pop()+"-->"+-1);
        }

    }
}
