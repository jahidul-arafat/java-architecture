package org.codeclinic.problems.prb1_weather.models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class WeatherRecordUtil {
    private static DateFormat formatParsedDateFromDataSheet = new SimpleDateFormat("yyyy_MM_dd HH:mm:ss");
    private static DateFormat formatParsedDateFromUserInput = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    public static WeatherRecord parseWeatherRecord(String dataString){
        var fields = Arrays.asList(dataString.split("\t"));

        try {
            Date when = formatParsedDateFromDataSheet.parse(fields.get(0));
            Double pressure = Double.parseDouble(fields.get(2));
            Double humidity = Double.parseDouble(fields.get(4));

            return new WeatherRecord(when,pressure, humidity);

        }catch (Exception e){
            System.out.println("Exception: "+ e.getMessage());
            return null;
        }

    }

    public static Double calculateSlopeCoefficient(String fromDate, String toDate, List<WeatherRecord> weatherRecordList){
        /*
        Slope       = rise/run
                    = (y2-y1)/(x2-x1)
         */

        Date fromDateFormatted = null;
        Date toDateFormatted = null;

        try {
            fromDateFormatted = formatParsedDateFromUserInput.parse(fromDate); // userInput in "2012/01/01 00:30:00" format
            toDateFormatted = formatParsedDateFromUserInput.parse(toDate);
        } catch (Exception e) {
            System.out.println("Exception: "+ e.getMessage());
        }

        System.out.println("FromDateFormatted: "+ fromDateFormatted);   // comment it
        System.out.println("ToDateFormatted: "+ toDateFormatted);       // comment it

        WeatherRecord y1 = null; // raise1
        WeatherRecord y2 = null; // raise2
        int idx =0, x1=0,x2=0; // 0,1,2,3,4,5,6,7 {run}
        Boolean stopFlag = false;

        for (WeatherRecord weatherRecord: weatherRecordList
             ) {
            //System.out.println("Traversing Weather Record: "+ weatherRecord);

            // Get the BeginDate
            // if startFlag is before or at weatherRecord date
            if ((y1==null) && (
                    fromDateFormatted.before(weatherRecord.getWhen()) ||
                            fromDateFormatted.equals(weatherRecord.getWhen()))
            ){
                System.out.println("---------------------------------------------------------");
                System.out.println("BeginDate Found. Registering BeginDate Flag .......");
                y1= weatherRecord; // Register BeginDate
                x1= idx;           // Register Run
                System.out.println("X1: "+ x1);
                System.out.println("Y1: "+y1);
                System.out.println("---------------------------------------------------------");
            }

            // get the EndDate
            // weatherRecord date is after or at the endFlag
            if (weatherRecord.getWhen().after(toDateFormatted) || weatherRecord.getWhen().equals(toDateFormatted)){
                System.out.println("---------------------------------------------------------");
                System.out.println("EndDate Found. Registering EndDate Flag .......");
                x2=idx;
                y2=weatherRecord;
                stopFlag = true;  // get out of the forLoop, if weatherRecord.getWhen is not in range of fromDate and toDate
                        // weatherRecord.getWhen is beyond toDate
                System.out.println("X2: "+x2);   // Register Run
                System.out.println("Y2: "+ y2); // Register EndDate
                System.out.println("---------------------------------------------------------");
            }

            // break, if weatherRecord.getWhen is not in range of fromDate and toDate
            if (stopFlag)
                break;
            idx++; // x axis -> run, always increment by 1 for each WeatherRecord Reading



        } // traversing weatherRecord ends

        // return the slope
        return (y2.getPressure()- y1.getPressure())/(x2-x1);

    }

    public static String slopeSummary(Double slope){
        String forecast="";
        String result= String.format("Barometric Pressure Slope is <%s>, Forecast: ",slope);
        forecast = slope>0? "Weather Condition improving, Next:: Fair and Sunny Weather":
                slope<0?"Inclement Weather is Close in":"Stable Weather";
        return result+" "+ forecast;
    }
}
