package com.jarotball.into_list.project_1_london_hotel_guest_checkin_loyalty;

import com.jarotball.into_list.project_1_london_hotel_guest_checkin_loyalty.data.Guest;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // 0. Setup - Create a list of guests
        Guest billy = new Guest("Billy","Bow", false);
        Guest cilly = new Guest("Cilly","Cow", true);
        Guest dilly = new Guest("Dilly","Dow", false);
        Guest eilly = new Guest("Eilly","Eow", true);

        // 2. Create a checkinList
        List<Guest> checkinList = new ArrayList<>(100); // default ArrayList size is 10;
                                                                    // if we are certain how many guest could be per day i.e. thats 100
                                                                    // that's why I have initialized the ArrayList with 100; means 100 guest; if more will resize automatically

        // 1. Scenario
        // 1.1 billy and dilly came to the London hotel lobby for checkin, billy comes first
        checkinList.add(billy);
        checkinList.add(dilly);
        print(checkinList);

        // 1.2 Now suddenly cilly, who is a loyaltyProgramMember came for checkin.
        // Constrain: A loyalty program member has preferences in checkin over the non-loyalty program member
        // so, cilly being loyalty_program_member will become first in the checkin list
        System.out.println("------");
        checkinList.add(0,cilly);
        print(checkinList);

        // 1.3 Seeing, the benefits of being a loyalty_program_member,
        // Dilly --> decided to become loyalty_program_member
        // eventually, eilly (loyaltyProgramMember)--> comes to lobby for checkin; but Dilly already become a loyalty program member
        System.out.println("-------");
        dilly.setLoyaltyProgramMember(true);
        checkinList.addAll(1, List.of(dilly, eilly));
        print(checkinList);

        // 1.4 an earlier non-loyalty Dilly (Duplicate) exists ; Remove this
        System.out.println("-------");
        checkinList.remove(checkinList.size()-1);
        print(checkinList);

        // 1.5 Now Billy who came first for checkin, becomes confused and wants to know his serial
        System.out.println("-------");
        var pos = checkinList.indexOf(billy);
        System.out.format("Mr. %s , your checkin serial is pos %s", billy.getFirstName(),pos+1);



    }

    public static void print(List<Guest> checkinList){
        for (int i = 0; i < checkinList.size(); i++) {
            System.out.format("%s: %s%n",i,checkinList.get(i).getFirstName());
        }
    }
}
