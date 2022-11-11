package org.codeclinic.problems.prb4_manufacture.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ManufactureRecord {
    /*

    Date timestamp = formatParsedDateFromDataSheet.parse(record.get("time_stamp"));
            var pulsometer = Integer.parseInt(record.get("Pulsometer_readout"));
            var engineeff = Double.parseDouble(record.get("Engine_efficiency"));
            var red= Integer.parseInt(record.get("red_Value"));
            var blue = Integer.parseInt(record.get("blue_Value"));
            var green = Integer.parseInt(record.get("green_Value"));
     */

    private final Date timestamp;
    private final Integer pulsometer;
    private final Double engineeff;
    private final Integer red;
    private final Integer blue;
    private final Integer green;

    // constructor
    public ManufactureRecord(Date timestamp, Integer pulsometer, Double engineeff, Integer red, Integer blue, Integer green) {
        this.timestamp = timestamp;
        this.pulsometer = pulsometer;
        this.engineeff = engineeff;
        this.red = red;
        this.blue = blue;
        this.green = green;
    }

    // Getter
    public Date getTimestamp() {
        return timestamp;
    }

    public Integer getPulsometer() {
        return pulsometer;
    }

    public Double getEngineeff() {
        return engineeff;
    }

    public Integer getRed() {
        return red;
    }

    public Integer getBlue() {
        return blue;
    }

    public Integer getGreen() {
        return green;
    }


    // Print the Object

    @Override
    public String toString() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "ManufactureRecord{" +
                "timestamp=" + format.format(timestamp) +
                ", pulsometer=" + pulsometer +
                ", engineeff=" + engineeff +
                ", red=" + red +
                ", blue=" + blue +
                ", green=" + green +
                '}';
    }
}
