package org.jarotball.collections.into_fundamentals.project_8_maps_deque;

import org.jarotball.collections.into_fundamentals.project_7_list.Guest;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class GuestApp {
    public static void printNormalQueue(@NotNull Queue<Guest> queue){
        queue.stream()
                .map(guest -> guest.getFirstName()+"::"+
                        (guest.isLoyaltyProgramMember()?"LoyaltyMember":"NotAMember"))
                .forEach(System.out::println);
        System.out.println("\n------------------------\n");
    }

    public static void printPriorityQueue(@NotNull Queue<Guest> priorityQueue){
        Guest guest;
        int gCounter=0;
        while ((guest=priorityQueue.poll())!=null){
            System.out.format("%s: %s%s%n",
                    gCounter,
                    guest.getFirstName()+"::"+(guest.isLoyaltyProgramMember()?"LoyaltyMember":"NotAMember"),
                    gCounter==0?"(Head)":""
                    );
            gCounter+=1;
        }
    }
    public static void main(String[] args) {

        // Create 5x Guests
        Guest billy = new Guest("Billy","Bow", false);
        Guest cilly = new Guest("Cilly","Cow", true);
        Guest dilly = new Guest("Dilly","Dow", false);
        Guest eilly = new Guest("Eilly","Eow", true);
        Guest filly = new Guest("Filly","Fow", true);

        // Create a Queue
        // Add the guests into the queue in the FIFO order
        Queue<Guest> guestRegularQueue = new ArrayDeque<>();
        guestRegularQueue.add(billy);
        guestRegularQueue.add(cilly);
        guestRegularQueue.add(dilly);
        guestRegularQueue.add(eilly);
        guestRegularQueue.add(filly);
        printNormalQueue(guestRegularQueue);



        // Add the guests into the queue based on their priority order
        // use PriorityQueue implementation
        Comparator<Guest> loyaltyComparator = Comparator.comparing(Guest::isLoyaltyProgramMember).reversed();
        Queue<Guest> guestPriorityQueue = new PriorityQueue<>(loyaltyComparator);

        // Now, add the Guests into the Priority Queue
        guestPriorityQueue.offer(billy);
        guestPriorityQueue.offer(cilly);
        guestPriorityQueue.offer(dilly);
        guestPriorityQueue.offer(eilly);
        guestPriorityQueue.offer(filly);
        printPriorityQueue(guestPriorityQueue);  // printing the PriorityQueue might mislead you to a wrong output
                                    // Never try to Print a PriorityQueue
                                    // Instead use the poll method

    }
}
