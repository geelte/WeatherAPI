package Connection;

public class API {

    private static final String API_WEATHER_BASE_LINK = "http://api.openweathermap.org/data/2.5/weather?q=";
    private static final String API_FORECAST_LINK = "http://api.openweathermap.org/data/2.5/forecast?q=";
    private static final String API_KEY = "&APPID=366131595824a73f1e38e53b2bfce155";

    public static String GetWeatherLink(String city) {
        return API_WEATHER_BASE_LINK
                + city
                + API_KEY;
    }

    public static String GetForecastLink(String city) {
        return API_FORECAST_LINK
                + city
                + API_KEY;
    }
    public static String TestLink() {
        return "http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=366131595824a73f1e38e53b2bfce155";
    }
}
