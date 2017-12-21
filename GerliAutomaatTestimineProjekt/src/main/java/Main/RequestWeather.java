package Main;

import Connection.HTTP;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import Connection.API;
import Weather.CurrentWeather;
import Weather.ForecastWeather;

public class RequestWeather {

    static CurrentWeather CityCurrentWeather(String CityName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String link = API.GetWeatherLink(CityName);
        HTTP http = new HTTP(link);
        String bufferData = http.DataComingFromConnection();
        if (bufferData.equals("Connection error")) {
            return null;
        } else {
            return gson.fromJson(bufferData, CurrentWeather.class);
        }
    }
    static ForecastWeather CityForecast(String CityName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String link = API.GetForecastLink(CityName);
        HTTP http = new HTTP(link);
        String bufferData = http.DataComingFromConnection();
        if (bufferData.equals("Connection error")) {
            return null;
        } else {
            ForecastWeather forecastModel = gson.fromJson(bufferData, ForecastWeather.class);;
            forecastModel.ForecastPredictionForThreeDays();
            return forecastModel;
        }
    }




}
