package com.fer.sunshineapp;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ServicesActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ServiceAdapter adapter;
    List<ServiceItem> serviceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        recyclerView = findViewById(R.id.recyclerViewServices);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        serviceList = new ArrayList<>();
        serviceList.add(new ServiceItem("Manicure", R.drawable.manicure));
        serviceList.add(new ServiceItem("Pedicure", R.drawable.pedicure));
        serviceList.add(new ServiceItem("Uñas", R.drawable.unas));
        serviceList.add(new ServiceItem("Depilación", R.drawable.depilacion));
        serviceList.add(new ServiceItem("Pestañas", R.drawable.pestanas));
        serviceList.add(new ServiceItem("Maquillaje", R.drawable.maquillaje));
        serviceList.add(new ServiceItem("Perfilación de cejas", R.drawable.cejas));

        adapter = new ServiceAdapter(serviceList);
        recyclerView.setAdapter(adapter);
    }
}
