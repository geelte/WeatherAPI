package InputOutput;

import Weather.CurrentWeather;
import Weather.ForecastWeather;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class WritingToFile {

    public String[] InputReader(String filename) {
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            List<String> lines = new ArrayList<String>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
            bufferedReader.close();
            return lines.toArray(new String[lines.size()]);
        } catch (IOException e) {
            System.err.println("Error InputReader");
            return null;
        }
    }

    public void OutputWriter(String CityName, CurrentWeather owModel, ForecastWeather forecastModel) {
        try {
            PrintWriter writer = new PrintWriter("C:\\Users\\arvuti\\Desktop\\MihkelAutomaatTestimineBackUP1\\outputTxtFile\\" + CityName + ".txt", "UTF-8");
            writer.println(owModel);
            writer.println(forecastModel);
            System.out.println(CityName + " recorded!");
            writer.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error FileNotFoundException");
        } catch (UnsupportedEncodingException e) {
            System.err.println("Error UnsupportedEncodingException");
        }
    }

}
