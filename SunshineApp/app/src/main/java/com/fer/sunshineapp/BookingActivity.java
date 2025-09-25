package com.fer.sunshineapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

public class BookingActivity extends AppCompatActivity {

    DatePicker datePicker;
    TimePicker timePicker;
    Button btnBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        btnBook = findViewById(R.id.btnBook);

        btnBook.setOnClickListener(v -> {
            int day = datePicker.getDayOfMonth();
            int month = datePicker.getMonth() + 1;
            int year = datePicker.getYear();
            int hour = timePicker.getHour();
            int minute = timePicker.getMinute();

            String message = "Hola, quiero agendar una cita el " + day + "/" + month + "/" + year +
                    " a las " + hour + ":" + String.format("%02d", minute);

            String phone = "+522291332290";
            String url = "https://wa.me/" + phone + "?text=" + Uri.encode(message);

            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });
    }
}
