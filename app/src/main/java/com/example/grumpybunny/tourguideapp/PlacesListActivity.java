package com.example.grumpybunny.tourguideapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlacesListActivity extends AppCompatActivity {

    // use ButterKnife to bind the recycler view
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    PlacesAdapter placesAdapter;
    LinearLayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placeslist);
        ButterKnife.bind(this);
        setUp();

    }

    // Set up the layout for the recycler view
    private void setUp() {
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        placesAdapter = new PlacesAdapter(new ArrayList<>());

//        prepareRestaurantContent();

        //collect the name of the data set we need to populate the layout
        Intent intent = getIntent();
        String view = intent.getStringExtra("dataSet");
        String viewTitle = intent.getStringExtra("title");

        TextView titleBar = findViewById(R.id.titleBar);
        titleBar.setText(viewTitle);

        // determine which data set to use (array)

        if (view.equals("Restaurants")) {
            Log.d("PlacesActivity","Calling Restaurants View");
            prepareRestaurantContent();
        }
        if (view.equals("Hotels")) {
            Log.d("PlacesActivity","Calling Hotels View");
            prepareHotelContent();
        }
        if (view.equals("Attractions")) {
            Log.d("PlacesActivity","Calling Attractions View");
            prepareAttractionContent();
        }
        if (view.equals("Events")) {
            Log.d("PlacesActivity","Calling Events View");
            prepareEventsContent();
        }
    }

    private void prepareRestaurantContent() {
        Log.d("PlacesActivity","Populating Restaurants View");
        ArrayList<Places> places = new ArrayList<>();

        // define the typed array resources that hold the data values
        String[] name = getResources().getStringArray(R.array.restaurantNames);
        String[] address = getResources().getStringArray(R.array.restaurantAddress);
        String[] addressURI = getResources().getStringArray(R.array.restaurantAddressURI);
        String[] hours = getResources().getStringArray(R.array.restaurantHours);
        String[] phone = getResources().getStringArray(R.array.restaurantPhone);
        String[] website = getResources().getStringArray(R.array.restaurantWebsiteURI);
        String[] reviewStars = getResources().getStringArray(R.array.restaurantReviewStars);
        String[] twitter = getResources().getStringArray(R.array.restaurantTwitterURI);
        TypedArray typedArray = getResources().obtainTypedArray(R.array.restaurantPhoto);


        // populate the list with values from the typed array resources
        for (int i = 0; i < name.length ; i++) {

            int photoResourceId = typedArray.getResourceId(i, 0);
            Log.d("PlacesActivity", "Restaurants: adding - " + name[i] + " " + address[i] + " " + addressURI[i] + " " + phone[i] + " " + website[i] + " " + reviewStars[i] + " " + photoResourceId + " " + twitter[i] + " " + hours[i]);
            places.add(new Places(name[i], address[i], addressURI[i], phone[i], website[i], reviewStars[i], photoResourceId, twitter[i], hours[i]));

        }

        typedArray.recycle();

        // call the SongAdapter class once all data items are in the array
        placesAdapter.addItems(places);
        recyclerView.setAdapter(placesAdapter);

    }

    private void prepareHotelContent() {
        Log.d("PlacesActivity","Populating Hotel View");
        ArrayList<Places> places = new ArrayList<>();

        // define the typed array resources that hold the data values
        String[] name = getResources().getStringArray(R.array.hotelNames);
        String[] address = getResources().getStringArray(R.array.hotelAddress);
        String[] addressURI = getResources().getStringArray(R.array.hotelAddressURI);
        String[] hours = getResources().getStringArray(R.array.hotelHours);
        String[] phone = getResources().getStringArray(R.array.hotelPhone);
        String[] website = getResources().getStringArray(R.array.hotelWebsiteURI);
        String[] reviewStars = getResources().getStringArray(R.array.hotelReviewStars);
        String[] twitter = getResources().getStringArray(R.array.hotelTwitterURI);
        TypedArray typedArray = getResources().obtainTypedArray(R.array.hotelPhoto);

        // populate the list with values from the typed array resources
        for (int i = 0; i < name.length ; i++) {

            int photoResourceId = typedArray.getResourceId(i, 0);
            Log.d("PlacesActivity", "Hotels: adding - " + name[i] + " " + address[i] + " " + addressURI[i] + " " + phone[i] + " " + website[i] + " " + reviewStars[i] + " " + photoResourceId + " " + twitter[i] + " " + hours[i]);
            places.add(new Places(name[i], address[i], addressURI[i], phone[i], website[i], reviewStars[i], photoResourceId, twitter[i], hours[i]));

        }

        typedArray.recycle();

        // call the SongAdapter class once all data items are in the array
        placesAdapter.addItems(places);
        recyclerView.setAdapter(placesAdapter);

    }
    private void prepareAttractionContent() {
        Log.d("PlacesActivity","Populating Attraction View");
        ArrayList<Places> places = new ArrayList<>();

        // define the typed array resources that hold the data values
        String[] name = getResources().getStringArray(R.array.attractionNames);
        String[] address = getResources().getStringArray(R.array.attractionAddress);
        String[] addressURI = getResources().getStringArray(R.array.attractionAddressURI);
        String[] hours = getResources().getStringArray(R.array.attractionHours);
        String[] phone = getResources().getStringArray(R.array.attractionPhone);
        String[] website = getResources().getStringArray(R.array.attractionWebsiteURI);
        String[] reviewStars = getResources().getStringArray(R.array.attractionReviewStars);
        String[] twitter = getResources().getStringArray(R.array.attractionTwitterURI);
        TypedArray typedArray = getResources().obtainTypedArray(R.array.attractionPhoto);

        // populate the list with values from the typed array resources
        for (int i = 0; i < name.length ; i++) {

            int photoResourceId = typedArray.getResourceId(i, 0);
            Log.d("PlacesActivity", "Attractions: adding - " + name[i] + " " + address[i] + " " + addressURI[i] + " " + phone[i] + " " + website[i] + " " + reviewStars[i] + " " + photoResourceId + " " + twitter[i] + " " + hours[i]);
            places.add(new Places(name[i], address[i], addressURI[i], phone[i], website[i], reviewStars[i], photoResourceId, twitter[i], hours[i]));

        }

        typedArray.recycle();

        // call the SongAdapter class once all data items are in the array
        placesAdapter.addItems(places);
        recyclerView.setAdapter(placesAdapter);

    }
    private void prepareEventsContent() {
        Log.d("PlacesActivity","Populating Calendar View");
        ArrayList<Places> places = new ArrayList<>();

        // define the typed array resources that hold the data values
        String[] name = getResources().getStringArray(R.array.calendarNames);
        String[] address = getResources().getStringArray(R.array.calendarAddress);
        String[] addressURI = getResources().getStringArray(R.array.calendarAddressURI);
        String[] hours = getResources().getStringArray(R.array.calendarHours);
        String[] phone = getResources().getStringArray(R.array.calendarPhone);
        String[] website = getResources().getStringArray(R.array.calendarWebsiteURI);
        String[] reviewStars = getResources().getStringArray(R.array.calendarReviewStars);
        String[] twitter = getResources().getStringArray(R.array.calendarTwitterURI);
        TypedArray typedArray = getResources().obtainTypedArray(R.array.calendarPhoto);

        // populate the list with values from the typed array resources
        for (int i = 0; i < name.length ; i++) {

            int photoResourceId = typedArray.getResourceId(i, 0);
            Log.d("PlacesActivity", "Calendar: adding - " + name[i] + " " + address[i] + " " + addressURI[i] + " " + phone[i] + " " + website[i] + " " + reviewStars[i] + " " + photoResourceId + " " + twitter[i] + " " + hours[i]);
            places.add(new Places(name[i], address[i], addressURI[i], phone[i], website[i], reviewStars[i], photoResourceId, twitter[i], hours[i]));

        }

        typedArray.recycle();

        // call the SongAdapter class once all data items are in the array
        placesAdapter.addItems(places);
        recyclerView.setAdapter(placesAdapter);

    }


}
