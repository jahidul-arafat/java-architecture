package employees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hairdresser {
    public static final int MAX_HAIRCUT = 5;
    private final String name;
    private List<String> daysAvailable;
    private Map<String,Integer> dayCountMap;


    // Constructor

    public Hairdresser(String name) {
        this.name = name;
        this.daysAvailable = new ArrayList<>();
        this.dayCountMap= new HashMap<>();

    }

    // getter and setter
    public String getName() {
        return name;
    }

    public List<String> getDaysAvailable() {
        return daysAvailable;
    }

    public Map<String, Integer> getDayCountMap(){
        return this.dayCountMap;
    }

    public void setDayCountMap(String... days){
        for (String day: days
        ) {
            this.dayCountMap.put(day,MAX_HAIRCUT);
        }
    }

    public void setDayCountMap(String day, int count){
        this.dayCountMap.put(day, count);
    }

    // there could have n number of days
    public void setDaysAvailable(String... days) {
        for (String day: days
             ) {
            this.daysAvailable.add(day);
            setDayCountMap(day);
        }
    }

    // custom method_01
    // remove a day from this hairdresser's available days
    public void removeDay(String day){
        if (this.daysAvailable.contains(day)){
            this.daysAvailable.remove(day);
        }
    }

}
