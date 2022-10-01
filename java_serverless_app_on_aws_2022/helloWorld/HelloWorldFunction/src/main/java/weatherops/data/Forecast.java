package weatherops.data;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * lombok annotation @Data and @NoArgConstructor cant be used for ENUM, only applicable for Class
 * */
public enum Forecast {
    STROM("Stromy weather"),
    CLOUDY("Cloudy Weather"),
    SUNNY("Sunny weather");

    private final String label;

    Forecast(String label) {
        this.label=label;
    }

    public String getLabel() {
        return label;
    }
}
