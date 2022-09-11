package scheduling;

import employee.Hairdresser;

import java.util.ArrayList;
import java.util.HashMap;

public class Scheduler {
    // class method
    // HashMap<hairDresserName, hairDresserObject>
    private static HashMap<String, Hairdresser> hairDresserList = new HashMap<>();

    // constructor - creating two hairdresser
    public Scheduler() {
        Hairdresser hairdresser1 = new Hairdresser("HairDresser_01");
        Hairdresser hairdresser2 = new Hairdresser("HairDresser_02");

        hairdresser1.setDaysAvailable("Monday","Tuesday");
        hairdresser2.setDaysAvailable("Wednesday");

        hairDresserList.put(hairdresser1.getName(),hairdresser1);
        hairDresserList.put(hairdresser2.getName(),hairdresser2);
    }

    // Customer will book by the hairdresserName and the day they will go for haircut
    public void bookHaircut(String hairdresserName, String dayCustomerChosenForHairCut){
        // get the booked hairdresser object
        Hairdresser toBeBookedHairdresser = hairDresserList.get(hairdresserName); //hairDresserList is a HashMap<hairdresserName, daysAvailableToWork>

        // get the days on which the bookedHairDresser is available
        ArrayList<String> hairDresserWorkingDays = toBeBookedHairdresser.getDaysAvailable();

        // check if the toBeBookedHairdresser is available on the day_customer_requested
        if (hairDresserWorkingDays.contains(dayCustomerChosenForHairCut)){
            System.out.println(String.format("You have booked %s on %s",toBeBookedHairdresser.getName(), dayCustomerChosenForHairCut));
            System.out.println("Booking Successful");

            // remove that specific day from the hairdresser available days due to booked
            toBeBookedHairdresser.removeDay(dayCustomerChosenForHairCut);

        } else {
            System.out.println(String.format("Hairdresser %s is not available on %s",toBeBookedHairdresser.getName(),dayCustomerChosenForHairCut));
        }



    }
}
