package com.fer.sunshineapp;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class PointsActivity extends AppCompatActivity {

    TextView tvPoints, tvReward;
    Button btnAddPoint;
    int points = 0;
    final String PIN = "1234"; // mamá lo puede cambiar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points);

        tvPoints = findViewById(R.id.tvPoints);
        tvReward = findViewById(R.id.tvReward);
        btnAddPoint = findViewById(R.id.btnAddPoint);

        SharedPreferences prefs = getSharedPreferences("PointsData", MODE_PRIVATE);
        points = prefs.getInt("points", 0);
        updateUI();

        btnAddPoint.setOnClickListener(v -> {
            // pedir PIN
            final EditText input = new EditText(this);
            new AlertDialog.Builder(this)
                    .setTitle("Ingresar PIN")
                    .setView(input)
                    .setPositiveButton("OK", (dialog, which) -> {
                        if (input.getText().toString().equals(PIN)) {
                            points++;
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putInt("points", points);
                            editor.apply();
                            updateUI();
                        }
                    })
                    .setNegativeButton("Cancelar", null)
                    .show();
        });
    }

    private void updateUI() {
        tvPoints.setText("Puntos: " + points);
        if (points >= 5) {
            tvReward.setText("🎉 ¡Tienes 15% de descuento en tu próximo servicio!");
        } else {
            tvReward.setText("Acumula 5 puntos para obtener 15% de descuento");
        }
    }
}
