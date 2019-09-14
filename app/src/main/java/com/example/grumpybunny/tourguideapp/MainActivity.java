package com.example.grumpybunny.tourguideapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // start the toolbar. This will hold icons for actions users can take
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        TextView restaurants = findViewById(R.id.restaurants);
        TextView hotels = findViewById(R.id.hotels);
        TextView attractions = findViewById(R.id.attractions);
        TextView calendar = findViewById(R.id.calendar);

        // click listener for the restaurants button
        restaurants.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), PlacesListActivity.class);
            intent.putExtra("title", "Restaurants in Washington DC");
            intent.putExtra("dataSet", "Restaurants");
            v.getContext().startActivity(intent);
        });

        // click listener for the attractions button
        attractions.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), PlacesListActivity.class);
            intent.putExtra("title", "Attractions in Washington DC");
            intent.putExtra("dataSet", "Attractions");
            v.getContext().startActivity(intent);
        });

        // click listener for the attractions button
        hotels.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), PlacesListActivity.class);
            intent.putExtra("title", "Hotels in Washington DC");
            intent.putExtra("dataSet", "Hotels");
            v.getContext().startActivity(intent);
        });

        // click listener for the calendar button
        calendar.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), PlacesListActivity.class);
            intent.putExtra("title", "Events in Washington DC");
            intent.putExtra("dataSet", "Events");
            v.getContext().startActivity(intent);
        });
    }
}
