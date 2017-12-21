package Connection;

import org.junit.Test;
import static org.junit.Assert.*;

public class UrlGenerationTest {

    @Test
    public void generateCurrentWeatherLinkByCityTest() {
        String CityName = "Tallinn";
        String link = API.GetWeatherLink(CityName);
        assertEquals("http://api.openweathermap.org/data/2.5/weather?q=Tallinn&APPID=366131595824a73f1e38e53b2bfce155", link);
    }

    @Test
    public void GetForecastLinkByCityTest() {
        String CityName = "Tallinn";
        String link = API.GetForecastLink(CityName);
        assertEquals("http://api.openweathermap.org/data/2.5/forecast?q=Tallinn&APPID=366131595824a73f1e38e53b2bfce155", link);
    }

}
