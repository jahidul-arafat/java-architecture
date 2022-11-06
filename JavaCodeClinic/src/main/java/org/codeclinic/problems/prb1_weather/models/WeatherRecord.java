package org.codeclinic.problems.prb1_weather.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WeatherRecord {
    private final Date when;
    private final Double pressure;
    private final Double humidity;

    public WeatherRecord(Date when, Double pressure, Double humidity) {
        this.when = when;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    // getter

    public Date getWhen() {
        return when;
    }

    public Double getPressure() {
        return pressure;
    }

    public Double getHumidity() {
        return humidity;
    }

    // Print the object

    @Override
    public String toString() {
        DateFormat format = new SimpleDateFormat("yyyy_MM_dd HH:mm:ss");
        return String.format("Date for: %s Barometric Pressure %s Humidity: %s",
                format.format(when),
                pressure,
                humidity);
    }
}
