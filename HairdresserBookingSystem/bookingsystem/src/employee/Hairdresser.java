package employee;

import java.util.ArrayList;

/**
 * @param1 name Each hairdresser has a name
 * @param2 daysAvailable # of days the hairdresser is available to work
 *
 * */

public class Hairdresser {
    private String name;
    private ArrayList<String> daysAvailable = new ArrayList<>();

    // constructor
    public Hairdresser(String name) {
        this.name = name;
    }

    // getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getDaysAvailable() {
        return daysAvailable;
    }

    public void setDaysAvailable(String... days) {
        for (String day:days
             ) {
            daysAvailable.add(day);
        }

    }

    public void removeDay(String day){
        if (daysAvailable.contains(day)){
            daysAvailable.remove(day);
        }

    }
}
