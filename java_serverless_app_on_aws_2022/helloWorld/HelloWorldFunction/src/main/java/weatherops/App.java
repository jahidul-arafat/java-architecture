package weatherops;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import weatherops.data.Forecast;
import weatherops.data.WeatherData;

import java.util.ArrayList;
import java.util.List;

public class App implements RequestHandler<WeatherData[], List<Forecast>> {
    @Override
    public List<Forecast> handleRequest(WeatherData[] weatherData, Context context) {
        int counter=1;
        List<Forecast> weatherForcastList = new ArrayList<>();
        for (WeatherData weatherDataItem:weatherData
             ) {
            Forecast whatsWeatherToday;
            System.out.println("Processing weather Data ..: "+counter);
            counter+=1;
            // business logic here
            if (weatherDataItem.getTemp()>50 && weatherDataItem.getHumidity()>70)
                whatsWeatherToday = Forecast.SUNNY;
            else if ((weatherDataItem.getTemp()>20 && weatherDataItem.getTemp()<50) &&
                    (weatherDataItem.getHumidity()>50 && weatherDataItem.getHumidity()<70))
                whatsWeatherToday=Forecast.CLOUDY;
            else whatsWeatherToday = Forecast.STROM;

            System.out.println(context.getFunctionName()+"->"+
                    context.getMemoryLimitInMB());
            weatherForcastList.add(whatsWeatherToday);

        }
        return  weatherForcastList;
    }
}
