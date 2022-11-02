package org.datascience.loadingdata.simulation.Car;

import org.datascience.loadingdata.models.Car.CarRecordUtil;
import org.datascience.loadingdata.utils.TextLoader;

import java.util.stream.Collectors;

public class CarSimulator {
    static String filePath= "/Users/jarotball/Study/java_architect/JavaDataScience/src/main/java/org/datascience/loadingdata/sampledata/";

    public static void main(String[] args) {
        var lines = TextLoader.parseLines(filePath+"auto-mpg.data");
        var carList = lines
                .stream()
                .map(line -> CarRecordUtil.parseCar(line))
                .collect(Collectors.toList());

        carList.forEach(System.out::println);
    }
}
