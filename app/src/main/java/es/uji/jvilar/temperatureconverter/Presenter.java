package es.uji.jvilar.temperatureconverter;

public class Presenter {
    private MainActivity view;

    public Presenter(MainActivity view) {
        this.view = view;
    }

    public void onCelsiusChanged(String s) {
        if (!s.isEmpty()) {
            double celsius = Double.parseDouble(s);
            double fahrenheit = Model.toFahrenheit(celsius);
            view.showFahrenheit(fahrenheit + "");
        } else
            view.showFahrenheit("");
    }

    public void onFahrenheitChanged(String s) {
        if (!s.isEmpty()) {
            double fahrenheit = Double.parseDouble(s);
            double celsius = Model.toCelsius(fahrenheit);
            view.showCelsius(celsius + "");
        } else
            view.showCelsius("");
    }
}
