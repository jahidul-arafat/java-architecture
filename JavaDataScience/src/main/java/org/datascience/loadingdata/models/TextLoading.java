package org.datascience.loadingdata.models;

import org.datascience.loadingdata.models.Car.CarRecordUtil;
import org.datascience.loadingdata.models.Census.PersonRecordUtil;
import org.datascience.loadingdata.utils.TextLoader;

import java.util.stream.Collectors;

public class TextLoading {

    static String filePath= "/Users/jarotball/Study/java_architect/JavaDataScience/src/main/java/org/datascience/loadingdata/sampledata/";

    public static void main(String[] args) {
        // ------------------------- A. People Census Data --------------------------
        var lines = TextLoader.parseLines(filePath+"adult-sample.data");
        var peoples = lines
                .stream()
                .map(line -> PersonRecordUtil.parsePerson(line))
                .collect(Collectors.toList());
        //peoples
        //        .forEach(System.out::println);

        // ----------------------- B. Car Data ---------------------------------------
        var carLines = TextLoader.parseLines(filePath+"auto-mpg.data");
        var carList= carLines
                .stream()
                .map((line)-> CarRecordUtil.parseCar(line))
                .collect(Collectors.toList());

        // Get avg weight of cars
        var avgMpg= carList
                .stream()
                .mapToDouble((car)-> car.getMpg())
                .average()
                //.stream()
                //.map(Math::round)
                //.findFirst()
                .orElse(-1);
        System.out.println("Average MPG: "+ avgMpg);

    }
}
