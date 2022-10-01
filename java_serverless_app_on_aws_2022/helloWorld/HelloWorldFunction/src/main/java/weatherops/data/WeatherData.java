package weatherops.data;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * lombok @Data is only applicable for Class; You cant use it for ENUM
 * If the Lombok annotations are used then you cant override the default Object method i.e. toSrtring
 *
 * */
@Data
@NoArgsConstructor
public class WeatherData {
    private int temp;
    private int humidity;

    // Getter and Setter
    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    // Print th
}
