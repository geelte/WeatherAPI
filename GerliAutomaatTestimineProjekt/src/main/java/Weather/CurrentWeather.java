package Weather;

import com.google.gson.annotations.SerializedName;

import static Weather.KelvinToCelsius.KELVIN_TO_CELSIUS;

public class CurrentWeather implements APIModel {

    @SerializedName("name")
    private String Location;


    private WeatherMain main;

    public String getLocation() {
        return Location;
    }

    public double getTemperature() {
        return this.main.getDegree();
    }

    public double getTemperatureInCelsius() {
        return this.main.getDegree() - KELVIN_TO_CELSIUS;
    }

    @Override
    public String toString() {
        return String.format("Weather in %s:\n\tTemperature: %.2f",
                this.getLocation(), this.getTemperatureInCelsius());
    }
}
