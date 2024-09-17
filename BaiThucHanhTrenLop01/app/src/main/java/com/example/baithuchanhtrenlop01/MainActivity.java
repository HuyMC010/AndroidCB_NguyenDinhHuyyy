package com.example.baithuchanhtrenlop01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText edtA, edtB;
    private TextView result;
    private Button btnSum, btnSub, btnMul, btnDiv, btnUCLN, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtA = findViewById(R.id.edt);
        edtB = findViewById(R.id.edt2);
        result = findViewById(R.id.textView9);
        btnSum = findViewById(R.id.btn);
        btnSub = findViewById(R.id.btn2);
        btnMul = findViewById(R.id.btn3);
        btnDiv = findViewById(R.id.btn4);
        btnUCLN = findViewById(R.id.btn5);
        btnExit = findViewById(R.id.btn6);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnSum.setOnClickListener(v -> calculateSum());
        btnSub.setOnClickListener(v -> calculateDifference());
        btnMul.setOnClickListener(v -> calculateProduct());
        btnDiv.setOnClickListener(v -> calculateQuotient());
        btnUCLN.setOnClickListener(v -> calculateGCD());
        btnExit.setOnClickListener(v -> finish());
    }

    private void calculateSum() {
        double a = getInput(edtA);
        double b = getInput(edtB);
        if (!Double.isNaN(a) && !Double.isNaN(b)) {
            double sum = a + b;
            result.setText("Tổng: " + sum);
        }
    }

    private void calculateDifference() {
        double a = getInput(edtA);
        double b = getInput(edtB);
        if (!Double.isNaN(a) && !Double.isNaN(b)) {
            double difference = a - b;
            result.setText("Hiệu: " + difference);
        }
    }

    private void calculateProduct() {
        double a = getInput(edtA);
        double b = getInput(edtB);
        if (!Double.isNaN(a) && !Double.isNaN(b)) {
            double product = a * b;
            result.setText("Tích: " + product);
        }
    }

    private void calculateQuotient() {
        double a = getInput(edtA);
        double b = getInput(edtB);
        if (!Double.isNaN(a) && !Double.isNaN(b)) {
            if (b != 0) {
                double quotient = a / b;
                result.setText("Thương: " + quotient);
            } else {
                Toast.makeText(this, "Số B không thể bằng 0", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void calculateGCD() {
        double a = getInput(edtA);
        double b = getInput(edtB);
        if (!Double.isNaN(a) && !Double.isNaN(b)) {
            if (a == (int) a && b == (int) b) {
                int gcd = gcd((int) a, (int) b);
                result.setText("Ước chung lớn nhất: " + gcd);
            } else {
                Toast.makeText(this, "Vui lòng nhập số nguyên để tính ước chung lớn nhất", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private double getInput(EditText editText) {
        try {
            return Double.parseDouble(editText.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show();
            return Double.NaN;
        }
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
