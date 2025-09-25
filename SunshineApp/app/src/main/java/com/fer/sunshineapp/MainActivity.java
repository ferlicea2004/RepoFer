package com.fer.sunshineapp;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnProfile, btnCatalog, btnPoints, btnBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnProfile = findViewById(R.id.btnProfile);
        btnCatalog = findViewById(R.id.btnCatalog);
        btnPoints = findViewById(R.id.btnPoints);
        btnBooking = findViewById(R.id.btnBooking);

        btnProfile.setOnClickListener(v -> startActivity(new Intent(this, ProfileActivity.class)));
        btnCatalog.setOnClickListener(v -> startActivity(new Intent(this, ServicesActivity.class)));
        btnPoints.setOnClickListener(v -> startActivity(new Intent(this, PointsActivity.class)));
        btnBooking.setOnClickListener(v -> startActivity(new Intent(this, BookingActivity.class)));
    }
}
