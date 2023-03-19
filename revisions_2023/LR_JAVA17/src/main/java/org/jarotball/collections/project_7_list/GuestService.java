package org.jarotball.collections.project_7_list;

import org.jarotball.collections.project_1_london_hotel.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GuestService {
    // Instance Attributes
    /*
    - checkInList
     */

    private List<Guest> checkinList;

    // Constructor
    public GuestService() {
        this.checkinList = new ArrayList<>();
    }

    // Getter and Setter
    public List<Guest> getCheckinList() {
        return checkinList;
    }

    public void setCheckinList(List<Guest> checkinList) {
        this.checkinList = checkinList;
    }

    // Custom Methods
    // Custom Method_1
    // filter guests by their favorite room
    // i.e. Among 3 guests 2 has chosen R1 to be their most favorite. So we will return those guests by R1

    public List<String> filterGuestsByTopRoom(Room room){
        return checkinList.stream()
                .filter(guest -> guest.getPreferredRooms().indexOf(room)==0)
                .map(guest -> guest.getFirstName()+" " + guest.getLastName())
                .collect(Collectors.toList());
    }

    // Custom Method_02: Add a Guest to the checkin list
    // loyalty program member has high precedence over others for checkin
    public void checkIn(Guest guest){
        if (guest.isLoyaltyProgramMember() && !checkinList.isEmpty()){
            // try to find a non-loyalty program member
            // if found, exit the loop and insert the loyalty member on top of that
            int i=0;
            for (; i < checkinList.size(); i++) {
                if (!checkinList.get(i).isLoyaltyProgramMember())
                    break;
            }
            checkinList.add(i,guest);
        } else
            checkinList.add(guest);
    }

    // Custom Method_03: Swap the position of two guests who has mutually agreed to swap their positions
    public void swapPosition(Guest g1, Guest g2){
        // get the g1 position
        var g1pos = checkinList.indexOf(g1);    // return -1 if not in the list

        // get the g2 position
        var g2pos = checkinList.indexOf(g2);    // return -1 if not in the list

        // swap
        if (g1pos!=-1 && g2pos!=-1){
            checkinList.set(g1pos,g2);
            checkinList.set(g2pos,g1);
        }
    }

    // Print the CheckinList
    public void print(){
        for (int i = 0; i < checkinList.size(); i++) {
            System.out.format("%s: %s%n", i, checkinList.get(i).getFirstName());
        }
    }


}
