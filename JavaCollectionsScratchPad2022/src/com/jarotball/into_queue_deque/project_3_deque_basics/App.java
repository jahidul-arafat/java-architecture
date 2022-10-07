package com.jarotball.into_queue_deque.project_3_deque_basics;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;
import java.util.List;

/**
 * Let's image London Hotel has an older Voicemail system,
 * Most recent messages appears at top, older messages at bottom
 *
 * */
public class App {
    public static void main(String[] args) {
        // 1. Stack implementation using Deque - LIFO: Last In First Out - Like a Stack of Plates
        /*
        * Expected Output
        * ---- Deque Contents ----
        0: Message 1 2021-10-11T10:20 (Top)

        ---- Deque Contents ----
        0: Message 2 2022-10-07T18:03:12.070454 (Top)
        1: Message 1 2021-10-11T10:20

        ---- Deque Contents ----
        0: Message 3 2022-10-07T18:03:12.070681 (Top)
        1: Message 2 2022-10-07T18:03:12.070454
        2: Message 1 2021-10-11T10:20

        ---- Deque Contents ----
        0: Message 4 2022-10-07T18:03:12.070858 (Top)
        1: Message 3 2022-10-07T18:03:12.070681
        2: Message 2 2022-10-07T18:03:12.070454
        3: Message 1 2021-10-11T10:20

        ---- Deque Contents ----
        0: Message 5 2022-10-07T18:03:12.071070 (Top)
        1: Message 4 2022-10-07T18:03:12.070858
        2: Message 3 2022-10-07T18:03:12.070681
        3: Message 2 2022-10-07T18:03:12.070454
        4: Message 1 2021-10-11T10:20
        * */

        // 1.1 Create a Stack using ArrayDeque
        Deque<String> msgStack = new ArrayDeque<>();

        // 1.2 Push some elements into the Stack
        msgStack.push("Message 1 "+ LocalDateTime.of(2021,10,11,10,20).toString());
        //print(msgStack);
        msgStack.push("Message 2 "+ LocalDateTime.now());
        //print(msgStack);
        msgStack.push("Message 3 " + LocalDateTime.now());
        //print(msgStack);
        msgStack.push("Message 4 "+ LocalDateTime.now());
        //print(msgStack);
        msgStack.push("Message 5 "+ LocalDateTime.now());
        print(msgStack);

        // 1.3 Pop elements from Stack
        System.out.format("%n-------Popping Elements from Stack ---------%n");
        String poppedItem;
        for (String item:msgStack)
        {
            System.out.println(msgStack.pop());

        }


        print(msgStack);



    }

    public static void print(Deque<String> deque){
        System.out.format("%n---- Deque Contents ----%n");
        int contentCounter=0;
        for (String item: deque
             ) {
            System.out.format("%s: %s %s%n",
                    contentCounter,
                    item,
                    contentCounter==0?"(Top)":"");
            contentCounter+=1;

        }
    }
}
