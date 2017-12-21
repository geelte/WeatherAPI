package Connection;

import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class HttpConnectionTest {


    @Test
    public void connectionNoFailureCheck() {
        String link = "http://www.google.com";
        new HTTP(link);
    }

    @Test
    public void connectToSampleApiUrlWithoutExceptions() {
        String url = "http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b1b15e88fa797225412429c1c50c122a1";
        new HTTP(url);
    }

    @Test
    public void mockHttpServiceBufferDataTest() {
        HTTP mockedHttpConnection = mock(HTTP.class);
        mockedHttpConnection.DataComingFromConnection();
        verify(mockedHttpConnection).DataComingFromConnection();
    }
}
