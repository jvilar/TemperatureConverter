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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
                onCelsiusChanged(s.toString());
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
                onFahrenheitChanged(s.toString());
            }
        });
    }

    public void onCelsiusChanged(String s) {
        if (changing)
            return;
        changing = true;
        if (!s.isEmpty()) {
            double celsius = Double.parseDouble(s);
            double fahrenheit = celsius / 100 * 180 + 32;
            this.fahrenheit.setText(fahrenheit + "");
        } else
            this.fahrenheit.setText("");
        changing = false;
    }

    public void onFahrenheitChanged(String s) {
        if (changing)
            return;
        changing = true;
        if (!s.isEmpty()) {
            double fahrenheit = Double.parseDouble(s);
            double celsius = (fahrenheit - 32) / 180 * 100;
            this.celsius.setText(celsius + "");
        } else
            this.celsius.setText("");
        changing = false;
    }
}
