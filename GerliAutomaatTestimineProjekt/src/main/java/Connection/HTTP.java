package Connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;

public class HTTP {

    private HttpURLConnection connection;

    public HTTP(String url) {
        try {
            this.connection = (HttpURLConnection) (new URL(url).openConnection());
            this.connection.setConnectTimeout(6000);
            this.connection.setReadTimeout(12000);

            this.connection.connect();
            if (this.connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            } else {
                System.err.println("Connection Error");
                throw new IOException();
            }
        } catch (SocketTimeoutException e) {
            System.err.println("Connection Timeout!");
        } catch (IOException e) {
            System.err.println("Connection Timeout Error");
        }
    }

    public String DataComingFromConnection() {
        try {
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    StringBuilder builder = new StringBuilder();
                    BufferedReader stream = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    while (stream.ready()) {
                        builder.append(stream.readLine());
                    }
                    return builder.toString();
            }
        } catch (IOException e) {
            System.err.println("Buffer error");
        }
        return "Error DataComingFromConnection";
    }
}
