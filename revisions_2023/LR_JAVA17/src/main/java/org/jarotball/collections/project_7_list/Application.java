package org.jarotball.collections.project_7_list;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Application {

    protected static void print(@NotNull List<Guest> checkinList){
        for (int i=0;i<checkinList.size();i++){
            System.out.format("%s: %s%n",i,checkinList.get(i).getFirstName());
        }
    }
    public static void main(String[] args) {
        // Create a list of Guests
        Guest billy = new Guest("Billy","Bow",false);
        Guest cilly = new Guest("Cilly","Cow", true);
        Guest dilly = new Guest("Dilly","Dow", false);
        Guest eilly = new Guest("Eilly","Eow", true);

        // Define the default guest checkin list everyday at reception
        List<Guest> checkinList = new ArrayList<>();


        // 1. Scenario
        // 1.1 billy and dilly came to the London hotel lobby for checkin, billy comes first
        checkinList.add(billy);
        checkinList.add(dilly);
        print(checkinList);

        System.out.println("-------------------------");

        // 1.2 Now suddenly cilly, who is a loyaltyProgramMember came for checkin.
        // Constrain: A loyalty program member has preferences in checkin over the non-loyalty program member
        // so, cilly being loyalty_program_member will become first in the checkin list
        checkinList.add(0,cilly);
        print(checkinList);

        // 1.3 Seeing, the benefits of being a loyalty_program_member,
        // Dilly --> decided to become loyalty_program_member
        // eventually, eilly (loyaltyProgramMember)--> comes to lobby for checkin; but Dilly already become a loyalty program member
        System.out.println("---------");
        dilly.setLoyaltyProgramMember(true);
        checkinList.addAll(1,Arrays.asList(dilly,eilly));
        print(checkinList);

        // 1.4 an earlier non-loyalty Dilly (Duplicate) exists ; Remove this
        System.out.println("-------");
        checkinList.remove(checkinList.size()-1);
        print(checkinList);

        // 1.5 Now Billy who came first for checkin, becomes confused and wants to know his serial
        System.out.println("-------");
        System.out.println(checkinList.indexOf(billy));
    }
}
