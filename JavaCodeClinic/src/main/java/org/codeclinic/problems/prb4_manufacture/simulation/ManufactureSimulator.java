package org.codeclinic.problems.prb4_manufacture.simulation;

import org.apache.commons.csv.CSVRecord;
import org.codeclinic.problems.prb4_manufacture.models.ManufactureRecord;
import org.codeclinic.problems.prb4_manufacture.models.ManufactureRecordUtil;
import org.codeclinic.problems.prb4_manufacture.utils.Service;
import org.codeclinic.utility.CSVLoader;
import org.codeclinic.utility.FilePath;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@EnableAutoConfiguration
public class ManufactureSimulator {
    public static List<Integer> pulsometer = new ArrayList<>();
    public static List<Double> engineeff = new ArrayList<>();
    public static List<Integer> red = new ArrayList<>();
    public static List<Integer> blue = new ArrayList<>();
    public static List<Integer> green = new ArrayList<>();

    String engineeffPattern = "###.###";
    DecimalFormat engineeffDecimalFormat = new DecimalFormat(engineeffPattern);

    @CrossOrigin
    @RequestMapping("/data")
    Map home(ManufactureSimulator sim) {
        // REST API Service Method
        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime midnight = now.truncatedTo(ChronoUnit.DAYS);
        Duration duration = Duration.between(midnight, now);
        var secondsPassed = (int) duration.getSeconds();

        Map valueAtSecondMap = new HashMap();
        valueAtSecondMap.put("pulsometer", pulsometer.get(secondsPassed));
        valueAtSecondMap.put("engineeff", engineeffDecimalFormat.format(engineeff.get(secondsPassed)));
        valueAtSecondMap.put("red", red.get(secondsPassed));
        valueAtSecondMap.put("blue", blue.get(secondsPassed));
        valueAtSecondMap.put("green", green.get(secondsPassed));

        return valueAtSecondMap;

    }

    public static void main(String[] args) {
        // load the data
        // A. creating the manufacterRecord object and return a list of all those
        List<CSVRecord> csvRecordList = CSVLoader.parseCSV(FilePath.FILE_PATH + "manufacture_industry" + "/dashBoardData.csv");
        var manufactureRecordList = csvRecordList
                //.subList(0,5)
                .stream()
                .map((record) -> ManufactureRecordUtil.parseManufactureItem(record))
                .collect(Collectors.toList());

        // B. get the valueList of all attributes in manufactureRecord
        pulsometer = Service.getPulsometers(manufactureRecordList);
        engineeff = Service.getEngineEff(manufactureRecordList);
        red = Service.getRed(manufactureRecordList);
        blue = Service.getBlue(manufactureRecordList);
        green = Service.getGreen(manufactureRecordList);

        // Let the SpringApplication run the API http://localhost:8080/data
        SpringApplication.run(ManufactureSimulator.class, args);

    }
}
