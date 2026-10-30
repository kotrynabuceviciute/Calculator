package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onBtnClick(View view) {
        EditText etText = findViewById(R.id.etText);
        String btn = ((Button) view).getText().toString();
        String expr = etText.getText().toString();

        if (btn.equals("=")) {
            if (expr.contains("√-")) {
                Toast.makeText(this, "Negalimas skaičiavimas", Toast.LENGTH_SHORT).show();
            } else {
                Expression evaluator = new Expression(expr);
                double result = evaluator.calculate();
                etText.setText(String.valueOf(result));
            }
        }
        else if (btn.equals("√")) {
            etText.append("√");

        }
        else if (btn.equals("CE")) {
            if (!expr.isEmpty()) {
                etText.setText(expr.substring(0, expr.length() - 1));
            }

        }
        else if (btn.equals("C")) {
            etText.setText("");

        }
        else if (btn.equals("±")) {
            if (!expr.isEmpty()) {
                double value = Double.parseDouble(expr);
                value = -value;
                etText.setText(String.valueOf(value));
            }

        }
        else {
            etText.append(btn);
        }
    }
}