package Weather;

import java.util.HashMap;

public class ForecastWeather implements APIModel {

    private ForecastDay[] ForecastArray = new ForecastDay[3];

    public HashMap<String, Object> city;
    public HashMap<String, Object>[] list;

    public String getLocation() {
        return (String) city.get("name");
    }

    public void ForecastPredictionForThreeDays() {
        int counter = 0;
        for (HashMap<String, Object> day : list) {
            if (counter == 3) break;
            ForecastDay forecastDay = new ForecastDay(day);
            ForecastArray[counter++] = forecastDay;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Forecast for the next 3 days:\n");
        for (ForecastDay day:
                ForecastArray) {
            sb.append(String.format("\tMin: %.2f | Max: %.2f\n", day.getDegreeMinCelsius(), day.getDegreeMaxCelsius()));
        }
        return sb.toString();
    }
}
