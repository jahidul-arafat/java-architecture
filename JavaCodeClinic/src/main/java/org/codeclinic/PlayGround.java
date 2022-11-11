package org.codeclinic;

import org.codeclinic.problems.prb1_weather.models.WeatherRecord;
import org.codeclinic.utility.AuxiliaryUtils;
import org.codeclinic.utility.FilePath;
import org.codeclinic.utility.TextLoader;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class PlayGround {
    public static void main(String[] args) {
//        System.out.println("JA's Scratch Book/ JAVA Test-Trial PlayGround");
//        var linesList = TextLoader.parseLines(FilePath.FILE_PATH+"test.txt");
//        linesList.forEach(System.out::println);
//
//        var fileNames = AuxiliaryUtils.getFileNamesFromDir(FilePath.FILE_PATH+"weatherdata");
//        System.out.println(fileNames);

        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime midnight = now.truncatedTo(ChronoUnit.DAYS);
        Duration duration = Duration.between(midnight, now);
        var secondsPassed = (int)duration.getSeconds();
        System.out.println(secondsPassed);


    }
}