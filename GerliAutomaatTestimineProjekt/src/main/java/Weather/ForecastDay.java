package Weather;

import com.google.gson.internal.LinkedTreeMap;

import java.util.HashMap;

import static Weather.KelvinToCelsius.KELVIN_TO_CELSIUS;

class ForecastDay {

    private double DegreeMax;
    private double DegreeMin;

    public ForecastDay(HashMap<String, Object> jsonDay) {

        LinkedTreeMap<String, Double> dayMain = (LinkedTreeMap<String, Double>) jsonDay.get("main");
        DegreeMax = dayMain.get("temp_max");
        DegreeMin = dayMain.get("temp_min");
    }

    public double getDegreeMaxCelsius() {
        return DegreeMax - KELVIN_TO_CELSIUS;
    }

    public double getDegreeMinCelsius() {
        return DegreeMin - KELVIN_TO_CELSIUS;
    }

    public double getDegreeMax() {
        return DegreeMax;
    }

    public double getDegreeMin() {
        return DegreeMin;
    }
}
