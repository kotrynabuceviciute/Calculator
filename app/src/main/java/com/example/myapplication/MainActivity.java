package com.example.myapplication;

import android.annotation.SuppressLint;
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

    @SuppressLint("DefaultLocale")
    public void onBtnClick(View view) {
        EditText etText = findViewById(R.id.etText);
        String btn = ((Button) view).getText().toString();
        String expr = etText.getText().toString();

        if (btn.equals(getString(R.string.btnEquals))) {
            String result = calculate(expr);
            if (result.equals("Klaida")) {
                Toast.makeText(this, "Negalimas skaičiavimas", Toast.LENGTH_SHORT).show();
            } else {
                etText.setText(result);
            }
        }
        else if (btn.equals(getString(R.string.btnSqrt))) {
            etText.append(getString(R.string.btnSqrt));
        }
        else if (btn.equals(getString(R.string.btnCE))) {
            if (!expr.isEmpty()) {
                etText.setText(expr.substring(0, expr.length() - 1));
            }
        }
        else if (btn.equals(getString(R.string.btnC))) {
            etText.setText("");
        }
        else if (btn.equals(getString(R.string.btnPlusMinus))) {
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

    @SuppressLint("DefaultLocale")
    public static String calculate(String expr) {
        if (expr.contains("√-")  || expr.contains("/0") || expr.isEmpty() || expr.equals(" ")) {
            return "Klaida";
        }

        Expression evaluator = new Expression(expr);
        double result = evaluator.calculate();

        if (result == (long) result) {
            return String.format("%d", (long) result);
        } else {
            return String.format("%.2f", result);
        }
    }
}
