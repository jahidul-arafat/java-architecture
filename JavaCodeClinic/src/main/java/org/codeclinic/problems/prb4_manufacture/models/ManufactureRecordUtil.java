package org.codeclinic.problems.prb4_manufacture.models;

import org.apache.commons.csv.CSVRecord;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ManufactureRecordUtil {
    // 2018-01-01T08:00:00Z
    private static DateFormat formatParsedDateFromDataSheet = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static ManufactureRecord parseManufactureItem(CSVRecord record){
        try {
            var tmpDate = record.get("time_stamp");
            var tmpDateList = Arrays.stream(tmpDate.split("T")).toList();
            var finalTmpDate = tmpDateList.get(0)+ " "+ tmpDateList.get(1).substring(0,tmpDateList.get(1).length()-1);
            Date timestamp = formatParsedDateFromDataSheet.parse(finalTmpDate);

            var pulsometer = Integer.parseInt(record.get("Pulsometer_readout"));
            var engineeff = Double.parseDouble(record.get("Engine_efficiency"));
            var red= Integer.parseInt(record.get("red_Value"));
            var blue = Integer.parseInt(record.get("blue_Value"));
            var green = Integer.parseInt(record.get("green_Value"));

            return new ManufactureRecord(timestamp,pulsometer,engineeff,red,blue,green);

        } catch (Exception e){
            System.out.println("Exception: "+ e.getMessage());
            return null;
        }

    }





}
