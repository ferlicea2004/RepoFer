package com.fer.sunshineapp;



import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    EditText etName, etPhone, etEmail;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etEmail = findViewById(R.id.etEmail);
        btnSave = findViewById(R.id.btnSave);

        SharedPreferences prefs = getSharedPreferences("ClientData", MODE_PRIVATE);
        etName.setText(prefs.getString("name", ""));
        etPhone.setText(prefs.getString("phone", ""));
        etEmail.setText(prefs.getString("email", ""));

        btnSave.setOnClickListener(v -> {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("name", etName.getText().toString());
            editor.putString("phone", etPhone.getText().toString());
            editor.putString("email", etEmail.getText().toString());
            editor.apply();
            Toast.makeText(this, "Perfil guardado", Toast.LENGTH_SHORT).show();
        });
    }
}
