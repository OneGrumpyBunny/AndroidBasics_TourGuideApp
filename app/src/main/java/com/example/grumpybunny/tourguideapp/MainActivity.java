package com.example.grumpybunny.tourguideapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    // Initialize the ViewPager
    @BindView(R.id.container)
    ViewPager viewPager;

    // Initialize the TabLayout
    @BindView(R.id.sliding_tabs)
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Remove title bar
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        // Initialize ButterKnife
        ButterKnife.bind(this);

        // Setup the ViewPager
        setupViewPager(viewPager);

        // Attach the ViewPager to the TabLayout
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        // Initialize the FragmentStatePagerAdapter
        CategoryAdapter adapter = new CategoryAdapter(this, getSupportFragmentManager());

        // Add the Fragments to the adapter
        adapter.addFragment(new RestaurantsFragment(), getResources().getString(R.string.restaurants_title));
        adapter.addFragment(new HotelFragment(), getResources().getString(R.string.hotels_title));
        adapter.addFragment(new AttractionFragment(), getResources().getString(R.string.attractions_title));
        adapter.addFragment(new CalendarFragment(), getResources().getString(R.string.events_title));

        // Attach the adapter to the ViewPager
        viewPager.setAdapter(adapter);
    }
}
