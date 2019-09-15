package com.example.grumpybunny.tourguideapp;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * this is a fragment for the Hotel list view
 */

public class HotelFragment extends Fragment {

    // Initialize the recycler view
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    // Initialize hotel data
    @BindArray(R.array.hotelNames)
    String[] name;
    @BindArray(R.array.hotelAddress)
    String[] address;
    @BindArray(R.array.hotelPhone)
    String[] phone;
    @BindArray(R.array.hotelWebsiteURI)
    String[] website;
    @BindArray(R.array.hotelPhoto)
    TypedArray typedArray;
    // Initialize the ArrayList
    private ArrayList<Places> places = new ArrayList<>();

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_placeslist, container, false);

        // Initialize ButterKnife
        ButterKnife.bind(this, view);

        // Check if this is not the first time to load the fragment
        // To avoid duplicate items in the ArrayList
        if (savedInstanceState == null) {
            // Setup the ArrayList
            setupArrayList();
        }
        // Setup the recycler view
        setupRecyclerView(view);

        return view;
    }

    private void setupArrayList() {

        // Populate the ArrayList with hotels
        for (int i = 0; i < name.length; i++) {

            int photoResourceId = typedArray.getResourceId(i, 0);
            Log.d("Fragment", "Hotels: adding - " + name[i] + " " + address[i] + " " + phone[i] + " " + website[i] + " " + photoResourceId);
            places.add(new Places(name[i], address[i], phone[i], website[i], photoResourceId));

        }
    }

    private void setupRecyclerView(View view) {

        // Initialize the adapter, and pass the ArrayList to it
        PlacesAdapter adapter = new PlacesAdapter(places);

        // Attach the adapter to the recycler view
        recyclerView.setAdapter(adapter);

        // Attach the layout manager to the recycler view
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
