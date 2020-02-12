package es.uji.jvilar.temperatureconverter;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private boolean changing;
    private EditText celsius;
    private EditText fahrenheit;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new Presenter(this);

        celsius = findViewById(R.id.celsius);
        celsius.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                presenter.onCelsiusChanged(s.toString());
            }
        });

        fahrenheit = findViewById(R.id.fahrenheit);

        fahrenheit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                presenter.onFahrenheitChanged(s.toString());
            }
        });
    }

    public void showFahrenheit(String s) {
        if (changing)
            return;
        changing = true;
        this.fahrenheit.setText(s);
        changing = false;
    }

    public void showCelsius(String s) {
        if (changing)
            return;
        changing = true;
        this.celsius.setText(s);
        changing = false;
    }


}
