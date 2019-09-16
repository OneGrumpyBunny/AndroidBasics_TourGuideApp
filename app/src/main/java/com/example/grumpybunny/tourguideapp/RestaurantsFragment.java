package com.example.grumpybunny.tourguideapp;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * this is a fragment for the Restaurants list view
 */

public class RestaurantsFragment extends Fragment {

    // Initialize the recycler view
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    // Initialize restaurant data
    @BindArray(R.array.restaurantNames)
    String[] name;
    @BindArray(R.array.restaurantAddress)
    String[] address;
    @BindArray(R.array.restaurantPhone)
    String[] phone;
    @BindArray(R.array.restaurantWebsiteURI)
    String[] website;
    @BindArray(R.array.restaurantPhoto)
    TypedArray typedArray;
    // Initialize the ArrayList
    //private ArrayList<Places> places = new ArrayList<>();
    List<Places> places = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_placeslist, container, false);

        // Initialize ButterKnife
        ButterKnife.bind(this, view);

        // Setup the ArrayList
        setupArrayList();

        // Setup the recycler view
        setupRecyclerView();

        return view;
    }

    private void setupArrayList() {

        // Populate the ArrayList with attractions
        for (int i = 0; i < name.length; i++) {

            int photoResourceId = typedArray.getResourceId(i, 0);
            places.add(new Places(name[i], address[i], phone[i], website[i], photoResourceId));

        }
    }

    private void setupRecyclerView() {

        // Initialize the adapter, and pass the ArrayList to it
        PlacesAdapter adapter = new PlacesAdapter(places);

        // Attach the adapter to the recycler view
        recyclerView.setAdapter(adapter);

        // Attach the layout manager to the recycler view
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
