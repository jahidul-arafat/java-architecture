package com.jarotball.into_queue_deque.project_1_london_hotel_member_checkin;

import com.jarotball.into_list.project_1_london_hotel_guest_checkin_loyalty.data.Guest;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class App {
    public static void main(String[] args) {
        // 0. Create 5x Guests
        Guest billy = new Guest("Billy","Bow", false);
        Guest cilly = new Guest("Cilly","Cow", true);
        Guest dilly = new Guest("Dilly","Dow", false);
        Guest eilly = new Guest("Eilly","Eow", true);
        Guest filly = new Guest("Filly","Fow", true);

        // 1. Queue Simulation
        // interface Queue extends Collection
        // interface Collection
        // Queue Implementations: ArrayDeque (FIFO), PriorityQueue(not FIFO, based on Comparator)
        /*
        * Operation                 Exception           NonException
        * Insert                    add()               offer()
        * Remove                    remove()            poll()
        * Examine                   element()           peek()
        *
        * */

        // 1.1 Create a Queue (FIFO)
        /* Expected Output
        *   0: Billy Bow::NotAMember (Head)
            1: Cilly Cow::LoyaltyMember
            2: Dilly Dow::NotAMember
            3: Eilly Eow::LoyaltyMember
            4: Filly Fow::LoyaltyMember
        * */
        //Queue<Guest> guestQueue = new ArrayDeque<>();

        // 1.1 (alt) What if we want to add Guest based on their loyaltyProgramMembership, instead FIFO
        // PriorityQueue doesn't guarantee an exact ordering of members based on loyaltyProgram
        /* Expected Output (with .reversed() in comparator)
            0: Cilly Cow::LoyaltyMember (Head)
            1: Filly Fow::LoyaltyMember
            2: Eilly Eow::LoyaltyMember
            3: Dilly Dow::NotAMember
            4: Billy Bow::NotAMember
        * */

        // why .reversed() is used; without this NonLoyaltyMembers will come first.
        // that's why for perfect ordering as we are expecting, use .reversed()
        /*
         * Without .reversed()
         * 0: Billy Bow::NotAMember (Head)
         * 1: Dilly Dow::NotAMember
         * 2: Eilly Eow::LoyaltyMember
         * 3: Filly Fow::LoyaltyMember
         * 4: Cilly Cow::LoyaltyMember
         */
        Comparator<Guest> loyaltyComparator = Comparator.comparing(Guest::isLoyaltyProgramMember).reversed();
        Queue<Guest> guestQueue = new PriorityQueue<>(loyaltyComparator);

        // 1.2 add guests into the Queue (FIFO)
        guestQueue.add(billy);
        guestQueue.add(cilly);
        guestQueue.add(dilly);
        guestQueue.add(eilly);
        guestQueue.add(filly);


        print(guestQueue); // never try to print the PriorityQueue; you may mislead to wrong output
                           // implement the print method with poll(); this will give you the correct ordering
    }


    // A print method to print the Queue along with a notation "Head" for the Head of the Queue
    public static void print(Queue<Guest> guestQueue) {
        Guest guest;
        int gCounter=0;
        while ((guest=guestQueue.poll())!=null){
            System.out.format("%s: %s %s%n",
                    gCounter,
                    guest.getFirstName()+ " "+ guest.getLastName()+"::"+
                            (guest.isLoyaltyProgramMember()? "LoyaltyMember":"NotAMember"),
                    gCounter==0?"(Head)":"");
             gCounter+=1;

        }
    }
}
