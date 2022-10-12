package scheduling;

import customers.Customer;
import employees.Hairdresser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scheduler {
    private static Map<String, Hairdresser> hairdresserMap = new HashMap<>();
    private static Map<String, List<String>> customerHairdresserDay = new HashMap<>();

    // constructor
    public Scheduler() {
        Hairdresser harry = new Hairdresser("Harry");
        Hairdresser jill = new Hairdresser("Jill");

        harry.setDaysAvailable("Monday", "Tuesday");
        jill.setDaysAvailable("Wednesday");

        hairdresserMap.put("Harry", harry);
        hairdresserMap.put("Jill",jill);
    }

    public boolean bookHaircut(Customer customer, String hairdresserName, String dayToCut){

        var hairdresser = hairdresserMap.get(hairdresserName);
        var daysInService = hairdresser.getDaysAvailable();
        var seatsAvailableOnTheDay = hairdresser.getDayCountMap().get(dayToCut);

//        System.out.format("Hairdresser %s available on %s and seats per day %s%n",
//                hairdresserName,
//                daysInService,
//                hairdresser.getDayCountMap());

        if (daysInService.contains(dayToCut) &&
                seatsAvailableOnTheDay>0){
            hairdresser.setDayCountMap(dayToCut,seatsAvailableOnTheDay-1);



            System.out.format("%s have booked %s on %s, remaining seat available %s%n",
                    customer.getName(),
                    hairdresser.getName(),
                    dayToCut,
                    hairdresser.getDayCountMap().get(dayToCut));
            return true;

        }
        System.out.format("Hairdresser %s is not available on %s%n",
                    hairdresser.getName(),
                    dayToCut);
        return false;

    }


}
