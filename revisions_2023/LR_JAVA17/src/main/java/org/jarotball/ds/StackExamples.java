package org.jarotball.ds;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class StackExamples {
    public static void main(String[] args) {
        Deque<String> stack = new ArrayDeque<>();
        stack.push("First Request");
        stack.push("Second Request");
        stack.push("Third Request");
        System.out.println(stack);

        System.out.println(stack.peek());
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.poll();
        System.out.println(stack);
    }
}
