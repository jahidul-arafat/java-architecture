package com.jarotball.into_list.project_2_london_hotel_guest_service.data;

import com.jarotball.into_fundamentals.project_1_london_hotel.data.Room;
import com.jarotball.into_list.project_1_london_hotel_guest_checkin_loyalty.data.Guest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GuestService {
    private List<Guest> checkinList;

    // no-argument constructor
    public GuestService() {
        this.checkinList = new ArrayList<>(100);
    }

    // getter and setter

    public List<Guest> getCheckinList() {
        return checkinList;
    }

    public void setCheckinList(List<Guest> checkinList) {
        this.checkinList = checkinList;
    }

    // custom_method_1: Return list of guest filter by favorite_room
    // Given a list_of_guest and a Room, return list_of_guest who has marked the room to be their most favorite; means
    // the room is at the top of their preference; means room at List index 0
    public List<Guest> filterByFavoriteRoom(List<Guest> guestList, Room room){
        var output = guestList
                .stream()
                .filter(guest -> guest.getPreferredRooms().indexOf(room)==0)
                //.map(guest -> guest.getFirstName())
                .collect(Collectors.toList());
        return output;
    }

    // custom_method_2: Add a guest to the checkin list;
    // loyaltyProgramMember has high precedence over others for checkin
    public void checkIn(Guest guest){
        if (guest.isLoyaltyProgramMember() && !this.checkinList.isEmpty()){
            // iterate every guest in the checkinList and find the position of a non-loyalty guest exists
            // if a non-loyalty-member found break and exit from the loop
            // else continue
            // finally, insert the new guest into the position <i> returned by the forLoop
            // add the loyalty_guest on the top of the non_loyalty_guest
            int i=0;
            for (; i < this.checkinList.size(); i++) {
                if (!checkinList.get(i).isLoyaltyProgramMember()){
                    break;
                } else
                    continue;
            }
            this.checkinList.add(i,guest);
        } else
            this.checkinList.add(guest);
    }

    // custom_method_3: swap the position of two guest (loyalty, no_loyalty), (loyalty, loyalty), (no_loyalty, no_loyalty)
    public void swapPosition(Guest guest1, Guest guest2){
        // find the position of guest1 and guest2
        var guest1Pos= this.checkinList.indexOf(guest1); // returns -1, if guest not in the list
        var guest2Pos = this.checkinList.indexOf(guest2);

        // swap the position if the both guests exist in the list, else no ops
        if (guest1Pos != -1 && guest2Pos!=-1){
            this.checkinList.set(guest1Pos, guest2);
            this.checkinList.set(guest2Pos, guest1);
        }
    }

    // custom_method_4: create a full copy of checkinList
    public List<Guest> getACopyOfCheckinList(){
        return List.copyOf(this.checkinList);
    }

    // custom_method_: print the checkinList position with Guest firstName
    public void print(){
        for (int i = 0; i < this.checkinList.size(); i++) {
            System.out.format("%s: %s%n", i, this.checkinList.get(i).getFirstName());

        }
    }

}
