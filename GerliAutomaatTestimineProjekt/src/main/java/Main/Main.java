package Main;

import InputOutput.WritingToFile;
import Weather.CurrentWeather;
import Weather.ForecastWeather;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        System.out.print("Enter a if you want read weather from console, \n" +
                        "Enter b if you want input.txt file information!\n" );
        while (true) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNext()) {
                String input = scanner.next();
                scanner.nextLine();
                if (input.equals("a")) {
                    AskConsole(scanner);
                    break;
                } else if (input.equals("b")) {
                    InformationFromInputFile();
                    break;
                } else {
                    System.out.println("Valid a console or b");
                }

            }

        }
    }

    private static void AskConsole(Scanner scanner) {
        while (true) {
            System.out.println("Enter city name to get weather information or 'quit' to exit");
            if (scanner.hasNext()) {
                String input = scanner.nextLine();
                if ("quit".equals(input)) {
                    System.out.println("Quit!");
                    break;
                } else {
                    String city = input.toUpperCase();
                    CurrentWeather currentWeatherModel = RequestWeather.CityCurrentWeather(city);
                    System.out.println(currentWeatherModel);
                    ForecastWeather forecastModel = RequestWeather.CityForecast(city);
                    System.out.println(forecastModel);
                }
            }
        }
    }

    private static void InformationFromInputFile() {
        WritingToFile writingToFile = new WritingToFile();
        String[] input = writingToFile.InputReader("C:\\Users\\arvuti\\Desktop\\MihkelAutomaatTestimineBackUP1\\inputTxtFile\\input.txt");
        for (String city : input) {
            CurrentWeather currentWeatherModel = RequestWeather.CityCurrentWeather(city);
            ForecastWeather forecastModel = RequestWeather.CityForecast(city);
            writingToFile.OutputWriter(city, currentWeatherModel, forecastModel);


        }
    }
}
