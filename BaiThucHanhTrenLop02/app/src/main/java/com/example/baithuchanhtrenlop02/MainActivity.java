package com.example.baithuchanhtrenlop02;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtFar;
    EditText txtCel;
    Button btnFar;
    Button btnCel;
    Button btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtFar = findViewById(R.id.txtFar);
        txtCel = findViewById(R.id.editTextText2);
        btnFar = findViewById(R.id.btnFar);
        btnCel = findViewById(R.id.btnCel);
        btnClear = findViewById(R.id.btnClear);

        btnFar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fahrenheitInput = txtFar.getText().toString();
                if (!fahrenheitInput.isEmpty()) {
                    try {
                        double fahrenheit = Double.parseDouble(fahrenheitInput);
                        double celsius = (fahrenheit - 32) * 5 / 9;
                        txtCel.setText(String.format("%.2f", celsius));
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập giá trị Fahrenheit", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String celsiusInput = txtCel.getText().toString();
                if (!celsiusInput.isEmpty()) {
                    try {
                        double celsius = Double.parseDouble(celsiusInput);
                        double fahrenheit = (celsius * 9 / 5) + 32;
                        txtFar.setText(String.format("%.2f", fahrenheit));
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập giá trị Celsius", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtFar.setText("");
                txtCel.setText("");
            }
        });
    }
}
