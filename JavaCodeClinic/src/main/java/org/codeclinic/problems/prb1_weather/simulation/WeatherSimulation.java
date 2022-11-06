package org.codeclinic.problems.prb1_weather.simulation;

import org.codeclinic.problems.prb1_weather.models.WeatherRecord;
import org.codeclinic.problems.prb1_weather.models.WeatherRecordUtil;
import org.codeclinic.utility.AuxiliaryUtils;
import org.codeclinic.utility.FilePath;
import org.codeclinic.utility.TextLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class WeatherSimulation {
    // targetDirectory
    public static String targetDirectory = FilePath.FILE_PATH + "weatherdata/";
    public static String fromDate="";
    public static String toDate="";
    public static Double slope=null;
    public static String report="";


    public static void main(String[] args) {
        var mergedWeatherRecordList= loadData();

        // Test Case-1
        fromDate = "2012/01/01 00:30:00";
        toDate = "2012/01/01 02:30:00";

        slope= WeatherRecordUtil.calculateSlopeCoefficient(fromDate,toDate,mergedWeatherRecordList);
        report = WeatherRecordUtil.slopeSummary(slope);
        System.out.println(report);
        System.out.println();

        // Test Case-2
        fromDate = "2013/03/15 10:30:00";
        toDate = "2013/03/17 02:30:00";
        slope= WeatherRecordUtil.calculateSlopeCoefficient(fromDate,toDate,mergedWeatherRecordList);
        report = WeatherRecordUtil.slopeSummary(slope);
        System.out.println(report);
        System.out.println();

        // Test Case-3
        fromDate = "2014/06/21 10:00:00";
        toDate = "2014/06/25 23:59:59";
        slope= WeatherRecordUtil.calculateSlopeCoefficient(fromDate,toDate,mergedWeatherRecordList);
        report = WeatherRecordUtil.slopeSummary(slope);
        System.out.println(report);




    }

    public static List<WeatherRecord> loadData() {
        // 0. mergedWeatherRecordList
        List<WeatherRecord> mergedWeatherRecordList = new ArrayList<>();

        // 1. List all the data sheet names requires
        var dataSheetList = AuxiliaryUtils.getFileNamesFromDir(targetDirectory);

        // 2. traverse each data sheet, parse lines from them, convert each line into a weatherRecord object
        for (String dataSheet : dataSheetList
        ) {
            // Load the data (get individual lines) from that respective dataSheet
            var linesFromDataSheet = TextLoader.parseLines(targetDirectory + dataSheet);

            // filter the first line as it contains header
            var linesFromDataSheet_filterFirst = linesFromDataSheet.subList(1, linesFromDataSheet.size());

            // from each line, parse the attributes and get the WeatherRecord object
            var weatherRecordList = linesFromDataSheet_filterFirst
                    .stream()
                    .map(line -> WeatherRecordUtil.parseWeatherRecord(line))
                    .collect(Collectors.toList());

            mergedWeatherRecordList.addAll(weatherRecordList);

            //System.out.println("Total Records: "+ mergedWeatherRecordList.size());


        }
        return mergedWeatherRecordList;
    }
}
