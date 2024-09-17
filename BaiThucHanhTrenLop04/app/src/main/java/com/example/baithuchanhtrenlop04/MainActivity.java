package com.example.baithuchanhtrenlop04;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnChuanDoan = findViewById(R.id.btntinhBMI);
        btnChuanDoan.setOnClickListener(v -> btnTinhBMI());
    }

    public void btnTinhBMI() {
        Button btnChuanDoan =(Button) findViewById(R.id.btntinhBMI);
        EditText editten, editchieucao, editcannang, editBMI, editChandoan;
        editten = findViewById(R.id.editten);
        editchieucao = findViewById(R.id.editchieucao);
        editcannang = findViewById(R.id.editcannang);
        editBMI = findViewById(R.id.editBMI);
        editChandoan = findViewById(R.id.editChanDoan);

        try {
            double H = Double.parseDouble(editchieucao.getText().toString());
            double W = Double.parseDouble(editcannang.getText().toString());
            double BMI = W / Math.pow(H , 2);
            String chandoan = "";

            if (BMI < 18) {
                chandoan = "Bạn gầy";
            } else if (BMI <= 24.9) {
                chandoan = "Bạn bình thường";
            } else if (BMI <= 29.9) {
                chandoan = "Bạn béo phì độ 1";
            } else if (BMI <= 34.9) {
                chandoan = "Bạn béo phì độ 2";
            } else {
                chandoan = "Bạn béo phì độ 3";
            }
            DecimalFormat df = new DecimalFormat("#.0");
            editBMI.setText(df.format(BMI));
            editChandoan.setText(chandoan);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Vui lòng nhập chiều cao và cân nặng hợp lệ!", Toast.LENGTH_SHORT).show();
        }
    }
}
