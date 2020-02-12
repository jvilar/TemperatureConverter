package es.uji.jvilar.temperatureconverter;

public class Model {
    public static double toFahrenheit(double celsius) {
        return celsius * 180 / 100 + 32;
    }

    public static double toCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 100 / 180;
    }
}
