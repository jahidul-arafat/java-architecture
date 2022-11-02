package org.datascience.loadingdata.simulation.Census;

import org.datascience.loadingdata.models.Census.PersonRecordUtil;
import org.datascience.loadingdata.utils.TextLoader;

import java.util.stream.Collectors;

public class CensusSimulator {
    static String filePath= "/Users/jarotball/Study/java_architect/JavaDataScience/src/main/java/org/datascience/loadingdata/sampledata/";

    public static void main(String[] args) {
        var lines = TextLoader.parseLines(filePath+"adult-sample.data");
        var peopleList = lines
                .stream()
                .map(line -> PersonRecordUtil.parsePerson(line))
                .collect(Collectors.toList());
        peopleList
                .forEach(System.out::println);

    }
}
